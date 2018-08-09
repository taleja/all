
public class Person {

	String name;
	static int bankVault;
	static {
		System.out.println("Intializer1: Person_1");
	}

	{
		System.out.println("Initializer2: Person_2");
	}

	Person() {
		System.out.println("Constructor");
	}

	void Person() {
		System.out.println("Person");
	}

	static int getBankVault() {
		return bankVault;
	}

}
