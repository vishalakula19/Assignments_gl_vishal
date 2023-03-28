package org.gl.ui;

import org.gl.database.StudentDB;
import org.gl.entity.Course;
import org.gl.entity.Employee;
import org.gl.entity.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManyToManyMapping {
    public void ManyToManyAssociation() {
        Scanner sc = new Scanner(System.in);
        int choice, id, projectCount;
        boolean flag=true;
        String name, projectName, city;
        StudentDB db = new StudentDB();
        do {
            System.out.println("\nChoose one of the options");
            System.out.println("1. Bidirectional - Insert data into the Employee along with the details of the project assigned to that employee.");
            System.out.println("2. Bidirectional - Fetch all employee names for a given project Id ");
            System.out.println("3. Bidirectional - Fetch all project names for a given employee Id ");
            System.out.println("4. Exit");
            choice = sc.nextInt();
            Course course = null;
            List<Project> projects = new ArrayList<>();
            List<Employee> employees = new ArrayList<>();
            Employee employee = null;
            Project project = null;
            switch (choice) {
                case 1:
                    System.out.println("Enter Employee name: ");
                    name = sc.next();
                    employee = new Employee(name);
                    employees.add(employee);
                    System.out.println("How many projects employee is assigned?: ");
                    projectCount = sc.nextInt();
                    for(int i=1;i<=projectCount;i++){
                        System.out.println("enter project name " + i + " : ");
                        projectName = sc.next();
                        projects.add(new Project(projectName, employees));
                    }
                    employee.setProjects(projects);
                    db.insertEmployee(employee);
                    break;
                case 2:
                    System.out.println("Enter Project ID: ");
                    id = sc.nextInt();
                    project = db.getProjectByID(id);
                    if (project != null) {
                        employees = project.getEmployees();
                        for(Employee emp : employees){
                            System.out.println("Employee ID: "+emp.getEid());
                            System.out.println("Employee Name: "+emp.getEmpName());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Project not Found\n");
                    }
                    break;
                case 3:
                    System.out.println("Enter Employee ID: ");
                    id = sc.nextInt();
                    employee = db.getEmployeeByID(id);
                    if (employee != null) {
                        projects = employee.getProjects();
                        for(Project prj : projects){
                            System.out.println("Project ID: "+prj.getPid());
                            System.out.println("Project Name: "+prj.getProjectName());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Project not Found\n");
                    }
                    break;
                case 4:
                    flag=false;
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }while(flag);
    }
}
