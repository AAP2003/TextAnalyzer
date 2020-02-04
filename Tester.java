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
		TextAnalyzer analyze = new TextAnalyzer("test_files\\Gettysburg.txt");

		System.out.println(analyze.getFlesch().getReadabilityScore());

		//new Tester();
	}
}

