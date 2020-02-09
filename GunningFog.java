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

	public String getScorerName() {
		return "Gunning Fog";
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

