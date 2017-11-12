package pl.lodz.p.mgr.services;

import lombok.extern.slf4j.Slf4j;
import pl.lodz.p.mgr.models.TestModel;
import pl.lodz.p.mgr.repo.ITestModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class TestModelService {

    @Autowired
    private ITestModelRepo repository;


    public void saveUserToDB(TestModel testModel){
        repository.save(testModel);
    }

    public void destroyAllModels(){
        double startTime = System.currentTimeMillis();
        repository.deleteAll();
        double stopTime = System.currentTimeMillis();
        double elapsedTime = stopTime - startTime;
        log.info("@@ destroy all: " + elapsedTime + "ms");
    }

    public void getAllRecords(){
        double startTime = System.currentTimeMillis();
        repository.findAll();
        double stopTime = System.currentTimeMillis();
        double elapsedTime = stopTime - startTime;
        log.info("@@ select all: " + elapsedTime + "ms");
    }

    public List<TestModel> getAllTestModels(){
        return (List<TestModel>) repository.findAll();
    }
}
