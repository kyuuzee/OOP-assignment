import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ListDrugs extends JFrame implements ActionListener {
    
    JLabel l1 = new JLabel("Display Drugs");
    
    JButton b1 = new JButton("Display All Drugs");
	JButton b2 = new JButton("Sort Drugs by ID");
	JButton b3 = new JButton("Sort Drugs by Name");
	JButton b4 = new JButton("Sort Drugs by Quantity");
	JButton b5 = new JButton("Back");
    
    JTextArea t1 = new JTextArea();
    
    


    
    ListDrugs() {
		
        super("List Drugs");
        l1.setBounds (215, 10, 200, 20);
        
        b1.setBounds(100, 40, 300, 20);
        b1.addActionListener(this);
        
        b2.setBounds(100, 70, 300, 20);
        b2.addActionListener(this);
        
        b3.setBounds(100, 100, 300, 20);
        b3.addActionListener(this);
        
        b4.setBounds(100, 130, 300, 20);
        b4.addActionListener(this);
        
        t1.setBounds(10, 160, 510, 370);
        t1.setEditable(false);
        
        b5.setBounds(100, 570, 300, 20);
		b5.addActionListener(this);
       
        
        add(l1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(t1);
		add(b5);
        
        
        
        setSize(530,650);  
        setLayout(null);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }
    
    private void readFile (Vector V) {
        
        Scanner inFile = null;
        try {
			File inputFile = new File("Drugs.txt");			
			BufferedReader br1 = new BufferedReader(new FileReader(inputFile));          
            inFile = new Scanner(br1); 
			while (inFile.hasNextLine()) {
				
				String s = inFile.nextLine();
				
				String a = s.substring(0,19);
				String b = s.substring(20,39);
				String c = s.substring(40,44);
				String d = "         " + s.substring(45,54);
				String e = "         " + s.substring(55,66);
				String f = "         " + s.substring(67,87);
				
				Vector <String> line = new Vector<String>();
			 
				line.add(a);
				line.add(b);
				line.add(c);
				line.add(d);
				line.add(e);
				line.add(f);
			 
				V.add(line);

			}
			br1.close();
		}
		catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void listAll () {
        
        t1.setText(""); //to clear out the textarea
        
        Vector<Vector<String>> med = new Vector<Vector<String>>();
         
        readFile(med);
        //displaying meds on text area
        t1.append ("ID                   Name             Qty           Price             Date                     Manufacturer\n");
        
        for (int i=0; i<med.size(); i++) {
             for (int j=0; j<6; j++){
                 t1.append(med.get(i).get(j));
             }
            t1.append("\n");
         }
        
    }
    
    private void sortID () {
        
        t1.setText(""); //to clear out the textarea
        
        Vector<Vector<String>> med = new Vector<Vector<String>>();
         
        readFile(med);
        
        Collections.sort(med, new Comparator<Vector<String>>(){
            @Override  public int compare(Vector<String> v1, Vector<String> v2) {
                return v1.get(0).compareTo(v2.get(0)); //Compare at index 0 because ID is at index 0
        }});
        
        t1.append ("ID                   Name             Qty           Price             Date                     Manufacturer\n");
        
        for (int i=0; i<med.size(); i++) {
             for (int j=0; j<6; j++){
                 t1.append(med.get(i).get(j));
             }
            t1.append("\n");
         }
        
    }
    
    private void sortName () {
        
        t1.setText(""); //to clear out the textarea
        
        Vector<Vector<String>> med = new Vector<Vector<String>>();
         
        readFile(med);
        
        Collections.sort(med, new Comparator<Vector<String>>(){
            @Override  public int compare(Vector<String> v1, Vector<String> v2) {
                return v1.get(1).compareTo(v2.get(1)); //Compare at index 1 because Name is at index 1
        }});
        
        t1.append ("ID                   Name             Qty           Price             Date                     Manufacturer\n");
        
        for (int i=0; i<med.size(); i++) {
             for (int j=0; j<6; j++){
                 t1.append(med.get(i).get(j));
             }
            t1.append("\n");
         }
        
    }
    
    private void sortQty () {
        
        t1.setText(""); //to clear out the textarea
        
        Vector<Vector<String>> med = new Vector<Vector<String>>();
         
        readFile(med);
        
        Collections.sort(med, new Comparator<Vector<String>>(){
            @Override  public int compare(Vector<String> v1, Vector<String> v2) {
                return v1.get(2).compareTo(v2.get(2)); //Compare at index 2 because Quantity is at index 2
        }});
        
        t1.append ("ID                   Name             Qty           Price             Date                     Manufacturer\n");
        
        for (int i=0; i<med.size(); i++) {
             for (int j=0; j<6; j++){
                 t1.append(med.get(i).get(j));
             }
            t1.append("\n");
         }
        
    }
    
    public void actionPerformed (ActionEvent e) {
        if(e.getSource() == b1) {
            listAll();
        }
        if(e.getSource() == b2) {
            sortID();
        }
        if(e.getSource() == b3) {
            sortName();
        }
        if(e.getSource() == b4) {
            sortQty();
        }
		if(e.getSource() == b5) {
			new MainMenu().setVisible(true);
			setVisible(false);
		}
    }
    
    public static void main (String [] args) {
        
        
        new ListDrugs();
        
    }

}