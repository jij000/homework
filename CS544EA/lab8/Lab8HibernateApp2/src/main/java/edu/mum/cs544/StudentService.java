package edu.mum.cs544;

import javax.persistence.TypedQuery;

public class StudentService {
    private StudentDAO studentdao;

    public StudentService() {
        studentdao = new StudentDAO();
    }

    public Student getStudent(long studentid) {
        Student student = null;
        EntityManagerHelper.getCurrent().getTransaction().begin();
        student = studentdao.load(studentid);
        EntityManagerHelper.getCurrent().getTransaction().commit();
        EntityManagerHelper.getCurrent().close();
        return student;
    }
}
