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
import MasterData.mySQLQueries;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import MasterData.mySQLQueries;



public class BrandEntry extends JDialog {
	private JTextField txtName;
	private JButton btnClose;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BrandEntry dialog = new BrandEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private JLabel lblid;



	/**
	 * Create the dialog.
	 * @throws ClassNotFoundException 
	 */
	public BrandEntry() throws ClassNotFoundException {
		setTitle("Brand Entry");
		setBounds(100, 100, 380, 205);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);

		
	     getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Brand Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 347, 92);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Brand ID:");
		lblNewLabel.setBounds(20, 21, 85, 14);
		panel.add(lblNewLabel);
		
		JLabel lblBrandName = new JLabel("Brand  Name:");
		lblBrandName.setBounds(10, 56, 85, 14);
		panel.add(lblBrandName);
		
		txtName = new JTextField();
		txtName.setBounds(105, 53, 197, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		lblid = new JLabel("");
		lblid.setBounds(105, 21, 100, 14);
		panel.add(lblid);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st[] = new String[1];
		        if(Checking.IsNull(txtName.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "First you must enter valid Brand name.");
		            txtName.requestFocus();
		            txtName.selectAll();
		        }
		        else{
		            st[0] = (String)txtName.getText();
		            boolean ee = mySQLQueries.isduplicate("brand", st);
		            if(!ee)
		            {
		                JOptionPane.showMessageDialog(null, "Duplicate Record!");
		                txtName.requestFocus();
		                txtName.selectAll();
		            }
		            else
		            {
		                String []str = new String [2];
		                str[0]= lblid.getText();
		                str[1]=txtName.getText();
		                boolean save = mySQLQueries.insertData("brand", str);
		                if(save)
		                {
		                    JOptionPane.showMessageDialog(null, "Successfully saved record!","Save Record.",JOptionPane.INFORMATION_MESSAGE);
		                    try {
								AutoID();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                    txtName.setText("");
		                    txtName.requestFocus();
		                }
		                else
		                {
		                    JOptionPane.showMessageDialog(null, "Failed to save new record","Cannot Saved.",JOptionPane.INFORMATION_MESSAGE);
		                  
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
		btnSave.setBounds(20, 120, 89, 23);
		getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(134, 120, 89, 23);
		getContentPane().add(btnCancel);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(253, 120, 89, 23);
		getContentPane().add(btnClose);
		AutoID();
		
	}
	//mySQLQueries mysql=new mySQLQueries();

	public void AutoID() throws ClassNotFoundException
    {
        lblid.setText((String.valueOf(mySQLQueries.getAutoid("brandid", "brand", "BR-"))));
    }


    public void clear()
    {
    	txtName.setText("");
    	txtName.requestFocus();
    	
    }

}
