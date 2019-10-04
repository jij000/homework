package edu.mum.formatter;

import edu.mum.domain.Category;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CategoryFormatter implements Formatter<Category> {
    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        int id = Integer.parseInt(text.substring(0, 1));
        String name = text.substring(2);
        return new Category(id, name);
    }

    @Override
    public String print(Category category, Locale locale) {
        return category.getId() + ":" + category.getName();
    }
}
