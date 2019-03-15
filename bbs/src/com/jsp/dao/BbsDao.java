package com.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.BbsDto;

public class BbsDao {

	private static BbsDao bbsDao;
	private Connection conn;
	private PreparedStatement pstmt;
	private int result;
	private ResultSet rs;
	private List<BbsDto> bbsList;


	private BbsDao() {
	}



	public static synchronized BbsDao getInstance() {
		if(bbsDao == null) {
			bbsDao = new BbsDao();
	}
		return bbsDao;
	}
	public Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "BIG";
		String pw ="1234";
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

	public BbsDto selectById(String id) {
		
		// id 확인
		//System.out.println("dao에서 id = " + id);
		BbsDto bbsDto = new BbsDto();
		//System.out.println("왜");
		conn = this.getConnect();
		//System.out.println("에러가난거야 쉬뱌ㅠㅠ");
		
		StringBuffer query = new StringBuffer();
		query.append("SELECT *");
		query.append(" FROM BBS");
		query.append(" WHERE BBSID=? ");
		
		try {
			//System.out.println("양심적으로 try문은 들어가야지?");
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			
			//System.out.println("설마 여긴가?");
			rs = pstmt.executeQuery();
			// rs 확인
			//System.out.println("dao에서 " + rs);
			while (rs.next()) {
				
				bbsDto.setId(rs.getString("ID"));
				bbsDto.setBbsId(rs.getString("BBSID"));
				bbsDto.setBbsTitle(rs.getString("BBSTITLE"));
				bbsDto.setBbsDate(rs.getString("BBSDATE"));
				bbsDto.setBbsCategory(rs.getString("BBSCATEGORY"));
				bbsDto.setBbsContent(rs.getString("BBSCONTENT"));
				bbsDto.setBbsHit(rs.getString("BBSHIT"));
				//System.out.println(bbsDto.toString());
			}
		} catch (SQLException e) {
			
		} finally {
			this.close(conn, pstmt, null);
		}
		return bbsDto;
	}
	
	
	public BbsDto selectBeforeById(String id) {
		
		BbsDto bbsDto = new BbsDto();
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT * FROM BBS WHERE BBSID IN ");
		query.append(" ((SELECT MAX(BBSID) FROM BBS ");
		query.append(" WHERE BBSID < ? ))");
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bbsDto.setId(rs.getString("ID"));
				bbsDto.setBbsId(rs.getString("BBSID"));
				bbsDto.setBbsTitle(rs.getString("BBSTITLE"));
				bbsDto.setBbsDate(rs.getString("BBSDATE"));
				bbsDto.setBbsCategory(rs.getString("BBSCATEGORY"));
				bbsDto.setBbsContent(rs.getString("BBSCONTENT"));
				bbsDto.setBbsHit(rs.getString("BBSHIT"));
			}
		} catch (SQLException e) {
			
		} finally {
			this.close(conn, pstmt, null);
		}
		return bbsDto;
	}
				
			
	public BbsDto selectAfterById(String id) {
		
		BbsDto	bbsDto = new BbsDto();
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT * FROM BBS WHERE BBSID IN ");
		query.append(" ((SELECT MIN(BBSID) FROM BBS ");
		query.append(" WHERE BBSID > ? )) ");
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bbsDto.setId(rs.getString("ID"));
				bbsDto.setBbsId(rs.getString("BBSID"));
				bbsDto.setBbsTitle(rs.getString("BBSTITLE"));
				bbsDto.setBbsDate(rs.getString("BBSDATE"));
				bbsDto.setBbsCategory(rs.getString("BBSCATEGORY"));
				bbsDto.setBbsContent(rs.getString("BBSCONTENT"));
				bbsDto.setBbsHit(rs.getString("BBSHIT"));
			}
		} catch (SQLException e) {
			
		} finally {
			this.close(conn, pstmt, null);
		}
		return bbsDto;
	}
		
	
	public int hitUpdate(String id) {
		
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		query.append("UPDATE BBS SET BBSHIT = BBSHIT +1 WHERE BBSID=?");
			try {
				pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, id);
				result = pstmt.executeUpdate();
			} catch(SQLException e1) {
	}
			finally {
				this.close(conn, pstmt, null);
			}
			return result;
	}
	
	public int hitUpdate(Connection conn, String id) {
			
			conn = this.getConnect();
			StringBuffer query = new StringBuffer();
			query.append("UPDATE BBS SET BBSHIT = BBSHIT +1 WHERE BBSID=?");
				try {
					pstmt = conn.prepareStatement(query.toString());
					pstmt.setString(1, id);
					result = pstmt.executeUpdate();
				} catch(SQLException e1) {
		}
				finally {
					this.close(conn, pstmt, null);
				}
				return result;
		}
	
	
	
	public int update(BbsDto bbsDto) {
		
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		query.append("UPDATE BBS SET ");
		query.append(" BBTITLE=?, BBSCATEGORY=?, BBSCONTENT=?");
		query.append(" WHERE BBSID=?");
			try {
				pstmt = conn.prepareStatement(query.toString());
				pstmt.setString(1, bbsDto.getBbsTitle());
				pstmt.setString(2, bbsDto.getBbsCategory());
				pstmt.setString(3, bbsDto.getBbsContent());
				pstmt.setString(4, bbsDto.getBbsId());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e1) {
	
			} finally {
				this.close(conn, pstmt, null);
			}
			return result;
	}
	
	
	public int insert(BbsDto bbsDto) {
		
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO BBS(BBSID, ID, BBSTITLE, BBSDATE, BBSCATEGORY, BBSCONTENT, BBSHIT)");
		query.append(" VALUES (bbs_seq.nextval ,? ,? ,sysdate,? ,? ,0 )");
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1, bbsDto.getId());
			pstmt.setString(2, bbsDto.getBbsTitle());
			pstmt.setString(3, bbsDto.getBbsCategory());
			pstmt.setString(4, bbsDto.getBbsContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, null);
		}
		return result;
	}
	
	
	public int insertOracle(BbsDto bbsDto) {
		
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO BBS(BBSID, ID, BBSTITLE, BBSDATE, BBSCATEGORY, BBSCONTENT, BBSHIT)");
		query.append(" VALUES(BBS_SEQ.BEXTVAL, ? ,? ,NOW(), ?, ?, 0 )");
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(1,  bbsDto.getId());
			pstmt.setString(2,  bbsDto.getBbsTitle());
			pstmt.setString(3,  bbsDto.getBbsCategory());
			pstmt.setString(4,  bbsDto.getBbsContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, null);
		}
		return result;
	}
	
	
	public List<BbsDto> selectAll(int startNum, int perpage) {
		bbsList = new ArrayList<>();
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		query.append("SELECT T2.*");
		query.append("	FROM (SELECT ROWNUM R2, T.*");
		query.append("	FROM (SELECT BBSID, ID, substr(BBSTITLE, 1, 10) BBSTITLE, BBSDATE,");
		query.append("BBSCATEGORY, substr(BBSCONTENT, 1, 15) BBSCONTENT, BBSHIT ");
		query.append(" FROM BBS ORDER BY BBSID DESC ) T) T2 ");
		query.append("WHERE T2.R2 BETWEEN ? AND ?");
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, startNum - 1);
			pstmt.setInt(2, perpage);
			
	
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsDto bbsDto = new BbsDto();
				
				bbsDto.setId(rs.getString("ID"));
				bbsDto.setBbsId(rs.getString("BBSID"));
				bbsDto.setBbsTitle(rs.getString("BBSTITLE"));
				bbsDto.setBbsDate(rs.getString("BBSDATE"));
				bbsDto.setBbsCategory(rs.getString("BBSCATEGORY"));
				bbsDto.setBbsContent(rs.getString("BBSCONTENT"));
				bbsDto.setBbsHit(rs.getString("BBSHIT"));
		
				bbsList.add(bbsDto);
			}
			} catch(SQLException e) {
				e.printStackTrace();
		}	return bbsList;
}
	
	
	public int delete(int id) {
		
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		
		try {
			
			query.append("DELETE FROM BBS");
			query.append(" WHERE BBSID = ?");
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1,  id);
			int result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, null);
		}
		return -1;
	}
	
	public int getTotalCount() {
		
		conn = this.getConnect();
		StringBuffer query = new StringBuffer();
		query.append("SELECT count(*)");
		query.append(" FROM BBS");
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return -1;
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
	
	public static void main(String[] args) {
		BbsDao mDao = BbsDao.getInstance();
	}
	
	
}
