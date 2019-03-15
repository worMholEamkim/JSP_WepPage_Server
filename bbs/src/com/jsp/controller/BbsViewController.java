package com.jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.BbsDao;
import com.jsp.dao.BbsFileDao;
import com.jsp.dto.BbsDto;
import com.jsp.dto.BbsFileDto;

public class BbsViewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// bbsview에서 id에 넘긴 글번호 수가 넘어옴
		String bbsId = req.getParameter("id");
		BbsDao bbsDao = BbsDao.getInstance();
		BbsDto bbsDto = new BbsDto();
		int result = bbsDao.hitUpdate(bbsId);
		bbsDto = bbsDao.selectById(bbsId);
		// bbsId 확인
		//System.out.println("컨트롤러에서 id =" + bbsId);
		// bbsDto 확인
		//System.out.println("컨트롤러에서 " + bbsDto.toString());
		req.setAttribute("bbsview", bbsDto);
		
		
		BbsFileDao bbsfDao = BbsFileDao.getInstance();
		List<BbsFileDto> files = bbsfDao.selectByBbsId(bbsId);
		//
		System.out.println("컨트롤러에서 files " + files);
		req.setAttribute("files", files);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/bbsview.jsp");
		rd.forward(req, resp);
	}
}
