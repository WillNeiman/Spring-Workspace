package com.ezen.biz.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.DTO.BoardVO;
import com.ezen.biz.service.BoardService;
import com.ezen.biz.service.UserService;
import com.ezen.biz.view.controller.CommonController;

@org.springframework.stereotype.Controller
public class GetBoardController implements CommonController{
	
	@Autowired
	BoardService boardService;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("�� �� ��ȸ ó��");
		// �����̳� �ʱ�ȭ
    	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
    	this.boardService = (BoardService)container.getBean(BoardService.class);
    	
		//1. �˻��� �Խñ� ��ȣ ����
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2. DB���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		BoardVO board = boardService.getBoard(vo);
		
		//3. �˻� ����� ���ǿ� �����ϰ� �� ȭ������ �̵�
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		container.close();
		
		return "getBoard";
	}

}