/*
 * Class: CMSC203 CRN 31648
 * Instructor: Gary Thai
 * Description: Create a utility class that manipulates a two-dimensional ragged array of doubles.  
 * Due: 04/23/2023
 * Platform/compiler: Eclipse IDE/JDK
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your name here: Paul Akiyama
 */

import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	private static final int MAX_ROW = 10;
	private static final int MAX_COLUMN = 10;
	
	public static double[][] readFile(File file) throws FileNotFoundException {
		Scanner inputFile = new Scanner(file);
		String[][] temp = new String[MAX_ROW][MAX_COLUMN];
		int numRows = 0;
		
		while(inputFile.hasNextLine() && numRows < MAX_ROW) {
			String[] row = inputFile.nextLine().trim().split(" ");
			for(int i = 0; i < row.length && i < MAX_COLUMN; i++) {
				temp[numRows][i] = row[i];
			}
			if(row[0] != null) {
				numRows++;
			}
		}
		double[][] ragged = new double[numRows][];
		
		for(int i = 0; i < numRows; i++) {
			int numColumns = 0;
			for(int j = 0; j < MAX_COLUMN; j++) {
				if(temp[i][j] != null) {
					numColumns++;
				}
			}
			ragged[i] = new double[numColumns];
		}
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < ragged[i].length; j++) {
				ragged[i][j] = Double.parseDouble(temp[i][j]);
			}
		}
		inputFile.close();
		return ragged;
	}
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		PrintWriter outFile = new PrintWriter(outputFile);
		for(double[] row : data) {
			for(int i = 0; i < row.length; i++) {
				outFile.print(row[i]);
				if(i != row.length - 1) {
					outFile.print(" ");
				}
			}
			outFile.println();
		}
		outFile.close();
	}
	public static double getTotal(double[][] data) {
		double total = 0.0;
		for(double[] row : data) {
			for(double value : row) {
				total += value;
			}
		}
		return total;
	}
	public static double getAverage(double[][] data) {
		double total = getTotal(data);
		int count = 0;
		for(double[] row : data) {
			count += row.length;
		}
		return total/count;
	}
	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;
		for(double value : data[row]) {
			total += value;
		}
		return total;
	}
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0.0;
		for(double[] row : data) {
			if(col < row.length) {
				total += row[col];
			}
		}
		return total;
	}
	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][0];
		for(int i = 1; i < data[row].length; i++) {
			if(data[row][i] > highest) {
				highest = data[row][i];
			}
		}
		return highest;
	}
	public static int getHighestInRowIndex(double[][] data, int row) {
		int highestIndex = 0;
		for(int i = 1; i < data[row].length; i++) {
			if(data[row][i] > data[row][highestIndex]) {
				highestIndex = i;
			}
		}
		return highestIndex;
	}
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0];
		for(int i = 1; i < data[row].length; i++) {
			if(data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}
		return lowest;
	}
	public static int getLowestInRowIndex(double[][] data, int row) {
		int lowestIndex = 0;
		for(int i = 1; i < data[row].length; i++) {
			if(data[row][i] < data[row][lowestIndex]) {
				lowestIndex = i;
			}
		}
		return lowestIndex;
	}
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = -1 * Double.MAX_VALUE;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length && data[i][col] > highest) {
	        	highest = data[i][col];
	        }
		}
		return highest;
	}
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = -1 * Double.MAX_VALUE;
		int highestIndex = -1;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length && data[i][col] > highest) {
	        	highest = data[i][col];
	        	highestIndex = i;
	        }
		}
		return highestIndex;
	}
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Double.MAX_VALUE;
		for(int i = 0; i < data.length; i++) {
			if(col < data[i].length && data[i][col] < lowest) {
				lowest = data[i][col];
			}
		}
		return lowest;
	}
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = Double.MAX_VALUE;
		int lowestIndex = -1;
		for(int i = 0; i < data.length; i++) {
			if(col < data[i].length && data[i][col] < lowest) {
				lowest = data[i][col];
				lowestIndex = i;
			}
		}
		return lowestIndex;
	}
	public static double getHighestInArray(double[][] data) {
		double highest = -1 * Double.MAX_VALUE;
	    for (int i = 0; i < data.length; i++) {
	    	for (int j = 0; j < data[i].length; j++) {
	            if (data[i][j] > highest) {
	                highest = data[i][j];
	            }
	        }
	    }
	    return highest;
	}
	public static double getLowestInArray(double[][] data) {
		double lowest = Double.MAX_VALUE;
	    for (int i = 0; i < data.length; i++) {
	    	for (int j = 0; j < data[i].length; j++) {
	            if (data[i][j] < lowest) {
	            	lowest = data[i][j];
	            }
	        }
	    }
	    return lowest;
	}
}