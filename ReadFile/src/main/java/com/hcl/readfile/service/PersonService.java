package com.hcl.readfile.service;

import java.io.IOException;
import java.util.List;

import com.hcl.readfile.model.PersonBook;

public interface PersonService {

	int getNumberOfMales(List<PersonBook> personBookList) throws IOException;

	List<PersonBook> fileToObjectConversion23(String file) throws IOException;

	String getOldestPerson(List<PersonBook> personBookList);

	Long compareNames(List<PersonBook> personBookList,String name1,String name2);

}
