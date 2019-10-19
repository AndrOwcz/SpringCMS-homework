package pl.coderslab.app.author;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping(value = "/showAll")
    public String showAll(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "authors";
    }

    @GetMapping(value = "/addForm")
    public String processForm(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthorForm";
    }

    @PostMapping(value = "/addForm")
    public String processForm(@Valid Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addAuthorForm";
        }
        authorDao.save(author);
        model.addAttribute("authors", authorDao.findAll());
        return "redirect:showAll";
    }

    @GetMapping(value = "/edit/{id}")
    public String processForm(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorDao.findById(id));
        return "addAuthorForm";
    }

    @PostMapping(value = "/edit/{id}")
    public String processForm(@Valid Author author, BindingResult result, Model model, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "addAuthorForm";
        }
        authorDao.update(author);
        model.addAttribute("author", authorDao.findAll());
        return "redirect:../showAll";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        authorDao.deleteById(id);
        return "redirect:../showAll";
    }
}
