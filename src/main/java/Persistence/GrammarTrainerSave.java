package Persistence;

import Model.GrammarTrainer;
import Model.Wordpair;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class GrammarTrainerSave implements Save {

	private GrammarTrainer trainer;

	public GrammarTrainerSave(GrammarTrainer trainer)	{
		this.trainer = trainer;
	}

	@Override
	public void save(String filename) {
		File f = new File(filename);
		PrintWriter out = null;

		try{
			out = new PrintWriter(f);
			for(int i = 0;i<trainer.getPairList().size();i++)	{
				Wordpair current = trainer.getWordpair(i);
				out.println(current.getWord());
				out.println(current.getURL());
			}

			out.println(trainer.getRight());
			out.println(trainer.getWrong());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(out!=null)	{
				out.close();
			}
		}
	}

	@Override
	public GrammarTrainer load(String filename) {
		GrammarTrainer g = new GrammarTrainer();
		try(Scanner s = new Scanner(new BufferedReader(new FileReader(filename))))	{
			while(s.hasNext()&& !s.hasNextInt())	{
				String word = s.nextLine();
				URL url = new URL(s.nextLine());
				Wordpair pair = new Wordpair(word,url);
			}

			int right=s.nextInt();
			s.nextLine();
			int wrong=s.nextInt();

			g.setRight(right);
			g.setWrong(wrong);
			return g;
		} catch (MalformedURLException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return g;
	}

}
