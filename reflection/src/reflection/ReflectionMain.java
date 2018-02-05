package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionMain {

	public static void main(String[] args) throws Exception {
//		printAllFields(Child.class); 
//		printAllMethods(Child.class);
//		findParentGeneric(Child.class); 
//		printFieldValue(child, "str");
//		invokeMethodAndPrintResult(child, "calculate", 1,2);		
		//TODO 
//		invokeMethodAndPrintResult(child, "printLine", 2);  
		Child child = new Child("stringValue", 1);
		Child.class.newInstance();
//		invokeMethodAndPrintResult(child, "nothinToReturn", child.getClass(), new Class[] {Integer.TYPE, Integer.TYPE}, 1,2); 		
//		printAllAnnotations(Child.class);
		
		//invokeMethodAndPrintResult(child, "methodWithGeneric", "Ronichka");  
		//List<String> strings = createList();
		//printList(strings);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static List<String> createList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		return (List)list;
	}

	private static void printList(List<? super String> strings) {
		System.out.println(strings);
		System.out.println(strings.get(0));
	}

	public static void printAllFields(Class<?> clazz) {
		System.out.println(clazz.getName()); 
		
		if(clazz.getSuperclass() != null) {
			printAllFields(clazz.getSuperclass());			
		}
		
		for(Class<?> interfazze: clazz.getInterfaces()) {
			printAllFields(interfazze); 
		}
		
		for(Field field: clazz.getDeclaredFields()) {
			System.out.println("Filedl's name: " + field.getName()); 
		}
		System.out.println("-------------------------------------");		 
	}
	
	public static void printAllMethods(Class<?> clazz) {
		System.out.println(clazz.getName()); 
		
		if(clazz.getSuperclass() != null) {
			printAllMethods(clazz.getSuperclass());			
		}
		
		for(Class<?> interfazze: clazz.getInterfaces()) {
			printAllMethods(interfazze); 
		}
		
		for(Method method: clazz.getDeclaredMethods()) {
			System.out.println("Method's name: " + method.getName()); 
		}
		System.out.println("-------------------------------------");		 
	}
	
	public static void printAllAnnotations(Class<?> clazz) throws Exception {
		System.out.println(clazz.getName());
		 if(clazz.getSuperclass() != null) {
			 printAllAnnotations(clazz.getSuperclass());
		 }
		
		for (Annotation annotation : clazz.getAnnotations()) {
			Class<? extends Annotation> annotationType = annotation.annotationType();
			System.out.println(clazz.getName());
			System.out.println("Annotation name: " + annotationType.getName());

			for (Method annotationMethod : annotationType.getDeclaredMethods()) {
				Object value = annotationMethod.invoke(annotation, (Object[]) null);
				System.out.println("Method name: " + annotationMethod.getName() + "Its value: " + value);
			}

			for (Field field : clazz.getDeclaredFields()) {
				for(Annotation annot: field.getAnnotations()) {
					System.out.println("Field name: " + field.getName() + "Annotation: " + annot); 
				}
//				Annotation ann = field.getAnnotation(MyAnnotation.class);
//				if(ann instanceof MyAnnotation) {
//					MyAnnotation myAnnotation = (MyAnnotation) ann;
//					System.out.println(myAnnotation.name());
//				}				
			}
		}
		System.out.println("==============================");
	}
	
	public static void findParentGeneric(Class<?> clazz) {
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
		Class<? extends Object> clazz =  obj.getClass();
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true); 
		Object rv = field.get(obj);
		System.out.println(rv); 
	}
	
	public static void invokeMethodAndPrintResult(Object obj, String methodName, Object...parameters) throws Exception {
		Class<? extends Object> clazz =  obj.getClass();
		Class [] parametersType = new Class [parameters.length];
		
		Type type = clazz.getGenericSuperclass();
		ParameterizedType paramType = (ParameterizedType) type;
		Type[] actualType = paramType.getActualTypeArguments();
		
		for(int i = 0; i < parametersType.length; i++) {
			parametersType[i] = parameters[i].getClass();
		}
		Method m = null;
		for(Method method: clazz.getMethods()) {
			if(method.getName().equals(methodName)){
				m = method;
				break;
			}
		}
		
		Type[] genericParameterTypes = m.getGenericParameterTypes();
		
		Type[] actualParameters = new Type[genericParameterTypes.length];
		
		for(int i = 0; i < genericParameterTypes.length; i++) {
			
			if(genericParameterTypes[i] instanceof ParameterizedType) {
				actualParameters = ((ParameterizedType)genericParameterTypes[i]).getActualTypeArguments();
			}
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
