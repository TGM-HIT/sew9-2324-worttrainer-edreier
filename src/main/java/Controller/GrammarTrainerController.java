package Controller;

import Model.GrammarTrainer;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrammarTrainerController implements ActionListener {

	private GrammarTrainer grammarTrainer;
	private GrammarTrainerPanel panel;
	private GrammarTrainerFrame frame;

	public GrammarTrainerController() {
		this.panel = new GrammarTrainerPanel(this);
		this.frame = new GrammarTrainerFrame("Worttrainer",this.panel);
	}

	public void main(String[] args) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
