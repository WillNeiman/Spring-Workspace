package com.ezen.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.DTO.BoardVO;
import com.ezen.biz.service.BoardService;
import com.ezen.biz.view.controller.CommonController;

@org.springframework.stereotype.Controller
public class UpdateBoardController implements CommonController{
	
	@Autowired
	BoardService boardService;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("�� ���� ó��");
		// �����̳� �ʱ�ȭ
    	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
    	this.boardService = (BoardService)container.getBean(BoardService.class);
    	
		//1. �Խñ� ���� ����		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2. DB����ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		boardService.updateBoard(vo);
		container.close();

		//3.ȭ�� ������̼�
		return "getBoardList.do";
	}

}