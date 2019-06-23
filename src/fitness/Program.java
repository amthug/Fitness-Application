package fitness;

public class Program {

	private ProgramName name;
	private Integer calorieTarget;
	private Integer dailyTime;

	public Program(ProgramName name, Integer calorieTarget, Integer dailyTime) {
		super();
		this.name = name;
		this.calorieTarget = calorieTarget;
		this.dailyTime = dailyTime;
	}

	public ProgramName getName() {
		return name;
	}

	public void setName(ProgramName name) {
		this.name = name;
	}

	public Integer getCalorieTarget() {
		return calorieTarget;
	}

	public void setCalorieTarget(Integer calorieTarget) {
		this.calorieTarget = calorieTarget;
	}

	public Integer getDailyTime() {
		return dailyTime;
	}

	public void setDailyTime(Integer dailyTime) {
		this.dailyTime = dailyTime;
	}
}
