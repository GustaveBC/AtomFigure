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
import javax.swing.JTextField;

public class IntroPanel extends JPanel implements ActionListener {

	private final int WIDTH = 786;
	private final int HEIGHT = 563;
	JLabel mainLabel;
	Frame frame;
	JLabel rights;
	JLabel explain;
	JButton button;
	JTextField choice;
	
	public IntroPanel(Frame frame) {
		
		// panel init

		this.frame = frame;
		this.setSize(WIDTH,HEIGHT);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
		
		mainLabel = new JLabel(" Welcome to AtomFigure!");
		mainLabel.setIcon(resizeImage(Frame.logo));
		mainLabel.setBorder(BorderFactory.createLineBorder(Color.blue,3));
		mainLabel.setFont(new Font("Serif",Font.PLAIN,30));
		mainLabel.setVerticalTextPosition(JLabel.BOTTOM);
		mainLabel.setHorizontalTextPosition(JLabel.CENTER);
		mainLabel.setIconTextGap(10);
		mainLabel.setBounds((WIDTH-320)/2, 10, 320, 200);
		
		rights = new JLabel("Made by @GustaveBC. \n All rights Reserved");
		rights.setFont(new Font("Calibri",Font.PLAIN,15));
		rights.setBounds(WIDTH-280, HEIGHT-70, 280, 70);
		
		explain = new JLabel("<html><hr>Please enter the atomic number or the element symbol in the text field bellow<hr></html>");
		explain.setBounds((WIDTH-(explain.getText().length()*2))/2, 200, explain.getText().length()*2, 100);
		
		choice = new JTextField();
		choice.setBounds((WIDTH-200)/2,310,200,50);
		choice.setFont(new Font("Calibri",Font.PLAIN,25));
		choice.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
		choice.setText("meh");
		
		button = new JButton();
		button.addActionListener(this);
		button.setText("GO!");
		button.setForeground(Color.BLACK);
		button.setBorder(BorderFactory.createRaisedBevelBorder());
		button.setFont(new Font("MV Boli",Font.BOLD,40));
		button.setBounds((WIDTH-150)/2,400,150,70);
		button.setBackground(new Color(192,75,75));
		button.setFocusable(false);
		button.setBorderPainted(true);
				
		displayPage();
	}

	private ImageIcon resizeImage(ImageIcon logo) {
		Image image = logo.getImage();
		logo = new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		return logo;
	}

	private void displayPage() {

		this.add(mainLabel);
		this.add(button);
		this.add(rights);
		this.add(explain);
		this.add(choice);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button) {
			String input = choice.getText();
			int index = this.frame.elements.getIndex(input);
			if (index >= 0) {
				this.frame.displayAtomPanel(index);
			}
			else {
				choice.setText("Error!");
			}
		}
	}
}