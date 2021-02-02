import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInvocationHandler implements InvocationHandler {
	private Person person;
	
	public PersonInvocationHandler(Person person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		System.out.println("Привет!");
		return null;
	}

}
