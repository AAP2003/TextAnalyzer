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
		ReadabilityScorer scorer;

		for (String fileName : new String[] {"Gettysburg.txt", "test-6th-grader.txt", "test-college-grad.txt"}) {
			analyze = new TextAnalyzer("test_files\\" + fileName);
			System.out.println("\n" + fileName);
			
			for (ScoringIndex index : ScoringIndex.values()) {
				scorer = analyze.getReadabilityScorer(index);
				System.out.println(scorer.getScorerName());
				System.out.println("Readability Score: " + scorer.getReadabilityScore());
			}
		}

		//new Tester();
	}
}

