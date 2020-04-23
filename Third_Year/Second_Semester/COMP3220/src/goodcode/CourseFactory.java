
/* Class used to instantiate everything
 * Andrea Bonato
 * 104760390
 * */
package goodcode;

//Creates abstract methods to create each instance in classes that 
//extend CourseFactory
public abstract class CourseFactory {
	
	public abstract LectureMethod createLectureMethod();
	public abstract OfficeHour setOfficeHour();
	public abstract ExamType setExamType();
	public abstract DiscussionBoard setupDiscussionBoard();
	public abstract CourseFee estimatedCourseFee();
	public abstract HousingCost estimatedHousingCost();
	
}
