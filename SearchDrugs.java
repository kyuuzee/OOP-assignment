import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class SearchDrugs extends JFrame implements ActionListener {

	JLabel l1 = new JLabel("Search Drugs");
	JLabel l2 = new JLabel("Please Enter: ");
	CheckboxGroup cbg = new CheckboxGroup();
	Checkbox cb1 = new Checkbox("Search by ID   ", cbg, false);
	Checkbox cb2 = new Checkbox("Search by Name", cbg, false);
	JTextField input = new JTextField(20);
	JTextArea output = new JTextArea();
	JButton b1 = new JButton("Search");
	JButton b2 = new JButton("Back");
   	Font f1 = new Font("Arial", Font.PLAIN, 18);
   	Font f2 = new Font("Arial", Font.BOLD, 28);
   	Font f3 = new Font("Arial", Font.PLAIN, 16);

	SearchDrugs(){
		super("Search Drugs");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        	setVisible(true);
		setSize(530,650);

		Container c = getContentPane();
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		JPanel p1 = new JPanel();			//l1
		JPanel p2 = new JPanel(new FlowLayout());	//cbg
		JPanel p3 = new JPanel(new FlowLayout());	//l2+input
		JPanel p4 = new JPanel();			//search button
		JPanel p5 = new JPanel();			//output
		JPanel p6 = new JPanel();			//back

		l1.setFont(f2);
		l2.setFont(f1);
		cb1.setFont(f1);
		cb2.setFont(f1);
		input.setFont(f1);
		output.setFont(f3);

		p1.add(l1);
		p2.add(cb1);
		p2.add(cb2);
		p3.add(l2);
		p3.add(input);
		p4.add(b1);
		p5.add(output);
		p6.add(b2);

		p1.setPreferredSize(new Dimension(650,36));
		p2.setPreferredSize(new Dimension(650,22));
		p3.setPreferredSize(new Dimension(650,22));
		p4.setPreferredSize(new Dimension(650,22));
		p5.setPreferredSize(new Dimension(650,250));
		p6.setPreferredSize(new Dimension(650,22));

		main.add(p1);
		main.add(p2);
		main.add(p3);
		main.add(p4);
		main.add(p5);
		main.add(p6);
		c.add(main);

		b1.addActionListener(this);
		b2.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e){
		String in, result;
		
		if(cb1.getState()){
			in = input.getText();
			SearchID(in);
		}else{
			in = input.getText();
			SearchName(in);
		}
		if(e.getSource() == b2) {
            new MainMenu().setVisible(true);
			setVisible(false);
        }
	}


     	public void SearchID(String input){
            String id;
			Scanner inFile = null;
			boolean notfound = false;
			try{
            		File inputFile = new File("Drugs.txt");		
					BufferedReader br1 = new BufferedReader(new FileReader(inputFile));          
					inFile = new Scanner(br1);
					output.setText("");
					output.append ("ID                    Name              Qty    Price     Date             Manufacturer\n");
            		while(inFile.hasNext())
            		{
              			id = inFile.nextLine();
						String b = id.substring(0,19);;
             			
                		while(b.contains(input))
                		{
            				output.append(id);
							output.append("\n");
							notfound = true;
                    			break;
                		}

                		if(!inFile.hasNext()){
                			if(!notfound)  
							{    
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



	public void SearchName(String input){
            String name;
			Scanner inFile = null;
			boolean notfound = false;
			try{
            		File inputFile = new File("Drugs.txt");		
					BufferedReader br1 = new BufferedReader(new FileReader(inputFile));          
					inFile = new Scanner(br1);
					output.setText("");
					output.append ("ID                    Name              Qty    Price     Date             Manufacturer\n");
            		while(inFile.hasNext())
            		{
              			name = inFile.nextLine();
						String b = name.substring(20,39);;
             			
                		while(b.contains(input))
                		{
            				output.append(name);
							output.append("\n");
							notfound = true;
                    			break;
                		}

                		if(!inFile.hasNext()){
                			if(!notfound)  
							{    
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



    	public static void main (String [] args) { 
        	new SearchDrugs();
    	}
        
}