/*
 * Class: CMSC203 CRN 31648
 * Instructor: Gary Thai
 * Description: Create a utility class that will calculate holiday bonuses given a ragged array of doubles which represent the sales for each store in each category.
 * Due: 04/23/2023
 * Platform/compiler: Eclipse IDE/JDK
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your name here: Paul Akiyama
 */

public class HolidayBonus {
	private static final double HIGHEST_SALES = 5000.0;
	private static final double OTHER_SALES = 2000.0;
	private static final double LOWEST_SALES = 1000.0;
	
	public static double[] calculateHolidayBonus(double[][] data) {
		double[] bonuses = new double[data.length];
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] < 0) {
					continue;
				}
				else if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
					bonuses[i] += HIGHEST_SALES;
				}
				else if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
					bonuses[i] += LOWEST_SALES;
				}
				else {
					bonuses[i] += OTHER_SALES;
				}
			}
		}
		return bonuses;
	}
	public static double calculateTotalHolidayBonus(double[][] data) {
		double totalBonus = 0.0;
		double[] bonuses = calculateHolidayBonus(data);
		
		for(double bonus : bonuses) {
			totalBonus += bonus;
		}
		return totalBonus;
	}
}
