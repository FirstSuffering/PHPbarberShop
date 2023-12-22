package nc.it.chayutpong.office.repository;
import org.springframework.data.repository.CrudRepository;

import nc.it.chayutpong.office.model.Employee;

import java.util.List;

public interface EmpRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByName(String name);
    List<Employee> findBySalaryGreaterThan(int salary);
}
