/* Class extends CourseFactory for the online course instance
 * Andrea Bonato
 * 104760390
 * */
package goodcode;

public class OnlineCourse extends CourseFactory {

	//Create online lecture
	public OnlineLectureMethod createLectureMethod() {
		
		return new OnlineLectureMethod();
	}
	
	//create virtual office hour
	public OfficeHour setOfficeHour() {
		
		return new VirtualOfficeHour();
	}
	
	//Create take home exam type
	public ExamType setExamType() {
		return new TakeHomeExam();
	}
	
	//Create Blackboard discussion 
	public BBDiscussionBoard setupDiscussionBoard() {
		return new BBDiscussionBoard();
	}
	
	//Create Online Course Fee
	public OnlineCourseFee estimatedCourseFee() {
		return new OnlineCourseFee();
	}
	
	//Create online housing cost
	public OnlineHousingCost estimatedHousingCost() {
		return new OnlineHousingCost();
	}
}