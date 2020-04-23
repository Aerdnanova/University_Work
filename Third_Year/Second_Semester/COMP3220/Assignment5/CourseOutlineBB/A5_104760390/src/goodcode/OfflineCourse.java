/* Class extends CourseFactory and is used to create an instance of an 
 * offline course
 * Andrea Bonato
 * 104760390
 * */
package goodcode;

public class OfflineCourse extends CourseFactory {

	//Create lecture method
	public OfflineLectureMethod createLectureMethod() {
		
		return new OfflineLectureMethod();
	}
	
	//Create in person office hour
	public OfficeHour setOfficeHour() {
	
		return new InPersonOfficeHour();
	}
	
	//create in class exam type
	public ExamType setExamType() {
		
		return new InClassExam();
		
	}
	
	//Create in class dicussion
	public InClassDiscussion setupDiscussionBoard() {
		return new InClassDiscussion();
	}
	//Create in class course fee
	public InClassCourseFee estimatedCourseFee() {
		return new InClassCourseFee();
	}
	
	//Create in class houseing cost
	public InClassHousingCost estimatedHousingCost() {
		return new InClassHousingCost();
	}

}
