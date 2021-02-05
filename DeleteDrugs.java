import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class DeleteDrugs extends JFrame implements ActionListener{

	JLabel l1 = new JLabel("Delete Drugs");
	JLabel l2 = new JLabel("Enter the name of the drug: ");
	JTextField input = new JTextField(20);
	JButton b1 = new JButton("Delete");
	JButton b2 = new JButton("Back");
   	Font f1 = new Font("Arial", Font.PLAIN, 18);
   	Font f2 = new Font("Arial", Font.BOLD, 28);
	
   	

	DeleteDrugs(){
		
		super("Delete Drugs");
		Container c = getContentPane();
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		JPanel p1 = new JPanel();			//l1
		JPanel p2 = new JPanel(new FlowLayout());	//l2+input
		JPanel p3 = new JPanel();			//search button
		JPanel p4 = new JPanel();			//back

		l1.setFont(f2);
		l2.setFont(f1);
		input.setFont(f1);
		
		p1.add(l1);
		p2.add(l2);
		p2.add(input);
		p3.add(b1);
		p4.add(b2);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
        	setVisible(true);
		setSize(530,650);

		p1.setPreferredSize(new Dimension(650,36));

		p2.setPreferredSize(new Dimension(650,22));
		p3.setPreferredSize(new Dimension(650,22));
		
		p4.setPreferredSize(new Dimension(650,22));

		main.add(p1);
		main.add(p2);
		main.add(p3);
		main.add(p4);
		c.add(main);

		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b2) {
            new MainMenu().setVisible(true);
			setVisible(false);
			}
			if(e.getSource() == b1) {
			DeleteDrugs(input.getText());
			input.setText("");
		}
	}
	
	public static String padRight(String s, int n) {
     return String.format("%-" + n + "s", s);  
	}
        


     	public void DeleteDrugs(String input){
		boolean exist = false;
			try{
			if(!input.isEmpty()){
				int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete this drug?","WARNING",JOptionPane.YES_NO_OPTION);
				if(dialogButton == JOptionPane.YES_OPTION){
					File inputFile = new File("Drugs.txt");
					File tempfile = new File("tmp.txt");
					BufferedWriter bw1 = new BufferedWriter(new FileWriter(tempfile));			
					// BufferedReader object for Drugs.txt 
					BufferedReader br1 = new BufferedReader(new FileReader(inputFile)); 
				
					String line1 = br1.readLine(); 
					// loop for each line of Drugs.txt
					while(line1 != null) 
					{ 
						String value2 = line1.substring(20,39);
						String name = padRight(value2,20);
						String input1 = padRight(input,20);
						if(name.equals(input1)){
							exist = true;
						}
						// if input is not present in line 
						// write it to Temp.txt
						if(!name.equals(input1)) {
							bw1.write(line1); 
							bw1.newLine();
						}
					
					line1 = br1.readLine(); 
					}
					//rename and overwrite filename
					// closing resources 
					br1.close(); 
					bw1.close();
					inputFile.delete();
					boolean success = tempfile.renameTo(inputFile);
					if (success && exist){
						JOptionPane.showMessageDialog(null, "Drug has been successfully deleted ");
					}
					else{
						JOptionPane.showMessageDialog(null, "There was an error deleting the drug or it does not exist ");
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "The input field is empty. ");
			} 
			}
			catch (IOException f) {
				
				f.printStackTrace();
			}
	}



    	public static void main (String [] args) { 
        	new DeleteDrugs();
    	}
        
}