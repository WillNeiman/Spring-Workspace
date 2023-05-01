package com.ezen.biz.view.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ezen.biz.DAO.BoardDAO;
import com.ezen.biz.DTO.BoardVO;

public class GetBoardController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("글 상세 조회 처리");
    	
		//1. 검색할 게시글 번호 추출
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2. DB연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		//3. 검색 결과를 저장하고 상세 화면으로 이동
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard");
		return mav;
	}

}
