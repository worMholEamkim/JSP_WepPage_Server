package com.jsp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.TransactionDao;
import com.jsp.dto.BbsDto;
import com.jsp.dto.BbsFileDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Bbsupload2Controller extends HttpServlet {
	// 글쓰는 화면 열어주긔
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/bbsupload2.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "D:/temp/";
		// 어디에 파일 저장할거냐
		
		// defaultFileRename : 파일 이름 기본값말고 지가 저장할 수 있게 해주는 메소드
		MultipartRequest mRequest = new MultipartRequest(req, path, 1024 * 1024 * 50, "utf-8", new DefaultFileRenamePolicy());
		HttpSession session = req.getSession();
		String sessionID = null;
		if (session.getAttribute("sessionID") != null) {
			sessionID = (String) session.getAttribute("sessionID");
		}
		
		// 카테고리, 타이틀, 콘텐트 값을 받아옴
		String category = mRequest.getParameter("category");
		String title = mRequest.getParameter("title");
		String content = mRequest.getParameter("content");
		
		BbsDto bbsDto = new BbsDto();
		
		// ID 검증스
		bbsDto.setId(sessionID);
		bbsDto.setBbsTitle(title);
		bbsDto.setBbsCategory(category);
		bbsDto.setBbsContent(content);
		
		System.out.println(bbsDto.toString());
		
		List<BbsFileDto> bbsfDtoList = new ArrayList<BbsFileDto> ();
		
		// 초기화
		BbsFileDto bbsfDto = null;
		// 변수 선언
		String name[] = new String[100];
		String changeName[] = new String[100];
		File file[] = new File[100];
		
		for (int i=1; i<50; i++) {
			name[i] = mRequest.getOriginalFileName("bbs_file" + i);
			System.out.println("왜안뜨지" + name[i]);
			if(name[i] == null) {
				if (i == 1) {
					bbsfDtoList = null;
				}
				break;
			}
				
				file[i] = mRequest.getFile("bbs_file" + i);
				changeName[i] = file[i].getName();
				
				bbsfDto = new BbsFileDto();
				bbsfDto.setOrgn_File_Nm(path + name[i]);
				bbsfDto.setSave_File_Nm(path + changeName[i]);
				System.out.println(bbsfDto.toString());
				bbsfDtoList.add(bbsfDto);
		}
		
		// sql문을 처리하는 것...한 파일에 처리되는 sql문이 다 성공, 아니면 롤백 transaction
		TransactionDao tDao = TransactionDao.getInstance();
		// insertAll에 저장된 값보내서 받음
		System.out.println("업로드 컨트롤러 인설트올 작동확인");
		int resultTrans = tDao.insertAll(bbsDto, bbsfDtoList);
		// req에 resultTrans 값 저장
		req.setAttribute("resultTrans", resultTrans);
		
		RequestDispatcher rd = req.getRequestDispatcher("bbs.do");
		
		rd.forward(req, resp);
		
		
	}
	
}
