package com.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jsp.dto.BbsFileDto;

public class BbsFileDao {

	private static BbsFileDao bbsfDao;
	private Connection conn;
	private PreparedStatement pstmt;
	private int result;
	private ResultSet rs;
	//Map<String, Object> map;
	private List<BbsFileDto> bbsfList;
	private ArrayList fileIdList;


private BbsFileDao() {
	
}

public static synchronized BbsFileDao getInstance() {
	if(bbsfDao == null) {
		bbsfDao = new BbsFileDao();
	}
	return bbsfDao;
}

public Connection getConnect() {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "BIG";
	String pw = "1234";
	try {
		Class.forName("core.log.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return conn;
}



public List<BbsFileDto> selectByBbsId(String bbsid) {
	System.out.println("야 갓재?");
	conn = this.getConnect();
	
	StringBuffer query = new StringBuffer();
	query.append("SELECT *");
	query.append(" FROM BBS_FILE");
	query.append(" WHERE BBSID=?");
	System.out.println("쿼리확인");
	try {
		pstmt = conn.prepareStatement(query.toString());
		pstmt.setString(1, bbsid);
		rs = pstmt.executeQuery();
		bbsfList = new ArrayList<>();
		
		while (rs.next()) {
			BbsFileDto bbsfDto = new BbsFileDto();
			bbsfDto.setFileId(rs.getString("FILEID"));
			bbsfDto.setOrgn_File_Nm(rs.getString("ORGN_FILE_NM"));
			// bbsfDto 확인
			System.out.println("filedao에서 bbsfdto" + bbsfDto);
			bbsfList.add(bbsfDto);
			
		}
		
	} catch (SQLException e) {
		
	} finally {
		this.close(conn, pstmt, null);
	}
	return bbsfList; 
}


public void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
	if (rs != null) {
		try {
			rs.close();
		} catch (SQLException e) {
		}
	}
	if (stmt != null) {
		try {
			stmt.close();
		} catch (SQLException e) {
		}
	}
	if (conn != null) {
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}
}



}
