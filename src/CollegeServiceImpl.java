// Import statements for required classes and utilities
// Provides functionality for working with lists
import java.util.List; 
// Allows reading user input
import java.util.Scanner; 
// Represents a specific instant in time
import java.sql.Timestamp; 
// Represents date-time without a time-zone
import java.time.LocalDateTime; 
// Allows formatting and parsing date-time objects
import java.time.format.DateTimeFormatter; 

/*
 * Implementation class for CollegeService interfacee
 * This class provides implementations for various operations related to college management.
 */
public class CollegeServiceImpl implements CollegeService {
    private CollegeDao daoObj; // Data Access Object for College

    /*
     * Constructor to initialize CollegeServiceImpl with a CollegeDao object.
     */
    public CollegeServiceImpl(CollegeDao daoObj) {
        this.daoObj = daoObj;
    }

    /*
     * Method to add a new college
     * This method attempts to add a new college to the system using the provided College object.
     * If successful, it prints a success message; otherwise, it prints an error message.
     * @param college The College object representing the new college to be added.
     */
    public void addCollege(College college) {
        try {
            daoObj.addCollege(college);
            System.out.println("College inserted Successfully");
        } catch (Exception e) {
            System.out.println("Inserting College is failed with Error" + e);
        }
    }

    /*
     * Method to retrieve college details by ID
     * This method retrieves and prints details of a college based on the provided ID.
     * If the college is not found, it prints an error message.
     * @param collegeId The ID of the college to retrieve details for.
     */
    public void getCollegeById(int collegeId) {
        try {
            College college = daoObj.getCollegeById(collegeId);

            Timestamp createdAt = college.getCreatedAt();
            Timestamp modifiedAt = college.getModifiedAt();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");
            LocalDateTime createdDateTime = createdAt.toLocalDateTime();
            String formattedCreatedAt = createdDateTime.format(formatter).toUpperCase();
            LocalDateTime modifiedDateTime = modifiedAt.toLocalDateTime();
            String formattedModifiedAt = modifiedDateTime.format(formatter).toUpperCase();

            System.out.println("\n College Details\n");

            System.out.println("College Id: " + college.getCollegeId());
            System.out.println("College Name: " + college.getCollegeName());
            System.out.println("College Location: " + college.getLocation());
            System.out.println("College Type: " + college.getType());
            System.out.println("College Counselling code: " + college.getCounsellingCode());
            System.out.println("College Autonomous: " + college.getIsAutonomous());
            System.out.println("Created By: " + college.getCreatedBy());
            System.out.println("Created At: " + formattedCreatedAt);
            System.out.println("Modified By: " + college.getModifiedBy());
            System.out.println("Modidfied At: " + formattedModifiedAt);
        } catch (Exception e) {
            System.out.println("College is not found with error" + e);
        }
    }

    /*
     * Method to retrieve details of all colleges
     * This method retrieves and prints details of all colleges stored in the system.
     * If no colleges are found, it prints an error message.
     */
    public void getAllCollege() {
        try {
            List<College> colleges = daoObj.getAllCollege();
            System.out.println("\n College Details\n");

            for (College college : colleges) {
                System.out.println();
                Timestamp createdAt = college.getCreatedAt();
                Timestamp modifiedAt = college.getModifiedAt();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy  HH:mm");
                LocalDateTime createdDateTime = createdAt.toLocalDateTime();
                String formattedCreatedAt = createdDateTime.format(formatter).toUpperCase();
                LocalDateTime modifiedDateTime = modifiedAt.toLocalDateTime();
                String formattedModifiedAt = modifiedDateTime.format(formatter).toUpperCase();

                System.out.println("College Id: " + college.getCollegeId());
                System.out.println("College Name: " + college.getCollegeName());
                System.out.println("College Location:" + college.getLocation());
                System.out.println("College Type:" + college.getType());
                System.out.println("College Counselling code:" + college.getCounsellingCode());
                System.out.println("College Autonomous:" + college.getIsAutonomous());
                System.out.println("Created By: " + college.getCreatedBy());
                System.out.println("Created At: " + formattedCreatedAt);
                System.out.println("Modified By: " + college.getModifiedBy());
                System.out.println("Modidfied At: " + formattedModifiedAt);
            }
        } catch (Exception e) {
            System.out.println("College List is Empty " + e);
        }
    }

    /*
     * Method to delete a college by ID
     * This method attempts to delete a college from the system based on the provided ID.
     * If successful, it prints a success message; otherwise, it prints an error message.
     * @param collegeId The ID of the college to be deleted.
     */
    public void deleteCollege(int collegeId) {
        try {
            daoObj.deleteCollege(collegeId);
            System.out.println(collegeId + " is deleted Successfully");
        } catch (Exception e) {
            System.out.println("Deleting College is failed with Error" + e);
        }
    }

    /*
     * Method to update college details
     * This method prompts the user to input updated details for a college and updates the college accordingly.
     * If successful, it prints a success message; otherwise, it prints an error message.
     * @param collegeId The ID of the college to be updated.
     */
    public void updateCollege(int collegeId) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter UpdatedName:(if not 'N')");
        String updatedName = sc.nextLine();

        System.out.println("Enter UpdatedLocation:(if not 'N')");
        String updatedLocation = sc.nextLine();

        System.out.println("Enter UpdatedType:(if not 'N')");
        String updatedType = sc.nextLine();

        System.out.println("Enter UpdatedCode:(if not '0')");
        int updatedCode = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter UpdatedAutonomous:(if not 'N')");
        String updatedAutonomous = sc.nextLine();

        College updatedCollege = new College();
        try {
            updatedCollege = daoObj.getCollegeById(collegeId);
        } catch (Exception e) {
            System.out.println("College not found " + e);
        }

        if (!updatedName.equals("N")) {
            updatedCollege.setCollegeName(updatedName);
        }

        if (!updatedLocation.equals("N")) {
            updatedCollege.setLocation(updatedLocation);
        }

        if (!updatedType.equals("N")) {
            updatedCollege.setType(updatedType);
        }

        if (updatedCode != 0) {
            updatedCollege.setCounsellingCode(updatedCode);
        }

        if (!updatedAutonomous.equals("N")) {
            if (updatedAutonomous.equals("true")) {
                updatedCollege.setAutonomous(true);
            } else if (updatedAutonomous.equals("false")) {
                updatedCollege.setAutonomous(false);
            }
        }

        updatedCollege.setModifiedBy("USER");
        updatedCollege.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        try {
            daoObj.updateCollege(updatedCollege);
            System.out.println(collegeId + " is Updated Successfully");
        } catch (Exception e) {
            System.out.println("Updation is failed with Error" + e);
        }

    }
}
