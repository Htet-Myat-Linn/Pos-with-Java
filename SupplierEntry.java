package MasterData;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupplierEntry extends JDialog {
	private JLabel l;
	private JLabel lblSupplierName;
	private JTextField txtsupname;
	private JTextField txtadd;
	private JLabel lblPhoneNo;
	private JTextField txtph;
	private JTextField txtemail;
	private JLabel supid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SupplierEntry dialog = new SupplierEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws ClassNotFoundException 
	 */
	public SupplierEntry() throws ClassNotFoundException {
		setTitle("Supplier Entry");
		setBounds(100, 100, 368, 334);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
	     
	     
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Supplier Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 336, 239);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				l = new JLabel("Supplier ID:");
				l.setBounds(24, 29, 71, 14);
				panel.add(l);
			}
			{
				lblSupplierName = new JLabel("Supplier Name:");
				lblSupplierName.setBounds(10, 67, 95, 14);
				panel.add(lblSupplierName);
			}
			{
				JLabel lblAddress = new JLabel("Address:");
				lblAddress.setBounds(34, 111, 58, 14);
				panel.add(lblAddress);
			}
			{
				lblPhoneNo = new JLabel("Phone No:");
				lblPhoneNo.setBounds(24, 160, 71, 14);
				panel.add(lblPhoneNo);
			}
			{
				JLabel lblEmail = new JLabel("Email:");
				lblEmail.setBounds(48, 203, 46, 14);
				panel.add(lblEmail);
			}
			{
				txtsupname = new JTextField();
				txtsupname.setBounds(102, 64, 190, 20);
				panel.add(txtsupname);
				txtsupname.setColumns(10);
			}
			{
				txtadd = new JTextField();
				txtadd.setColumns(10);
				txtadd.setBounds(102, 108, 190, 20);
				panel.add(txtadd);
			}
			{
				txtph = new JTextField();
				txtph.setColumns(10);
				txtph.setBounds(102, 157, 190, 20);
				panel.add(txtph);
			}
			{
				txtemail = new JTextField();
				txtemail.setColumns(10);
				txtemail.setBounds(102, 200, 190, 20);
				panel.add(txtemail);
			}
			{
				supid = new JLabel("");
				supid.setBounds(105, 29, 125, 14);
				panel.add(supid);
			}
		}
		{
			JButton btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

			        if(!Checking.IsValidName(txtsupname.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter VALID Name.");
			            txtsupname.requestFocus();
			            txtsupname.selectAll();
			        }
			        else if(Checking.IsNull(txtadd.getText()))
			        {
			            JOptionPane.showMessageDialog(null,"Please enter Address.");;
			            txtadd.requestFocus();
			            txtadd.selectAll();
			        }
			        else if(Checking.IsNull(txtph.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Phone.");
			            txtph.requestFocus();
			            txtph.selectAll();
			        }
			        else if(!Checking.IsAllDigit(txtph.getText()))
			        {
			            JOptionPane.showMessageDialog(null,"Please enter valid Phone Number.");
			            txtph.requestFocus();
			            txtph.selectAll();
			        }
			         else if(Checking.IsNull(txtemail.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter Email.");
			            txtemail.requestFocus();
			            txtemail.selectAll();
			        }
			         else if(!Checking.IsEformat(txtemail.getText()))
			         {
			            JOptionPane.showMessageDialog(null, "Invalid Email Format.Please reenter!");
			            txtemail.requestFocus();
			            txtemail.selectAll();
			         }
			         else{
			        	 String st[] = new String[4];
							st[0] = (String)txtsupname.getText();
							st[1] = (String)txtadd.getText();
							st[2] = (String)txtph.getText();
							st[3] = (String)txtemail.getText();
							
							
				            boolean ee = mySQLQueries.isduplicate("supplier", st);
				            if(!ee)
				            {
				                JOptionPane.showMessageDialog(null, "Duplicate Record!");
				                txtsupname.requestFocus();
				                txtsupname.selectAll();
				            }
					        else
					        {
					            String str[]=new String[5];
					            str[0]=supid.getText();
					            str[1]=txtsupname.getText();
					            str[2]=txtadd.getText();
					            str[3]=txtph.getText();
					            str[4]=txtemail.getText();
					            boolean save = mySQLQueries.insertData("supplier", str);
					            if(save)
					            {
					                JOptionPane.showMessageDialog(null, "Successfully saved record!","Save Record.",JOptionPane.INFORMATION_MESSAGE);
					                try {
										AutoID();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					                clear();
					            }
					            else
					            {
					                JOptionPane.showMessageDialog(null,"Failed to save new record","Cannot Save",JOptionPane.INFORMATION_MESSAGE);
					                try {
										AutoID();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					            }
					        }
			         }
				}
			});
			btnSave.setBounds(20, 261, 89, 23);
			getContentPane().add(btnSave);
		}
		{
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear();
				}
			});
			btnCancel.setBounds(135, 261, 89, 23);
			getContentPane().add(btnCancel);
		}
		{
			JButton btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					{	
						dispose();
					}

				}
			});
			btnClose.setBounds(246, 261, 89, 23);
			getContentPane().add(btnClose);
		}
		AutoID();
	}

    public void AutoID() throws ClassNotFoundException
    {
    	 supid.setText((String.valueOf(mySQLQueries.getAutoid("supplierid", "supplier", "SU-"))));
    }

    public void clear()
    {
        txtsupname.setText("");
        txtadd.setText("");
        txtph.setText("");
        txtemail.setText("");
        txtsupname.requestFocus();
    }
    

}
