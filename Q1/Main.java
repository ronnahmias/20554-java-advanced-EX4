import java.util.Random;
import java.util.Scanner;

public class Main {
	public static final int SIZE_ARRAY = 10;
	public static final int MAX_RANDOM = 10;

	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		Integer arrayA[] = new Integer[SIZE_ARRAY];
		Integer arrayB[] = new Integer[SIZE_ARRAY];
		Integer arrayC[] = new Integer[SIZE_ARRAY];

		insertRandom(rd, arrayA);
		insertRandom(rd, arrayB);
		insertRandom(rd, arrayC);

		Set<Integer> setA = new Set<Integer>(arrayA);
		Set<Integer> setB = new Set<Integer>(arrayB);
		Set<Integer> setC = new Set<Integer>(arrayC);

		System.out.println("Question 1.1 + 1.2");

		// after generate new sets
		System.out.println("Set A Init:");
		System.out.println(setA);
		System.out.println("Set B Init:");
		System.out.println(setB);
		System.out.println("Set C Init:");
		System.out.println(setC);

		// union
		setA.union(setB);
		System.out.println("Set A After Union with set B:");
		System.out.println(setA);

		setA.intersect(setC);
		System.out.println("Set A After Intersect with set C:");
		System.out.println(setA);

		Set<Integer> setD = generateGroupD(sc);
		System.out.println("Set D init:");
		System.out.println(setD);

		if (setA.isSubset(setD)) {
			System.out.println("Set D is subset of set A");
		}
		if (setB.isSubset(setD)) {
			System.out.println("Set D is subset of set B");
		}
		if (setC.isSubset(setD)) {
			System.out.println("Set D is subset of set C");
		}

		Integer num = getNumber(sc);
		if (setA.isMember(num)) {
			System.out.println(num + " is member of set A");
		}

		setB.insert(num);
		System.out.println("Set B After Insert " + num + ":");
		System.out.println(setB);

		setC.delete(num);
		System.out.println("Set C After Delete " + num + ":");
		System.out.println(setC);

		/* Q1.3 */

		Person p1 = new Person("15223355", "Ron", "Ivry", "12/02/1998");
		Person p2 = new Person("12654232", "Keren", "Ivry", "26/06/2000");
		Person p3 = new Person("04565434", "Ben", "Ivry", "30/04/1999");
		Person p4 = new Person("98767554", "Yuval", "Ivry", "01/10/1994");
		Person p5 = new Person("045654344", "Alon", "Ivry", "18/03/1993");
		Set<Person> setP = new Set<Person>();
		setP.insert(p1);
		setP.insert(p2);
		setP.insert(p3);
		setP.insert(p4);
		setP.insert(p5);

		System.out.println("Question 1.3");
		System.out.println("Set of Persons:");
		System.out.println(setP);
		System.out.println("Min Item in Person is: " + MinSet.minItem(setP));
	}

	public static void insertRandom(Random rd, Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(MAX_RANDOM);
		}
	}

	public static Set<Integer> generateGroupD(Scanner sc) {
		System.out.println("Enter number:");
		Integer num1 = sc.nextInt();
		System.out.println("Enter another number:");
		Integer num2 = sc.nextInt();
		Integer array[] = { num1, num2 };
		return new Set<Integer>(array);

	}

	public static Integer getNumber(Scanner sc) {
		System.out.println("Enter New number:");
		return sc.nextInt();
	}

}
