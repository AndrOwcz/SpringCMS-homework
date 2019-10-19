package pl.coderslab.app.article;

import pl.coderslab.app.author.Author;
import pl.coderslab.app.category.Category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(ArticleEventListener.class)
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    @NotBlank(groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    @TitleSize(groups = ArticleValidationGroup.class)
    @Column(length = 200)
    private String title;

    @OneToOne
    private Author Author;

    @NotNull(groups = ArticleValidationGroup.class)
    @OneToMany
    private List<Category> categories;

    @NotNull(groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    @NotBlank(groups = {ArticleValidationGroup.class, DraftValidationGroup.class})
    @Size(min = 50, groups = ArticleValidationGroup.class)
    private String content;

    private LocalDateTime created;

    private LocalDateTime updated;

    private boolean draft;


    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public pl.coderslab.app.author.Author getAuthor() {
        return Author;
    }

    public void setAuthor(Author author) {
        Author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Author=" + Author +
                ", categories=" + categories +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", draft=" + draft +
                '}';
    }
}