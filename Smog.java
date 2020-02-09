import java.util.Arrays;

public class Smog extends ReadabilityScorer {
	public Smog(TextAnalyzer text) {
		super(text);
	}
	
	public double getReadabilityScore() {
		return 1.0430 * Math.pow(30.0 * (double) numWordsOverThreeSyllables() / (double) text.countSentences(), 0.5) + 3.1291;
	}

	public String getScorerName() {
		return "Smog";
	}

	public String getReadingLevel() {
		int score = (int) getReadabilityScore();

		String out = score == 1 ? "1st Grade" : "Unknown";
		out = score == 2 ? "2nd Grade" : out;
		out = score == 3 ? "3rd Grade" : out;
		out = score <= 12 && score > 3 ? (score + "th Grade") : out;
		out = score <= 16 && score > 12 ? "College Student" : out;
		out = score > 16 ? "College Graduate" : out;

		return out;
	}

	private long numWordsOverThreeSyllables() {
		return Arrays.stream(text.splitWords())
			.filter(a -> a.countSyllables() >= 3)
			.count();
	}
}

