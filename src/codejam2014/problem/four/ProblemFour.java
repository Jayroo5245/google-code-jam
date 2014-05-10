package codejam2014.problem.four;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ProblemFour {
	Scanner mScanner = new Scanner(getClass().getResourceAsStream(IN));
	static final String FILENAME = "A-large";
	static final String IN = FILENAME + ".in";
	static final String OUT = FILENAME + ".out";
	PrintStream out = System.out;
	
	static final int LENGTH = 3;
	static final int WIDTH = 3;

	private void solve(float[][] matrix) {
		System.out.println("Solving: ");
		int ans = 0;
		out.println(ans);
		System.out.println("answer: " + ans);
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
			float floatMatrix[][] = fillMatrix();
			solve(floatMatrix);
		}
		mScanner.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new ProblemFour().run();
	}
	private float[][] fillMatrix() {
		float intMatrix[][] = new float[LENGTH][WIDTH];
		for (int row = 0; row < intMatrix.length; row++) {
			for (int col = 0; col < intMatrix[row].length; col++) {
				intMatrix[row][col] = mScanner.nextFloat();
			}
		}
		return intMatrix;
	}
}
