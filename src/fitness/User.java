package fitness;

import java.util.List;

public class User {

	private String name;
	private Program program;
	private Integer age;
	private List<String> days;
	private Integer zumbaTime;
	private Integer weightsTime;
	private Integer cardioTime;
	private Integer totalCalories;
	private Integer points;
	private Integer achievedPercentage;
	private String result;

	public User(String name, Program program, Integer age, List<String> days) {
		super();
		this.name = name;
		this.program = program;
		this.age = age;
		this.days = days;

		this.zumbaTime = new Integer(0);
		this.weightsTime = new Integer(0);
		this.cardioTime = new Integer(0);
		this.totalCalories = new Integer(0);
		this.points = new Integer(0);

		for (String day : days) {
			if (day.equals("SKIPPED")) {
				// impl to deduct points
				continue;
			}

			String[] exercise = day.split("#");
			for (String ex : exercise) {
				switch (ex.charAt(0)) {
				case 'C': {
					Integer newCardio = Integer.valueOf(ex.substring(1));
					this.cardioTime += newCardio;
					Integer newCalories = newCardio * CalorieProfileConstants.CARDIO;
					this.totalCalories += newCalories;
					this.points += newCalories;
					break;
				}

				case 'W': {
					Integer newWeights = Integer.valueOf(ex.substring(1));
					this.weightsTime += newWeights;
					Integer newCalories = newWeights * CalorieProfileConstants.WEIGHTS;
					this.totalCalories += newCalories;
					this.points += newCalories;
					break;
				}

				case 'Z': {
					Integer newZumba = Integer.valueOf(ex.substring(1));
					this.zumbaTime += newZumba;
					Integer newCalories = newZumba * CalorieProfileConstants.ZUMBA;
					this.totalCalories += newCalories;
					this.points += newCalories;
					break;
				}

				default:
					break;
				}
			}
		}

		this.achievedPercentage = (this.totalCalories.intValue() * 100) / this.program.getCalorieTarget().intValue();

		// set results
		Integer per = this.achievedPercentage;

		if (per >= 0 && per <= 50)
			this.result = "POOR";
		else if (per >= 51 && per <= 75)
			this.result = "FAIR";
		else if (per >= 76 && per <= 90)
			this.result = "GOOD";
		else if (per > 90)
			this.result = "EXCELLENT";
	}

	public String getName() {
		return name;
	}

	public Program getProgram() {
		return program;
	}

	public Integer getAge() {
		return age;
	}

	public List<String> getDays() {
		return days;
	}

	public Integer getZumbaTime() {
		return zumbaTime;
	}

	public Integer getWeightsTime() {
		return weightsTime;
	}

	public Integer getCardioTime() {
		return cardioTime;
	}

	public Integer getTotalCalories() {
		return totalCalories;
	}

	public Integer getPoints() {
		return points;
	}

	public Integer getAchievedPercentage() {
		return achievedPercentage;
	}

	public String getResult() {
		return result;
	}

}
