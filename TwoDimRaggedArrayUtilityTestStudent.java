/*
 * Class: CMSC203 CRN 31648
 * Instructor: Gary Thai
 * Description: JUnit testing for the TwoDimRaggedArray.
 * Due: 04/23/2023
 * Platform/compiler: Eclipse IDE/JDK
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your name here: Paul Akiyama
 */
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

public class TwoDimRaggedArrayUtilityTestStudent {
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testReadFile() throws FileNotFoundException {
		double[][] expectedData = {{7, 2, 9, 4}, {5}, {8, 1, 3}, {11, 6, 7, 2}};
		double[][] actualData = TwoDimRaggedArrayUtility.readFile(new File("dataSet2.txt"));
		assertArrayEquals(expectedData, actualData);
	}
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		File outputFile = new File("testfile.txt");
		TwoDimRaggedArrayUtility.writeToFile(dataSet1, outputFile);
		
		double[][] actualData = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertArrayEquals(actualData, dataSet1);
	}
	@Test
	public void testGetTotal() {
		assertEquals(45.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),0.001);
	}
	@Test
	public void testGetAverage() {
		assertEquals(5.0,TwoDimRaggedArrayUtility.getAverage(dataSet1),0.001);
	}
	@Test
	public void testGetRowTotal() {
		assertEquals(6.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,0),0.001);
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),0.001);
		assertEquals(30.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,2),0.001);
	}
	@Test
	public void testGetColumnTotal() {
		assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0),0.001);
		assertEquals(14.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1),0.001);
		assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2),0.001);
		assertEquals(9.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 3),0.001);
	}
	@Test
	public void testGetHighestInRow() {
		assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0),0.001);
		assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 1),0.001);
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2),0.001);
	}
	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0),0.001);
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 1),0.001);
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2),0.001);
	}
	@Test
	public void testGetLowestInRow() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0),0.001);
		assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1),0.001);
		assertEquals(6.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2),0.001);
	}
	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0),0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 1),0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2),0.001);
	}
	@Test
	public void testGetHighestInColumn() {
		assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0),0.001);
		assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1),0.001);
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2),0.001);
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 3),0.001);
	}
	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 0),0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 1),0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2),0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 3),0.001);
	}
	@Test
	public void testGetLowestInColumn() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0),0.001);
		assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1),0.001);
		assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2),0.001);
		assertEquals(9.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 3),0.001);
	}
	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0),0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1),0.001);
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2),0.001);
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 3),0.001);
	}
	@Test
	public void testGetHighestInArray() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),0.001);
	}
	@Test
	public void testGetLowestInArray() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1),0.001);
	}
}
