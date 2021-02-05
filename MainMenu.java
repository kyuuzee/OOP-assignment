import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener{
	JLabel l0 = new JLabel("Welcome to The Pharmacy Inventory Management System", JLabel.CENTER);
	JLabel l1 = new JLabel("                                  ");
	JLabel l2 = new JLabel("                                  ");
	JLabel l3 = new JLabel(" ");
	
	JButton b1 = new JButton("Add Drugs");
	JButton b2 = new JButton("Edit Drugs");
	JButton b3 = new JButton("Search Drugs");
	JButton b4 = new JButton("List Drugs");
	JButton b5 = new JButton("Delete Drugs");
	Panel p = new Panel(new GridLayout(5,0,0,50));
	
	Font f1 = new Font("Arial", Font.BOLD, 18);
	
	public MainMenu(){
		super("Main Menu");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		l0.setFont(f1);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		
		c.add(l0, BorderLayout.NORTH);
		c.add(l1, BorderLayout.WEST);
		c.add(l2, BorderLayout.EAST);
		c.add(l3, BorderLayout.SOUTH);
		c.add(p, BorderLayout.CENTER);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		setSize(600, 500);
		show();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]){
		new MainMenu();
	}
	
	public void actionPerformed (ActionEvent e) {
			if(e.getSource() == b1) {
            new AddDrugs().setVisible(true);
			setVisible(false);
			}
			if(e.getSource() == b2) {
            new EditDrugs().setVisible(true);
			setVisible(false);
			}
			if(e.getSource() == b3) {
            new SearchDrugs().setVisible(true);
			setVisible(false);
			}
			if(e.getSource() == b4) {
            new ListDrugs().setVisible(true);
			setVisible(false);
			}
			if(e.getSource() == b5) {
            new DeleteDrugs().setVisible(true);
			setVisible(false);
			}
    }
}