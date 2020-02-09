import java.util.Arrays;

public class GunningFog extends ReadabilityScorer {
	public GunningFog(TextAnalyzer text) {
		super(text);
	}

	public double getReadabilityScore() {
		double numWords = text.countWords();
		double numSentences = text.countSentences();
		double numComplexWords = numWordsOverThreeSyllables();

		return 0.4 * (numWords / numSentences + 100 * numComplexWords / numWords);
	}

	private long numWordsOverThreeSyllables() {
		return Arrays.stream(text.splitWords())
			.filter(a -> a.countSyllables() >= 3)
			.count();
	}
}

