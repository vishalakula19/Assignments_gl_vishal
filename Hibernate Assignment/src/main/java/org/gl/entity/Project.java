package org.gl.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String projectName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_projects")

    private List<Employee> employees;

    public Project() {
    }

    public Project(String projectName, List<Employee> employees) {
        this.projectName = projectName;
        this.employees = employees;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
