package Persistence;

import Model.GrammarTrainer;
import Model.Wordpair;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * In dieser Klasse wird speichern und laden aus einem File umgesetzt
 * @author Eric Dreier
 * @version 18-10-2023
 */
public class GrammarTrainerSave implements Save {

	/**
	 * Diese Klasse speichert die Wortpaare aus einem Trainer in ein file.
	 * @param filename Der name des files
	 * @param trainer Der trainer, aus dem die Daten in das File gespeichert werden sollen
	 */
	@Override
	public void save(String filename, GrammarTrainer trainer) {
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
			out.println(trainer.getRight()+trainer.getWrong());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(out!=null)	{
				out.close();
			}
		}
	}

	/**
	 * Diese Methode liest aus einem File nach einem festgelegten Muster Daten aus
	 * @param filename Der name des Files
	 * @return Das GrammarTrainer Objekt, in dem sich die Daten aus dem File befinden
	 */
	@Override
	public GrammarTrainer load(String filename) {
		GrammarTrainer t = new GrammarTrainer();
		try (Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
			while (s.hasNext() && !(s.hasNextInt())) {
				String wort = s.nextLine();
				String url = s.nextLine();
				Wordpair wp= new Wordpair(wort, url);
				t.addWordpair(wp);
			}
			int right=0;
			int wrong=0;
			right= s.nextInt();
			s.nextLine();
			wrong= s.nextInt();
			t.setRight(right);
			t.setWrong(wrong);
			return t;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
