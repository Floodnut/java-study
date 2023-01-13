package jpastudy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args){
        /* 로딩 시점에 하나만 작성 */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        /*
            실제 트랜잭션 단위, DB 커넥션을 들고 있음.
            매 요청마다 새롭게 생성하고 닫아야 한다. 스레드간 공유하지 말기.
         */
        EntityManager em = emf.createEntityManager();

        EntityTransaction ts = em.getTransaction();
        ts.begin();

        /* code */
        try{
            /* 생성 - 비영속 */
            Member member = new Member();
            member.setId(2L);
            member.setName("member");

            /* 영속, 실제로 DB에 저장되지는 않음. */
            em.persist(member);

            /* 준영속 */
            em.detach(member);

            /* 조회 */
            Member findMember = em.find(Member.class, 1L);

            /* 수정 */
            findMember.setName("update_member");

            /* 삭제 */
            em.remove(findMember);

            /* 영속성 컨텍스트에 있는 값을 기반으로 DB에 쿼리를 날림. */
            ts.commit();
        }
        catch (Exception e){
            ts.rollback();
        }
        finally{
            em.close();
        }

        emf.close();
    }
}
