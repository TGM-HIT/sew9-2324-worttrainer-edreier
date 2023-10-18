package View;

import javax.swing.*;
import java.util.Locale;

/**
 * Standrd Frame klasse
 * @author Eric Dreier
 * @version 18-10-2023
 */
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
