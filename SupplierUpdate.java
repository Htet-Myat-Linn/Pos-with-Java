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
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupplierUpdate extends JDialog {
	private final JPanel panel = new JPanel();
	private JTextField txtname;
	private JTextField txtaddress;
	private JTextField txtphno;
	private JTextField txtemail;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClose;
	private JComboBox cbosupplierid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SupplierUpdate dialog = new SupplierUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SupplierUpdate() {
		setTitle("Supplier Update");
		setBounds(100, 100, 368, 347);
		getContentPane().setLayout(null);
		panel.setBounds(10, 11, 326, 238);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
	     
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Supplier Update Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		{
			JLabel l = new JLabel("Supplier ID:");
			l.setBounds(24, 29, 71, 14);
			panel.add(l);
		}
		{
			JLabel lblSupplierName = new JLabel("Supplier Name:");
			lblSupplierName.setBounds(10, 67, 95, 14);
			panel.add(lblSupplierName);
		}
		{
			JLabel lblAddress = new JLabel("Address:");
			lblAddress.setBounds(34, 111, 58, 14);
			panel.add(lblAddress);
		}
		{
			JLabel lblPhoneNo = new JLabel("Phone No:");
			lblPhoneNo.setBounds(24, 160, 71, 14);
			panel.add(lblPhoneNo);
		}
		{
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(48, 203, 46, 14);
			panel.add(lblEmail);
		}
		{
			txtname = new JTextField();
			txtname.setColumns(10);
			txtname.setBounds(102, 64, 190, 20);
			panel.add(txtname);
		}
		{
			txtaddress = new JTextField();
			txtaddress.setColumns(10);
			txtaddress.setBounds(102, 108, 190, 20);
			panel.add(txtaddress);
		}
		{
			txtphno = new JTextField();
			txtphno.setColumns(10);
			txtphno.setBounds(102, 157, 190, 20);
			panel.add(txtphno);
		}
		{
			txtemail = new JTextField();
			txtemail.setColumns(10);
			txtemail.setBounds(102, 200, 190, 20);
			panel.add(txtemail);
		}
		
		cbosupplierid = new JComboBox();
		cbosupplierid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbosupplierid.getSelectedIndex()<=0)
		        {
		            txtname.setText("");
		            txtaddress.setText("");
		            txtphno.setText("");
		            txtemail.setText("");
		        }
		        else
		        {
		            showSupplier();
		        }

			}
		});
		cbosupplierid.setBounds(105, 25, 187, 22);
		panel.add(cbosupplierid);
		{
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbosupplierid.getSelectedIndex()==0)
			        {
			            JOptionPane.showMessageDialog(null, "Please choose supplier id.");
			            cbosupplierid.requestFocus();
			        }
			        else if(Checking.IsValidName(txtname.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Name.");
			            txtname.requestFocus();
			            txtname.selectAll();
			        }
			        else if(Checking.IsNull(txtaddress.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Address.");
			            txtaddress.requestFocus();
			            txtaddress.selectAll();
			        }
			          else if(Checking.IsNull(txtphno.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Phone.");
			            txtphno.requestFocus();
			            txtphno.selectAll();
			        }
			        else if(!Checking.IsAllDigit(txtphno.getText().trim()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter valid Phone Number.");
			            txtphno.requestFocus();
			            txtphno.selectAll();
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
							st[2] = (String)txtphno.getText();
							st[3] = (String)txtemail.getText();
							
							
				            boolean ee = mySQLQueries.isduplicate("supplier", st);
				            if(!ee)
				            {
				                JOptionPane.showMessageDialog(null, "Duplicate Record!");
				                txtname.requestFocus();
				                txtname.selectAll();
				            }
					        else
					        {
					          if(JOptionPane.showConfirmDialog(null, "Are you Sure Update?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					          {
					              String []str = new String[4];
					              String id = cbosupplierid.getSelectedItem().toString();
					              str[0]=txtname.getText();
					              str[1]=txtaddress.getText();
					              str[2]=txtphno.getText();
					              str[3]=txtemail.getText();
					              boolean save = mySQLQueries.updateRecord("supplier", id, str);
					              if(save)
					              {
					                  JOptionPane.showMessageDialog(null, "Successfully update record!","Update Record.",JOptionPane.INFORMATION_MESSAGE);
					              }
					          }
			        }
			        }
				}
			});
			btnUpdate.setBounds(20, 260, 89, 23);
			getContentPane().add(btnUpdate);
		}
		{
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
	                    String id = cbosupplierid.getSelectedItem().toString();
	                    if(JOptionPane.showConfirmDialog(null, "Are you Sure Delete?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
	                    {
	                    	mySQLQueries.deleteRecord("supplier", id);
	                    	fillSupplier();
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
			btnDelete.setBounds(135, 260, 89, 23);
			getContentPane().add(btnDelete);
		}
		{
			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					{	
						dispose();
					}
				}
			});
			btnClose.setBounds(246, 260, 89, 23);
			getContentPane().add(btnClose);
		}
		fillSupplier();
		clear();
	}
	public void showSupplier()
	{
	    String result[]= mySQLQueries.getSupplierData(cbosupplierid.getSelectedItem().toString());
	    txtname.setText(result[0]);
	    txtaddress.setText(result[1]);
	    txtphno.setText(result[2]);
	    txtemail.setText(result[3]);
	}
	public void fillSupplier()
    {
        cbosupplierid.removeAllItems();
        cbosupplierid.addItem("-Selected-");
        String str[]=mySQLQueries.getIDForChoice("supplier");
        for(int i = 0 ; i<str.length ; i++)
            cbosupplierid.addItem(str[i].toString());
        cbosupplierid.setSelectedIndex(0);
    }

    public void clear()
    {
        txtname.setText("");
        txtaddress.setText("");
        txtphno.setText("");
        txtemail.setText("");
        cbosupplierid.requestFocus();
        cbosupplierid.setSelectedIndex(0);
    }



}
