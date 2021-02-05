import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class EditDrugs extends JFrame implements ActionListener {
	boolean notfound = false;
	boolean modify = false;

	JLabel l1 = new JLabel("Edit Drugs");
	JLabel l2 = new JLabel("Please enter ID of drug to be edited: ");
	JLabel l4 = new JLabel(" New information");
	JLabel l5 = new JLabel(" ID:                              ");
	JLabel l6 = new JLabel(" Name:                        ");
	JLabel l7 = new JLabel(" Quantity:                    ");
	JLabel l8 = new JLabel(" Price:                         ");
	JLabel l9 = new JLabel(" Date(DD/MM/YYYY):");
	JLabel l10 = new JLabel(" Manufacturer:            ");
 
	JTextField input = new JTextField(10);
	JTextField input1 = new JTextField(20);
	JTextField input2 = new JTextField(20);
	JTextField input3 = new JTextField(20);
	JTextField input4 = new JTextField(20);
	JTextField input5 = new JTextField(20);
	JTextField input6 = new JTextField(20);
	JTextArea output = new JTextArea(30,35);
	JButton b1 = new JButton("Search");
	JButton b2 = new JButton("Back");
	JButton b3 = new JButton("Edit");
   	Font f1 = new Font("Arial", Font.PLAIN, 18);
   	Font f2 = new Font("Arial", Font.BOLD, 28);
   	Font f3 = new Font("Arial", Font.PLAIN, 16);
   	Font f4 = new Font("Arial", Font.PLAIN, 22);
	

	EditDrugs(){
		super("Edit Drugs");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        	setVisible(true);
		setSize(530,800);

		Container c = getContentPane();
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		JPanel p1 = new JPanel();			//l1
		JPanel p2 = new JPanel(new FlowLayout());	//l2+input
		JPanel p3 = new JPanel();			//search
		JPanel p4 = new JPanel();			//output
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));			//l4
		JPanel p6 = new JPanel();			//back
		JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));	//input1
		JPanel p8 = new JPanel(new FlowLayout(FlowLayout.LEFT));	//input2
		JPanel p9 = new JPanel(new FlowLayout(FlowLayout.LEFT));	//input3
		JPanel p10 = new JPanel(new FlowLayout(FlowLayout.LEFT));	//input4
		JPanel p11 = new JPanel(new FlowLayout(FlowLayout.LEFT));	//input5
		JPanel p12 = new JPanel(new FlowLayout(FlowLayout.LEFT));	//input6
		JPanel p13 = new JPanel();			//edit
		JPanel blank = new JPanel();			
		JPanel blank1 = new JPanel();	

		l1.setFont(f2);
		l2.setFont(f1);
		l4.setFont(f4);
		input.setFont(f1);
		l5.setFont(f1);
		l6.setFont(f1);
		l7.setFont(f1);
		l8.setFont(f1);
		l9.setFont(f1);
		l10.setFont(f1);
		input1.setFont(f1);
		input2.setFont(f1);
		input3.setFont(f1);
		input4.setFont(f1);
		input5.setFont(f1);
		input6.setFont(f1);
		
		input1.setEditable(false);
		input2.setEditable(false);
		input3.setEditable(false);
		input4.setEditable(false);
		input5.setEditable(false);
		input6.setEditable(false);
		
		input1.setDocument(new JTextFieldLimit(20));
		input2.setDocument(new JTextFieldLimit(20));
		input3.setDocument(new JTextFieldLimit(5));
		input4.setDocument(new JTextFieldLimit(10));
		input5.setDocument(new JTextFieldLimit(12));
		input6.setDocument(new JTextFieldLimit(20));

		p1.add(l1);
		p2.add(l2);
		p2.add(input);
		p3.add(b1);
		p4.add(output);
		p5.add(l4);
		p7.add(l5);
		p7.add(input1);
		p8.add(l6);
		p8.add(input2);
		p9.add(l7);
		p9.add(input3);
		p10.add(l8);
		p10.add(input4);
		p11.add(l9);
		p11.add(input5);
		p12.add(l10);
		p12.add(input6);
		p13.add(b3);
		p6.add(b2);

		p1.setPreferredSize(new Dimension(650,36));
		p2.setPreferredSize(new Dimension(650,32));
		p3.setPreferredSize(new Dimension(650,22));
		p4.setPreferredSize(new Dimension(650,30));
		p5.setPreferredSize(new Dimension(650,22));
		p6.setPreferredSize(new Dimension(650,22));
		p7.setPreferredSize(new Dimension(650,22));
		p8.setPreferredSize(new Dimension(650,22));
		p9.setPreferredSize(new Dimension(650,22));
		p10.setPreferredSize(new Dimension(650,22));
		p11.setPreferredSize(new Dimension(650,22));
		p12.setPreferredSize(new Dimension(650,22));
		p13.setPreferredSize(new Dimension(650,22));
		
		

		main.add(p1);
		main.add(p2);
		main.add(p3);
		main.add(p4);
		main.add(blank);
		main.add(p5);
		main.add(p7);
		main.add(p8);
		main.add(p9);
		main.add(p10);
		main.add(p11);
		main.add(p12);
		main.add(p13);
		main.add(blank1);
		main.add(p6);
		c.add(main);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e){
		String in;
		if(e.getSource() == b1){
			in = input.getText();
			SearchID(in);
			if(notfound){
			input1.setEditable(true);
			input2.setEditable(true);
			input3.setEditable(true);
			input4.setEditable(true);
			input5.setEditable(true);
			input6.setEditable(true);
			}
		}
		if(e.getSource() == b2) {
            new MainMenu().setVisible(true);
			setVisible(false);
		}
		if(e.getSource() == b3){
			in = input.getText();
			EditID(in);
			if(modify){
			input1.setText("");
			input2.setText("");
			input3.setText("");
			input4.setText("");
			input5.setText("");
			input6.setText("");
			input1.setEditable(false);
			input2.setEditable(false);
			input3.setEditable(false);
			input4.setEditable(false);
			input5.setEditable(false);
			input6.setEditable(false);
			}

		}
		
	}


    public void SearchID(String input){
            String id;
			Scanner inFile = null;
			if(!input.isEmpty()){
				try{
						File inputFile = new File("Drugs.txt");		
						BufferedReader br1 = new BufferedReader(new FileReader(inputFile));          
						inFile = new Scanner(br1);
						output.setText("");
						output.append ("ID                    Name              Qty    Price     Date             Manufacturer\n");
						while(inFile.hasNext())
						{
							id = inFile.nextLine();
							String b = id.substring(0,19);
							
							while(b.contains(input))
							{
								output.append(id);
								output.append("\n");
								notfound = true;
									break;
							}

							if(!inFile.hasNext()){
								if(!notfound){    
								JOptionPane.showMessageDialog(null, "No record found.");
								}
							}
						}
					br1.close();
				}		
			catch (IOException f) {
						f.printStackTrace();
			}
		}
		else{
		JOptionPane.showMessageDialog(null, "Please enter an ID. ");
		}
	}

	public static String padRight(String s, int n) {
     		return String.format("%-" + n + "s", s);  
	}

	public void EditID(String input){
		String ID = input1.getText();
		String name = input2.getText();
		String quantity = input3.getText();
		String price = input4.getText();
		String date = input5.getText();
		String manufacturer = input6.getText();
		Scanner inFile = null;
		if(!ID.isEmpty() && !name.isEmpty() && !quantity.isEmpty() && !price.isEmpty() && !date.isEmpty() && !manufacturer.isEmpty()){
					if(!price.contains("-") && !quantity.contains("-") && !ID.contains("-")){
						try{
							File inputFile = new File("Drugs.txt");
							File tempfile = new File("tmp.txt");
							BufferedWriter bw1 = new BufferedWriter(new FileWriter(tempfile));			
							BufferedReader br1 = new BufferedReader(new FileReader(inputFile)); 	
							inFile = new Scanner(br1);
							while(inFile.hasNext())
							{	
								String id = inFile.nextLine();
								String b = id.substring(0,19);
								String c = padRight(b,20);
								String input1 = padRight(input,20);
								if(!c.equals(input1)) {
									bw1.write(id); 
									bw1.newLine();
								}
									
								if(c.equals(input1)){
									bw1.write( padRight(ID,20) + padRight(name,20) + padRight(quantity,5) + padRight(price,10) + padRight(date,12) + padRight(manufacturer,20));
									bw1.newLine();
									modify = true;
								}
							}
							bw1.close();
							br1.close();
							if(modify){
							inputFile.delete();
							boolean success = tempfile.renameTo(inputFile);
								if (success){
								JOptionPane.showMessageDialog(null, "Drug has been successfully edited. ");
								}
								else{
								JOptionPane.showMessageDialog(null, "An error occured. ");
								}
							}
							else{
								JOptionPane.showMessageDialog(null, "No drugs were edited as ID is not specific enough. ");
							}
						}
						catch (IOException e){
										e.printStackTrace();
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
	
    public static void main (String [] args) { 
        new EditDrugs();
    }
        
}