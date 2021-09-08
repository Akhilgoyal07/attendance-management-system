import javax.swing.*;
import java.awt.event.*;
class home implements ActionListener
{
	JFrame f1;
	JPanel p1;
	JMenuBar mb1;
	JMenu m1,m2,m3,m21;
	JMenuItem m11,m211,m212,m213,m31,m32,m33,m34;
        JButton b1;
	home()
	{
		f1=new JFrame("Form");
		p1=new JPanel();
		mb1=new JMenuBar();
		m1=new JMenu("About");
		//m2=new JMenu("Staff");
		m21=new JMenu("Instructor");
		m3=new JMenu("Student");
                b1=new JButton("Logout");
		
		m11=new JMenuItem("Details");
		m211=new JMenuItem("Register");
		m212=new JMenuItem("View");
		m213=new JMenuItem("Delete");
		m31=new JMenuItem("Register");
		m32=new JMenuItem("View");
		m33=new JMenuItem("Delete");
		m34=new JMenuItem("Attendance");

		f1.setVisible(true);
		f1.setSize(1000,600);
		f1.setLocationRelativeTo(null);
		f1.add(p1);
		p1.setLayout(null);
		f1.setResizable(false);
                p1.add(b1);
                b1.setBounds(900,10,75,25);

		f1.setJMenuBar(mb1);
		mb1.add(m1);	
		//mb1.add(m2);
		mb1.add(m3);
		/*m2.add(m21);
		m21.add(m211);
		m21.add(m212);
		m21.add(m213);*/
		m3.add(m31);
		m3.add(m32);
		//m3.add(m33);
		m3.add(m34);
		m1.add(m11);
		
		m11.addActionListener(this);
		//m211.addActionListener(this);
		//m212.addActionListener(this);
		//m213.addActionListener(this);
		m31.addActionListener(this);
		m32.addActionListener(this);
		//m33.addActionListener(this);
		m34.addActionListener(this);
                b1.addActionListener(this);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==m11)
		{
			JOptionPane.showMessageDialog(f1,"About page working");
		}
		/*else if(ae.getSource()==m211)
		{
			JOptionPane.showMessageDialog(f1,"Instructor Register working");
			
		}
		else if(ae.getSource()==m212)
		{
			JOptionPane.showMessageDialog(f1,"Instructor View working");
			
		}
		else if(ae.getSource()==m213)
		{
			JOptionPane.showMessageDialog(f1,"Instructor delete working");
		}*/
		else if(ae.getSource()==m31)
		{
			//JOptionPane.showMessageDialog(f1,"Student register working");
                         f1.setVisible(false);
			new stdreg();
		}
		else if(ae.getSource()==m32)
		{
			//JOptionPane.showMessageDialog(f1,"Student view working");
			new studentviewpage();
		}
		/*else if(ae.getSource()==m33)
		{
			JOptionPane.showMessageDialog(f1,"Student Delete working");
			//new studentviewpage();
		}*/
		if(ae.getSource()==m34)
		{
			//JOptionPane.showMessageDialog(f1,"Student attendace working");
                    f1.setVisible(false);
                    new markatt();
		}
                if(ae.getSource()==b1)
                {
                    f1.setVisible(false);
                    new loginpage();
                }

	}
	
}