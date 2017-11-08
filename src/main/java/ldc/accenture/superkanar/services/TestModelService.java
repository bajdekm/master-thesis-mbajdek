package ldc.accenture.superkanar.services;

import ldc.accenture.superkanar.models.TestModel;
import ldc.accenture.superkanar.repo.ITestModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestModelService {

    @Autowired
    private ITestModelRepo repository;


    public void saveUserToDB(TestModel testModel){
        repository.save(testModel);
    }
}
