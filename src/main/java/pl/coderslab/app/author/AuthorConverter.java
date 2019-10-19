package pl.coderslab.app.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.app.category.Category;
import pl.coderslab.app.category.CategoryDao;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    AuthorDao authorDao;

    @Override
    public Author convert(String s) {
        return authorDao.findById(Long.parseLong(s));
    }

}
