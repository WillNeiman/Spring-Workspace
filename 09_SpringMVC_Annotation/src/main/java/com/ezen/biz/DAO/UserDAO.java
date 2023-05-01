package com.ezen.biz.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ezen.biz.DTO.UserVO;
import com.ezen.biz.common.JDBCUtil;

@Repository("usersDAO")
public class UserDAO {
	
	// JDBC ���� ����
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// CRUD
	// ȸ�� ���
	public void insertUser(UserVO user) {
		System.out.println("===> JDBC�� insertUser() ó��");
		String sql = "insert into users(id, password, name, role) " +
				"values(?, ?, ?, ? )";
		this.conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {JDBCUtil.close(pstmt, conn);		
		}
	}
	
	// ȸ�� ����
	public void updateUser(UserVO user) {
		System.out.println("===> JDBC�� updateUser() ó��");
		String sql = "update users set password=?, name=?, role=? " +
						"where id=?";
		this.conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getRole());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {JDBCUtil.close(pstmt, conn);		
		}
	}
	
	// ȸ�� ����
	public void deleteUser(UserVO user) {
		System.out.println("===> JDBC�� deleteUser() ó��");
		String sql = "delete from users where seq = ?";
		this.conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {JDBCUtil.close(pstmt, conn);		
		}
	}
	
	// ȸ�� ��ȸ - seq ��ȣ�� ���� ��ȸ
	public UserVO getUser(UserVO user) {
		System.out.println("===> JDBC�� getUser() ó��");
		String sql = "select * from users where id = ?";
		this.conn = JDBCUtil.getConnection();
		UserVO result = new UserVO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {				 
				result.setId(rs.getString("id"));
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {JDBCUtil.close(pstmt, conn, rs);	
		}
		return result;
	}
	
	// ȸ�� ��� ��ȸ
	public List<UserVO> getUserList() {
		System.out.println("===> JDBC�� getUserList() ó��");
		String sql = "select * from users";
		this.conn = JDBCUtil.getConnection();
		List<UserVO> userList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {JDBCUtil.close(pstmt, conn, rs);	
		}
		return userList;
	}
}