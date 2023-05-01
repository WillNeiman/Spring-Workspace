package com.ezen.biz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.biz.DTO.BoardVO;
import com.ezen.biz.DTO.UserVO;

@Service
public interface UserService {
	
	public void insertUser(UserVO vo);
	public void updateUser(UserVO vo);
	public void deleteUser(UserVO vo);
	public UserVO getUser(UserVO vo); 
	public List<UserVO> getUserList();

}
