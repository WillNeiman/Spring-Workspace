package com.ezen.biz.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ezen.biz.DTO.BoardVO;
import com.ezen.biz.common.JDBCUtil;

@Repository("jdbcBoardDAO")
public class JdbcBoardDAOImpl implements BoardDAO{
	
	// JDBC ���� ����
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String BOARD_LIST_T =	
			"select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C =	
			"select * from board where content like '%'||?||'%' order by seq desc";
	
	// CRUD
	// �� ���
	public void insertBoard(BoardVO board) {
		System.out.println("===> JDBC�� insertBoard() ó��");
		String sql = "insert into board(seq, title, writer, content) " +
				"values(board_seq.NEXTVAL, ?, ?, ? )";
		this.conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {JDBCUtil.close(pstmt, conn);		
		}
	}
	
	// �� ����
	public void updateBoard(BoardVO board) {
		System.out.println("===> JDBC�� updateBoard() ó��");
		String sql = "update board set title=?, writer=?, content=? " +
						"where seq=?";
		this.conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {JDBCUtil.close(pstmt, conn);		
		}
	}
	
	// �� ����
	public void deleteBoard(BoardVO board) {
		System.out.println("===> JDBC�� deleteBoard() ó��");
		String sql = "delete from board where seq = ?";
		this.conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {JDBCUtil.close(pstmt, conn);		
		}
	}
	
	// �� �� ��ȸ - seq ��ȣ�� ���� ��ȸ
	public BoardVO getBoard(BoardVO board) {
		System.out.println("===> JDBC�� getBoard() ó��");
		String sql = "select * from board where seq = ?";
		this.conn = JDBCUtil.getConnection();
		BoardVO result = new BoardVO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {				 
				result.setSeq(rs.getInt("SEQ"));
				result.setTitle(rs.getString("TITLE"));
				result.setWriter(rs.getString("WRITER"));
				result.setContent(rs.getString("CONTENT"));
				result.setRegDate(rs.getDate("REGDATE"));
				result.setCnt(rs.getInt("CNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {JDBCUtil.close(pstmt, conn, rs);	
		}
		return result;
	}
	
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC�� getBoardList() ó��");
		String sql = "select * from board order by seq desc";
		this.conn = JDBCUtil.getConnection();
		List<BoardVO> boardList = new ArrayList<>();
		try {
			if(vo.getSearchCondition().equals("TITLE")) {
				pstmt = conn.prepareStatement(BOARD_LIST_T);
			} else if (vo.getSearchCondition().equals("CONTENT")) {
				pstmt = conn.prepareStatement(BOARD_LIST_C);
			}
			pstmt.setString(1, vo.getSearchKeyword());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {JDBCUtil.close(pstmt, conn, rs);	
		}
		return boardList;
	}
}