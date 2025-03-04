package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.BoardVO;



public class BoardDao {
	
	private Connection conn = DbConnection.getConn();
	//private Connection conn2 = DbConnection.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	String sql = " ";
	BoardVO vo = null;
	
	public void pstmtClose() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				
			}
		}
	}
	
	public void rsClose() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
			}finally {
				pstmtClose();
			}
		}
	}
	
	//게시글 전체 리스트
	public List<BoardVO> getBoardList() {
		/*
		 * if(conn.equals(conn2)) { System.out.println("conn과 conn2는 같은 객체 입니다."); }
		 * else { System.out.println("conn과 conn2는 다른 객체 입니다."); }
		 */
		List<BoardVO> vos = new ArrayList<BoardVO>();
		try {
			sql = "select * from boardTest order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			 while(rs.next()) {
			  	BoardVO vo = new BoardVO();
			  	vo.setIdx(rs.getInt("idx"));
			  	vo.setName(rs.getString("name"));
			  	vo.setTitle(rs.getString("title"));
			  	vo.setContent(rs.getString("content"));
			  	vo.setHostIp(rs.getString("hostIp"));
			  	vo.setReadNum(rs.getInt("readNum"));
			  	vo.setwDate(rs.getDate("wDate"));
			  	vos.add(vo);
			  }
			 
		} catch (SQLException e) {
			System.out.println("sql오류(getBoardList) : " + e.getMessage());
		}	finally {
			rsClose();
		}
		return vos;
	}
	
	//게시글 등록하기
		public int setBoardInput(BoardVO vo) {
			int res = 0;
			try {
					sql = "insert into boardTest values (default,?,?,?,default,default,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, vo.getName());
					pstmt.setString(2, vo.getTitle());
					pstmt.setString(3, vo.getContent());
					pstmt.setString(4, vo.getHostIp());
					res = pstmt.executeUpdate();
			} catch (SQLException e) {
					System.out.println("sql오류(setBoardInput) : " + e.getMessage());
			}	finally {
					pstmtClose();
			}
			return res;
			}

		//글 조회수 증가하기
		public void setReadNumUpdate(int idx) {
			try {
				sql = "update boardTest set readNum = readNum + 1 where idx = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, idx);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("sql오류(setReadNumUpdate) : " + e.getMessage());
			}	finally {
				pstmtClose();
			}
			
		}
		
		//글 내용 조회하기
		public BoardVO getBoardContent(int idx) {
			vo = new BoardVO();
			try {
				sql="select * from boardTest where idx = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, idx);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo.setIdx(rs.getInt("idx"));
					vo.setName(rs.getString("name"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
					vo.setHostIp(rs.getString("hostIp"));
					vo.setReadNum(rs.getInt("readNum"));
					vo.setwDate(rs.getDate("wDate"));
					
					
				}
			}catch (SQLException e) {
					System.out.println("sql오류(getBoardContent) : " + e.getMessage());
			}finally {
					rsClose();
			}
			return vo;
		}

		//게시글 삭제처리
		public int setBoardDelete(int idx) {
			int res = 0;
			try {
				sql = "delete from boardTest where idx = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, idx);
				res = pstmt.executeUpdate();
			}catch (SQLException e) {
				System.out.println("sql오류(setBoardDelete) : " + e.getMessage());
			}finally {
				pstmtClose();
			}
			return res;
		}
}
