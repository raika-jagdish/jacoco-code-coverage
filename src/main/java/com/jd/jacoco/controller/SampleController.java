package com.jd.jacoco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping(path = "/test/{param}")
	public String codeCoverageMethod(@PathVariable int param) {

		if (param > 10) {
			return callingThisMethod(param);
		}
		else {
			return callingAnotherMethod(param);
		}
	}

	private String callingThisMethod(int param) {

		System.out.println("Calling this method.");
		if (param < 10) {
			System.out.println("This code cannot be called..");
		}
		return "Calling this method.";
	}

	private String callingAnotherMethod(int param) {

		System.out.println("Calling another method.");
		return "Calling another method.";
	}

}
