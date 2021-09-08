import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class stdreg extends DBCON implements ActionListener
{
	JFrame f1;
	JPanel p1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8, l9, l10;
	JTextField t1,t2,t3,t6,t7;
        TextField t8,t9;
	JComboBox c41, c42, c43, c5, c10;
	JButton b3,b1,b2;
 
	stdreg()
	{
		f1=new JFrame("Student Registration");
		p1=new JPanel();

		l1=new JLabel("Student Id");
		l2=new JLabel("Student Name");
		l3=new JLabel("Father's Name");
		l4=new JLabel("D.O.B.");
		l5=new JLabel("Gender");
		l6=new JLabel("Address");
		l7=new JLabel("Contact No.");
		l8=new JLabel("Password");
		l9=new JLabel("Confirm Pwrd");
		l10=new JLabel("Course");

		b3=new JButton("Back");
		b1=new JButton("Save");
		b2=new JButton("Reset");

		String str[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		c41=new JComboBox();
		c42=new JComboBox(str);
		c43=new JComboBox();
		c5=new JComboBox();
		c10=new JComboBox();

		c10.addItem("Btech");
		c10.addItem("Mtech");
		c10.addItem("Msc");

		c5.addItem("Male");
		c5.addItem("Female");
		
		for(int i=1; i<32; i++)
		{
			c41.addItem(i);
		}

		for(int i=1980; i<2010; i++)
		{
			c43.addItem(i);
		}

		t9=new TextField();
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t6=new JTextField();
		t7=new JTextField();
		t8=new TextField();

		f1.add(p1);
		p1.add(l1); p1.add(l2); p1.add(l3);
		p1.add(l4); p1.add(l5); p1.add(l6);
		p1.add(l7); p1.add(l8); p1.add(l9);
		p1.add(l10);
		
		p1.add(b3); p1.add(b1); p1.add(b2);
		p1.add(c41); p1.add(c42); p1.add(c43);
		p1.add(c5); p1.add(c10);

		p1.add(t9); p1.add(t1); p1.add(t2);p1.add(t3);
		p1.add(t6); p1.add(t7); p1.add(t8);


		l1.setBounds(50, 25,150,25);
		l2.setBounds(50, 75,150,25);
		l3.setBounds(50,125,150,25);
		l4.setBounds(50,175,150,25);
		l5.setBounds(50,225,150,25);
		l6.setBounds(50,275,150,25);
		l7.setBounds(50,325,150,25);
		l8.setBounds(50,375,150,25);
		l9.setBounds(50,425,150,25);
		l10.setBounds(50,475,150,25);

		t1.setBounds(250,25,150,25);
		t2.setBounds(250,75,150,25);
		t3.setBounds(250,125,150,25);
		t6.setBounds(250,275,150,25);
		t7.setBounds(250,325,150,25);
		t8.setBounds(250,375,150,25);
		t9.setBounds(250,425,150,25);

		b3.setBounds(275,525,100,25);
		b1.setBounds(75,525,100,25);
		b2.setBounds(175,525,100,25);
		
		c41.setBounds(250, 175,50,25);
		c42.setBounds(300, 175,50,25);
		c43.setBounds(350, 175,50,25);
		c5.setBounds(250, 225,150,25);
		c10.setBounds(250, 475,150,25);

		
		t8.setEchoChar('*');
		t9.setEchoChar('*');	
	
		p1.setLayout(null);
		f1.setSize(450,625);
		f1.setVisible(true);
		f1.setLocationRelativeTo(null);
		p1.setLayout(null);
		f1.setResizable(false);

		b3.addActionListener(this);	
		b1.addActionListener(this);
		b2.addActionListener(this);
		

	}
        private void save()
        {
                    String s1=t8.getText();
                    String s2=t9.getText();
                    
                    if(s2.equals(s1))
                    {
                        String insertquery="insert into studentreg values(?,?,?,?,?,?,?,?,?,?,0);";
                        try
                        {
                            PreparedStatement pst=con.prepareStatement(insertquery);
                            pst.setInt(1,Integer.parseInt(t1.getText()));
                            pst.setString(2,t2.getText());
                            pst.setString(3,t3.getText());
                            
                            String dob=c41.getSelectedItem().toString()+c42.getSelectedItem().toString()+c43.getSelectedItem().toString();
                            pst.setString(4,dob);
                            pst.setString(5,c5.getSelectedItem().toString());
                            
                            pst.setString(6,t6.getText());
                            pst.setString(7,t7.getText());
                            pst.setString(8,t8.getText());
                            pst.setString(9,t9.getText());
                            pst.setString(10,c10.getSelectedItem().toString());
                            
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(f1,"Data Inserted.");
                            reset();
                            
                        
                        }
                        catch(Exception e)
                        {
                            JOptionPane.showMessageDialog(f1,"Data not inserted.");
                        }
                        
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(f1,"Password field donot match with confirm password field.");
                    }
        }
        public void reset()
        {
            t1.setText("");t2.setText("");
            t3.setText("");t6.setText("");
            t7.setText("");t8.setText("");
            t9.setText("");
        }
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
                    
			save();	
		}
		if(ae.getSource()==b2)
		{
                    reset();
			
		}
		if(ae.getSource()==b3)
		{
			f1.setVisible(false);
                        new home();
		}
	}
	
}