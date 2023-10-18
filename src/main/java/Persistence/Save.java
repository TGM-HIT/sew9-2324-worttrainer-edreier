package Persistence;

import Model.GrammarTrainer;

public interface Save {

	public void save(String filename,GrammarTrainer trainer);
	public GrammarTrainer load(String filename);

}
