package org.gl.database;

import org.gl.config.HibernateConfig;
import org.gl.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TeacherDB {
    SessionFactory factory;

    public TeacherDB() {
        factory = HibernateConfig.getSessionFactory();
    }

    public void insertTeacher(Teacher t1) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(t1);
        tx.commit();
        session.close();
    }

    public void updateTeacher(Teacher t1) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(t1);
        tx.commit();
        session.close();
    }

    public Teacher getTeacherByID(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, id);
        session.close();
        return teacher;
    }

    public Teacher queryTeacher(String email) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Teacher teacher = session.createQuery("from Teacher where email= :email", Teacher.class)
                .setParameter("email", email)
                .getSingleResultOrNull();
        tx.commit();
        session.close();
        return teacher;
    }

    public void deleteTeacher(Teacher teacher) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.remove(teacher);
        tx.commit();
        session.close();
    }
}
