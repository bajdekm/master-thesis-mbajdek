package pl.lodz.p.mgr.repo;

import pl.lodz.p.mgr.models.TestModel;
import org.springframework.data.repository.CrudRepository;

public interface ITestModelRepo extends CrudRepository<TestModel,Integer> {

}
