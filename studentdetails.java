import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class studentdetails extends DBCON implements ActionListener
{
	JFrame f1;
	JPanel p1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8, l9, l10;
	JLabel t1,t2,t3,t4, t5, t6,t7,t8,t9, t10, t11;
	JButton b1;
 
	studentdetails(String id)
	{
            f1=new JFrame("Student Details");
            p1=new JPanel();

            l1=new JLabel("Student Id");
            l2=new JLabel("Student Name");
            l3=new JLabel("Father's Name");
            l4=new JLabel("D.O.B.");
            l5=new JLabel("Gender");
            l6=new JLabel("Address");
            l7=new JLabel("Contact No.");
            l8=new JLabel("Course");
            l9=new JLabel("Total classes");
            l10=new JLabel("Class Attended");

            b1=new JButton("Logout");
`
            t9=new JLabel();
            t1=new JLabel();
            t2=new JLabel();
            t3=new JLabel();
            t4=new JLabel();
            t5=new JLabel();
            t6=new JLabel();
            t7=new JLabel();
            t8=new JLabel();
            t10=new JLabel();
            t11=new JLabel();

            f1.add(p1);
            p1.add(l1); p1.add(l2); p1.add(l3);
            p1.add(l4); p1.add(l5); p1.add(l6);
            p1.add(l7); p1.add(l8); p1.add(l9);
            p1.add(l10);

            p1.add(b1); 
            p1.add(t4); p1.add(t5); p1.add(t10);
            p1.add(t11); 
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
            t4.setBounds(250, 175,150,25);
            t5.setBounds(250, 225,150,25);
            t6.setBounds(250,275,150,25);
            t7.setBounds(250,325,150,25);
            t8.setBounds(250,375,150,25);
            t9.setBounds(250,425,150,25);
            t10.setBounds(250, 475,70,25);
            t11.setBounds(330, 475,70,25);

            t1.setText(id);

            int ip= Integer.parseInt(t1.getText());
            try
            {
                String viewquery = "Select * from studentreg inner join course on studentreg.course = course.course where sid ="+id;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(viewquery);

                if(rs.next())
                {
                    t2.setText(rs.getString(2));
                    t3.setText(rs.getString(3));
                    t4.setText(rs.getString(4));
                    t5.setText(rs.getString(5));
                    t6.setText(rs.getString(6));
                    t7.setText(rs.getString(7));
                    t8.setText(rs.getString(10));
                    t9.setText(rs.getString(13));
                    t10.setText(rs.getString(11));
                    if(rs.getString(13).equals("0"))
                    {
                        t11.setText("---");
                    }
                    else
                    {
                        float ca = Integer.parseInt(rs.getString(11));
                        int tc = Integer.parseInt(rs.getString(13));
                        ca = ca*100/tc;
                        t11.setText("" + ca + " %");
                    }
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(f1,"Data not found.."+e);
            }

            b1.setBounds(150,525,100,25);


            p1.setLayout(null);
            f1.setSize(450,600);
            f1.setVisible(true);
            f1.setLocationRelativeTo(null);
            p1.setLayout(null);
            f1.setResizable(false);

            b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
            if(ae.getSource()==b1)
            {
                f1.setVisible(false);
                new loginpage();
            }
	}
        
}