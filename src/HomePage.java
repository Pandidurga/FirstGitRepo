/*-------------------------------------------WELCOME TO COLLEGE MANAGEMENT SYSTEM------------------------------------
 * This class represents the main homepage for the College Management System.
 * It serves as the entry point of the application and provides a menu-driven interface 
 * for users to interact with various functionalities related to college management.
 * The class integrates with the CollegeService layer to perform operations on college entities.
 */

// Hibernate Session
import org.hibernate.Session; 
// Hibernate SessionFactory
import org.hibernate.SessionFactory;
// Hibernate Transaction 
import org.hibernate.Transaction;
// Hibernate Configuration 
import org.hibernate.cfg.Configuration; 
// SQL Timestamp
import java.sql.Timestamp; 
// Scanner for user input
import java.util.Scanner; 

/* 
 * Class representing the main homepage for College Management System
 * This class is the starting point of this entire application
 * In this main class, All the service class methods will be called, and the required parameters will be passed by getting from the user
 */
public class HomePage {

    /* 
     * Main method to start the College Management System application
     */
    public static void main(String[] args) {
        // Create a Hibernate SessionFactory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
        // Create Data Access Object (DAO) for College
        CollegeDao daoObj = new CollegeDaoImpl(sessionFactory);
        
		// Create Service Object for College
        CollegeService serviceObj = new CollegeServiceImpl(daoObj);
        
		// Create an instance of HomePage class
        HomePage homeObj = new HomePage();

        // Scanner object for user input
        Scanner sc = new Scanner(System.in);
        int n = 1;
        // Loop until user chooses to exit
        while (n != 0) {
            System.out.println("\n Welcome to College Management System\n");
            System.out.println("Enter Your choice:\n1.Add College\n2.Display CollegeById\n3.Display All Colleges\n4.Delete College\n5.Update College\n6.Exit");

            // User input for choice
            int choice = sc.nextInt();
            switch (choice) {
				
				//case 1 responsible for calling addCollege method and passing serviceobj to the method
                case 1:
                    homeObj.addCollege(serviceObj);
                    break;
                //case 2 responsible for calling getCollegeById and passing serviceobj to the method
                case 2:
                    homeObj.getCollegeById(serviceObj);
                    break;
				//case 3 responsible for calling getCollege method to display all colleges and passing serviceobj to the method	
                case 3:
                    homeObj.getAllCollege(serviceObj);
                    break;
				//case 4 responsible for calling deleteCollege method and passing serviceobj to the method
                case 4:
                    homeObj.deleteCollege(serviceObj);
                    break;
				//case 5 responsible for calling updateCollege method and passing serviceobj to the method
                case 5:
                    homeObj.updateCollege(serviceObj);
                    break;
				//case 6 responsible for setting the n value to 0 for terminating the loop 
                case 6:
                    n = 0;
                    System.out.println("Exited...");
                    break;
            }
        }
    }


	/* 
	 * Method to add a new college
	 * This method prompts the user to input details of a new college,
	 * creates a new College object with the provided information, sets
	 * creator, created timestamp, modifier, and modified timestamp, and
	 * then it responsible for the task of adding the college to the CollegeService layer.
	 * @param serviceObj The CollegeService object responsible for adding the college to the system.
	 */
    public void addCollege(CollegeService serviceObj) {
        // Create a new College object
		College college = new College(); 

		// Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // User input for College details
        System.out.println("Enter College Name:");
        String collegeName = sc.nextLine();
        college.setCollegeName(collegeName);

        System.out.println("Enter College Location:");
        String location = sc.nextLine();
        college.setLocation(location);

        System.out.println("Enter College Type:");
        String type = sc.nextLine();
        college.setType(type);

        System.out.println("Enter Counselling Code:");
        int counsellingCode = sc.nextInt();
        sc.nextLine();
        college.setCounsellingCode(counsellingCode);

        System.out.println("Enter Autonomous Status:");
        boolean isAutonomous = sc.nextBoolean();
        sc.nextLine();
        college.setAutonomous(isAutonomous);

        // Set creator, created timestamp, modifier, and modified timestamp
        college.setCreatedBy("Admin");
        college.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        college.setModifiedBy("Admin");
        college.setModifiedAt(new Timestamp(System.currentTimeMillis()));

        // Add the new College to the database
        serviceObj.addCollege(college);
    }

    
	/* 
	 * Method to get college details by ID
	 * This method prompts the user to input the ID of the college they want to retrieve details for.
	 * It then delegates the task of retrieving the college details by ID to the CollegeService layer.
	 * @param serviceObj The CollegeService object responsible for retrieving college details by ID.
	 */
    public void getCollegeById(CollegeService serviceObj) {
		// Scanner object for user input
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter College Id:");
        int collegeId = sc.nextInt();
        serviceObj.getCollegeById(collegeId);
    }
    
	/* 
	 * Method to get all colleges
	 * This method delegates the task of retrieving details of all colleges to the CollegeService layer.
	 * @param serviceObj The CollegeService object responsible for retrieving details of all colleges.
	 */
    public void getAllCollege(CollegeService serviceObj) {
        serviceObj.getAllCollege();
    }

    /* 
	 * Method to delete a college
	 * This method prompts the user to input the ID of the college they want to delete.
	 * It then delegates the task of deleting the college to the CollegeService layer.
	 * @param serviceObj The CollegeService object responsible for deleting a college by ID.
	 */
    public void deleteCollege(CollegeService serviceObj) {
        Scanner sc = new Scanner(System.in); // Scanner object for user input
        System.out.println("Enter College Id:");
        int collegeId = sc.nextInt();
        serviceObj.deleteCollege(collegeId);
    }

    /* 
	 * Method to update college details
	 * This method prompts the user to input the ID of the college they want to update.
	 * It then delegates the task of updating the college details to the CollegeService layer.
	 * @param serviceObj The CollegeService object responsible for updating college details by ID.
	 */
    public void updateCollege(CollegeService serviceObj) {
        Scanner sc = new Scanner(System.in); // Scanner object for user input
        System.out.println("Enter College Id:");
        int collegeId = sc.nextInt();

        serviceObj.updateCollege(collegeId);
    }
}
