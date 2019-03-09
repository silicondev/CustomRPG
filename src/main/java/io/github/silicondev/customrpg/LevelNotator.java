package io.github.silicondev.customrpg;

public enum LevelNotator {
	
	SAFE("SAFE", 0, 0),
	VERY_LOW("VERY_LOW", 1, 9),
	LOW("LOW", 10, 29),
	MEDIUM("MEDIUM", 30, 59),
	MEDIUM_HIGH("MEDIUM_HIGH", 60, 69),
	HIGH("HIGH", 70, 84),
	VERY_HIGH("VERY_HIGH", 85, 100);
	
	private String name;
	private int min;
	private int max;
	
	LevelNotator(String name, int min, int max) {
		this.name = name;
		this.min = min;
		this.max = max;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMin() {
		return this.min;
	}
	
	public int getMax() {
		return this.max;
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public void setMinMax(int[] data) {
		this.min = data[0];
		this.max = data[1];
	}
}
