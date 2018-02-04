package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionMain {

	public static void main(String[] args) throws Exception {
//		printAllFields(Child.class); 
//		printAllMethods(Child.class);
//		findParentGeneric(Child.class); 
		Child child = new Child("stringValue", 1);
//		printFieldValue(child, "str");
//		invokeMethodAndPrintResult(child, "calculate", 1,2);
		
		//TODO 
		invokeMethodAndPrintResult(child, "printLine", 2);  
		invokeMethodAndPrintResult(child, "printLine", "Ronichka");  
	}

	public static void printAllFields(Class clazz) {
		System.out.println(clazz.getName()); 
		
		if(clazz.getSuperclass() != null) {
			printAllFields(clazz.getSuperclass());			
		}
		
		for(Class interfazze: clazz.getInterfaces()) {
			printAllFields(interfazze); 
		}
		
		for(Field field: clazz.getDeclaredFields()) {
			System.out.println("Filedl's name: " + field.getName()); 
		}
		System.out.println("-------------------------------------");		 
	}
	
	public static void printAllMethods(Class clazz) {
		System.out.println(clazz.getName()); 
		
		if(clazz.getSuperclass() != null) {
			printAllMethods(clazz.getSuperclass());			
		}
		
		for(Class interfazze: clazz.getInterfaces()) {
			printAllMethods(interfazze); 
		}
		
		for(Method method: clazz.getDeclaredMethods()) {
			System.out.println("Method's name: " + method.getName()); 
		}
		System.out.println("-------------------------------------");		 
	}
	
	//TODO print all annotations and their attributes values
	public static void printAllAnnotations(Class clazz) {}
	
	public static void findParentGeneric(Class clazz) {
		Type type = clazz.getGenericSuperclass();
		System.out.println(type); 

		if(type instanceof ParameterizedType) {
			ParameterizedType ptype =  (ParameterizedType) type;
			System.out.println(ptype.getRawType() + ", " + ptype.getOwnerType() + ", " + ptype.getActualTypeArguments()); 
			System.out.println("Type is ParameterizedType");
		} else 	{
			System.out.println("Simple type"); 
		}
	}
	
	public static void printFieldValue(Object obj, String fieldName) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class clazz =  obj.getClass();
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true); 
		Object rv = field.get(obj);
		System.out.println(rv); 
	}
	
	public static void invokeMethodAndPrintResult(Object obj, String methodName, Object...parameters) throws Exception {
		Class clazz =  obj.getClass();
		Class [] parametersType = new Class [parameters.length];
		
		for(int i = 0; i < parameters.length; i++) {
			parametersType[i] = parameters[i].getClass();
		}

//		Method method = clazz.getDeclaredMethod(methodName, new Class[] {Integer.TYPE, Integer.TYPE});
		invokeMethodAndPrintResult(obj, methodName, clazz, parametersType, parameters); 
	}

	public static void invokeMethodAndPrintResult(Object obj, String methodName, Class clazz, Class[] parametersType,
			Object... parameters) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method method = clazz.getDeclaredMethod(methodName, parametersType);
		method.setAccessible(true); 
		Object rv = method.invoke(obj, parameters);
		System.out.println(rv);
	}
}
