/* 
 * The CollegeService interface defines the contract for interacting with college-related operations.
 * It abstracts away the implementation details and provides a clear, standardized way for different 
 * components of the application to communicate with the business logic layer responsible for handling 
 * college-related functionality.
 */
public interface CollegeService {

    /* 
     * Method signature to add a new college to the system.
     * This method allows the application to add a new college entity to the database.
     * @param college The College object representing the college to be added.
     */
    public void addCollege(College college);

    /* 
     * Method signature to retrieve college details by college ID.
     * This method allows the application to retrieve details of a college entity from the database based on its ID.
     * @param collegeId The unique identifier of the college to retrieve.
     */
    public void getCollegeById(int collegeId);

    /* 
     * Method signature to retrieve details of all colleges.
     * This method allows the application to retrieve details of all college entities stored in the database.
     */
    public void getAllCollege();

    /* 
     * Method signature to delete a college by its ID.
     * This method allows the application to delete a college entity from the database based on its ID.
     * @param collegeId The unique identifier of the college to delete.
     */
    public void deleteCollege(int collegeId);

    /* 
     * Method signature to update details of a college.
     * This method allows the application to update details of a college entity in the database based on its ID.
     * @param collegeId The unique identifier of the college to update.
     */
    public void updateCollege(int collegeId);
}
