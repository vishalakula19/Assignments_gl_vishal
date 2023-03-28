package org.gl;

import org.gl.ui.HibernateCRUD;
import org.gl.ui.ManyToManyMapping;
import org.gl.ui.OneToManyMapping;
import org.gl.ui.OneToOneMapping;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int choice;
        boolean flag = true;
        do {
            System.out.println();
            System.out.println("Choose one of the options");
            System.out.println("1. Hibernate CRUD Operations");
            System.out.println("2. one to one association");
            System.out.println("3. one to many association");
            System.out.println("4. many to many association");
            System.out.println("5. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    new HibernateCRUD().HibernateCodingChallenge1();
                    break;
                case 2:
                    new OneToOneMapping().OneToOneAssociation();
                    break;
                case 3:
                    new OneToManyMapping().OneToManyAssociation();
                    break;
                case 4:
                    new ManyToManyMapping().ManyToManyAssociation();
                    break;
                case 5:
                    System.out.println("Thanks exiting the application");
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }while(flag);

    }






}
