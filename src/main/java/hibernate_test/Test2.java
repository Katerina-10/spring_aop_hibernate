package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        /*
        <property name="connection.url">jdbc:mysql://localhost:3306/myDB?useSSL=false&amp;allowPublicKeyRetrieval=true&amp;serverTimezone=UTC</property>
                jdbc:mysql://localhost:3306/myDB?useSSL=false&amp;serverTimezone=UTC
         */


        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Oleg", "Ivanov", "HR", 600);
            session.beginTransaction();
            session.save(emp);
            //session.getTransaction().commit();

            int myId = emp.getId();
            //session = factory.getCurrentSession();
            //session.beginTransaction();
            Employee emp2 = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(emp);
            System.out.println(emp2);

            System.out.println("Добавление успешно завершено");
        }
        finally {
            factory.close();
        }
    }
}
