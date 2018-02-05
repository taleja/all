package reflection;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author olena.viliuzhanina
 *
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RUNTIME)
 @interface MyAnnotation{

	String name();
	int value();
}
