package hibernate_many_to_many;


import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try
        {
            session = factory.getCurrentSession();
//
//            Section section1 = new Section("izo");
//            Child child1 = new Child("Kate", 5);
//            Child child2 = new Child("Masha", 6);
//            Child child3 = new Child("Alex", 7);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//            session.save(section1);
//            session.getTransaction().commit();
//            System.out.println("Done");




//            Section section1 = new Section("Voleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Igor", 5);
//            child1.addSectoin(section1);
//            child1.addSectoin(section2);
//            child1.addSectoin(section3);
//
//            session.beginTransaction();
//            session.save(child1);
//            session.getTransaction().commit();
//            System.out.println("Done");




//            session.beginTransaction();
//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildrens());
//
//            session.getTransaction().commit();
//            System.out.println("Done");

//            session.beginTransaction();
//            Child child = session.get(Child.class, 7);
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            session.getTransaction().commit();
//            System.out.println("Done");


            session.beginTransaction();
            Section section = session.get(Section.class, 1);
            session.delete(section);
            session.getTransaction().commit();
            System.out.println("Done");

        }
        finally {
            factory.close();
            session.close();
        }

    }
}
