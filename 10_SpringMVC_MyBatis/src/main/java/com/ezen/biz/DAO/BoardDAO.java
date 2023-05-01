package com.ezen.biz.DAO;

import java.util.List;

import com.ezen.biz.DTO.BoardVO;

public interface BoardDAO {

	public void insertBoard(BoardVO board);
	
	// 글 수정
	public void updateBoard(BoardVO board);
	
	// 글 삭제
	public void deleteBoard(BoardVO board);
	
	// 글 상세 조회 - seq 번호에 의한 조회
	public BoardVO getBoard(BoardVO board);
	
	// 글 목록 조회
	public List<BoardVO> getBoardList(BoardVO board);
}
