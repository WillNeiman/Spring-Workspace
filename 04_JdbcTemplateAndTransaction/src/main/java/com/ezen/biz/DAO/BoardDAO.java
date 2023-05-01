package com.ezen.biz.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.biz.DTO.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// CRUD
	// �� ���
	public void insertBoard(BoardVO board) {
		System.out.println("===> JDBC�� insertBoard() ó��");
		String sql = "insert into board(seq, title, writer, content) " +
				"values(board_seq.NEXTVAL, ?, ?, ? )";
		Object[] args = {board.getTitle(), board.getWriter(), board.getContent()};
		jdbcTemplate.update(sql, args);
	}
	
	// �� ����
	public void updateBoard(BoardVO board) {
		System.out.println("===> JDBC�� updateBoard() ó��");
		String sql = "update board set title=?, writer=?, content=? " +
						"where seq=?";
		Object[] args = {board.getTitle(), board.getWriter(), board.getContent(), board.getSeq()};
		jdbcTemplate.update(sql, args);
	}
	
	// �� ����
	public void deleteBoard(BoardVO board) {
		System.out.println("===> JDBC�� deleteBoard() ó��");
		String sql = "delete from board where seq = ?";
		jdbcTemplate.update(sql, board.getSeq());
	}
	
	// �� �� ��ȸ - seq ��ȣ�� ���� ��ȸ
	public BoardVO getBoard(BoardVO board) {
		System.out.println("===> JDBC�� getBoard() ó��");
		String sql = "select * from board where seq = ?";
		Object[] args = {board.getSeq()};
		return jdbcTemplate.queryForObject(sql, args, new BoardRowMapper());
	}
	
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC�� getBoardList() ó��");
		String sql = "select * from board";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
}
