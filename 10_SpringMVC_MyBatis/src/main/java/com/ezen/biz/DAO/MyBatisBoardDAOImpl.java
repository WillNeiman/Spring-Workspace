package com.ezen.biz.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ezen.biz.DTO.BoardVO;
import com.ezen.biz.util.SqlSessionFactoryBean;

@Repository("myBatisBoardDAO")
public class MyBatisBoardDAOImpl implements BoardDAO{
	
	// JDBC ���� ����
	private SqlSession mybatis;
	
	public MyBatisBoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	// CRUD
	// �� ���
	public void insertBoard(BoardVO board) {
		System.out.println("===> MyBatis�� insertBoard() ó��");
		mybatis.insert("BoardDAO.insertBoard", board);
	}
	
	// �� ����
	public void updateBoard(BoardVO board) {
		System.out.println("===> MyBatis�� updateBoard() ó��");
		mybatis.insert("BoardDAO.updateBoard", board);
		mybatis.commit();
	}
	
	// �� ����
	public void deleteBoard(BoardVO board) {
		System.out.println("===> MyBatis�� deleteBoard() ó��");
		mybatis.insert("BoardDAO.deleteBoard", board);
		mybatis.commit();
		
	}
	
	// �� �� ��ȸ - seq ��ȣ�� ���� ��ȸ
	public BoardVO getBoard(BoardVO board) {
		System.out.println("===> MyBatis�� getBoard() ó��");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", board);
		
	}
	
	// �� ��� ��ȸ
	public List<BoardVO> getBoardList(BoardVO board) {
		System.out.println("===> MyBatis�� getBoardList() ó��");
		return mybatis.selectList("BoardDAO.getBoardList", board);
	}
}
