import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AddDrugs extends JFrame implements ActionListener {
	private String ID;
	private String name;
	private String quantity;
	private String price;
	private String date;
	private String manufacturer;
	
	JLabel l0 = new JLabel("Add Drug Details", JLabel.CENTER);
	JLabel l1 = new JLabel("Drug ID : ");
	JLabel l2 = new JLabel("Drug Name : ");
	JLabel l3 = new JLabel("Quantity : ");
	JLabel l4 = new JLabel("Price : ");
	JLabel l5 = new JLabel("Expiration Date(DD/MM/YYYY) : ");
	JLabel l6 = new JLabel("Manufacturer : ");
	
	JButton b1 = new JButton("Back");
	JButton b2 = new JButton("Add Drugs");
	
	JTextField input1 = new JTextField(20);
	JTextField input2 = new JTextField(20);
	JTextField input3 = new JTextField(5);
	JTextField input4 = new JTextField(10);
	JTextField input5 = new JTextField(12);
	JTextField input6 = new JTextField(20);
	
	Panel p1 = new Panel(new GridLayout(3,2,6,6));
	Panel p2 = new Panel(new FlowLayout());
	Panel p3 = new Panel(new FlowLayout());
	Panel p4 = new Panel(new FlowLayout());
	Panel p5 = new Panel(new FlowLayout());
	Panel p6 = new Panel(new FlowLayout());
	Panel p7 = new Panel(new FlowLayout());
	Panel p8 = new Panel(new FlowLayout());
	
	public AddDrugs(){
		super("Add Drugs");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(l0, BorderLayout.NORTH);
		
		p2.add(l1);
		p2.add(input1);
		p3.add(l2);
		p3.add(input2);
		p4.add(l3);
		p4.add(input3);
		p5.add(l4);
		p5.add(input4);
		p6.add(l5);
		p6.add(input5);
		p7.add(l6);
		p7.add(input6);
		
		p1.add(p2);
		p1.add(p3);
		p1.add(p4);
		p1.add(p5);
		p1.add(p6);
		p1.add(p7);
		
		p8.add(b1);
		p8.add(b2);
		
		c.add(p1, BorderLayout.CENTER);
		c.add(p8, BorderLayout.SOUTH);
		
		
		b2.addActionListener(this);
		b1.addActionListener(this);
		
		input1.setDocument(new JTextFieldLimit(20));
		input2.setDocument(new JTextFieldLimit(20));
		input3.setDocument(new JTextFieldLimit(5));
		input4.setDocument(new JTextFieldLimit(10));
		input5.setDocument(new JTextFieldLimit(12));
		input6.setDocument(new JTextFieldLimit(20));
		
		setSize(680, 250);
		show();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]){
		AddDrugs app = new AddDrugs();
		app.addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			}
		);
	}
	
	public static String padRight(String s, int n) {
     return String.format("%-" + n + "s", s);  
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b1){
			new MainMenu().setVisible(true);
			setVisible(false);
		}
		if(e.getSource() == b2){
			ID = input1.getText();
			name = input2.getText();
			quantity = input3.getText();
			price = input4.getText();
			date = input5.getText();
			manufacturer = input6.getText();
			if(!ID.isEmpty() && !name.isEmpty() && !quantity.isEmpty() && !price.isEmpty() && !date.isEmpty() && !manufacturer.isEmpty()){
				if(!price.contains("-") && !quantity.contains("-") && !ID.contains("-")){
					try {
						FileWriter myWriter = new FileWriter("Drugs.txt", true);
						BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
						bufferedWriter.write( padRight(ID,20) + padRight(name,20) + padRight(quantity,5) + padRight(price,10) + padRight(date,12) + padRight(manufacturer,20));
						bufferedWriter.newLine();
						bufferedWriter.close();
						JOptionPane.showMessageDialog(null, "Successfully wrote to the file. ");
						input1.setText("");
						input2.setText("");
						input3.setText("");
						input4.setText("");
						input5.setText("");
						input6.setText("");
					} 
					catch (IOException f) {
						JOptionPane.showMessageDialog(null, "An error occurred. ");
						f.printStackTrace();
					}
				}
				else{
				JOptionPane.showMessageDialog(null, "No negative value allowed. ");
				}
			}
			else{
			JOptionPane.showMessageDialog(null, "There are still empty fields. ");
			}
		}
	}
}