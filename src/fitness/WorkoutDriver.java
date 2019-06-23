package fitness;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkoutDriver {

	// create programs
	private static Program weightLoss = new Program(ProgramName.WL, 4900, 45);
	private static Program crossFit = new Program(ProgramName.WL, 6000, 60);

	private static List<User> listOfusers = new ArrayList<>();

	public static void main(String[] args) {

		// test case 1 - get Ranveer's result
		// test1();

		 test2();

		
	}

	private static void testGetAgeRange() {
		List<User> users = listOfusers.stream().filter(u -> u.getAge() < 35).collect(Collectors.toList());
		for(User u:users) {
			System.out.println(u.getName());
		}
	}

	private static void test1() {
		List<String> days = new ArrayList<>();
		days.add("C10#W20#Z15");
		days.add("C10#W20#Z15");
		days.add("C10#W20#Z15");
		days.add("Z45");
		days.add("C10#W20#Z15");
		days.add("SKIPPED");

		User ranveer = new User("Ranveer", weightLoss, 35, days);

		printResult(ranveer);
	}

	private static void test2() {

		List<String> days = new ArrayList<>();
		days.add("C10#W20#Z15");
		days.add("C10#W20#Z15");
		days.add("C10#W20#Z15");
		days.add("Z45");
		days.add("C10#W20#Z15");
		days.add("SKIPPED");

		List<String> days1 = new ArrayList<>();
		days1.add("C10#W20#Z15");
		days1.add("C10#W20#Z15");
		days1.add("C10#W20#Z15");
		days1.add("C0#W20#Z15");
		days1.add("C10#W20#Z15");
		days1.add("Z20");

		User ranveer = new User("Ranveer", weightLoss, 35, days);
		User deepika = new User("Deepika", crossFit, 30, days1);

		listOfusers.add(ranveer);
		listOfusers.add(deepika);

		for (User u : listOfusers) {
			printResult(u);
		}
		
		System.out.println("");
		
		testGetAgeRange();
	}

	private static void printResult(User user) {
		System.out.println("Name: " + user.getName());
		System.out.println("Program: " + user.getProgram());
		System.out.println("Age: " + user.getAge());
		System.out.println("Target Calories: " + user.getProgram().getCalorieTarget());
		System.out.println("Achieved Calories: " + user.getTotalCalories());
		System.out.println("Percentage Achieved: " + user.getAchievedPercentage());
		System.out.println("Result: " + user.getResult());
	}

}
