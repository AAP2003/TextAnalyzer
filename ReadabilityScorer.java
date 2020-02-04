public abstract class ReadabilityScorer {
	protected TextAnalyzer text;

	public ReadabilityScorer(TextAnalyzer text) {
		this.text = text;
	}
	
	// Abstract methods
	public abstract double getReadabilityScore();
}
