import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class loginpage extends DBCON implements ActionListener
{
	JFrame f1;
	JPanel p1;
	JComboBox c;
	TextField t2, t3;
	JLabel l1, l2, l3;
	JButton b1, b2;


	loginpage()
	{
		f1 = new JFrame("Login Page");
		p1 = new JPanel();
		t3 = new TextField();
		t2 = new TextField();
		b1 = new JButton("Login");
		b2 = new JButton ("Reset");
		l1 = new JLabel ("UserId");
		l2 = new JLabel("Username");
		l3 = new JLabel ("Password");
		c = new JComboBox();
		
		f1.add(p1);
		p1.add(t3);
		p1.add(t2);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(b1);
		p1.add(b2);
		p1.add(c);
		
		c.addItem("Admin");
		c.addItem("Student");
		//c.addItem("Instructor");

		t2.setBounds(225, 125, 125, 25);
		t3.setBounds(225, 200, 125, 25);
		l1.setBounds(50, 50, 125, 25);
		l2.setBounds(50, 125, 125, 25);
		l3.setBounds(50, 200, 125, 25);
		b1.setBounds(75, 275, 100, 50);
		b2.setBounds(225, 275, 100, 50);
		c.setBounds(225, 50, 125, 25);

		t3.setEchoChar('#');
		

		p1.setLayout(null);
		f1.setVisible(true);
		f1.setSize(400, 400);
		f1.setLocationRelativeTo(null);

		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}

        @Override
	public void actionPerformed (ActionEvent ae)
	{
		String s1=c.getSelectedItem().toString();
		String s2=t2.getText();
		String s3=t3.getText();
		if(ae.getSource()==b1)
		{
			if(s1.equalsIgnoreCase("ADMiN")&&s2.equalsIgnoreCase("Admin")&&s3.equals("ADMIN"))
			{
				JOptionPane.showMessageDialog(f1,"Admin Login Success");
                                new home();
			}
			else if(s1.equalsIgnoreCase("student"))
                        {
                    
                            try
                            {
                                int id = Integer.parseInt(t2.getText());
                                String viewquery = "Select pw from studentreg where sid ="+id;
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery(viewquery);
                                
                                String str="";
                                
                                if(rs.next())
                                {
                                    str = rs.getString(1);
                                }
                                
                                if(str.equals(s3))
                                {
                                    new studentdetails(t2.getText());
                                    f1.setVisible(false);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(f1,"Student login Failed. Please enter correct userid and password");
                                }
                            }
                            catch(Exception e)
                            {
                                JOptionPane.showMessageDialog(f1,"Data not found.."+e);
                            }
		}
		if(ae.getSource()==b2)
		{
			t2.setText("");
			t3.setText("");
		}
			
	}

	public static void main(String[] args)
	{
		loginpage obj = new loginpage();
	}

}