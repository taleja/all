package com.paazl.cases.test2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
     * Implement a main method that is functionally identical to Test #1. In
     * this case, use a DeveloperFactory that is able to produce 3 types of
     * developers that implement a "print" method. The Factory should have a
     * create method that takes the user's score as an argument.
     */
    public static void main(String[] args) throws IOException {
    }

}
