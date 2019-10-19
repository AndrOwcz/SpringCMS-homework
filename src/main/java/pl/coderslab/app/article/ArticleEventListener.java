package pl.coderslab.app.article;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class ArticleEventListener {

    @PrePersist
    public void prePersist(Object object) {
        Article article = (Article) object;
        article.setCreated(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(Object object) {
        Article article = (Article) object;
        article.setUpdated(LocalDateTime.now());
    }
}