package View;

import javax.swing.*;
import java.util.Locale;

public class GrammarTrainerFrame extends JFrame {

	public GrammarTrainerFrame(String titel, JPanel panel) {
		super(titel);
		Locale.setDefault(new Locale("de","DE"));
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
