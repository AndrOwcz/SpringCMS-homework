package pl.coderslab.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.app.article.Article;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findById(Long id);

    @Query(value = "SELECT * FROM article AS a JOIN article_categories ON a.id = article_categories.Article_id WHERE a.id = ?1", nativeQuery = true)
    Optional<Article> findByIdWithCategories(Long id);

}
