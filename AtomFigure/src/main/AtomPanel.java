package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AtomPanel extends JPanel implements ActionListener {

	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private JLabel atomLabel;
	private Frame frame;
	private JButton returnButton;
	
	public AtomPanel(Frame frame, int index) {
		
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.frame = frame;
				
		atomLabel = new JLabel();

		atomLabel.setIcon(resizeImage(this.frame.elements.REPRESENTATIONS[index]));
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
		
	// adds all element to JFrame
	private void displayAtomPage() {
		this.add(atomLabel);
		this.add(returnButton);
		
	}

	private ImageIcon resizeImage(ImageIcon image) {

		return new ImageIcon(image.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// hit return => back to intro panel
		if(e.getSource() == returnButton) {
			frame.displayIntroPanel();
		}		
	}
}