package com.ezen.biz;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ezen.biz.DTO.BoardVO;
import com.ezen.biz.DTO.UserVO;
import com.ezen.biz.service.BoardService;
import com.ezen.biz.service.UserService;
import com.ezen.biz.view.controller.CommonController;
import com.ezen.biz.view.controller.HandlerMapping;
import com.ezen.biz.view.controller.ViewResolver;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
       
    public void init() throws ServletException {
    	// 의존성 주입
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//1.클라이언트의 요청 path 정보 추출
		String uri = request.getRequestURI();
		System.out.println("process() 진행 중 - String uri = request.getRequestURI(); 결과 : " + uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("process() 진행 중 - String path = uri.substring(uri.lastIndexOf(\"/\")); 결과 : " + path);
		
		//2. 핸들러매핑을 통해 path에 해당하는 Controller를 검색한다.
		CommonController ctrl = handlerMapping.getController(path);
		System.out.println("process() 진행 중 - Controller ctrl = handlerMapping.getController(path); 결과 : " + ctrl);
		
		//3. 검색된 컨트롤러 실행
		String viewName = ctrl.handleRequest(request, response);
		System.out.println("process() 진행 중 - String viewName = ctrl.handleRequest(request, response);");
		
		//4. ViewResolver를 통해  viewName에 해당하는 화면 검색
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
			System.out.println("process() 진행 중 - view = viewResolver.getView(viewName);");
					} else {
			view = viewName;			
			System.out.println("process() 진행 중 - view = viewName;");
		}
		
		//5. 검색된 화면으로 이동
		System.out.println("process() 진행 중 - response.sendRedirect(view); 결과 : " + view);
		response.sendRedirect(view);
		
	}

}
