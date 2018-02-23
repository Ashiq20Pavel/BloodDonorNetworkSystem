import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class Verification extends JFrame implements ActionListener
{
		JLabel l1 = new JLabel("Your User Name: ");
		JTextField f1 = new JTextField();
		JButton b1 = new JButton("Go");
		
		String u;
		
		public Verification(String u)
		{
			setSize(700,730);
			setBackground(Color.red);
			this.setContentPane(new JLabel(new ImageIcon("Blood3.jpg")));
			setVisible(true);
			setLocationRelativeTo(null);
			setResizable(false);
			this.setTitle("Verification");
			
			add(l1);
			l1.setBounds(100,90,150,30);
			l1.setForeground(new Color(253,254,254));
			
			add(f1);
			f1.setBounds(100,150,230,28);
		    f1.setBackground(Color.lightGray);
		    
		    b1.setBounds(230,200,100,30);
			b1.setBackground(new Color(253,254,254));
			add(b1);
			
			b1.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent a){
			
			this.u=u;
			
			if(a.getSource()==b1)
			{
				u = f1.getText();
				
				if(u.length()==0)
				{
					JOptionPane.showMessageDialog(null,"Empty Field!");
				}
				
				else
				{
					try
					{
						String query ="Select * from blood2 where User_Name = "+"'"+u+"'";
						Connection c = DatabaseConnection.dbConnector();
						Statement st = c.createStatement();
						ResultSet r = st.executeQuery(query);

						int count =0;
						while(r.next())
							{
								count=count+1;
							}
						if(count>=1)
							{
								System.out.println(u+" ");
								JOptionPane.showMessageDialog(null,"User Name Matched!");
								NewPass np = new NewPass(null);
								
								dispose();
								
							}
						else
							{
								System.out.println(u+" ");
								JOptionPane.showMessageDialog(null,"The User Name is incorrect!");
							}
						
						r.close();
					}
						
						catch(Exception e)
							{
								JOptionPane.showMessageDialog(null,e);
								System.out.println("E2");
							}
					}
				}
				
			}
		}


