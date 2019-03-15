package com.jsp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.MemberDao;
import com.jsp.dto.MemberDto;

public class JoinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = 
			req.getRequestDispatcher("/WEB-INF/join.jsp");
		
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String jogakId = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		MemberDao mDao = MemberDao.getInstance();
		MemberDto mDto = new MemberDto();
		mDto.setId(jogakId);
		mDto.setPw(pw);
		mDto.setName(name);
		mDto.setEmail(email);
		int joinResult = mDao.join(mDto);
		
		if(joinResult==1) {
			req.setAttribute("joinResult", joinResult);
			HttpSession session = req.getSession();
			session.setAttribute("sessionID", jogakId);
			RequestDispatcher rd = 
					req.getRequestDispatcher("/WEB-INF/home.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("joinResult", 0);
			RequestDispatcher rd = 
					req.getRequestDispatcher("/WEB-INF/join.jsp");
			rd.forward(req, resp);
		}
	}
}
