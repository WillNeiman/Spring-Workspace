package com.ezen.biz;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.DTO.BoardVO;
import com.ezen.biz.DTO.UserVO;
import com.ezen.biz.service.BoardService;
import com.ezen.biz.service.UserService;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//������ �����̳� �ʱ�ȭ
		AbstractApplicationContext container = 
			new GenericXmlApplicationContext("applicationContext.xml");
			
		UserService userService = (UserService) container.getBean("userService");
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//1.Ŭ���̾�Ʈ�� ��û path ���� ����
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//2. Ŭ���̾�Ʈ�� ��û path�� ���� ������ �б�ó��
		if(path.equals("/login.do")) {
			System.out.println("�α��� ó��");

			//1. ����� �Է� ���� ����
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB ���� ó��
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserVO user = userService.getUser(vo);
			container.close();
			
			//3. ȭ�� ������̼�
			if(user!=null){
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.do");
			}
		} else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ó��");
			//1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
			HttpSession session = request.getSession();
			session.invalidate();

			//2. ���� ���� �� ����ȭ������ �̵�
			response.sendRedirect("login.jsp");
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ó��");
				//1. ����� �Է� ���� ����				
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				
				//2. DB����ó��
				BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setContent(content);
				
				boardService.insertBoard(vo);
				
				//3.ȭ�� ������̼�
				response.sendRedirect("getBoardList.do");
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ó��");
				//1. ����� �Է� ���� ����				
				request.setCharacterEncoding("UTF-8");
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
				
				//3.ȭ�� ������̼�
				response.sendRedirect("getBoardList.do");
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ó��");
				//1. ����� �Է� ���� ����				
				request.setCharacterEncoding("UTF-8");
				int seq = Integer.parseInt(request.getParameter("seq"));
				
				//2. DB����ó��
				BoardVO vo = new BoardVO();
				vo.setSeq(seq);
				
				boardService.deleteBoard(vo);
				
				//3.ȭ�� ������̼�
				response.sendRedirect("getBoardList.do");
		} else if(path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ó��");
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
			response.sendRedirect("getBoard.jsp");
			
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("�� ��� �˻� ó��");
			//1. ����� �Է� ���� ����(�˻� ����� ���߿� ����)
			//2. DB ���� ó��				
			BoardVO vo = new BoardVO();
			List<BoardVO> boardList = boardService.getBoardList();
			
			//3. ���� ȭ�� ����
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			container.close();
			response.sendRedirect("getBoardList.jsp");
		}
	}

}