import org.hibernate.Session; // Represents a single connection to the database
import org.hibernate.SessionFactory; // Factory for creating sessions
import org.hibernate.Transaction; // Manages transactions
import org.hibernate.cfg.Configuration; // Loads configuration settings for Hibernate
import org.hibernate.query.Query; // Represents a Hibernate query
import java.util.List; // Provides functionality for working with lists

public class CollegeDaoImpl implements CollegeDao {
    private SessionFactory sessionFactory;

    public CollegeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Method to add a college to the database
    public void addCollege(College college) {
        Session session = sessionFactory.openSession(); // Open a new session
        Transaction transaction = session.beginTransaction(); // Begin a transaction

        try {
            session.save(college); // Save the college object to the database
            transaction.commit(); // Commit the transaction if successful
        } catch (Exception e) {
            transaction.rollback(); // Rollback the transaction if an exception occurs
            throw e; // Rethrow the exception
        } finally {
            if (session != null) {
                session.close(); // Close the session to release resources
            }
        }
    }

    // Method to retrieve a college by its ID from the database
    public College getCollegeById(int collegeId) {
        Session session = sessionFactory.openSession(); // Open a new session
        Transaction transaction = session.beginTransaction(); // Begin a transaction
        College college = new College(); // Create a new College object

        try {
            college = (College) session.get(College.class, collegeId); // Retrieve the college by its ID
        } catch (Exception e) {
            transaction.rollback(); // Rollback the transaction if an exception occurs
            throw e; // Rethrow the exception
        } finally {
            if (session != null) {
                session.close(); // Close the session to release resources
            }
        }
        return college; // Return the retrieved college object
    }

    // Method to retrieve all colleges from the database
    public List<College> getAllCollege() {
        Session session = sessionFactory.openSession(); // Open a new session
        Transaction transaction = session.beginTransaction(); // Begin a transaction
        List<College> colleges = null; // Initialize a list to hold colleges

        try {
            colleges = session.createQuery("FROM College").list(); // Query all colleges from the database
            transaction.commit(); // Commit the transaction if successful
        } catch (Exception e) {
            transaction.rollback(); // Rollback the transaction if an exception occurs
            throw e; // Rethrow the exception
        } finally {
            if (session != null) {
                session.close(); // Close the session to release resources
            }
        }
        return colleges; // Return the list of colleges
    }

    // Method to delete a college from the database
    public void deleteCollege(int collegeId) {
        Session session = sessionFactory.openSession(); // Open a new session
        Transaction transaction = session.beginTransaction(); // Begin a transaction

        try {
            College college = getCollegeById(collegeId); // Retrieve the college by its ID
            session.delete(college); // Delete the college object from the database
            transaction.commit(); // Commit the transaction if successful
        } catch (Exception e) {
            transaction.rollback(); // Rollback the transaction if an exception occurs
            throw e; // Rethrow the exception
        } finally {
            if (session != null) {
                session.close(); // Close the session to release resources
            }
        }
    }

    // Method to update a college in the database
    public void updateCollege(College updatedCollege) {
        Session session = sessionFactory.openSession(); // Open a new session
        Transaction transaction = session.beginTransaction(); // Begin a transaction

        try {
            session.update(updatedCollege); // Update the college object in the database
            transaction.commit(); // Commit the transaction if successful
        } catch (Exception e) {
            transaction.rollback(); // Rollback the transaction if an exception occurs
            throw e; // Rethrow the exception
        } finally {
            if (session != null) {
                session.close(); // Close the session to release resources
            }
        }
    }
}
