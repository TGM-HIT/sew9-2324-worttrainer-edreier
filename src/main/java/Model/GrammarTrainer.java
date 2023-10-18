package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GrammarTrainer {

	private List<Wordpair> pair;
	private int wrong;
	private int right;
	private String input;
	private int pairIndex=0;

	public GrammarTrainer() {
		this.pair = new LinkedList<>();
	}

	public int getRight() {
		return this.right;
	}

	public int getWrong() {
		return this.wrong;
	}

	public int getPairIndex()	{
		return this.pairIndex;
	}

	public void addWordpair(Wordpair pair) {
		if(pair!=null)	{
			this.pair.add(pair);
		} else {
			throw new IllegalArgumentException("Wordpair is null");
		}
	}

	public Wordpair getWordpair(int index) {
		if(index <= pair.size()-1)	{
			return this.pair.get(index);
		} else {
			throw new IllegalArgumentException("Index doesn't exist");
		}
	}

	public Wordpair getRandomPair()	{
		Random rand = new Random();
		int rnum = rand.nextInt((this.pair.size()-1)+1)+0;
		this.pairIndex=rnum;
		return this.pair.get(rnum);
	}

	public List<Wordpair> getPairList()	{
		return this.pair;
	}

	public void setInput(String input) {
		if(!input.equals(null))	{
			this.input = input;
		}
	}

	public int setRight(int right)	{
		return this.right = right;
	}

	public int setWrong(int wrong)	{
		return this.wrong = wrong;
	}

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
