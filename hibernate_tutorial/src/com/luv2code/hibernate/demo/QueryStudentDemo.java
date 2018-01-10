package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args)
	{
		// create session factory
		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory())
		{
			// create session
			Session session = factory.getCurrentSession();
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display the students
			displayStudents(theStudents);
			
			// query students: lastName = 'Doe'
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(theStudents);

			// query students: lastName = 'Doe' or firstName = 'Daffy'
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe' or s.firstName = 'Daffy'").getResultList();

			System.out.println("\n\nStudents who have last name of Doe or first name of Daffy");
			displayStudents(theStudents);
			
			// query students where email like '%gmail.com'
			theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();

			System.out.println("\n\nStudents whose email ends with gmail.com");
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		theStudents.forEach(s -> System.out.println(s));
	}

}
