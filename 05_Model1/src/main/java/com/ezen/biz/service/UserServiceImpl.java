package com.ezen.biz.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.DAO.UserDAO;
import com.ezen.biz.DTO.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@PostConstruct
    public void init() {
        System.out.println("UserServiceImpl 빈이 생성되었습니다.");
    }
	@Autowired
	private UserDAO userDAO;

	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		userDAO.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		userDAO.deleteUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public List<UserVO> getUserList() {
		return userDAO.getUserList();
	}

}
