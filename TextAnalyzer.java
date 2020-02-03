public class TextAnalyzer {
	private String text;

	public TextAnalyzer() {
		text = new String();
	}

	public TextAnalyzer(String text) {
		this.text = text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
