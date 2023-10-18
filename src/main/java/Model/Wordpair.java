package Model;

import java.net.URL;

public class Wordpair {

	private String word;

	private String url;

	public Wordpair(String word, String url) {
		this.url = url;
		this.word = word;
	}

	public void setWord(String word) {
		if(!word.equals(null) && !word.equals("")){
			this.word = word;
		}
	}

	public void setURL(String url) {
		this.url = url;
	}

	public String getWord() {
		return this.word;
	}

	public String getURL() {
		return this.url;
	}

}
