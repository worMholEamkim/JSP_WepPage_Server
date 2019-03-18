package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.BbsDao;
import com.jsp.dao.BbsFileDao;
import com.jsp.dao.TransactionDao;
import com.jsp.dto.BbsDto;

public class BbsDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파일 id 받아옴
		String bbsId = req.getParameter("id");
		// 거꾸로 파일쪽부터 날림
		BbsFileDao bbsfDao = BbsFileDao.getInstance();
		int result1 = bbsfDao.delete(Integer.parseInt(bbsId));
		
		BbsDao bbsDao = BbsDao.getInstance();
		int result2 = bbsDao.delete(Integer.parseInt(bbsId));
		
		int deleteResult = result1 + result2;
		BbsDto bbsDto = new BbsDto();
		req.setAttribute("deleteResult", deleteResult);
		
		RequestDispatcher rd = req.getRequestDispatcher("bbs.do");
		rd.forward(req, resp);
}
	
}
