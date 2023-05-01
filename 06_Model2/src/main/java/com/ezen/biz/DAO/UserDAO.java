package com.ezen.biz.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.biz.DTO.UserVO;
import com.ezen.biz.common.JDBCUtil;

@Repository("usersDAO")
public class UserDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// CRUD
	// 회원 등록
	public void insertUser(UserVO user) {
		System.out.println("===> JDBC로 insertUser() 처리");
		String sql = "insert into users(id, password, name, role) " +
				"values(?, ?, ?, ? )";
		Object[] args = {user.getId(), user.getPassword(), user.getName(), user.getRole()};
		jdbcTemplate.update(sql, args);
	}
	
	// 회원 수정
	public void updateUser(UserVO user) {
		System.out.println("===> JDBC로 updateUser() 처리");
		String sql = "update users set password=?, name=?, role=? " +
						"where id=?";
		Object[] args = {user.getPassword(), user.getName(), user.getRole(), user.getId()};
		jdbcTemplate.update(sql, args);
	}
	
	// 회원 삭제
	public void deleteUser(UserVO user) {
		System.out.println("===> JDBC로 deleteUser() 처리");
		String sql = "delete from users where seq = ?";
		Object[] args = {user.getId()};
		jdbcTemplate.update(sql, args);

	}
	
	// 회원 조회 - seq 번호에 의한 조회
	public UserVO getUser(UserVO user) {
		System.out.println("===> JDBC로 getUser() 처리");
		String sql = "select * from users where id = ?";
		Object[] args = {user.getId()};
		return jdbcTemplate.queryForObject(sql, args, new UserRowMapper());
	}
	
	// 회원 목록 조회
	public List<UserVO> getUserList() {
		System.out.println("===> JDBC로 getUserList() 처리");
		String sql = "select * from users";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
}
