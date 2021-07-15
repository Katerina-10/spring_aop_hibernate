package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
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
            Employee emp = new Employee("Kate", "Famili", "it", 900);
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

            System.out.println("Добавление успешно завершено");
        }
        finally {
            factory.close();
        }
    }
}
