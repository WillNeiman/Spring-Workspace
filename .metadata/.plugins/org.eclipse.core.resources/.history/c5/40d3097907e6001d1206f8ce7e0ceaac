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
	// 글 등록
	public void insertBoard(BoardVO board) {
		System.out.println("===> JDBC로 insertBoard() 처리");
		String sql = "insert into board(seq, title, writer, content) " +
				"values(board_seq.NEXTVAL, ?, ?, ? )";
		Object[] args = {board.getTitle(), board.getWriter(), board.getContent()};
		jdbcTemplate.update(sql, args);
	}
	
	// 글 수정
	public void updateBoard(BoardVO board) {
		System.out.println("===> JDBC로 updateBoard() 처리");
		String sql = "update board set title=?, writer=?, content=? " +
						"where seq=?";
		Object[] args = {board.getTitle(), board.getWriter(), board.getContent(), board.getSeq()};
		jdbcTemplate.update(sql, args);
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO board) {
		System.out.println("===> JDBC로 deleteBoard() 처리");
		String sql = "delete from board where seq = ?";
		jdbcTemplate.update(sql, board.getSeq());
	}
	
	// 글 상세 조회 - seq 번호에 의한 조회
	public BoardVO getBoard(BoardVO board) {
		System.out.println("===> JDBC로 getBoard() 처리");
		String sql = "select * from board where seq = ?";
		Object[] args = {board.getSeq()};
		return jdbcTemplate.queryForObject(sql, args, new BoardRowMapper());
	}
	
	// 글 목록 조회
	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC로 getBoardList() 처리");
		String sql = "select * from board";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
}
