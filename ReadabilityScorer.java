public abstract class ReadabilityScorer {
	protected TextAnalyzer text;

	public ReadabilityScorer(TextAnalyzer text) {
		this.text = text;
	}
	
	public String toString() {
		return getScorerName() + "\nScore: " + getReadabilityScore() + "\nLevel: " + getReadingLevel();
	}

	// Abstract methods
	public abstract double getReadabilityScore();
	public abstract String getScorerName();
	public abstract String getReadingLevel();
}

