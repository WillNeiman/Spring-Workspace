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
public class DeleteBoardController implements CommonController{
	
	@Autowired
	BoardService boardService;

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("글 등록 처리");
		// 컨테이너 초기화
    	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
    	this.boardService = (BoardService)container.getBean(BoardService.class);
    	
		//1. 게시글 정보		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2. DB연동처리
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		
		boardService.deleteBoard(vo);
		container.close();

		//3.화면 내비게이션
		return "getBoardList.do";
	}

}
