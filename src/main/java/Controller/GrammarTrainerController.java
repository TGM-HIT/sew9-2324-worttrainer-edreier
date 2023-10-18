package Controller;

import Model.GrammarTrainer;
import Persistence.GrammarTrainerSave;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrammarTrainerController implements ActionListener {

	private GrammarTrainer grammarTrainer;
	private GrammarTrainerPanel panel;
	private GrammarTrainerFrame frame;
	private GrammarTrainerSave save;

	public GrammarTrainerController() {
		this.panel = new GrammarTrainerPanel(this);
		this.frame = new GrammarTrainerFrame("Worttrainer",this.panel);
		this.save = new GrammarTrainerSave(this.grammarTrainer);
		this.grammarTrainer = save.load("GrammarTrainer.txt");
		this.save = new GrammarTrainerSave(this.grammarTrainer);
	}

	public static void main(String[] args) {
		GrammarTrainerController trainer = new GrammarTrainerController();
		trainer.panel.setUrl(trainer.grammarTrainer.getRandomPair().getURL());
		trainer.panel.setRight(trainer.grammarTrainer.getRight()+"");
		trainer.panel.setWrong(trainer.grammarTrainer.getWrong()+"");
		trainer.panel.setCounter(trainer.grammarTrainer.getWrong()+trainer.grammarTrainer.getRight()+"");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.grammarTrainer.setInput(this.panel.getInput());

		if(e.getActionCommand().equals("end"))	{
			this.panel.inputEnable(false);
			this.panel.enableReset(false);
			this.panel.enableEnd(false);
			this.panel.endMessage();
			this.save.save("GrammarTrainer.txt");
		}

		if(e.getActionCommand().equals("reset"))	{
			this.grammarTrainer.setRight(0);
			this.grammarTrainer.setWrong(0);
			this.panel.setRight("0");
			this.panel.setWrong("0");
			this.panel.setCounter("0");
		}

		if(e.getActionCommand().equals("input"))	{
			if(this.grammarTrainer.checkInput(grammarTrainer.getWordpair(grammarTrainer.getPairIndex())))	{
				this.panel.setRight(grammarTrainer.getRight()+"");
				this.panel.correctMessage();
				this.panel.setCounter(grammarTrainer.getRight()+grammarTrainer.getWrong()+"");
				this.panel.resetField();
				this.panel.setUrl(grammarTrainer.getRandomPair().getURL());
			} else {
				this.panel.setWrong(grammarTrainer.getWrong()+"");
				this.panel.wrongMessage();
				this.panel.resetField();
				this.panel.setCounter(grammarTrainer.getWrong()+grammarTrainer.getRight()+"");
			}
		}
	}
}
