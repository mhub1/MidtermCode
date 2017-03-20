package com.cisc181.core;
import com.cisc181.core.*;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonException extends Exception{

	private Person Person;
	private Date DOB;
	private String Phone_number;
	public PersonException(Person Person){
		this.Person = Person;
	}
	public PersonException(PersonException personException) {
	}
	public Person getPerson() {
		return Person;
	}
	public Date getDOB() {
		return DOB;
	}

	public String getPhone_number() {
		return Phone_number;
	}
	public void setDOB(Date dOB) throws PersonException {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, 100);
		if (calendar.getTime().before(DOB)) {
			throw new PersonException(this);
		}
		this.DOB = dOB;
	}
	public void setPhone_number(String PhoneNumber) throws PersonException {
		Pattern pattern = Pattern.compile("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$");
		if (!pattern.matcher(PhoneNumber).matches()) {
			throw new PersonException(this);
		}

		Phone_number = PhoneNumber;
	}

}