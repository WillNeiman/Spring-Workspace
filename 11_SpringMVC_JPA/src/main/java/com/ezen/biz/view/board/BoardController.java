package com.ezen.biz.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.biz.DAO.JdbcBoardDAOImpl;
import com.ezen.biz.DTO.BoardVO;
import com.ezen.biz.service.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
	
	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	//글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException{
    	System.out.println("글 등록 처리");
    	//파일 업로드 처리
    	MultipartFile uploadFile = vo.getUploadFile();
    	if(!uploadFile.isEmpty()) {
    		String fileName = uploadFile.getOriginalFilename();
    		uploadFile.transferTo(new File("C:/" + fileName));
    	}
		
    	boardService.insertBoard(vo);		
		return "getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
    	System.out.println("번호 : " + vo.getSeq());
    	System.out.println("제목 : " + vo.getTitle());
    	System.out.println("작성자 : " + vo.getWriter());
    	System.out.println("내용 : " + vo.getContent());
    	System.out.println("작성일 : " + vo.getRegDate());
    	System.out.println("조회수 : " + vo.getCnt());
		
    	boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
    	System.out.println("글 등록 처리");
		
    	boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//글 상세
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
    	System.out.println("글 상세 조회 처리");
		
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	//글 목록
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");
		// Null check
		if(vo.getSearchCondition()==null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword()==null) {
			vo.setSearchKeyword("");
		}
		
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}
}
