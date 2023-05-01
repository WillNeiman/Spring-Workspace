package com.ezen.biz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.biz.DTO.BoardVO;

@Service
public interface BoardService {
	
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo); 
	public List<BoardVO> getBoardList(BoardVO vo);

}
