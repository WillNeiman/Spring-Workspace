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

		UserVO userVO = new UserVO();
//		회원등록
//		userVO.setId("test");
//		userVO.setPassword("1234");
//		userVO.setName("tester");
//		userVO.setRole("testRole");
//		userService.insertUser(userVO);
		
		//회원 단건 조회
		userVO.setId("test");
		UserVO findOne = userService.getUser(userVO);
		System.out.println(findOne.toString());
		
		//전체 회원 조회
//		List<UserVO> userList = userService.getUserList();
//		for(UserVO user : userList) {
//			System.out.println(user.toString());
//		}
	}

}
