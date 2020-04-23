package badsmell;

public class Student {
	private String studentNumber;
    private String studentName;
    private String major;
    
    public Student(String studentNumber, String studentName, String major){
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.major = major;
    }
    
    public double computeTuitionFees(){
        if (major.equals("Computer Science")){
            return 3150.00;
        } else if (major.equals("French")){
            return 2570.00;
        } else {
            return 3850.00;
        }
    }
    
    public String degreeToBeGranted(){
        if (major.equals("Computer Science")){
            return "B.C.S. (Honours)";
        } else if (major.equals("French")){
            return "B. A. (Honours)";
        } else {
            return "B. A. Sc. (Honours)";
        }
    }
    
    public void changeMajor(String newMajor){
        major = newMajor;
    }
    
    public String toString(){
        return studentName + " is pursuing " + degreeToBeGranted() +
        " degree; pays $" + computeTuitionFees();
    }
}