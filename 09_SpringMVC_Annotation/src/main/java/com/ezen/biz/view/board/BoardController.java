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

import com.ezen.biz.DAO.BoardDAO;
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
	
	//�˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}
	
	//�� ���
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException{
    	System.out.println("�� ��� ó��");
    	//���� ���ε� ó��
    	MultipartFile uploadFile = vo.getUploadFile();
    	if(!uploadFile.isEmpty()) {
    		String fileName = uploadFile.getOriginalFilename();
    		uploadFile.transferTo(new File("C:/" + fileName));
    	}
		
    	boardService.insertBoard(vo);		
		return "getBoardList.do";
	}
	
	//�� ����
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
    	System.out.println("��ȣ : " + vo.getSeq());
    	System.out.println("���� : " + vo.getTitle());
    	System.out.println("�ۼ��� : " + vo.getWriter());
    	System.out.println("���� : " + vo.getContent());
    	System.out.println("�ۼ��� : " + vo.getRegDate());
    	System.out.println("��ȸ�� : " + vo.getCnt());
		
    	boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	//�� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
    	System.out.println("�� ��� ó��");
		
    	boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//�� ��
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
    	System.out.println("�� �� ��ȸ ó��");
		
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	//�� ���
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("�� ��� �˻� ó��");
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
