import javax.swing.*;
import java.util.Scanner;

public class Tester {
	private JFrame frame;

	public Tester() {
		frame = new JFrame();
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		TextAnalyzer analyze;

		for (String fileName : new String[] {"Gettysburg.txt", "test-6th-grader.txt", "test-college-grad.txt"}) {
			analyze = new TextAnalyzer("test_files\\" + fileName);
			System.out.println(fileName);
			System.out.println(analyze.getFlesch().getReadabilityScore());
			System.out.println(analyze.getSmog().getReadabilityScore());
			System.out.println(analyze.getGunningFog().getReadabilityScore());
		}

		//new Tester();
	}
}

