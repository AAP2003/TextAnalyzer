public class Flesch {
	public TextAnalyzer text;

	public Flesch(TextAnalyzer text) {
		this.text = text;
	}

	public double getReadabilityScore() {
		int numSyllables = text.countSyllables();
		int numWords = text.countWords();
		int numSentences = text.countSentences();

		double avgWordLength = numSyllables / numWords;
		double avgSentenceLength = numWords / numSentences;

		return 206.835 - (avgSentenceLength * 1.015 + avgWordLength * 84.6);
	}
}

