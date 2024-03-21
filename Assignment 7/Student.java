// CS-280 Sp24
// Sydney Nilles
// Assignment 7 - due 03/21/2024

/* STOP CAUSING PROBLEMS
public class Student extends Person{
    private int numCourses;
    private String courses[] = new String[30];
    private int grades[] = new int[30];
    
    public Student(String name, String address){
        super(name, address);
        numCourses = 0;
        for (int i = 0; i < courses.length; i++){ // due to an error found while writing Teacher, 
            courses[i] = " ";
        }
        for (int i = 0; i < courses.length; i++){ // these arrays will be initialized with non-null values
            grades[i] = 0;
        }
    }

    // uses numCourses as the index to add a course to.
    public void addCourseGrade(String course, int grade){
        courses[numCourses] = course;
        grades[numCourses] = grade;
        numCourses += 1;
    }

    // Prints the grades in a nice list.
    public void printGrades(){
        for (int i = 0; i < numCourses; i++ ){
            System.out.println("Course: " + courses[i] + " Grade: " + grades[i]);
        }
    }

    /*
    adds together all grades within the range of 0 to numCourses-1 to make sure
    the average is accurate and does not include the initial objects it was
    initialized with.
    *//*
    public int getAverageGrade(){
        int total = 0;
        int average = 0;
        for (int i = 0; i < numCourses; i++){
            total += grades[i];
        }
        average = total/numCourses;
        return average;
    }
}
*/