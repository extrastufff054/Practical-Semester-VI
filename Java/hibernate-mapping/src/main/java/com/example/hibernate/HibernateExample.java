import org.hibernate.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import com.example.entities.Employee;

public class HibernateExample {
    public static void main(String[] args) {
        // Create the SessionFactory
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a Session and perform CRUD operations
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Save an Employee
        Employee employee = new Employee("John Doe", 50000.0);
        session.save(employee);

        // Retrieve an Employee
        Employee retrievedEmployee = session.get(Employee.class, employee.getId());
        System.out.println("Retrieved Employee: " + retrievedEmployee.getName());

        // Update an Employee
        retrievedEmployee.setSalary(55000.0);
        session.update(retrievedEmployee);

        // Delete an Employee
        session.delete(retrievedEmployee);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
