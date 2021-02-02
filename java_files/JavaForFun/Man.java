interface Person {
	void introduce(String name);
	
	void sayAge(int age);
	
	void sayFrom(String city, String country);
}

public class Man implements Person {
	private String name;
	private int age;
	private String city;
	private String country;
	
	public Man(String name, int age, String city, String country) {
		this.name = name;
		this.age = age;
		this.city = city;
		this.country = country;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getCountry() {
		return this.country;
	}

	@Override
	public void introduce(String name) {
		System.out.println("���� ����� " + this.name);
	}

	@Override
	public void sayAge(int age) {
		System.out.println("��� " + this.age + " ���");
	}

	@Override
	public void sayFrom(String city, String country) {
		System.out.println("� �� ������ " + this.city + ", " + this.country);
	}

}