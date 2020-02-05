import java.util.Arrays;

public class Smog extends ReadabilityScorer {
	public Smog(TextAnalyzer text) {
		super(text);
	}
	
	public double getReadabilityScore() {
		return 3 + Math.pow(numWordsOverThreeSyllables(), 0.5) * (10.0 / text.countSentences());
	}

	private long numWordsOverThreeSyllables() {
		return Arrays.stream(text.splitWords())
			.filter(a -> a.countSyllables() >= 3)
			.count();
	}
}

