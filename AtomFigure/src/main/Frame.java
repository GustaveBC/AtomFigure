package main;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame{
	
	public static ImageIcon logo = new ImageIcon("atomFigure_logo.png");
	private IntroPanel introPanel = new IntroPanel(this);
	private AtomPanel atomPanel;
	final String[] SYMBOLS = new String[18];
	final byte[] ATOMIC_NUMBERS = new byte[18];
	final ImageIcon[] REPRESENTATIONS = new ImageIcon[18];
	JButton button;

	public Frame() {// frame init
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("AtomeFigure v2.0");
		this.setIconImage(logo.getImage());
		this.setResizable(false);
		this.getContentPane().add(introPanel);
		this.setVisible(true);
		
	}
	
	public void displayPanel2(String txChoice){//tx choice is the string containing the user's choice; it is either a number, either a string.

		this.getContentPane().remove(introPanel);
		atomPanel = new AtomPanel(this,txChoice);
		this.getContentPane().add(atomPanel);
		this.repaint();
	}
	
	public void displayPanel1(){//displays the introPanel

		this.getContentPane().remove(atomPanel);
		this.getContentPane().add(introPanel);
		this.repaint();
	}
}