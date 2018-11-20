package com.gmail.aisdugo.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gmail.aisdugo.dao.PeoplesDao;
import com.gmail.aisdugo.vo.Peoples;

@Service
public class PeoplesServiceImpl implements PeoplesService {

	@Autowired
	private PeoplesDao peoplesDao;
	
	//아이디 중복체크 메소드
	@Override
	public String idcheck(String pid) {
		return peoplesDao.idcheck(pid);
	}
	
	//회원가입 메소드
	@Override
	public boolean register(MultipartHttpServletRequest request) {
		//파라미터 읽기
		String pid = request.getParameter("email");
		String ppw = request.getParameter("pw");
		String pnick = request.getParameter("nickname");
		//파일은 getFile로 읽고 MultipartFile로 저장
		MultipartFile pimage = request.getFile("image");
		
		//파일 업로드 처리
		//업로드 할 디렉토리를 문자열로 만들기
		String uploadPath = request.getRealPath("/peoplesimage");
		//파일 이름 만들기 -- 중복되지 않게 하기 위해 UUID와 원본파일 이름을 합쳐서 생성
		UUID uuid = UUID.randomUUID();
		String filename = pimage.getOriginalFilename();
		String filepath = uploadPath+"/"+uuid+"_"+filename;
		
		//파일 업로드와 데이터베이스 작업
		Peoples peoples = new Peoples();
		File file = new File(filepath);
		try {
			peoples.setPid(pid);
			//비밀번호 암호화
			peoples.setPpw(BCrypt.hashpw(ppw, BCrypt.gensalt()));
			peoples.setPnick(pnick);
			peoples.setPimage(filename);
			//파일업로드
			pimage.transferTo(file);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		boolean registerSuccess = peoplesDao.register(peoples);

		System.out.print(registerSuccess);
		return registerSuccess;
	}

	@Override
	public Peoples login(HttpServletRequest request) {
		System.out.println("로그인 서비스:");
		//파라미터 읽기 -- 아이디와 비밀번호
		String pid = request.getParameter("email");
		String ppw = request.getParameter("pw");
		System.out.println(pid+"/"+ppw);
		//파라미터 pid에 해당하는 데이터를 데이터베이스에서 가져오기
		//peoples가 null이면 데이터베이스에 없는 것. -- 이 경우 아래 작업을 하지 않고 리턴됨.
		Peoples peoples = peoplesDao.login(pid);
		if(peoples != null) {
			System.out.println("peoples값이 있는 경우:"+peoples.getPpw());
			//비밀번호가 맞는지 확인 -- 암호화 되어 있으므로 BCrypt.checkpw를 이용하여 비밀번호가 맞는지 확인해야 함.
			if(BCrypt.checkpw(ppw, peoples.getPpw() ) ) {
				System.out.println("비밀번호 검사");
				//비밀번호가 일치할 때 -- 비밀번호만 null로 설정
				System.out.println("비밀번호 맞음");
				peoples.setPpw(null);
			}else {
				//비밀번호가 틀렸을 때 -- peoples를 null로 만듦
				System.out.println("비밀번호 틀림");
				peoples = null;
			}
			
			
			
			
			System.out.println("서비스 작업 끝");
		}
		return peoples;
	}


}
