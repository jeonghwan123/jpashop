package japbook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import japbook.jpashop.domain.Book;
import japbook.jpashop.domain.Order;
import japbook.jpashop.domain.OrderItem;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("영한");
            em.persist(book);



            tx.commit();
        } catch(Exception E){
            tx.rollback();

        } finally {
            em.close();
        }
        emf.close();
    }
}
