package pl.lodz.p.mgr.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.lodz.p.mgr.models.TestModel;
import pl.lodz.p.mgr.services.TestModelService;
import pl.lodz.p.mgr.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Controller
@Slf4j
public class HomeController {


    @Autowired
    private TestModelService testModelService;
    Random random = new Random();

    @RequestMapping("/")
    public String reqMap(){
        return "welcome";
    }

    @RequestMapping("/da")
    public String destroyAll(){
        testModelService.destroyAllModels();
        return "welcome";
    }

    @RequestMapping(value="/gen" , method = RequestMethod.GET)
    public String welcome(@RequestParam("num") int num){
        List<TestModel> testModels = new LinkedList<TestModel>();

        TestModel testModel = null;
        for( int i = 0 ; i < num ; i++ ){
            testModel = new TestModel(StringUtil.generateRandomString(10),
                   random.nextInt(100),
                    StringUtil.generateRandomString(40));
            testModels.add(testModel);
        }

        double startTime = System.currentTimeMillis();
        for (TestModel element : testModels) {
            testModelService.saveUserToDB(element);

        }
        double stopTime = System.currentTimeMillis();
        double elapsedTime = stopTime - startTime;
        log.info("@@ time for "+ num+ " records : " + elapsedTime + "ms");


        return "welcome";
    }

    @RequestMapping("/sa")
    public String selectAll(){
        testModelService.getAllRecords();
        return "welcome";
    }

    @RequestMapping("/gj")
    public @ResponseBody List<TestModel> getAllTMJSON(){
        return testModelService.getAllTestModels();
    }

    @RequestMapping(value = "/pj", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void parseJson(@RequestBody List<TestModel> testModels){
        double startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (TestModel element: testModels) {
            sb.append("name: " + element.getName() + " someString: " + element.getRandomString() + " some num: " + element.getSomeNumber() + " , ");
            testModelService.saveUserToDB(element);
        }
       // log.info( sb.toString() );
        double stopTime = System.currentTimeMillis();
        double elapsedTime = stopTime - startTime;
        log.info("@@ time elapsed: " + elapsedTime + "ms");
    }
}
