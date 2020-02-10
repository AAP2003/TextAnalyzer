import javax.swing.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.*;

public class Tester {
	private JFrame frame;
	private JTable table;
	private JScrollPane sp;

	public Tester() {
		for (String fileName : new String[] {"Gettysburg.txt", "test-6th-grader.txt", "test-college-grad.txt"}) {
			System.out.println("\n" + (new TextAnalyzer("test_files\\" + fileName)).toString());
		}
		
		frame = new JFrame();
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Object data[][] = new Object[12][4];
		
		int shift = 0;
		
		for (String fileName : new String[] {"Gettysburg.txt", "test-6th-grader.txt", "test-college-grad.txt"}) {
			TextAnalyzer analyze = new TextAnalyzer("test_files\\" + fileName);
			
			data[shift][0] = fileName;
			data[shift + 1][0] = "Score:";
			data[shift + 2][0] = "Level:";
			int shiftScorer = 1;
			for (ScoringIndex v : ScoringIndex.values()) {
				ReadabilityScorer scorer = analyze.getReadabilityScorer(v);

				data[shift][shiftScorer]= scorer.getScorerName();
				data[shift + 1][shiftScorer] = scorer.getReadabilityScore();
				data[shift + 2][shiftScorer] = scorer.getReadingLevel();
				++shiftScorer;
			}
			shift += 4;
		}
		
		table = new JTable(data, new Object[] {"", "", "", ""});
		table.getTableHeader().setUI(null);
		sp = new JScrollPane(table);
		
		frame.add(sp);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Tester();
	}
}

