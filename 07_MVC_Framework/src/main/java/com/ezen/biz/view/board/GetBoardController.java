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
    	System.out.println("글 상세 조회 처리");
		// 컨테이너 초기화
    	AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
    	this.boardService = (BoardService)container.getBean(BoardService.class);
    	
		//1. 검색할 게시글 번호 추출
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2. DB연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		BoardVO board = boardService.getBoard(vo);
		
		//3. 검색 결과를 세션에 저장하고 상세 화면으로 이동
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		container.close();
		
		return "getBoard";
	}

}
