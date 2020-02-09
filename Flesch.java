public class Flesch extends ReadabilityScorer {
	public Flesch(TextAnalyzer text) {
		super(text);
	}

	public double getReadabilityScore() {
		double numSyllables = text.countSyllables();
		double numWords = text.countWords();
		double numSentences = text.countSentences();

		return 206.835 - (numWords / numSentences * 1.015) - (numSyllables / numWords * 84.6);
	}
	
	public String getScorerName() {
		return "Flesch";
	}
}

