package pl.lodz.p.mgr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lodz.p.mgr.models.BookCategory;
import pl.lodz.p.mgr.repo.BookCategoryRepository;

import java.util.List;

@Controller
@RequestMapping("/i")
public class RestController {

    @Autowired
    BookCategoryRepository repository;

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public @ResponseBody List<BookCategory> getBC(){
        return repository.findAll();
    }

//
//    @Autowired
//    private TestModelService testModelService;
//
//    @RequestMapping(value="/all",method = RequestMethod.GET)
//    public @ResponseBody List<TestModel> getModels(){
//        return testModelService.getAllTestModels();
//
//
//
//    }
}
