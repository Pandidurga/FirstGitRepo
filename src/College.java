// Import statements for required Java Persistence API (JPA) classes
// Annotation to specify that the class is an entity
import javax.persistence.Entity;
// Annotation to specify the primary key field
import javax.persistence.Id;
// Annotation to specify the table name in the database
import javax.persistence.Table; 
// Annotation to specify the column name in the database
import javax.persistence.Column;
// Annotation to specify the generation strategy for the primary key
import javax.persistence.GeneratedValue;
// Enumeration for primary key generation strategies
import javax.persistence.GenerationType;
// Class representing a timestamp
import java.sql.Timestamp;

// Annotation indicating that this class is a JPA entity mapped to a database table
@Entity
//Specify the table name in the database
@Table(name = "college")
// Java class representing a College entity in the database 
public class College {

    // Annotation specifying the primary key field
    @Id
	// Annotation specifying the column name in the database
    @Column(name = "college_id")
	// Annotation specifying the generation strategy for the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	// Field representing the unique identifier for the college
	private int collegeId;

    // Field representing the name of the college
    @Column(name = "college_name")
    private String collegeName;
	
	// Field representing the location of the college
    @Column(name = "location")
    private String location;
	
	// Field representing the type of the college
    @Column(name = "type")
    private String type;
	
	// Field representing the counselling code of the college
    @Column(name = "counselling_code")
    private int counsellingCode;
    
	// Field representing whether the college is autonomous or not
    @Column(name = "is_autonomous")
    private boolean isAutonomous;

	// Field representing the creator of the college entity
    @Column(name = "created_by")
    private String createdBy;
	
	// Field representing the timestamp when the college entity was created
    @Column(name = "created_at")
    private Timestamp createdAt;
	
	// Field representing the modifier of the college entity
    @Column(name = "modified_by")
    private String modifiedBy;
	
	 // Field representing the timestamp when the college entity was last modified
    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    // Default constructor (required by Hibernate)
    public College() {
    }

    // Constructor with fields 
    public College(int collegeId, String collegeName, String location, String type, int counsellingCode,
                   boolean isAutonomous, String createdBy, Timestamp createdAt, String modifiedBy, Timestamp modifiedAt) {
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.location = location;
        this.type = type;
        this.counsellingCode = counsellingCode;
        this.isAutonomous = isAutonomous;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = modifiedAt;
    }

    // Getter and Setter methods for collegeId
    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    // Getter and Setter methods for collegeName
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    // Getter and Setter methods for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getter and Setter methods for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter methods for counsellingCode
    public int getCounsellingCode() {
        return counsellingCode;
    }

    public void setCounsellingCode(int counsellingCode) {
        this.counsellingCode = counsellingCode;
    }

    // Getter and Setter methods for isAutonomous
    public boolean getIsAutonomous() {
        return isAutonomous;
    }

    public void setAutonomous(boolean autonomous) {
        isAutonomous = autonomous;
    }

    // Getter and Setter methods for createdBy
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    // Getter and Setter methods for createdAt
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // Getter and Setter methods for modifiedBy
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    // Getter and Setter methods for modifiedAt
    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
