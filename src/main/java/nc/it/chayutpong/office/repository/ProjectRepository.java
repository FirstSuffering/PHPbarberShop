package nc.it.chayutpong.office.repository;

import org.springframework.data.repository.CrudRepository;

import nc.it.chayutpong.office.model.Project;
import java.util.List;


public interface ProjectRepository extends CrudRepository<Project, Integer>{
    List<Project> findByNameContaining(String name);
}
