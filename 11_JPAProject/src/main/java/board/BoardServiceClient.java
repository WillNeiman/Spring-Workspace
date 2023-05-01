package board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			//Transaction 시작
			tx.begin();
			
			Board board = new Board();
			board.setTitle("title");
			board.setContent("content");
			board.setWriter("writer");
			
			//글 등록
			em.persist(board);
			
			// 글 목록 조회
			List<Board> boardList = em.createQuery("select b from Board b order by seq desc", Board.class).getResultList();
			for(Board findBoard : boardList) {
				System.out.println(findBoard.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			//Transaction Rollback
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();

	}

}
