package springBootProject;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
	
	private ArrayList<String> testedList;

	@Before
	public void init() {
		testedList = new ArrayList<>();
	}
	
	@Test
	public void addOneEnlement() {
		//given
		testedList = new ArrayList<>();
		String el = "Hello, World!";
		
		//when
		testedList.add(el);
		
		//when
		assertEquals("Hello, World!", testedList.get(0));
	}
	
	@Test
	public void size() {
		//given
		testedList.add("Roni");
		testedList.add("Olena");
		testedList.add("Denis");
		
		assertEquals(3, testedList.size()); 
	} 
	
}
