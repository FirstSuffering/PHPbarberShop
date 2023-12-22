package nc.it.chayutpong.office.model;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Getter @Setter @NoArgsConstructor
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private int salary;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="dept_id")
private Department dept;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="project_id")
private Project project;

public Employee(String name, int salary, Department dept, Project project) {
    this.name = name;
    this.salary = salary;
    this.dept = dept;
    this.project = project;
}

}