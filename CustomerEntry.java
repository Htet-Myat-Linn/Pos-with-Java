package MasterData;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerEntry extends JDialog {
	private JLabel lblcusid;
	private JTextField txtcusname;
	private JTextField txtaddress;
	private JTextField txtphone;
	private JTextField txtEmail;
	public JButton btnSave;
	private JButton btnclose;
	private JButton btnCancel;
	public int c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomerEntry dialog = new CustomerEntry();
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
	public CustomerEntry() throws ClassNotFoundException {
		setTitle("Customer Entry");
		setBounds(100, 100, 357, 319);
		getContentPane().setLayout(null);
		
		 Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Customer Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 325, 224);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer ID:");
		lblNewLabel.setBounds(20, 23, 81, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCusto = new JLabel("Customer Name:");
		lblCusto.setBounds(10, 62, 109, 14);
		panel.add(lblCusto);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setBounds(45, 103, 56, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblPhoneNp = new JLabel("Phone No:");
		lblPhoneNp.setBounds(40, 147, 79, 14);
		panel.add(lblPhoneNp);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(62, 186, 46, 14);
		panel.add(lblEmail);
		
		lblcusid = new JLabel("");
		lblcusid.setBounds(111, 23, 151, 14);
		panel.add(lblcusid);
		
		txtcusname = new JTextField();
		txtcusname.setBounds(111, 59, 167, 20);
		panel.add(txtcusname);
		txtcusname.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(111, 100, 169, 20);
		panel.add(txtaddress);
		
		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(111, 144, 169, 20);
		panel.add(txtphone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(113, 183, 167, 20);
		panel.add(txtEmail);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		         if(Checking.IsValidName(txtcusname.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter VALID Name.");
		            txtcusname.requestFocus();
		            txtcusname.selectAll();
		        }
		        else if(Checking.IsNull(txtaddress.getText()))
		        {
		            JOptionPane.showMessageDialog(null,"Please enter Address.");;
		            txtaddress.requestFocus();
		            txtaddress.selectAll();
		        }
		        else if(Checking.IsNull(txtphone.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter Phone.");
		            txtphone.requestFocus();
		            txtphone.selectAll();
		        }
		        else if(!Checking.IsAllDigit(txtphone.getText()))
		        {
		            JOptionPane.showMessageDialog(null,"Please enter valid Phone Number.");
		            txtphone.requestFocus();
		            txtphone.selectAll();
		        }
		         else if(Checking.IsNull(txtEmail.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter Email.");
		            txtEmail.requestFocus();
		            txtEmail.selectAll();
		        }
		         else if(!Checking.IsEformat(txtEmail.getText()))
		         {
		            JOptionPane.showMessageDialog(null, "Invalid Email Format.Please reenter!");
		            txtEmail.requestFocus();
		            txtEmail.selectAll();
		         }
		         
		         else{
		        	 String st[] = new String[4];
						st[0] = (String)txtcusname.getText();
						st[1] = (String)txtaddress.getText();
						st[2] = (String)txtphone.getText();
						st[3] = (String)txtEmail.getText();
						
						
			            boolean ee = mySQLQueries.isduplicate("customer", st);
			            if(!ee)
			            {
			                JOptionPane.showMessageDialog(null, "Duplicate Record!");
			                txtcusname.requestFocus();
			                txtcusname.selectAll();
			            }
			            else
						       {
					            String str[]=new String[5];
					            str[0]=lblcusid.getText();
					            str[1]=txtcusname.getText();
					            str[2]=txtaddress.getText();
					            str[3]=txtphone.getText();
					            str[4]=txtEmail.getText();
					            boolean save = mySQLQueries.insertData("customer", str);
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
		btnSave.setBounds(20, 246, 79, 23);
		getContentPane().add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(130, 246, 85, 23);
		getContentPane().add(btnCancel);
		
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
		AutoID();
	}
public void clear()
	    {
	        txtcusname.setText("");
	        txtaddress.setText("");
	        txtphone.setText("");
	        txtEmail.setText("");
	        txtcusname.requestFocus();
	    }

public void AutoID() throws ClassNotFoundException
	    {
	    	 lblcusid.setText((String.valueOf(mySQLQueries.getAutoid("customerid", "customer", "CU_"))));
	    }

}
