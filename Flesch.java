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

	public String getReadingLevel() {
		double score = getReadabilityScore();

		String out = score <= 100 && score > 90 ? "5th Grade" : "Unknown";
		out = score <= 90 && score > 80 ? "6th Grade" : out;
		out = score <= 80 && score > 70 ? "7th Grade" : out;
		out = score <= 70 && score > 60 ? "8th and 9th Grade" : out;
		out = score <= 60 && score > 50 ? "10th and 11th Grade" : out;
		out = score <= 50 && score > 30 ? "College Student" : out;
		out = score <= 30 && score >= 0 ? "College Graduate" : out;
		
		return out;
	}
}

