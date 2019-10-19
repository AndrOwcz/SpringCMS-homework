package pl.coderslab.app.article;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.author.Author;
import pl.coderslab.app.author.AuthorDao;
import pl.coderslab.app.category.Category;
import pl.coderslab.app.category.CategoryDao;
import pl.coderslab.app.repositories.ArticleRepository;

import java.util.List;

@Controller
@RequestMapping("/article/repo")
public class ArticleControllerFromRepo {


    private final ArticleRepository articleRepository;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleControllerFromRepo(ArticleRepository articleRepository, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleRepository = articleRepository;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping(value = "/showAll")
    public String showAll(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "articlesRepo";
    }

    @GetMapping(value = "/addForm")
    public String processForm(Model model) {
        model.addAttribute("article", new Article());
        return "addArticleFormRepo";
    }

    @PostMapping(value = "/addForm")
    public String processForm(@Validated({ArticleValidationGroup.class}) Article article, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addArticleFormRepo";
        }
        article.setDraft(false);
        articleRepository.save(article);
        model.addAttribute("article", articleRepository.findAll());
        return "redirect:showAll";
    }

    @GetMapping(value = "/edit/{id}")
    public String processForm(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleRepository.findByIdWithCategories(id));
        return "addArticleFormRepo";
    }

    @PostMapping(value = "/edit/{id}")
    public String processForm(@Validated({ArticleValidationGroup.class}) Article article, BindingResult result, Model model, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "addArticleFormRepo";
        }
        article.setDraft(false);
        articleRepository.save(article);
        model.addAttribute("article", articleRepository.findAll());
        return "redirect:../showAll";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return "redirect:../showAll";
    }

    @ModelAttribute("authors")
    public List<Author> fetchAllAuthors() {
        return authorDao.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> fetchAllCategories() {
        return categoryDao.findAll();
    }
}

