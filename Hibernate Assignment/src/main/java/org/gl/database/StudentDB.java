package org.gl.database;

import org.gl.config.HibernateConfig;
import org.gl.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDB {
    SessionFactory factory;

    public StudentDB() {
        factory = HibernateConfig.getSessionFactory();
    }

    public void insertStudent(Student s1) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(s1);
        tx.commit();
        System.out.println("Student Inserted");
        session.close();

    }

    public void deleteStudent(Student student) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.remove(student);
        tx.commit();
        System.out.println("Student Deleted with associated Address");
        session.close();
    }

    public Student getStudentByID(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    public Address getAddressByID(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Address address = session.get(Address.class, id);
        session.close();
        return address;
    }

    public void deleteAddress(Address address) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.remove(address);
        tx.commit();
        System.out.println("Address Deleted with associated Student");
        session.close();
    }

    public Course getCourseByID(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }

    public void deleteCourse(Course course) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.remove(course);
        tx.commit();
        System.out.println("Course Deleted with affecting Student");
        session.close();
    }

    public void insertEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(employee);
        tx.commit();
        System.out.println("Employee Inserted");
        session.close();
    }

    public Project getProjectByID(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Project project = session.get(Project.class, id);
        session.close();
        return project;
    }

    public Employee getEmployeeByID(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }
}
