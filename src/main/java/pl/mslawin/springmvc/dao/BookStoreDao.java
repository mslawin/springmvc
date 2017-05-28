package pl.mslawin.springmvc.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.mslawin.springmvc.model.Author;
import pl.mslawin.springmvc.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookStoreDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addAuthor(Author author) {
        entityManager.persist(author);
    }

    @Transactional
    public List<Author> getAllAuthors() {
        return entityManager.createQuery("select a from " + Author.class.getName() + " a", Author.class)
                .getResultList();
    }

    @Transactional
    public void addBook(Book book, String authorId) {
        Author author = entityManager.createQuery("select a from " + Author.class.getName() + " a where a.id = :id", Author.class)
                .setParameter("id", authorId)
                .getSingleResult();
        book.setAuthor(author);
        entityManager.persist(book);
    }

    @Transactional
    public List<Book> getAllBooks() {
        return entityManager.createQuery("select b from " + Book.class.getName() + " b", Book.class)
                .getResultList();
    }
}