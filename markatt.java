import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class markatt extends DBCON implements ActionListener
{
	JFrame f1;
	JPanel p1;
	JLabel l1,l2;
	JComboBox cb0;
	JButton b1,b2, b3, b4;
        JCheckBox[] c;
        
	markatt()
	{
		f1=new JFrame("Mark Attendance");
		p1=new JPanel();
		l1=new JLabel("Course Name");
		l2=new JLabel("Students Enrolled:");
		
                cb0=new JComboBox();
                cb0.addItem("Btech");
                cb0.addItem("Mtech");
                
		b2=new JButton("Save");
		b1=new JButton("Fetch");
                b3=new JButton("Reset");
                b4=new JButton("Back");
		
		p1.add(cb0); p1.add(b1);
		p1.add(l1);p1.add(l2);p1.add(b2);
		f1.add(p1); p1.add(b3); p1.add(b4);
                
		f1.setSize(500,550);
		f1.setVisible(true);
		f1.setLocationRelativeTo(null);
		p1.setLayout(null);
		f1.setResizable(false);
		
		l1.setBounds(25,25,150,25);
		l2.setBounds(25,75,200,25);
		cb0.setBounds(225,25,150,25);
                
		b2.setBounds(75,475,100,25);
		b1.setBounds(380,25,75,25);
                b3.setBounds(200,475,100,25);
                b4.setBounds(325,475,100,25);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
                b4.addActionListener(this);
	}
        
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == b1)
		{
                    fetch();
		}
                else if(ae.getSource() == b2)
		{
                    save();
		}
                else if(ae.getSource() == b3)
		{
		    reset();
		}
                else if(ae.getSource() == b4)
		{
                    f1.setVisible(false);
                    new home();
		}
	}
        
        private void fetch()
        {
            try
            {
                if (c != null)
                {
                    for (JCheckBox j : c)
                    {
                        p1.remove(j);
                    }
                    p1.updateUI();
                }

                String cn = cb0.getSelectedItem().toString();
                String query = "Select count(*) from studentreg where course = '" + cn + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                int count = 0;
                if (rs.next())
                {
                    count = Integer.parseInt(rs.getString(1));
                }

                query = "Select sid from studentreg where course = '" + cn + "'";
                rs = stmt.executeQuery(query);

                int size = 100;
                int i = 0;
                c = new JCheckBox[count];

                while(rs.next())
                {
                    c[i] = new JCheckBox(rs.getString(1));
                    size += 25;
                    p1.add(c[i]);
                    c[i].setBounds(25, size, 150, 25);
                    i++;
                }

            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(f1, ""+e);
            }
        }
        
        private void save()
        {
            try
            {
                String cn = cb0.getSelectedItem().toString();
                String up = "update course set totalclasses = totalclasses + 1 where course = '" + cn + "'";
                PreparedStatement ps = con.prepareStatement(up);
                ps.executeUpdate();
                
                for (JCheckBox j : c)
                {
                    if (j.isSelected())
                    {
                        up = "update studentreg set classesattended = classesattended + 1 where sid = " + j.getText();
                        ps = con.prepareStatement(up);
                        ps.executeUpdate();
                    }
                }
                
                JOptionPane.showMessageDialog(f1, "Attendence saved...");
                
                if (c != null)
                {
                    for (JCheckBox j : c)
                    {
                        p1.remove(j);
                    }
                    p1.updateUI();
                }
                c = null;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(f1, ""+e);
            }
        }
        
        private void reset()
        {
            if (c != null)
            {
                for (JCheckBox j : c)
                {
                    j.setSelected(false);
                }
                p1.updateUI();
            }
        }
        
}