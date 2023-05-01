package com.ezen.biz.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ezen.biz.DTO.BoardVO;

@Repository
public class BoardRowMapper implements RowMapper<BoardVO> {
	
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		BoardVO board = new BoardVO();
		
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regdate"));
		board.setCnt(rs.getInt("cnt"));
		
		return board;
	}
}