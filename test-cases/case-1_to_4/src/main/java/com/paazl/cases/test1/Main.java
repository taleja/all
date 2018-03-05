package com.paazl.cases.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	@SuppressWarnings("serial")
	private static final Map<String, Character> QUESTIONS = new HashMap<String, Character>() {
		{
			put("A Thread is a process", 'N');
			put("A List cannot contain duplicates", 'N');
			put("A Set can contain duplicates", 'N');
			put("Java is platform independent", 'Y');
			put("Java supports copy constructors like C++", 'Y');
			put("The primitive data types supported by the Java programming language are: byte, short, int, long, float, double, boolean, char", 'Y');
			put("Constructor overloading is similar to method overloading in Java", 'N');
			put("The purpose of garbage collection in Java is to reclaim and reuse objects which are no longer used", 'Y');
			put("Autoboxing is the automatic conversion made by the Java compiler between the primitive types and their corresponding object wrapper classes", 'Y');
			put("JDBC is an abstraction layer that allows users to choose between databases", 'Y');
			put("Java supports the usage of pointers", 'N');
		}
	};

	/*
	 * Implement the main method:
	 * * Show the user the questions on a console and collect the answers.
	 * * If the user scores 0-3 points, print "You are a junior Java developer".
	 * * If the user scores 4-7 points, print "You are a medior Java developer".
	 * * If the user scores 8-10 points, print "You are a senior Java developer".
	 */
	public static void main(String[] args) {
     }
        
}