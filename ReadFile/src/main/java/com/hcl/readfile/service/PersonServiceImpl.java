package com.hcl.readfile.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.readfile.model.PersonBook;

@Service
public class PersonServiceImpl implements PersonService {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate date1;
	LocalDate date2;
	LocalDate date3;
	int maleCounter;

	public List<PersonBook> fileToObjectConversion23(String file) throws IOException {
		// TODO Auto-generated method stub
		List<PersonBook> person_Data = null;
		BufferedReader bufferedReader = null;
		FileInputStream fileInputStream = null;

		fileInputStream = new FileInputStream(file);
		bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));

		person_Data = new ArrayList<PersonBook>();
		String tmp = null;
		String tmp_data[] = null;
		while ((tmp = bufferedReader.readLine()) != null) {

			tmp_data = tmp.split(",");
			PersonBook person_Data_Row = new PersonBook();
			person_Data_Row.setName(tmp_data[0]);
			person_Data_Row.setGender(tmp_data[1]);
			person_Data_Row.setDob(LocalDate.parse(tmp_data[2], formatter));

			person_Data.add(person_Data_Row);
		}

		return person_Data;
	}

	public int getNumberOfMales(List<PersonBook> personBookList) throws IOException {
		for (int i = 0; i < personBookList.size(); i++) {

			if (((personBookList.get(i)).getGender()).equals("Male")) {
				maleCounter++;
			}
		}
		return maleCounter;
	}

	public String getOldestPerson(List<PersonBook> personBookList) {
		// TODO Auto-generated method stub
		Collections.sort(personBookList);
		String oldestPerson = (personBookList.get(0)).getName();
		return oldestPerson;
	}

	public Long compareNames(List<PersonBook> personBookList, String name1, String name2) {

		for (int i = 0; i < personBookList.size(); i++) {
			System.out.println((personBookList.get(i)).getName() + " 1");
			if (((personBookList.get(i)).getName()).equals(name1)) {
				date2 = ((personBookList.get(i)).getDob());
				System.out.println(date2 + "  date2");
			}

			if (((personBookList.get(i)).getName()).equals(name2)) {
				date3 = ((personBookList.get(i)).getDob());
				System.out.println(date3 + "  date3");
			}

		}

		long noOfDaysBetween = ChronoUnit.DAYS.between(date2, date3);

		return noOfDaysBetween;
	}

}
