package ldc.accenture.superkanar.controllers;

import ldc.accenture.superkanar.models.TestModel;
import ldc.accenture.superkanar.services.TestModelService;
import ldc.accenture.superkanar.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private TestModelService testModelService;
    Random random = new Random();

    @RequestMapping(value="/" , method = RequestMethod.GET)
    public String welcome(@RequestParam("num") int num){
        List<TestModel> testModels = new LinkedList<TestModel>();

        TestModel testModel = null;
        for( int i = 0 ; i < num ; i++ ){
            testModel = new TestModel(StringUtil.generateRandomString(10),
                   random.nextInt(100),
                    StringUtil.generateRandomString(40));
            testModels.add(testModel);
        }

        for (TestModel element : testModels) {
            testModelService.saveUserToDB(element);

        }


        return "welcome";
    }
}
