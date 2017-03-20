package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;


public class Staff_Test {

	public static java.util.Date date(int year,int month, int day){
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
		return date.getTime();
	}
	static ArrayList<Staff> staffList = new ArrayList<Staff>();
	@AfterClass
	public static void tearDownAfterClass() throws PersonException {
	}

	@Before
	public void setUp() throws PersonException {
	}

	@After
	public void tearDown() throws PersonException {
	}
	
	@BeforeClass
	public static void setup() throws PersonException{
		Staff a,b,c,d,e,f,g;
		a = new Staff("Kyle","Bob","Smith", date(1998,10,23), "199 Ocean Street", "(302)-555-6655", "1@udel.edu", "Friday 7-8", 1, 60000.00, date(2000,1,1), eTitle.MR);
		b = new Staff("John","Louis","Doe", date(1996,8,8), "105 Delaware Trail", "(302)-289-4444", "2@udel.edu", "Monday 5-6", 1, 50000.00, date(2000,1,1), eTitle.MR);
		c = new Staff("Frank","Charlie","Reynolds",date(1997,5,9), "155 Lake Street", "(302)-123-4567", "3@udel.edu", "Tuesday 3-4", 1, 55000.00, date(2000,1,1), eTitle.MR);
		d = new Staff("Jane","Maria","Doe", date(1990,1,1), "56 Horeshoe Drive", "(302)-765-4321", "4@udel.edu", "Thursday 1-2", 1, 80000.00, date(2000,1,1), eTitle.MS);
		e = new Staff("Kristine","Mary","Reynolds", date(1993,4,16), "123 Diamond Road", "(302)-012-9876", "5@udel.edu", "Thursday 1-2", 1, 70000.00, date(2000,1,1), eTitle.MRS);
		
		staffList.add(a);
		staffList.add(b);
		staffList.add(c);
		staffList.add(d);
		staffList.add(e);
	}
	@Test
	public void SalaryTest() {
		double Avg = 0;
		for (Staff staff : staffList) {
			Avg =+ staff.getSalary()/staffList.size();
		}
		double ActualAvg = 63000;
		assertEquals(Avg, ActualAvg, 0);
	}
	@Test
	public void testDOB() throws PersonException{
		try {
			staffList.add(new Staff("Kyle","Bob","Smith", date(1776,10,23), "199 Ocean Street", "(302)-555-6655", "1@udel.edu", "Friday 7-8", 1, 60000.00, date(2000,1,1), eTitle.MR));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	@Test
	public void testPhoneNumber() throws PersonException{
		try {
			staffList.add(new Staff("Kyle","Bob","Smith", date(1998,10,23), "199 Ocean Street", "(302)-1-6655", "1@udel.edu", "Friday 7-8", 1, 60000.00, date(2000,1,1), eTitle.MR));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	}	

