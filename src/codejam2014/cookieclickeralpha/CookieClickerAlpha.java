package codejam2014.cookieclickeralpha;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
//https://code.google.com/codejam/contest/2974486/dashboard#s=p1
public class CookieClickerAlpha {

	Scanner mScanner = new Scanner(getClass().getResourceAsStream(IN));
	static final String FILENAME = "b-small";
	static final String IN = FILENAME + ".in";
	static final String OUT = FILENAME + ".out";
	PrintStream out = System.out;
	
	static final int LENGTH = 3;
	static final int WIDTH = 3;

	private void solve(float[] array, int testCase) {
		System.out.println("Solving...");
		float c, f, x;
		c = array[0];
		f = array[1];
		x = array[2];
		System.out.println("c: " + c);
		System.out.println("f: " + f);
		System.out.println("x: " + x);
		float cookiesPerSec = 2.0f;
		float totalSeconds = 0.0f;
		float costRatio = x/c;
		System.out.println("costRatio: " + costRatio);
		int farms = 0;
		boolean done = false;
		while(!done){
			float timeToBuyFarm = c / cookiesPerSec;
			float timeToFinish = x / cookiesPerSec;
			float costRatio_timeToBuyFarm = costRatio * timeToBuyFarm;
			System.out.println("timeToBuyFarm: " + timeToBuyFarm);
			System.out.println("costRatio * timeToBuyFarm: " + costRatio_timeToBuyFarm);
			System.out.println("timeToFinish: " + timeToFinish);
			if(costRatio_timeToBuyFarm >= timeToFinish){
				totalSeconds += timeToFinish;
				System.out.println("totalSeconds: " + totalSeconds);
				System.out.println("done: true");
				done = true;
			} else {
				totalSeconds += timeToBuyFarm;
				farms++;
				cookiesPerSec += f;
				System.out.println("totalSeconds: " + totalSeconds);
				System.out.println("farms: " + farms);
				System.out.println("x: " + cookiesPerSec);
			}
		}
		
		String ans = getTestCaseStringHelper(testCase) + totalSeconds;
		//out.println(ans);
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
//		for (int x = 0; x < numTestCases; x++) {
//			float floatMatrix[][] = fillMatrix();
//			solve(floatMatrix[x], x);
//		}
			float floatMatrix[][] = fillMatrix();
			solve(floatMatrix[0], 0);
		mScanner.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new CookieClickerAlpha().run();
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
