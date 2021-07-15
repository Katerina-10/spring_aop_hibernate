package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {


//            Employee emp = new Employee("Misha", "Smit", "Hr", 600);
//            Detail detail = new Detail("Lond", "123","emailMisha");
//
//            emp.setEmpDetail(detail);
//            detail.setEmployee(emp);
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            session.save(detail);
//
//            session.getTransaction().commit();
//            System.out.println("Добавление успешно завершено");





//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Detail det = session.get(Detail.class, 3); //по id
//            System.out.println(det.getEmployee());
//            session.getTransaction().commit();
//            System.out.println("Добавление успешно завершено");


            session = factory.getCurrentSession();
            session.beginTransaction();
            Detail det = session.get(Detail.class, 1); //по id
            det.getEmployee().setEmpDetail(null);
            session.delete(det);
            session.getTransaction().commit();
            System.out.println("Добавление успешно завершено");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
