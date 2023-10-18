package View;

import Controller.GrammarTrainerController;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Das Panel für die GUI
 * @author Eric Dreier
 * @version 18-10-2023
 */
public class GrammarTrainerPanel extends JPanel {

	private String url = new String("https://media.istockphoto.com/id/1335247217/vector/loading-icon-vector-illustration.jpg?s=612x612&w=0&k=20&c=jARr4Alv-d5U3bCa8eixuX2593e1rDiiWnvJLgHCkQM=");
	private JLabel image, right, wrong, counter;
	private JButton end, reset;
	private JTextField textfield;

	/**
	 * Hier wird das Panel generiert
	 * @param controller Logikklasse
	 */
	public GrammarTrainerPanel(GrammarTrainerController controller) {
		this.setLayout(new BorderLayout());

		JPanel input = new JPanel();
		input.setLayout(new GridLayout(2,1,5,5));
		JLabel label = new JLabel("Was wird im Bild dargestellt");

		input.add(label);
		textfield = new JTextField();
		textfield.setActionCommand("input");
		textfield.addActionListener(controller);
		input.add(textfield);
		this.add(input, BorderLayout.PAGE_START);

		this.drawImage();

		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(5,2,5,5));
		JLabel l1 = new JLabel("Statistik");
		JLabel l2 = new JLabel("Richtige W\u00f6rter");
		JLabel l3 = new JLabel("Falsche W\u00f6rter");
		JLabel l4 = new JLabel("Versuche");
		right = new JLabel("0",SwingConstants.CENTER);
		wrong = new JLabel("0",SwingConstants.CENTER);
		counter = new JLabel("0",SwingConstants.CENTER);

		menu.add(l1);
		end = new JButton("Speichern & beenden");
		end.setActionCommand("end");
		end.addActionListener(controller);
		menu.add(new JLabel(""));
		menu.add(l2);
		menu.add(right);
		menu.add(l3);
		menu.add(wrong);
		menu.add(l4);
		menu.add(counter);

		reset = new JButton("zurücksetzen");
		reset.setActionCommand("reset");
		reset.addActionListener(controller);

		menu.add(reset);
		menu.add(end);

		this.add(menu,BorderLayout.PAGE_END);
	}

	/**
	 * Gibt den Inhalt des Inputfensters zurück
	 * @return Inhalt des Inputfensters
	 */
	public String getInput() {
		return this.textfield.getText();
	}

	/**
	 * Setzt die Anzahl der richtig beantworteten Wörter
	 * @param text Anzahl
	 */
	public void setRight(String text)	{
		this.right.setText(text);
	}

	/**
	 * Setzt die Anzahl der falsch beantworteten Wörter
	 * @param text Anzahl
	 */
	public void setWrong(String text)	{
		this.wrong.setText(text);
	}

	/**
	 * Setzt die Anzahl der insgesamt beantworteten Wörter
	 * @param text Anzahl
	 */
	public void setCounter(String text)	{
		this.counter.setText(text);
	}

	/**
	 * Setzt die URL auf den Parameter
	 * @param url Angegebene URL
	 */
	public void setUrl(String url)	{
		this.url = url;
		this.drawImage();
	}

	/**
	 * Hier wird das ausgeben des Bildes von einer URL umgesetzt
	 */
	public void drawImage() {
		if(image!=null)	{
			this.remove(image);
		}

		ImageIcon icon = null;
		try{
			icon = new ImageIcon(new URL(this.url.toString()));
		} catch (MalformedURLException e)	{
			e.printStackTrace();
		}

		Image img = icon.getImage();
		img = img.getScaledInstance(250,250,Image.SCALE_SMOOTH);
		image = new JLabel(new ImageIcon(img));
		this.add(image, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	/**
	 * Enabled oder Disabled das Inputfenster
	 * @param b ob es enabled oder disabled ist
	 */
	public void inputEnable(boolean b)	{
		this.textfield.setEnabled(b);
	}

	/**
	 * cleared das Inputfenster
	 */
	public void resetField()	{
		this.textfield.setText("");
	}

	/**
	 * Setzt den reset Button auf enabled oder disabled
	 * @param b ob es enabled oder disabled ist
	 */
	public void enableReset(boolean b)	{
		this.reset.setEnabled(b);
	}

	/**
	 * Setzt den end Button auf enabled oder disabled
	 * @param b ob es enabled oder disabled ist
	 */
	public void enableEnd(boolean b)	{
		this.end.setEnabled(b);
	}

	/**
	 * Diese Methode gibt nach einem korrekt klassifizierten Bild eine nachricht aus
	 */
	public void correctMessage() {
		try{
			URL imgURL = new URL("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fstatic.vecteezy.com%2Fsystem%2Fresources%2Fpreviews%2F000%2F581%2F688%2Foriginal%2Fgreen-check-mark-logo-template-illustration-design-vector-eps-10.jpg&f=1&nofb=1&ipt=93b2976f10549f3fd96d05d1ebc683286a412af01c916869d844480e5ae2232f&ipo=images");
			ImageIcon icon = new ImageIcon(imgURL);
			Image scaled = icon.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaled);

			JOptionPane.showMessageDialog(null, "Die Antwort war richtig", "Richtig!", JOptionPane.INFORMATION_MESSAGE,scaledIcon);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode gibt nach einem falsch klassifizierten Bild eine nachricht aus
	 */
	public void wrongMessage() {
		try{
			URL imgURL = new URL("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F5%2F5f%2FRed_X.svg%2F1024px-Red_X.svg.png&f=1&nofb=1&ipt=4edef4c0da4ab03f8cb2273a15c20d031742d05fe87f8a02d1f6176221b59148&ipo=images");
			ImageIcon icon = new ImageIcon(imgURL);
			Image scaled = icon.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaled);

			JOptionPane.showMessageDialog(null,"Die Antwort war falsch", "leider falsch", JOptionPane.INFORMATION_MESSAGE,scaledIcon);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Diese Methode gibt nach dem drücken des speichern und beenden buttons eine nachricht aus
	 */
	public void endMessage() {
		try{
			URL imgURL = new URL("https://icon-library.com/images/end-icon/end-icon-2.jpg");
			ImageIcon icon = new ImageIcon(imgURL);
			Image scaled = icon.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaled);

			JOptionPane.showMessageDialog(null,"Du bist am Ende", "ende", JOptionPane.INFORMATION_MESSAGE,scaledIcon);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
