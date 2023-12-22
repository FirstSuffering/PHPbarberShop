package nc.it.chayutpong.office.repository;

import org.springframework.data.repository.CrudRepository;

import nc.it.chayutpong.office.model.Department;

public interface DeptRepository extends CrudRepository<Department, Integer>{
}
