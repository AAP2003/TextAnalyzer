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
		for (String fileName : new String[] {"Gettysburg.txt", "test-6th-grader.txt", "test-college-grad.txt"}) {
			System.out.println("\n" + (new TextAnalyzer("test_files\\" + fileName)).toString());
		}

		//new Tester();
	}
}

