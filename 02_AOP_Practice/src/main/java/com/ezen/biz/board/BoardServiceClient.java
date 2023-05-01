package com.ezen.biz.board;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ezen.biz.DTO.BoardVO;
import com.ezen.biz.service.BoardService;

import oracle.sql.DATE;

public class BoardServiceClient {
	
	private static BoardService boardService;

	public static void main(String[] args) {
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		boardService = (BoardService) container.getBean("boardService");
		
		// �Խñ� ���
		BoardVO board = new BoardVO();
		board.setTitle("����");
		board.setWriter("�ۼ���");
		board.setContent("����");
		board.setRegDate(new Date(System.currentTimeMillis()));
		
		// �Խñ� �Է� �׽�Ʈ
		boardService.insertBoard(board);
	
		// �Խñ� ��� ��ȸ
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO findBoard : boardList) {
			System.out.println(findBoard.toString());
		}
		
		BoardVO findSeq = new BoardVO();
		findSeq.setSeq(3);
		BoardVO findOne = boardService.getBoard(findSeq);
		System.out.println(findOne.toString());
		
		
		container.close();

	}

}