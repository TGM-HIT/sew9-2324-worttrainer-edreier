package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Diese Klasse verwaltet die Wordpairs
 * @author Eric Dreier
 * @version 18-10-2023
 */
public class GrammarTrainer {

	private List<Wordpair> pair;
	private int wrong;
	private int right;
	private String input;
	private int pairIndex=0;

	public GrammarTrainer() {
		this.pair = new LinkedList<>();
	}

	/**
	 * Getter methode für richtig eingegebene wörter
	 * @return anzahl
	 */
	public int getRight() {
		return this.right;
	}

	/**
	 * Getter methode für falsch eingegebene wörter
	 * @return anzahl
	 */
	public int getWrong() {
		return this.wrong;
	}

	/**
	 * Gibt den index für das aktuell angezeigte pair an
	 * @return index des pairs
	 */
	public int getPairIndex()	{
		return this.pairIndex;
	}

	/**
	 * Fügt ein wordpair in die Liste hinzu
	 * @param pair ein Wordpair welches hinzugefügt werden will
	 */
	public void addWordpair(Wordpair pair) {
		if(pair!=null)	{
			this.pair.add(pair);
		} else {
			throw new IllegalArgumentException("Wordpair is null");
		}
	}

	/**
	 * Gibt das Wordpair an einem angegebenen Index zurück
	 * @param index der gewollte index
	 * @return Das wordpair an der Stelle des Index
	 */
	public Wordpair getWordpair(int index) {
		if(index <= pair.size()-1)	{
			return this.pair.get(index);
		} else {
			throw new IllegalArgumentException("Index doesn't exist");
		}
	}

	/**
	 * Gibt ein zufällig ausgewähltes Wordpair zurück
	 * @return das zufällig ausgewählte Wordpar
	 */
	public Wordpair getRandomPair()	{
		Random rand = new Random();
		int rnum = rand.nextInt((this.pair.size()-1)+1)+0;
		this.pairIndex=rnum;
		return this.pair.get(rnum);
	}

	/**
	 * Gibt die Liste an Wordpairs zurück
	 * @return die Wordpairliste
	 */
	public List<Wordpair> getPairList()	{
		return this.pair;
	}

	/**
	 * Setzt den eingegebenen Text
	 * @param input der eingegebene Text
	 */
	public void setInput(String input) {
		if(!input.equals(null))	{
			this.input = input;
		}
	}

	/**
	 * Setzt die aktuell richtigen wörter
	 * @param right anzahl
	 */
	public void setRight(int right)	{
		this.right = right;
	}

	/**
	 * Setzt die aktull falschen wörter
	 * @param wrong anzahl
	 */
	public void setWrong(int wrong)	{
		this.wrong = wrong;
	}

	/**
	 * Vergleicht den eingegebenen Text mit dem Wordpair
	 * @param current zu überorüfendes Wordpair
	 * @return ob es richtig oder falsch
	 */
	public boolean checkInput(Wordpair current)	{
		if(this.input.equals(current.getWord()))	{
			this.right++;
			return true;
		} else {
			this.wrong++;
			return false;
		}
	}

}
