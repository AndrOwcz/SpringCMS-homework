package pl.coderslab.app.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.article.ArticleDao;
import pl.coderslab.app.article.Article;

@Controller
public class HomePageController {

    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @ResponseBody
    @RequestMapping("/")
    public String getAllArticles() {
        return articleDao.findAll().toString();
    }

    @ResponseBody
    @RequestMapping(value = "/findFive", produces = "text/html")
    public String getFiveArticles() {
        StringBuilder sb = new StringBuilder();
        for (Article article : articleDao.findFive()) {
            sb.append(getResults(article));
        }
        return sb.toString();
    }

    private String getResults(Article article) {
        String trimmedContent = article.getContent();
        if (trimmedContent.length() > 200) {
            trimmedContent = trimmedContent.substring(0, 200);
        }
        return article.getTitle() + " " + article.getCreated() + " " + trimmedContent + " ";
    }

    @ResponseBody
    @RequestMapping("/findMore")
    public String findMore() {
        return articleDao.findFive().toString();
    }
}
