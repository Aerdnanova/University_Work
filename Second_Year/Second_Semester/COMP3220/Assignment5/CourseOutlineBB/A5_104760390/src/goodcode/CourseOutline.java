/* Class used to assign all the values and create the remaining body
 * section of the output
 * Andrea Bonato
 * 104760390
 * */
package goodcode;

public class CourseOutline {
	
	//This will isntantiate all other classes and determine body output
	public String generateCourseOutline(String type, String courseSize) {
		LectureMethod Lm;
		OfficeHour Oh;
		ExamType Et;
		DiscussionBoard Db;
		CourseFee Cf;
		HousingCost Hc;
		CourseFactory CF;
		
		//Checks to see if it is inclass
		if(type.equals("Inclass")) {
			CF = new OfflineCourse();
		}else {

			CF = new OnlineCourse();
		}
		
		//Assigns proper values
		Lm = CF.createLectureMethod();
		Oh = CF.setOfficeHour();
		Et = CF.setExamType();
		Db = CF.setupDiscussionBoard();
		Cf = CF.estimatedCourseFee();
		Hc = CF.estimatedHousingCost();
		
		//Return string
		return Lm.displayLectureMethod() + Oh.setAndDisplayOfficeHour()
		+ Et.setExamType() + Db.setupDiscussionBoard() + Cf.estimatedCourseFee(courseSize)
		+ Hc.calculateHousingCost(courseSize);
		
	}
	
}
 