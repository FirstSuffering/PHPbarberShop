package nc.it.chayutpong.office;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nc.it.chayutpong.office.model.Employee;
import nc.it.chayutpong.office.model.Project;
import nc.it.chayutpong.office.model.Department;
import nc.it.chayutpong.office.repository.EmpRepository;
import nc.it.chayutpong.office.repository.DeptRepository;
import nc.it.chayutpong.office.repository.ProjectRepository;

@SpringBootApplication
public class OfficeApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(
			OfficeApplication.class);
	private final EmpRepository empRepository;
	private final DeptRepository deptRepository;
	private final ProjectRepository projectRepository;

	public OfficeApplication(EmpRepository empRepository, DeptRepository deptRepository, ProjectRepository projectRepository) {
		this.empRepository = empRepository;
		this.deptRepository = deptRepository;
		this.projectRepository = projectRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(OfficeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Department dept1 = new Department("Trainee");
		Department dept2 = new Department("Normal Employee");

		Project p1 = new Project("Best Employee");
		Project p2 = new Project("The Trainee");

		deptRepository.saveAll(Arrays.asList(dept1, dept2));
		projectRepository.saveAll(Arrays.asList(p1, p2));

		empRepository.save(new Employee("Joseph Jostar", 10000, dept1, p2));
		empRepository.save(new Employee("B.O.B", 12000, dept1, p2));
		empRepository.save(new Employee("Jean Gunnhildr", 20000, dept2, p1));

		
		for (Employee emp : empRepository.findAll()) {
			logger.info("Name: {}, Salary: {}",
			emp.getName(), emp.getSalary());
		} 

		for (Department dept : deptRepository.findAll()) {
			logger.info("Department: {}",
			dept.getName());
		}

		for (Project project : projectRepository.findAll()) {
			logger.info("Department: {}",
			project.getName());
		}

		logger.info("================ findByName =================");
		for (Employee emp : empRepository.findByName("B.O.B")) {
			logger.info("Employee's name: {}, Salary: {}",
			emp.getName(), emp.getSalary());
		}

		logger.info("================ findBySalaryGreaterThan =================");
		for (Employee emp : empRepository.findBySalaryGreaterThan(11000)) {
			logger.info("Employee's name: {}, Salary: {}",
			emp.getName(), emp.getSalary());
		}
		
		logger.info("================ findByNameContaining =================");
		for (Project project : projectRepository.findByNameContaining("The")) {
			logger.info("Project's name: {}",
			project.getName());
		}
	}
}
