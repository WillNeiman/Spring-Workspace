package com.ezen.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.DTO.UserVO;
import com.ezen.biz.service.UserService;

public class UserServiceClient {
	
	private static UserService userService;
	
	public static void main(String[] args) {
		
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		userService = (UserService) container.getBean("userService");
		
//		회원등록
		UserVO userVO = new UserVO();
		userVO.setId("아이디1");
		userVO.setPassword("비번");
		userVO.setName("이름");
		userVO.setRole("역할");
		userService.insertUser(userVO);
		
		//회원 단건 조회
		UserVO findOne = userService.getUser(userVO);
		System.out.println(findOne.toString());
		
		//전체 회원 조회
		List<UserVO> userList = userService.getUserList();
		for(UserVO user : userList) {
			System.out.println(user.toString());
		}
	}

}
