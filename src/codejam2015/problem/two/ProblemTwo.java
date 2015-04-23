package codejam2015.problem.two;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class ProblemTwo {
	Scanner mScanner = new Scanner(getClass().getResourceAsStream(IN));
	static final String FILENAME = "B-large";
	static final String IN = FILENAME + ".in";
	static final String OUT = FILENAME + ".out";
	PrintStream out = System.out;
	
	static final int LENGTH = 5;
	static final int WIDTH = 5;

	private void solve(long[] stringArray, int textCase) {
		long aA, bB, alpha, beta, years;
		aA = stringArray[0];
		bB = stringArray[1]; 
		alpha = stringArray[2];
		beta = stringArray[3];
		years = stringArray[4];
		if(alpha < 0){
			alpha = 0;
		}
		if(beta < 0){
			beta = 0;
		}
		BigDecimal bd = new BigDecimal(.01f, MathContext.DECIMAL32);
		BigDecimal bd2 = new BigDecimal(.02f, MathContext.DECIMAL32);
		double decomish = bd.doubleValue();
		double babyPercent = bd2.doubleValue();
		double alphaFloat =  (alpha * bd.doubleValue());
		double betaFloat = (beta * bd.doubleValue());
		long previous_aA = -1;
		long previous_bB = -1;
		
		for(int i = 0; i < years; i++){
			//System.out.println("year: " + i);
			//Decomish
			if(i == 98){
				String test = "";
				test += "dafsf";
			}
			long aAForDecomish = (long)Math.floor(aA * decomish);
			long bBForDecomish = (long)Math.floor(bB * decomish);
			long numCouples = Math.min(aA, bB);
			long numBabies = (long)Math.floor((numCouples * babyPercent));
			long baby_aA = (long)(Math.floor(((numBabies)) * (alphaFloat)));
			long baby_bB = (long)(Math.floor(((numBabies)) * (betaFloat)));
			long remaininBabies = numBabies - baby_aA - baby_bB;
			long oddBabies = remaininBabies % 2;
			if(oddBabies == 1){
				baby_bB++;
			}
			remaininBabies = remaininBabies / 2;
			baby_aA += remaininBabies;
			baby_bB += remaininBabies;
			aA += baby_aA;
			bB += baby_bB;
			//End day two
			aA -= aAForDecomish;
			bB -= bBForDecomish;
			//End day three
			if(previous_aA == aA && previous_bB == bB){
				System.out.println("Num aliens no longer changing. year: " + i + " of: "+ years);
				break;
			} else {
				previous_aA = aA;
				previous_bB = bB;
			}
		}
		
		out.println(getTestCaseStringHelper(textCase) + aA + " " + bB);
		System.out.println(getTestCaseStringHelper(textCase) + aA + " " + bB);
//		int ans = 0;
//		out.println(ans);
//		System.out.println("answer: " + ans);
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
			System.out.println("textCase: " + x);
			long stringArray[] = fillMatrix();
			solve(stringArray, x+1);
		}
		mScanner.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new ProblemTwo().run();
	}
	private long[] fillMatrix() {
		long intMatrix[] = new long[LENGTH];
		for (int row = 0; row < intMatrix.length; row++) {
				intMatrix[row] = mScanner.nextLong();
		}
		return intMatrix;
	}
}
