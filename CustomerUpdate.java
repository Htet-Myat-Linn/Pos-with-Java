package MasterData;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerUpdate extends JDialog {
	private JTextField txtname;
	private JTextField txtaddress;
	private JTextField txtphone;
	private JTextField txtemail;
	private JComboBox cbocustomerid;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnclose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomerUpdate dialog = new CustomerUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomerUpdate() {
		setTitle("Customer Update");
		setBounds(100, 100, 360, 324);
		getContentPane().setLayout(null);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
	     
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Update Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 325, 224);
			getContentPane().add(panel);
			{
				JLabel lblNewLabel = new JLabel("Customer ID:");
				lblNewLabel.setBounds(20, 23, 81, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblCusto = new JLabel("Customer Name:");
				lblCusto.setBounds(10, 62, 109, 14);
				panel.add(lblCusto);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Address:");
				lblNewLabel_2.setBounds(45, 103, 56, 14);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblPhoneNp = new JLabel("Phone No:");
				lblPhoneNp.setBounds(40, 147, 79, 14);
				panel.add(lblPhoneNp);
			}
			{
				JLabel lblEmail = new JLabel("Email:");
				lblEmail.setBounds(62, 186, 46, 14);
				panel.add(lblEmail);
			}
			{
				txtname = new JTextField();
				txtname.setColumns(10);
				txtname.setBounds(111, 59, 167, 20);
				panel.add(txtname);
			}
			{
				txtaddress = new JTextField();
				txtaddress.setColumns(10);
				txtaddress.setBounds(111, 100, 169, 20);
				panel.add(txtaddress);
			}
			{
				txtphone = new JTextField();
				txtphone.setColumns(10);
				txtphone.setBounds(111, 144, 169, 20);
				panel.add(txtphone);
			}
			{
				txtemail = new JTextField();
				txtemail.setColumns(10);
				txtemail.setBounds(113, 183, 167, 20);
				panel.add(txtemail);
			}
			{
				cbocustomerid = new JComboBox();
				cbocustomerid.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(cbocustomerid.getSelectedIndex()<=0)
						{
							txtname.setText("");
					        txtaddress.setText("");
					        txtphone.setText("");
					        txtemail.setText("");
						}
						else
						{
							showCustomer();
						}
							
						
						
					}
				});
				cbocustomerid.setBounds(111, 19, 167, 22);
				panel.add(cbocustomerid);
			}
		}
		{
			btnclose = new JButton("Close");
			btnclose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					{	
						dispose();
					}
				}
			});
			btnclose.setBounds(246, 246, 85, 23);
			getContentPane().add(btnclose);
		}
		{
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
	                    String id = cbocustomerid.getSelectedItem().toString();
	                    if(JOptionPane.showConfirmDialog(null, "Are you Sure Delete?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
	                    {
	                    	mySQLQueries.deleteRecord("customer", id);
	                    	//remove all item
	                    	fillCustomer();
	                    }
	                    else
	                    {
	                    	JOptionPane.showMessageDialog(null, "Fail to delete record","Cannot Update",JOptionPane.INFORMATION_MESSAGE);
	                    }
	                } catch(Exception sqle) {
	                    sqle.printStackTrace();
	                }

				}
			});
			btnDelete.setBounds(130, 246, 85, 23);
			getContentPane().add(btnDelete);
		}
		{
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

			        if(cbocustomerid.getSelectedIndex()==0) 
			        {
			            JOptionPane.showMessageDialog(null, "Please choose customer id.");
			            cbocustomerid.requestFocus();
			        } else if(Checking.IsValidName(txtname.getText())) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Name.");
			            txtname.requestFocus();
			            txtname.selectAll();
			        } else if(Checking.IsNull(txtaddress.getText())) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Address.");
			            txtaddress.requestFocus();
			            txtaddress.selectAll();
			        } else if(Checking.IsNull(txtphone.getText())) {
			            JOptionPane.showMessageDialog(null, "Please enter Phone.");
			            txtphone.requestFocus();
			            txtphone.selectAll();
			        }
			        else if(!Checking.IsAllDigit(txtphone.getText().trim())) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Phone Number.");
			            txtphone.requestFocus();
			            txtphone.selectAll();
			        } 
			        else if(Checking.IsNull(txtemail.getText())) 
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Email.");
			            txtemail.requestFocus();
			            txtemail.selectAll();
			        }
			        else{
			        	 String st[] = new String[4];
							st[0] = (String)txtname.getText();
							st[1] = (String)txtaddress.getText();
							st[2] = (String)txtphone.getText();
							st[3] = (String)txtemail.getText();
							
							
				            boolean ee = mySQLQueries.isduplicate("customer", st);
				            if(!ee)
				            {
				                JOptionPane.showMessageDialog(null, "Duplicate Record!");
				                txtname.requestFocus();
				                txtname.selectAll();
				            }
				            else {
						            if(JOptionPane.showConfirmDialog(null, "Are you Sure Update?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) 
						            {
						                String []str = new String[4];
						                String id = cbocustomerid.getSelectedItem().toString();
						                str[0]=txtname.getText();
						                str[1]=txtaddress.getText();
						                str[2]=txtphone.getText();
						                str[3]=txtemail.getText();
						                boolean save = mySQLQueries.updateRecord("customer", id, str);
						                if(save) 
						                {
						                    JOptionPane.showMessageDialog(null, "Successfully update record!","Update Record.",JOptionPane.INFORMATION_MESSAGE);
						                    clear();
						                }
						                else
						                {
						                	JOptionPane.showMessageDialog(null, "Fail to update record","Cannot Update",JOptionPane.INFORMATION_MESSAGE);
						                }
						            }
				            }
			        }
				}
			});
			btnUpdate.setBounds(20, 246, 79, 23);
			getContentPane().add(btnUpdate);
		}
		fillCustomer();
	}

    public void fillCustomer()
   {
       cbocustomerid.removeAllItems();
       cbocustomerid.addItem("-Selected-");
       String str[]=mySQLQueries.getIDForChoice("customer");
       for(int i = 0 ; i<str.length ; i++)
    	   cbocustomerid.addItem(str[i].toString());
       cbocustomerid.setSelectedIndex(0);
   }
    public void showCustomer()
    {
        String result[]= mySQLQueries.getCustomerData(cbocustomerid.getSelectedItem().toString());
        txtname.setText(result[0]);
        txtaddress.setText(result[1]);
        txtphone.setText(result[2]);
        txtemail.setText(result[3]);
    }
    public void clear()
    {
        txtname.setText("");
        txtaddress.setText("");
        txtphone.setText("");
        txtemail.setText("");
        cbocustomerid.requestFocus();
        cbocustomerid.setSelectedIndex(0);
    }




}
