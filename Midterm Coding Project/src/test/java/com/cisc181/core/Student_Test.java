package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;
import java.util.Date;
import java.util.List;
public class Student_Test {
	static ArrayList<Student> StudentList = new ArrayList<Student>();
	static ArrayList<Course> CourseList = new ArrayList<Course>();
	static ArrayList<Semester> SemesterList = new ArrayList<Semester>();
	static ArrayList<Section> SectionList = new ArrayList<Section>();
	static Course Course1, Course2, Course3;
	static Semester Fall, Spring;
	static Section Semester1,Semester2,Semester3,Semester4,Semester5,Semester6;
	static Student Student1,Student2,Student3,Student4,Student5,Student6,Student7,Student8,Student9,Student10;
	
	@BeforeClass
	public static void setup() {

		
		Course1 = new Course("Organic Chem",3,eMajor.CHEM);
		CourseList.add(Course1);
		Course2 = new Course("Health",3,eMajor.NURSING);
		CourseList.add(Course2);
		Course3 = new Course("Macro",3,eMajor.BUSINESS);
		CourseList.add(Course3);

		
		Fall = new Semester(date(2015,8,22),date(2015,12,7));
		Spring = new Semester(date(2016,1,20), date(2016,5,27));
		SemesterList.add(Fall);
		SemesterList.add(Spring);

		
		Semester1 = new Section(Course1.getCourseID(),Fall.getSemesterID());
		Semester2 = new Section(Course2.getCourseID(),Fall.getSemesterID());
		Semester3 = new Section(Course3.getCourseID(),Fall.getSemesterID());
		Semester4 = new Section(Course1.getCourseID(),Spring.getSemesterID());
		Semester5 = new Section(Course2.getCourseID(),Spring.getSemesterID());
		Semester6 = new Section(Course3.getCourseID(),Spring.getSemesterID());

		SectionList.add(Semester1);
		SectionList.add(Semester2);
		SectionList.add(Semester3);
		SectionList.add(Semester4);
		SectionList.add(Semester5);
		SectionList.add(Semester6);

		

		try {
			Student1 = new Student("Michael","Will","Smith", date(1998,10,23), eMajor.NURSING,"568 Horseshoe dr","(302)-888-8888", "5555@udel.edu");
			Student2 = new Student("Michael","Will","Smith", date(1998,10,23), eMajor.NURSING,"568 Horseshoe dr","(302)-888-8888", "5555@udel.edu");
			Student3 = new Student("Michael","Will","Smith", date(1998,10,23), eMajor.NURSING,"568 Horseshoe dr","(302)-888-8888", "5555@udel.edu");
			Student4 = new Student("Michael","Will","Smith", date(1998,10,23), eMajor.NURSING,"568 Horseshoe dr","(302)-888-8888", "5555@udel.edu");
			Student5 = new Student("Michael","Will","Smith", date(1998,10,23), eMajor.NURSING,"568 Horseshoe dr","(302)-888-8888", "5555@udel.edu");
			Student6 = new Student("Michael","Will","Smith", date(1998,10,23), eMajor.NURSING,"568 Horseshoe dr","(302)-888-8888", "5555@udel.edu");
			Student7 = new Student("Michael","Will","Smith", date(1998,10,23), eMajor.NURSING,"568 Horseshoe dr","(302)-888-8888", "5555@udel.edu");
			Student8 = new Student("Michael","Will","Smith", date(1998,10,23), eMajor.NURSING,"568 Horseshoe dr","(302)-888-8888", "5555@udel.edu");
			Student9 = new Student("Michael","Will","Smith", date(1998,10,23), eMajor.NURSING,"568 Horseshoe dr","(302)-888-8888", "5555@udel.edu");
			Student10 = new Student("Michael","Will","Smith", date(1996,10,23), eMajor.NURSING,"568 Horseshoe dr","(302)-888-8888", "5555@udel.edu");

			StudentList.add(Student1);
			StudentList.add(Student2);
			StudentList.add(Student3);
			StudentList.add(Student4);
			StudentList.add(Student5);
			StudentList.add(Student6);
			StudentList.add(Student7);
			StudentList.add(Student8);
			StudentList.add(Student9);
			StudentList.add(Student10);

		} catch (PersonException e) {
			e.printStackTrace();
		}

	}
	public static java.util.Date date(int year,int month, int day){
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
		return date.getTime();
	}

	@Test
	public void test() {
		ArrayList<Enrollment> EnrollmentList = new ArrayList<Enrollment>();
		List<Enrollment> Student1EnrollmentList;
		List<Enrollment> Student10EnrollmentList;
		Enrollment e;
		double grade;
		grade = 0.0;
		for (Student student : StudentList) {
			grade += 0.4;
			for (Section section : SectionList) {
				e = new Enrollment(student.getStudentID(),section.getSectionID());
				e.setGrade(grade);
				EnrollmentList.add(e);
			}
		}
		System.out.println("Number of enrolled students:" + EnrollmentList.size());
		Student1EnrollmentList = EnrollmentList.subList(0, 5);
		Student10EnrollmentList = EnrollmentList.subList(54, 59);
		double total = 0;
		double count = 0;
		double average = 0;
		for (Enrollment enrollment : Student1EnrollmentList) {
			total += enrollment.getGrade();
			count++;
		}
		average = total/count;
		System.out.println("GPA is:" + average);			
		assertEquals(average, 0.4, 0.0);
		total = 0;
		count = 0;
		average = 0;
		for (Enrollment enrollment : Student10EnrollmentList) {
			total += enrollment.getGrade();
			count++;
		}
		average = total/count;
		System.out.println("GPA is:" + average);
		assertEquals(average, 4.0, 0.1);

		double Course1total = 0;
		double Course1count = 0;
		double Course1average = 0;
		double Course2total = 0;
		double Course2count = 0;
		double Course2average = 0;
		double Course3total = 0;
		double Course3count = 0;
		double Course3average = 0;
		for (Enrollment enrollment : EnrollmentList) {
			UUID sid = enrollment.getSectionID(); 
			if (sid == Semester1.getSectionID() || sid == Semester4.getSectionID()){
				Course1total += enrollment.getGrade();
				Course1count++;
			}
			if (sid == Semester2.getSectionID() || sid == Semester5.getSectionID()){
				Course2total += enrollment.getGrade();
				Course2count++;
			} if (sid == Semester3.getSectionID() || sid == Semester6.getSectionID()){
				Course3total += enrollment.getGrade();
				Course3count++;
			}
		}
		Course1average = Course1total/Course1count;
		Course2average = Course2total/Course2count;
		Course3average = Course3total/Course3count;
		
		System.out.println("Course 1 average:" + Course1average);
		assertEquals(Course1average, 2.2, 0.1);
		assertEquals(Course2average, 2.2, 0.1);
		assertEquals(Course3average, 2.2, 0.1);
		
		StudentList.get(0).setMajor(eMajor.NURSING);

	}
}