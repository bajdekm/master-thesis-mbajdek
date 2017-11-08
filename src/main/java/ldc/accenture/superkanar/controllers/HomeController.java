package ldc.accenture.superkanar.controllers;

import ldc.accenture.superkanar.models.TestModel;
import ldc.accenture.superkanar.services.TestModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private TestModelService testModelService;

    @RequestMapping(value="/" , method = RequestMethod.GET)
    public String welcome(){

        TestModel testModel = new TestModel();
        testModel.setName("pipszczok");
        testModel.setDupa("dupsztal totalus");

        testModelService.saveUserToDB(testModel);

        return "welcome";
    }
}
