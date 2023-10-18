package Persistence;

import Model.GrammarTrainer;

public interface Save {

	public void save(String filename);
	public GrammarTrainer load(String filename);

}
