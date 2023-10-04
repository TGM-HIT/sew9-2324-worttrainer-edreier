package Model;

import java.net.URL;

public class Wordpair {

	private String word;

	private URL url;

	public Wordpair(String word, URL url) {
		this.url = url;
		this.word = word;
	}

	public void setWord(String word) {
		if(!word.equals(null) && !word.equals("")){
			this.word = word;
		}
	}

	public void setURL(URL url) {
		this.url = url;
	}

	public String getWord() {
		return this.word;
	}

	public URL getURL() {
		return this.url;
	}

}
