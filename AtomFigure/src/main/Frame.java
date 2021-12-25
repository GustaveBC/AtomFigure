package main;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame {
	
	public final Elements elements = new Elements();
	public static ImageIcon logo = new ImageIcon("atomFigure_logo.png");
	private IntroPanel introPanel;
	private AtomPanel atomPanel;
	JButton button;

	public Frame() {
		
		// frame init
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("AtomeFigure v2.0");
		this.setIconImage(logo.getImage());
		this.setResizable(false);
		this.setVisible(true);

		this.introPanel = new IntroPanel(this.elements);
		this.introPanel.addInputListener(args -> this.displayAtomPanel(args.getIndex()));
		this.getContentPane().add(introPanel);
		this.repaint();
	}
	
	// displays the atomPanel
	// txChoice: contains the user's choice; it is either a number or a string.
	public void displayAtomPanel(int index) {

		// remove the introPanel, creates the atomPanel and add it
		this.getContentPane().remove(introPanel);
		atomPanel = new AtomPanel(this.elements, index);
		atomPanel.addReturnListener(args -> this.displayIntroPanel());
		this.getContentPane().add(atomPanel);
		this.repaint();
	}
	
	// displays the introPanel
	public void displayIntroPanel() {

		// remove the atomPanel, add the introPanel back
		// FIXME: should null the atomPanel? reuse it?
		this.getContentPane().remove(atomPanel);
		this.getContentPane().add(introPanel);
		this.repaint();
	}
}