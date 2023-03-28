package org.gl.ui;

import org.gl.database.StudentDB;
import org.gl.entity.Course;
import org.gl.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneToManyMapping {
    public void OneToManyAssociation(){
        Scanner sc = new Scanner(System.in);
        int choice, id, courseCount;
        boolean flag=true;
        String name, courseName, city;
        StudentDB db = new StudentDB();
        do {
            System.out.println("\nChoose one of the options");
            System.out.println("1. Bidirectional - Insert into Student along with data in the courses.");
            System.out.println("2. Unidirectional - Remove a Course from the database without affecting students.");
            System.out.println("3. Exit");
            choice = sc.nextInt();
            Course course = null;
            List<Course> courses = new ArrayList<>();
            Student student = null;
            switch (choice) {
                case 1:
                    System.out.println("enter student name: ");
                    name = sc.next();
                    student = new Student();
                    System.out.println("How many courses student has done?: ");
                    courseCount = sc.nextInt();
                    for(int i=1;i<=courseCount;i++){
                        System.out.println("enter course name " + i + " : ");
                        courseName = sc.next();
                        courses.add(new Course(courseName, student));
                    }
                    student.setName(name);
                    student.setCourses(courses);
                    db.insertStudent(student);
                    break;
                case 2:
                    System.out.println("Enter Course ID: ");
                    id = sc.nextInt();
                    course = db.getCourseByID(id);
                    if (course != null) {
                        db.deleteCourse(course);
                    } else {
                        System.out.println("Course not Found\n");
                    }
                    break;
                case 3:
                    flag=false;
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }while(flag);
    }
}
