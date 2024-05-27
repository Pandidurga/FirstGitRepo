//Import list Provides functionality for working with lists
import java.util.List;
/* 
 * The CollegeDao interface defines the contract for performing CRUD operations on college entities in the database.
 * It abstracts away the implementation details of data access and provides a standardized way for different 
 * components of the application to interact with the database layer responsible for college-related operations.
 */
public interface CollegeDao {

    /* 
     * Method signature to add a new college to the database.
     * This method allows the data access layer to insert a new college entity into the database.
     * @param college The College object representing the college to be added.
     */
    public void addCollege(College college);

    /* 
     * Method signature to retrieve a college by its ID from the database.
     * This method allows the data access layer to fetch details of a college entity from the database based on its ID.
     * @param collegeId The unique identifier of the college to retrieve.
     * @return The College object representing the retrieved college entity.
     */
    public College getCollegeById(int collegeId);

    /* 
     * Method signature to retrieve details of all colleges from the database.
     * This method allows the data access layer to fetch details of all college entities stored in the database.
     * @return A List containing all College objects representing the retrieved college entities.
     */
    public List<College> getAllCollege();

    /* 
     * Method signature to delete a college from the database by its ID.
     * This method allows the data access layer to delete a college entity from the database based on its ID.
     * @param collegeId The unique identifier of the college to delete.
     */
    public void deleteCollege(int collegeId);

    /* 
     * Method signature to update details of a college in the database.
     * This method allows the data access layer to update details of a college entity in the database.
     * @param updatedCollege The College object representing the updated details of the college.
     */
    public void updateCollege(College updatedCollege);
}
