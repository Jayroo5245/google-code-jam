package codejam2014.problem.three;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ProblemThree {
	Scanner mScanner = new Scanner(getClass().getResourceAsStream(IN));
	static final String FILENAME = "A-large";
	static final String IN = FILENAME + ".in";
	static final String OUT = FILENAME + ".out";
	PrintStream out = System.out;
	
	static final int LENGTH = 2;
	static final int WIDTH = 3;

	private void solve(int[] intArray, int x) {
		System.out.println("Solving: ");
		int N, K;
		N = intArray[0];
		K = intArray[1];
		System.out.println(getTestCaseStringHelper(x));
	}
	
	private String getTestCaseStringHelper(int testCase){
		return "Case #" + testCase + ": ";
	}
	
	private void run() throws Exception {
		System.out.println("run()");
		out = new PrintStream(new FileOutputStream(OUT));
		int numTestCases = mScanner.nextInt();
		if (numTestCases < 1 || numTestCases > 100) {
			System.out.println("numTestCases invalid" + numTestCases);
			out.println("numTestCases invalid" + numTestCases);
			return;
		}
		for (int x = 0; x < numTestCases; x++) {
			int intArray[] = fillMatrix();
			solve(intArray[]);
		}
		mScanner.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new ProblemThree().run();
	}
	private int[] fillMatrix() {
		int intMatrix[] = new int[LENGTH];
		for (int row = 0; row < intMatrix.length; row++) {
				intMatrix[row] = mScanner.nextInt();
		}
		return intMatrix;
	}
}
