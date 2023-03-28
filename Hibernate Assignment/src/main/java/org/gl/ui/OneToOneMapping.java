package org.gl.ui;

import org.gl.database.StudentDB;
import org.gl.entity.Address;
import org.gl.entity.Student;

import java.util.Scanner;

public class OneToOneMapping {

    public void OneToOneAssociation(){
        Scanner sc = new Scanner(System.in);
        int choice, id;
        boolean flag=true;
        String name, country, city;
        StudentDB db = new StudentDB();
        do {
            System.out.println("\nChoose one of the options");
            System.out.println("1. Unidirectional - Insert into Student along with the required Address");
            System.out.println("2. Unidirectional - Remove Student from the database with the cascade effect on Address table");
            System.out.println("3. Bidirectional - Fetch the student details with the help of given address");
            System.out.println("4. Bidirectional - Remove Address Record from the database with the cascaded effect on Students.");
            System.out.println("5. Exit");
            choice = sc.nextInt();
            Address address = null;
            Student student = null;
            switch (choice) {
                case 1:
                    System.out.println("enter student name: ");
                    name = sc.next();
                    System.out.println("Enter Country: ");
                    country = sc.next();
                    System.out.println("Enter City: ");
                    city = sc.next();
                    address = new Address(city, country);
                    student = new Student(name, address);
                    db.insertStudent(student);
                    break;
                case 2:
                    System.out.println("Enter ID: ");
                    id = sc.nextInt();
                    student = db.getStudentByID(id);
                    if (student != null) {
                        db.deleteStudent(student);
                    } else {
                        System.out.println("Student not Found\n");
                    }
                    break;
                case 3:
                    System.out.println("Enter Address ID: ");
                    id = sc.nextInt();
                    address = db.getAddressByID(id);
                    if (address != null) {
                        System.out.println("Student ID: "+address.getStudent().getSid());
                        System.out.println("Student Name: "+address.getStudent().getName());
                    } else {
                        System.out.println("Address not Found\n");
                    }
                    break;
                case 4:
                    System.out.println("Enter Address ID: ");
                    id = sc.nextInt();
                    address = db.getAddressByID(id);
                    if (address != null) {
                        db.deleteAddress(address);
                    } else {
                        System.out.println("Address not Found\n");
                    }
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }while(flag);
    }
}
