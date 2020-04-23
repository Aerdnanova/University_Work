/* Class used to hold the course details
 * Andrea Bonato
 * 104760390
 * */
package goodcode;

public class CourseDetails {
	
	//Holds course code and title of course
	String courseCode;
	String courseName;
	
	public CourseDetails() {}
	
	//Get course code
	public String getCourseCode () {
		
		return courseCode;
	}
	
	//Get title
	public String getCourseName() {
		return courseName;
	}
	
	//Set course code
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	//Set title
	public void setCourseName(String courseName) {
		this.courseName=courseName;
	}
	
	//Print off header section of output
	public String printHeader() {
		return "Course Outline\n\nCourse No: " + courseCode + "\nCourse Title: "+
				courseName+"\n";
	}
	
}
