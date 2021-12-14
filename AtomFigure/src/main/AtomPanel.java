package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AtomPanel extends JPanel implements ActionListener{

	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private final String[] SYMBOLS = new String[18];
	private final byte[] ATOMIC_NUMBERS = new byte[18];
	private final ImageIcon[] REPRESENTATIONS = new ImageIcon[18];
	private final String[] ELEMENT_NAMES = new String[18];
	private String AtomID;
	private JLabel atomLabel;
	private Frame frame;
	private JButton returnButton;
	
	
	public AtomPanel(Frame proposedFrame, String AtomID) {
		
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.AtomID = AtomID;
		this.frame = proposedFrame;
		composeArrays();
		
		
		atomLabel = new JLabel();
		int countLoopForIndex = 0;
		
		if(validateID()) {// determines atomLabel's text
			for(byte AN:ATOMIC_NUMBERS) {
				if(AN == Integer.valueOf(AtomID)) {
					atomLabel.setText(ELEMENT_NAMES[countLoopForIndex]);
					break;
				}
				countLoopForIndex++;
			}
		}else {
			for(String SYM: SYMBOLS) {
				if(SYM.equalsIgnoreCase(AtomID)) {
					atomLabel.setText(ELEMENT_NAMES[countLoopForIndex]);
					break;
				}
				countLoopForIndex++;
			}
		}
		
		atomLabel.setIcon(resizeImage(REPRESENTATIONS[countLoopForIndex]));
		atomLabel.setIconTextGap(30);
		atomLabel.setFont(new Font("Calibri",Font.PLAIN,40));
		atomLabel.setHorizontalTextPosition(JLabel.CENTER);
		atomLabel.setVerticalTextPosition(JLabel.BOTTOM);
		atomLabel.setVerticalAlignment(JLabel.CENTER);
		atomLabel.setHorizontalAlignment(JLabel.CENTER);
		atomLabel.setBounds(0,0,WIDTH-14,HEIGHT-200);
		atomLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 14));
		
		
		returnButton = new JButton();
		returnButton.setText("Return");
		returnButton.setFont(new Font("MVBoli",Font.BOLD,40));
		returnButton.setBackground(new Color(192,75,75));
		returnButton.setForeground(Color.BLACK);
		returnButton.addActionListener(this);
		returnButton.setBorder(BorderFactory.createRaisedBevelBorder());		
		returnButton.setBounds((WIDTH-150)/2,HEIGHT-150,150,100);
		returnButton.setFocusable(false);
		returnButton.setBorderPainted(true);
		displayAtomPage();
	}
	
	
	private void displayAtomPage() {// adds all element to JFrame
		this.add(atomLabel);
		this.add(returnButton);
		
	}

	private boolean validateID() {// tests if AtomID is a string or an int
		try {
			Integer.valueOf(AtomID);
			return true;
			
		}catch(NumberFormatException e) {
			return false;
		}
		
	}
	private ImageIcon resizeImage(ImageIcon logo) {
		Image image = logo.getImage();
		logo = new ImageIcon(image.getScaledInstance(300, 300, Image.SCALE_SMOOTH));
		return logo;
	}

	public void composeArrays() {
		
		SYMBOLS[0] = "H";
		SYMBOLS[1] = "He";
		SYMBOLS[2] = "Li";
		SYMBOLS[3] = "Be";
		SYMBOLS[4] = "B";
		SYMBOLS[5] = "C";
		SYMBOLS[6] = "N";
		SYMBOLS[7] = "O";
		SYMBOLS[8] = "F";
		SYMBOLS[9] = "Ne";
		SYMBOLS[10] = "Na";
		SYMBOLS[11] = "Mg";
		SYMBOLS[12] = "Al";
		SYMBOLS[13] = "Si";
		SYMBOLS[14] = "P";
		SYMBOLS[15] = "S";
		SYMBOLS[16] = "Cl";
		SYMBOLS[17] = "Ar";
		
		for(int i = 0; i<18; i++) {// composing array for atomic numbers
			ATOMIC_NUMBERS[i] = (byte) (i+1);
		}
		
		REPRESENTATIONS[0] = new ImageIcon("H.png");
		REPRESENTATIONS[1] = new ImageIcon("He.png");
		REPRESENTATIONS[2] = new ImageIcon("Li.png");
		REPRESENTATIONS[3] = new ImageIcon("Be.png");
		REPRESENTATIONS[4] = new ImageIcon("B.png");
		REPRESENTATIONS[5] = new ImageIcon("C.png");
		REPRESENTATIONS[6] = new ImageIcon("N.png");
		REPRESENTATIONS[7] = new ImageIcon("O.png");
		REPRESENTATIONS[8] = new ImageIcon("F.png");
		REPRESENTATIONS[9] = new ImageIcon("Ne.png");
		REPRESENTATIONS[10] = new ImageIcon("Na.png");
		REPRESENTATIONS[11] = new ImageIcon("Mg.png");
		REPRESENTATIONS[12] = new ImageIcon("src/res/Al.png");
		REPRESENTATIONS[13] = new ImageIcon("Si.png");
		REPRESENTATIONS[14] = new ImageIcon("P.png");
		REPRESENTATIONS[15] = new ImageIcon("S.png");
		REPRESENTATIONS[16] = new ImageIcon("Cl.png");
		REPRESENTATIONS[17] = new ImageIcon("Ar.png");
	
		ELEMENT_NAMES[0] = "Hydrogen";
		ELEMENT_NAMES[1] = "Helium";
		ELEMENT_NAMES[2] = "Lithium";
		ELEMENT_NAMES[3] = "Beryllium";
		ELEMENT_NAMES[4] = "Boron";
		ELEMENT_NAMES[5] = "Carbon";
		ELEMENT_NAMES[6] = "Nitrogen";
		ELEMENT_NAMES[7] = "Oxygen";
		ELEMENT_NAMES[8] = "Fluorine";
		ELEMENT_NAMES[9] = "Neon";
		ELEMENT_NAMES[10] = "Sodium";
		ELEMENT_NAMES[11] = "Magnesium";
		ELEMENT_NAMES[12] = "Aluminium";
		ELEMENT_NAMES[13] = "Silicon";
		ELEMENT_NAMES[14] = "Phosphorus";
		ELEMENT_NAMES[15] = "Sulfur";
		ELEMENT_NAMES[16] = "Chlorine";
		ELEMENT_NAMES[17] = "Argon";
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == returnButton) {
			frame.displayPanel1();
		}
		
	}
}