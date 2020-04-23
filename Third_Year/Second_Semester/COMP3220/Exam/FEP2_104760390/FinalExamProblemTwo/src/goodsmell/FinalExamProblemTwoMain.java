package goodsmell;

import badsmell.Student;

public class FinalExamProblemTwoMain {
	public static void main(String[] args) {
        Student s1 = new Student("1234", "Mary Dobbs", "French");
        System.out.println(s1);
        s1.changeMajor("Computer Science");
        System.out.println(s1);
        
        Student s2 = new Student("4568", "Tom Brew", "Computer Science");
        System.out.println(s2);
        s2.changeMajor("Electrical Engineering");
        System.out.println(s2);
    }
}