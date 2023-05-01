package com.ezen.biz.DAO;

import java.util.List;

import com.ezen.biz.DTO.BoardVO;

public interface BoardDAO {

	public void insertBoard(BoardVO board);
	
	// �� ����
	public void updateBoard(BoardVO board);
	
	// �� ����
	public void deleteBoard(BoardVO board);
	
	// �� �� ��ȸ - seq ��ȣ�� ���� ��ȸ
	public BoardVO getBoard(BoardVO board);
	
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO board);
}
