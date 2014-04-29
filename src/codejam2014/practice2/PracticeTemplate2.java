package codejam2014.practice2;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PracticeTemplate2 {

	Scanner sc = new Scanner(getClass().getResourceAsStream(IN));
	static final String FILENAME = "A-large";
	static final String IN = FILENAME + ".in";
	static final String OUT = FILENAME + ".out";
	PrintStream out = System.out;

	private void solve(String string) {
		System.out.println("Solving: " + string);
		int ans = 0;
		out.println(ans);
		System.out.println("answer: " + ans);
	}

	private void run() throws Exception {
		System.out.println("run()");
		out = new PrintStream(new FileOutputStream(OUT));
		int i = 0;
		while(sc.hasNextLine()){
			String nextLine = sc.nextLine();
			solve(nextLine);
			i++;
		}
		System.out.println("Total num lines: " + i);
		sc.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new PracticeTemplate2().run();
	}

}
