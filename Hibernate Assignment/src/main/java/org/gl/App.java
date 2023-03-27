package org.gl;

import org.gl.database.TeacherDB;
import org.gl.entity.Teacher;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    static Scanner sc = new Scanner(System.in);
    static TeacherDB db = new TeacherDB();
    public static void main(String[] args) throws Exception {
        boolean flag = true;
        int choice, id;
        String f_name, l_name, email;
        do {
            System.out.println();
            System.out.println("Choose one of the options");
            System.out.println("1. Insert Teacher");
            System.out.println("2. Update Teacher");
            System.out.println("3. Read Teacher");
            System.out.println("4. Query Teacher");
            System.out.println("5. Delete Teacher");
            System.out.println("6. Exit");
            choice = sc.nextInt();
            Teacher teacher = null;
            switch (choice) {
                case 1:
                    System.out.println("enter first name: ");
                    f_name = sc.next();
                    System.out.println("enter last name: ");
                    l_name = sc.next();
                    System.out.println("enter email: ");
                    email = sc.next();
                    teacher = new Teacher(f_name, l_name, email);
                    db.insertTeacher(teacher);
                    break;
                case 2:
                    System.out.println("Enter ID");
                    id = sc.nextInt();
                    teacher = db.getTeacherByID(id);
                    if (teacher != null) {
                        Teacher teacherData = collectTeacherData(teacher, id);
                        db.updateTeacher(teacherData);
                    } else {
                        System.out.println("Teacher not Found\n");
                    }
                    break;
                case 3:
                    System.out.println("Enter ID: ");
                    id = sc.nextInt();
                    teacher = db.getTeacherByID(id);
                    if (teacher != null) {
                        System.out.println("ID: "+teacher.getId());
                        System.out.println("First Name: "+teacher.getF_Name());
                        System.out.println("Last Name: "+teacher.getL_Name());
                        System.out.println("Email: "+ teacher.getEmail());
                    } else {
                        System.out.println("Teacher not Found\n");
                    }
                    break;
                case 4:
                    System.out.println("Enter Teacher Email ID: ");
                    email = sc.next();
                    teacher = db.queryTeacher(email);
                    if (teacher != null) {
                        System.out.println("ID: "+teacher.getId());
                        System.out.println("First Name: "+teacher.getF_Name());
                        System.out.println("Last Name: "+teacher.getL_Name());
                        System.out.println("Email: "+ teacher.getEmail());
                    } else {
                        System.out.println("Teacher not Found\n");
                    }
                    break;
                case 5:
                    System.out.println("Enter ID: ");
                    id = sc.nextInt();
                    teacher = db.getTeacherByID(id);
                    if (teacher != null) {
                        db.deleteTeacher(teacher);
                    }
                    else{
                        System.out.println("Teacher not Found\n");
                    }
                    break;
                case 6:
                    System.out.println("Thank You bye !!");
                    flag = false;
                    break;
                default:
                    System.out.println("Enter correct option");

            }
        }while(flag);
    }

    public static Teacher collectTeacherData(Teacher teacher, int id){
        String f_name, l_name, email, new_fName, new_lName, newEmail;
        System.out.println("Teacher first name: " + teacher.getF_Name());
        System.out.print("Enter new text (or) press Enter key to skip: ");
        sc.nextLine();
        new_fName = sc.nextLine();
        if(!new_fName.isEmpty())
            f_name = new_fName;
        else
            f_name = teacher.getF_Name();
        System.out.println("Teacher last name: " + teacher.getL_Name());
        System.out.print("Enter new text (or) press Enter key to skip: ");
        new_lName = sc.nextLine();
        if(!new_lName.isEmpty())
            l_name = new_lName;
        else
            l_name = teacher.getL_Name();
        System.out.println("Teacher Email: " + teacher.getEmail());
        System.out.print("Enter new text (or) press Enter key to skip: ");
        newEmail = sc.nextLine();
        if(!newEmail.isEmpty())
            email = newEmail;
        else
            email = teacher.getEmail();
        Teacher t2 = new Teacher();
        t2.setId(id);
        t2.setF_Name(f_name);
        t2.setL_Name(l_name);
        t2.setEmail(email);
        return t2;
    }


}
