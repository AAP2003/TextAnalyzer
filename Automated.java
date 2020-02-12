public class Automated extends ReadabilityScorer {
	public Automated(TextAnalyzer text) {
		super(text);
	}

	public double getReadabilityScore() {
		double numChar = text.countCharacters();
		double numWords = text.countWords();
		double numSentences = text.countSentences();

		return (numChar / numWords * 4.71) + (numWords / numSentences * 0.5) - 21.43;
	}
	
	public String getScorerName() {
		return "Automated";
	}

	public String getReadingLevel() {
		int score = (int) getReadabilityScore();

		String out = score == 1 ? "Kindergarten" : "Unknown";
		out = score == 2 ? "1st to 2nd Grade" : out;
		out = score == 3 ? "3rd Grade" : out;
		out = score <= 12 && score > 3 ? (score + "th Grade") : out;
		out = score == 13 ? "College Student" : out;
		out = score == 14 ? "College Graduate" : out;

		return out;
	}
}

