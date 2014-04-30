package codejam2014.magictrick;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

//https://code.google.com/codejam/contest/2974486/dashboard
public class PracticeTemplate2 {

	//static final String FILENAME = "A-large";
	static final String FILENAME = "A-small-practice";
	static final String IN = FILENAME + ".in";
	static final String OUT = FILENAME + ".out";
	static final int LENGTH = 4;
	static final int WIDTH = 4;
	PrintStream out = System.out;
	Scanner sc = new Scanner(getClass().getResourceAsStream(IN));

	private void solve(int testCase, int rowNum, int rowNum2, int[][] intMatrix, int[][] intMatrix2) {
		System.out.println("testCase: " + testCase);
		System.out.println("row1: " + rowNum);
		System.out.println("row2: " + rowNum2);
		//for zero based arrays
		rowNum--;
		rowNum2--;
		String answer = "Error";
		if(rowNum < 1 || rowNum > 4 || rowNum2 < 1 || rowNum2 > 4){
			System.out.println("testCase: " + testCase);
			answer = "Error: Invalid solution";
		}
		int rowArray[] = intMatrix[rowNum];
		int rowArray2[] = intMatrix2[rowNum2];
		int x = testCase;
		int y = -1;
		String yString = null;
		for (int row = 0; row < rowArray.length; row++) {
			int value = rowArray[row];
			for(int row2 = 0; row2 < rowArray2.length; row2++){
				int value2 = rowArray2[row2];
				if(value == value2){
					if(y != -1){
						yString = "Bad magician!";
						break;
					}
					yString = String.valueOf(value);
					y = value;
					break;
				}
			}
		}
		if(y == -1){
			yString = "Volunteer cheated!";
		}
		answer = "Case #" + x + ": " + yString;
		out.println(answer);
		System.out.println("answer: " + answer);
	}

	private void run() throws Exception {
		System.out.println("run()");
		out = new PrintStream(new FileOutputStream(OUT));
		int numTestCases = sc.nextInt();
		if (numTestCases < 1 || numTestCases > 100) {
			System.out.println("numTestCases invalid" + numTestCases);
			out.println("numTestCases invalid" + numTestCases);
		}
		for (int x = 0; x < numTestCases; x++) {
			int row = sc.nextInt();
			int intMatrix[][] = fillMatrix();
			int row2 = sc.nextInt();
			int intMatrix2[][] = fillMatrix();
			solve(x+1, row, row2, intMatrix, intMatrix2);
		}
		sc.close();
		out.close();
	}

	private int[][] fillMatrix() {
		int intMatrix[][] = new int[LENGTH][WIDTH];
		for (int row = 0; row < intMatrix.length; row++) {
			for (int col = 0; col < intMatrix[row].length; col++) {
				intMatrix[row][col] = sc.nextInt();
			}
		}
		return intMatrix;
	}

	public static void main(String args[]) throws Exception {
		new PracticeTemplate2().run();
	}

}
