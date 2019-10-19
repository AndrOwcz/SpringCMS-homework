package pl.coderslab.app.category;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Category> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Category b");
        return query.getResultList();
    }

    public void save(Category entity) {
        entityManager.persist(entity);
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public Category update(Category entity) {
        return entityManager.merge(entity);
    }

    public void deleteById(Long id) {
        Category categoryToDelete = findById(id);
        if (categoryToDelete != null) {
            entityManager.remove(categoryToDelete);
        }
    }
}
