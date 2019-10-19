package pl.coderslab.app.article;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Article> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Article b");
        return query.getResultList();
    }

    public List<Article> findFive() {
        List<Article> allList = findAll();
        Collections.reverse(allList);
        if (allList.size() > 5) {
            return allList.subList(0, 5);
        } else {
            return allList;
        }
    }

    public void save(Article entity) {
        entityManager.persist(entity);
    }

    public Article findById(Long id) {
        return entityManager.find(Article.class, id);
    }

    public Article findByIdWithCategories(Long id) {
        Article article = entityManager.find(Article.class, id);
        Hibernate.initialize(article.getCategories());
        return article;
    }

    public Article update(Article entity) {
        LocalDateTime created = entity.getCreated();
        System.out.println(created);
        Article article = entityManager.merge(entity);
        article.setCreated(created);
        return article;
    }

    public void deleteById(Long id) {
        Article articleToDelete = findById(id);
        if (articleToDelete != null) {
            entityManager.remove(articleToDelete);
        }
    }

    public List<Article> findAllWithDraft() {
        Query query = entityManager.createQuery("SELECT b FROM Article b WHERE b.draft = true ");
        return query.getResultList();
    }
}
