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

		Object data[][] = new Object[15][6];
		
		int shift = 0;
		
		for (String fileName : new String[] {"Gettysburg.txt", "test-6th-grader.txt", "test-college-grad.txt"}) {
			TextAnalyzer analyze = new TextAnalyzer("test_files\\" + fileName);
			
			data[shift][0] = fileName;
			data[shift + 1][0] = "# of Syllables:";
			data[shift + 2][0] = "# of Words:";
			data[shift + 3][0] = "# of Sentences:";	
			data[shift + 1][1] = analyze.countSyllables();
			data[shift + 2][1] = analyze.countWords();
			data[shift + 3][1] = analyze.countSentences();	
			data[shift + 1][2] = "Score:";
			data[shift + 2][2] = "Level:";
			int shiftScorer = 3;
			for (ScoringIndex v : ScoringIndex.values()) {
				ReadabilityScorer scorer = analyze.getReadabilityScorer(v);
				data[shift + 1][shiftScorer] = scorer.getReadabilityScore();
				data[shift + 2][shiftScorer] = scorer.getReadingLevel();
				++shiftScorer;
			}
			shift += 5;
		}
		
		table = new JTable(data, new Object[] {"", "Stats", "", "Flesch", "Smog", "Gunning Fog"});
		sp = new JScrollPane(table);
		
		frame.add(sp);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Tester();
	}
}

