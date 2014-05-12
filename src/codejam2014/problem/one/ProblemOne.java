package codejam2014.problem.one;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ProblemOne {
	Scanner mScanner = new Scanner(getClass().getResourceAsStream(IN));
	static final String FILENAME = "A-small";
	static final String IN = FILENAME + ".in";
	static final String OUT = FILENAME + ".out";
	PrintStream out = System.out;
	
	static final int LENGTH = 3;
	static final int WIDTH = 3;

	private void solve(String string, int x) {

		String testCase = getTestCaseStringHelper(x);
		String answerLine1 = getanswerLine1Helper(string);
		String answerLine2 = getanswerLine2Helper(string);
		String answerLine3 = getanswerLine1Helper(string);
		out.println(testCase);
		out.println(answerLine1);
		out.println(answerLine2);
		out.println(answerLine3);

		System.out.println(testCase);
		System.out.println(answerLine1);
		System.out.println(answerLine2);
		System.out.println(answerLine3);
	}
	

	private String getanswerLine1Helper(String string){
		String answerLine = "+-";
		if(string!= null && !string.isEmpty()){
			for(int i = 0; i < string.length(); i++){
				answerLine += "-";
			}
		}
		return answerLine += "-+";
	}
	private String getanswerLine2Helper(String string){
		String answerLine = "| ";
		answerLine += string;
		answerLine += " |";
		return answerLine;
	}
	
	private String getTestCaseStringHelper(int testCase){
		return "Case #" + testCase + ":";
	}	
	private void run() throws Exception {
		System.out.println("run()");
		out = new PrintStream(new FileOutputStream(OUT));
		int numTestCases = Integer.valueOf(mScanner.nextLine());
		if (numTestCases < 1 || numTestCases > 100) {
			System.out.println("numTestCases invalid" + numTestCases);
			out.println("numTestCases invalid" + numTestCases);
			return;
		}
		for (int x = 0; x < numTestCases; x++) {
			String string = mScanner.nextLine();
			solve(string,x+1);
		}
		mScanner.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new ProblemOne().run();
	}
	private String[] getString(int arrayLength) {
		String intMatrix[] = new String[arrayLength];
		for (int row = 0; row < intMatrix.length; row++) {
			intMatrix[row] = mScanner.nextLine();
		}
		return intMatrix;
	}
}
