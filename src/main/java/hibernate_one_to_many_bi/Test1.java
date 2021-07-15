package hibernate_one_to_many_bi;



import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {

//            session = factory.getCurrentSession();
//            Department dep = new Department("Sales", 300, 1200);
//            Employee emp1 = new Employee("Kate", "Fam", 800);
//            Employee emp2 = new Employee("Elena", "Smir", 1200);
//            Employee emp3 = new Employee("Anton", "Sid", 1000);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//            session.beginTransaction();
//            session.save(dep);
//            session.getTransaction().commit();
//            System.out.println("успешно завершено");

            session = factory.getCurrentSession();
            session.beginTransaction();
            Department dep = session.get(Department.class, 3);
            System.out.println(dep);
            System.out.println("emp of the dep");
            System.out.println(dep.getEmps());
            session.getTransaction().commit();
            System.out.println("успешно завершено");

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class,1);
//            System.out.println(emp);
//            System.out.println(emp.getDepartment());
//            session.getTransaction().commit();
//            System.out.println("успешно завершено");


//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class,1);
//            session.delete(emp);
//            session.getTransaction().commit();
//            System.out.println("успешно завершено");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
