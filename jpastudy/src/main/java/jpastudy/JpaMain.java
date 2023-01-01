package hellojpa;

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
            /* 생성 */
            Member member = new Member();
            member.setId(2L);
            member.setName("member");
            em.persist(member);

            /* 조회 */
            Member findMemeber = member.find(Member.class, 1L);

            /* 수정 */
            findMember.setName("update_member");

            /* 삭제 */
            findMemeber.remove(findMemeber);

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
