package hibernate_one_to_many_bi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String departmentName;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    //@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE}, mappedBy = "department")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department",fetch = FetchType.LAZY)
    private List<Employee> emps;


    public Department() {
    }

    public Department(String departmentName, int maxSalary, int minSalary) {
        this.departmentName = departmentName;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
    }

    public void addEmployeeToDepartment(Employee emp)
    {
        if (emps == null)
            emps = new ArrayList<>();
        emps.add(emp);
        emp.setDepartment(this);
    }

    public int getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", maxSalary=" + maxSalary +
                ", minSalary=" + minSalary +
                '}';
    }
}
