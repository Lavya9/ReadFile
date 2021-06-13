package com.hcl.readfile.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.readfile.model.PersonBook;
import com.hcl.readfile.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personServiceImpl;

	@Autowired
	Environment env;

	@GetMapping(path = "/males", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> getNumberOfMales() throws Exception {
		String file = env.getProperty("file_location");
		List<PersonBook> personBookList = personServiceImpl.fileToObjectConversion23(file);
		Integer numberOfMales = personServiceImpl.getNumberOfMales(personBookList);
		return new ResponseEntity<String>(String.valueOf(numberOfMales), HttpStatus.OK);
	}

	@GetMapping(path = "/oldest", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> getOldestPersonName() throws IOException {
		String file = env.getProperty("file_location");
		List<PersonBook> personBookList = personServiceImpl.fileToObjectConversion23(file);
		String oldestPerson = personServiceImpl.getOldestPerson(personBookList);
		return new ResponseEntity<String>(oldestPerson, HttpStatus.OK);
	}

	@PostMapping(path = "{name1}/compare/{name2}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> compareNames(@PathVariable String name1,@PathVariable String name2) throws IOException {
        
		String file = env.getProperty("file_location");
		List<PersonBook> personBookList = personServiceImpl.fileToObjectConversion23(file);
		Long daysDifference=personServiceImpl.compareNames(personBookList,name1,name2);
		return new ResponseEntity<String>(String.valueOf(daysDifference)+" is the days difference",HttpStatus.OK);
	}
	
	 @RequestMapping("/")
	    public String index() {
	        return "index";
	    }
}
