// CS-280 Sp24
// Sydney Nilles
// Assignment 7 - due 03/21/2024

public class Teacher extends Person {
    private int numCourses;
    private String courses[] = new String[5]; // initialized here due to a weird local variable not being used problem.

    //Uses the Person constructor for name and address, while initializing numCourses.
    public Teacher(String name, String address){
        super(name, address);
        numCourses = 0;
        for (int i = 0; i < courses.length; i++){ // nulls were causing NullPointerException errors, so I'm setting all slots to  a single character
            courses[i] = " ";
        }
    }

    public boolean addCourse(String course){
        // searches through courses to see if course already exists.
        for (int i = 0; i < numCourses; i++ ){
            if (courses[i].contains(course)){
                System.out.println("The course " + course + " cannot be added.");
                return false;
            }
        }
        // if it isn't found, the method will proceed to add it.
        courses[numCourses] = course;
        numCourses += 1;
        System.out.println("Course " + course + " added.");
        return true;
    }

    public boolean removeCourse(String course){
        // searches through courses to see if course is present
        for (int i = 0; i < numCourses; i++ ){
            if (courses[i].equals(course)){
                //moves all slots after course[i] down, effectively deleting it
                for (int j = i; j < numCourses; j++){
                    courses[j] = courses[j+1];
                }
                System.out.println("Course " + course + " removed.");
                numCourses -= 1;
                return true;  
            }
        }
        // if the course isn't found in the loop, the method proceeds
        System.out.println("The course " + course + " cannot be removed.");
        return false;

    }

}
