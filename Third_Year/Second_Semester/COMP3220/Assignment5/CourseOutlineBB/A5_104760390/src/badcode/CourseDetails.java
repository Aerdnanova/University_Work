
package badcode;

public class CourseDetails {
    
    public enum CourseType {
        Inclass, Online;
    }
    
    public enum CourseSize {
        Full, Half;
    }
    private String courseNumber;
    private String courseTitle;
    private String courseType;
    private String courseSize;

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseTitle() {
        return courseTitle;
    }
    
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseType() {
        return courseType;
    }
    
    public void setCourseSize(String courseSize) {
        this.courseSize = courseSize;
    }

    public String getCourseSize() {
        return courseSize;
    }
    
    public String printHeader(){
        String headerString = "";
        headerString = "Course Outline\n\n";
        headerString = headerString +"Course No: "+courseNumber+"\n";
        headerString = headerString +"Course Title: "+courseTitle+"\n";
        return headerString;
    }
    
    public String displayLectureMethod(){
        if(courseType.equals("Inclass")){
            return "Lecture Method: "+courseType+"\n";
        }
        else{
            return "Lecture Method: "+courseType+"\n";
        }
    }
    
    public String officeHour(){
        if(courseType.equals("Inclass")){
            return "Office hour: EH-3146\n";
        }
        else{
            return "Office hour: on Blackboard\n";
        }
    }
    
    public String examtype(){
        if(courseType.equals("Inclass")){
            return "Inclass final exam\n";
        }
        else{
            return "Take home final exam\n";
        }
    }
    
    public String discussionboard(){
        if(courseType.equals("Inclass")){
            return "Inclass discussion\n";
        }
        else{
            return "Use discussion board on Blackboard\n";
        }
    }
    
    public String courseFee(){
        if(courseType.equals("Inclass")){
            if (courseSize.equals("Full")){
                return "Estimated Course Fee: CAD$"+
                        calculateInclassCourseFee(3000)+"\n";
            }
            else{
                return "Estimated Course Fee: CAD$"+
                        calculateInclassCourseFee(2250)+"\n";
            }
        }
        else{
            if (courseSize.equals("Full")){
                return "Estimated Course Fee: CAD$"+
                        calculateInclassCourseFee(2500)+"\n";
            }
            else{
                return "Estimated Course Fee: CAD$"+
                        calculateInclassCourseFee(1750)+"\n";
            }
        }
    }
    
    public double calculateInclassCourseFee(double courseFee){
        if (courseSize.equals("Full")){
            return (courseFee+courseFee*0.1);
        }
        else{
            return (courseFee+courseFee*0.08);
        }
    }
    
    public double calculateOnlineCourseFee(double courseFee){
        if (courseSize.equals("Full")){
            return (courseFee+courseFee*0.075);
        }
        else{
            return (courseFee+courseFee*0.05);
        }
    }
    
    public String housingCost(){
        if(courseType.equals("Inclass")){
            if (courseSize.equals("Full")){
                return "Estimated Housing Cost: CAD$500\n";
            }
            else{
                return "Estimated Housing Cost: CAD$250\n";
            }
        }
        else{
            return "No Housing Cost but you need high speed "
                    + "internet connection\n";
        }
    }
    
    public String generateCourseOutline(){
        String outputString;
        outputString = displayLectureMethod();
        outputString = outputString+officeHour();
        outputString = outputString+examtype();
        outputString = outputString+discussionboard();
        outputString = outputString+courseFee();
        outputString = outputString+housingCost();
        return outputString;
    }
}
