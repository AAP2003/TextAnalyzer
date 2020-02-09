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

	private long numWordsOverThreeSyllables() {
		return Arrays.stream(text.splitWords())
			.filter(a -> a.countSyllables() >= 3)
			.count();
	}
}

