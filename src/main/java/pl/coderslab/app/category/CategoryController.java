package pl.coderslab.app.category;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping(value = "/showAll")
    public String showAll(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        return "categories";
    }

    @GetMapping(value = "/addForm")
    public String processForm(Model model) {
        model.addAttribute("category", new Category());
        return "addCategoryForm";
    }

    @PostMapping(value = "/addForm")
    public String processForm(@Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addCategoryForm";
        }
        categoryDao.save(category);
        model.addAttribute("categories", categoryDao.findAll());
        return "redirect:showAll";
    }

    @GetMapping(value = "/edit/{id}")
    public String processForm(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryDao.findById(id));
        return "addCategoryForm";
    }

    @PostMapping(value = "/edit/{id}")
    public String processForm(@Valid Category category, BindingResult result, Model model, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "addCategoryForm";
        }
        categoryDao.update(category);
        model.addAttribute("category", categoryDao.findAll());
        return "redirect:../showAll";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryDao.deleteById(id);
        return "redirect:../showAll";
    }

}
