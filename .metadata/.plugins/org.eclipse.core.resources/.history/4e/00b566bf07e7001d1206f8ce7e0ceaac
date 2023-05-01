package com.ezen.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.DTO.BoardVO;
import com.ezen.biz.service.BoardService;

public class InsertBoardController implements Controller{
	
	@Autowired
	BoardService boardService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("글 등록 처리");
		// 컨테이너 초기화
    	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
    	this.boardService = (BoardService)container.getBean(BoardService.class);
    	
		//1. 게시글 작성 정보			
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		//2. DB연동처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		boardService.insertBoard(vo);		
		container.close();

		//3.화면 내비게이션
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}

}
