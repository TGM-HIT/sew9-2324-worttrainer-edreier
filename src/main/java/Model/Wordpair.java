package Model;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Diese Klasse enthält die Wortpaare auf die in dem Programm geprüft werden.
 * @author Eric Dreier
 * @version 18-10-2023
 */
public class Wordpair {

	private String word;
	private String url;

	/**
	 * Konstruktor
	 * @param word Das Wort welches das Bild beschreibt
	 * @param url Das Bild, das zumm Wort passt
	 */
	public Wordpair(String word, String url) {
		this.url = url;
		this.word = word;
	}

	/**
	 * Setter Methode für das Attribut word
	 * @param word Das Wort welches das Bild beschreibt
	 */
	public void setWord(String word) {
		if(!word.equals(null) && !word.equals("")){
			this.word = word;
		}
	}

	/**
	 * Setter Methode für das Attribut url
	 * @param url Das Bild, das zum Wort passt
	 */
	public void setURL(String url) {
		try{
			URL u = new URL(url);
			this.url = url;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gibt das Wort zurück
	 * @return Das Wort
	 */
	public String getWord() {
		return this.word;
	}

	/**
	 * Gibt die URL zurück
	 * @return Die URL
	 */
	public String getURL() {
		return this.url;
	}

}
