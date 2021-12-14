package main;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntroPanel extends JPanel implements ActionListener{

	private final int WIDTH = 786;
	private final int HEIGHT = 563;
	private String vChoice;
	JLabel mainLabel;
	Frame mFrame;
	JLabel rights;
	JLabel explain;
	JButton button;
	JTextField choice;
	
	public IntroPanel(Frame proposedFrame) {// panel init

		
		this.mFrame = proposedFrame;
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
		/* The monstruosity bellow is here to verify the demanded atom. 
		 * If you have a better alternative, please contact me at u03759572@gmail.com. Thx!
		 * */
		if(e.getSource() == button && ((choice.getText().equalsIgnoreCase("1")||choice.getText().equalsIgnoreCase("2")
				||choice.getText().equalsIgnoreCase("3")||choice.getText().equalsIgnoreCase("4")||choice.getText().equalsIgnoreCase("5")
				||choice.getText().equalsIgnoreCase("6")||choice.getText().equalsIgnoreCase("7")||choice.getText().equalsIgnoreCase("8")
				||choice.getText().equalsIgnoreCase("9")||choice.getText().equalsIgnoreCase("10")||choice.getText().equalsIgnoreCase("11")
				||choice.getText().equalsIgnoreCase("12")||choice.getText().equalsIgnoreCase("13")||choice.getText().equalsIgnoreCase("14")
				||choice.getText().equalsIgnoreCase("15")||choice.getText().equalsIgnoreCase("16")||choice.getText().equalsIgnoreCase("17")
				||choice.getText().equalsIgnoreCase("18")||choice.getText().equalsIgnoreCase("H")||choice.getText().equalsIgnoreCase("He")
				||choice.getText().equalsIgnoreCase("Li")||choice.getText().equalsIgnoreCase("Be")||choice.getText().equalsIgnoreCase("B")
				||choice.getText().equalsIgnoreCase("C")||choice.getText().equalsIgnoreCase("N")||choice.getText().equalsIgnoreCase("O")
				||choice.getText().equalsIgnoreCase("F")||choice.getText().equalsIgnoreCase("Ne")||choice.getText().equalsIgnoreCase("Na")
				||choice.getText().equalsIgnoreCase("Mg")||choice.getText().equalsIgnoreCase("Al")||choice.getText().equalsIgnoreCase("Si")
				||choice.getText().equalsIgnoreCase("P")||choice.getText().equalsIgnoreCase("S")||choice.getText().equalsIgnoreCase("Cl")||choice.getText().equalsIgnoreCase("Ar")))) {
			
			vChoice = choice.getText();
			this.mFrame.displayPanel2(vChoice);
		}else {
			choice.setText("Error!");
		}
	}

}