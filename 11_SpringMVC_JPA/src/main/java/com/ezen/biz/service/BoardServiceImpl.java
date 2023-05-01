package com.ezen.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ezen.biz.DAO.BoardDAO;
import com.ezen.biz.DTO.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("jdbcBoardDAO")
	private BoardDAO boardDAO;

	@Override
	public void insertBoard(BoardVO board) {
		boardDAO.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVO board) {
		boardDAO.updateBoard(board);
	}

	@Override
	public void deleteBoard(BoardVO board) {
		boardDAO.deleteBoard(board);
	}

	@Override
	public BoardVO getBoard(BoardVO board) {
		return boardDAO.getBoard(board);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO board) {
		return boardDAO.getBoardList(board);
	}

}
