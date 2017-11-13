package pl.lodz.p.mgr.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.lodz.p.mgr.models.Book;
import pl.lodz.p.mgr.models.BookCategory;
import pl.lodz.p.mgr.repo.BookCategoryRepository;
import pl.lodz.p.mgr.utils.StringUtil;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    BookCategoryRepository repository;

    Random random = new Random();

    @RequestMapping("/")
    public String reqMap(){
        return "welcome";
    }

    @RequestMapping(value="/gen" , method = RequestMethod.GET)
    public String welcome(@RequestParam("num") int num){

        BookCategory category = new BookCategory("FairyTale");
        Set<Book> books = new HashSet<Book>();
        for (int i = 0; i < num; i++) {
            books.add( new Book(StringUtil.generateRandomString(15), category) );
        }
        category.setBooks(books);

        repository.save(category);

        return "welcome";
    }

    @RequestMapping("/del")
    public String del(){
        BookCategory cat = repository.findOne(1);
        repository.delete(cat);


        return "welcome";
    }

}
