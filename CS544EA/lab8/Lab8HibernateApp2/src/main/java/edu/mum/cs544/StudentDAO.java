package edu.mum.cs544;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDAO {

	private Collection<Student> studentlist = new ArrayList<Student>();

	public StudentDAO() {
//		Student student = new Student(12345, "Frank", "Brown");
//		Course course1 = new Course(1101, "Java", "A");
//		Course course2 = new Course(1102, "Math", "B-");
//		student.addCourse(course1);
//		student.addCourse(course2);
//		studentlist.add(student);

	}

	public Student load(long studentid) {
//		for (Student student : studentlist) {
//			if (student.getStudentid() == studentid) {
//				return student;
//			}
//		}
//		return null;
		TypedQuery<Student> query = EntityManagerHelper.getCurrent()
				.createQuery("from Student s " +
//                .createQuery("from Student s left join fetch s.courselist el " +
						"where s.studentid = :studentid", Student.class);
		EntityGraph<Student> graph =
				EntityManagerHelper.getCurrent().createEntityGraph(Student.class);
		graph.addAttributeNodes("courselist");
		query.setHint("javax.persistence.fetchgraph", graph);
		query.setParameter("studentid", studentid);
		return query.getSingleResult();
	}
}
