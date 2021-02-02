import java.lang.reflect.Proxy;

public class Prekolchik { 
	public static void main(String[] args) {
		Man vasia = new Man("Вася", 30, "Питер", "Россия");
		
		ClassLoader vasiaClassLoader = vasia.getClass().getClassLoader();
		
		Class[] interfaces = vasia.getClass().getInterfaces();
		
		Person proxyVasia = (Person)Proxy.newProxyInstance(vasiaClassLoader, interfaces, new PersonInvocationHandler(vasia));
		
		proxyVasia.introduce(vasia.getName());
		proxyVasia.sayAge(vasia.getAge());
		proxyVasia.sayFrom(vasia.getCity(), vasia.getCountry());
    }
} 