import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class TextAnalyzer {
	
	private final String fileName;

	private String text;

	public TextAnalyzer(String fileName) {
		this.fileName = fileName;
		
		try {
			this.text = "";

			Scanner in = new Scanner(new File(fileName));
			
			while(in.hasNext()) {
				this.text += in.next() + " ";
			}

			in.close();

		} catch (Exception e) {
			this.text = new String();
		}
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public String getFileName() {
		return fileName;
	}

	public String toString() {
		String out = fileName;
			
		for (ScoringIndex index : ScoringIndex.values()) {
			out += "\n" + getReadabilityScorer(index).toString();
		}

		return out;
	}

	public ReadabilityScorer getReadabilityScorer(ScoringIndex index) {
		switch (index) {
			case FLESCH:
				return getFlesch();
			case SMOG:
				return getSmog();
			case GUNNING_FOG:
				return getGunningFog();
			case AUTOMATED:
				return getAutomated();
			default:
				return null;
		}
	}

	public ReadabilityScorer getFlesch() {
		return new Flesch(this);
	}
	
	public ReadabilityScorer getSmog() {
		return new Smog(this);
	}

	public ReadabilityScorer getGunningFog() {
		return new GunningFog(this);
	}

	public ReadabilityScorer getAutomated() {
		return new Automated(this);
	}

	public Word[] splitWords() {
		return Arrays.stream(text.split("\\W"))
			.filter(a -> !a.isBlank())
			.map(a -> new Word(a))
			.toArray(Word[]::new);
	}

	public int countSentences() {
		int sentences = 0;
		
		for (char c : text.toCharArray()) {
			if (c == '.' || c == ';' || c == ':' || c == '?' || c == '!') {
				sentences++;
			}
		}

		return sentences;
	}

	public int countWords() {
		return splitWords().length;
	}

	public int countSyllables() {
		int syllables = 0;
		
		for (Word word : splitWords()) {
			syllables += word.countSyllables();
		}

		return syllables;
	}

	public int countCharacters() {
		return Arrays.stream(splitWords())
			.map(a -> a.getWord().length())
			.reduce(0, (a, b) -> a + b);
	}
}

