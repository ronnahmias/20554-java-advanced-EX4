public class Person implements Comparable<Person> {

	private String id;
	private String firstName;
	private String lastName;
	private String birthdayDate;

	public Person(String id, String firstName, String lastName, String birthdayDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdayDate = birthdayDate;
	}

	@Override
	public int compareTo(Person p) {
		return this.id.compareTo(p.id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this.id.equals(((Person) obj).id)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " Id Number=" + id;
	}

}
