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

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {


    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping(value = "/showAll")
    public String showAll(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "articles";
    }

    @GetMapping(value = "/addForm")
    public String processForm(Model model) {
        model.addAttribute("article", new Article());
        return "addArticleForm";
    }

    @PostMapping(value = "/addForm")
    public String processForm(@Validated({ArticleValidationGroup.class}) Article article, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addArticleForm";
        }
        article.setDraft(false);
        articleDao.save(article);
        model.addAttribute("article", articleDao.findAll());
        return "redirect:showAll";
    }

    @GetMapping(value = "/edit/{id}")
    public String processForm(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleDao.findByIdWithCategories(id));
        return "addArticleForm";
    }

    @PostMapping(value = "/edit/{id}")
    public String processForm(@Validated({ArticleValidationGroup.class}) Article article, BindingResult result, Model model, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "addArticleForm";
        }
        article.setDraft(false);
        articleDao.update(article);
        model.addAttribute("article", articleDao.findAll());
        return "redirect:../showAll";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        articleDao.deleteById(id);
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

