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

public class TypeEntry extends JDialog {
	private JTextField txtname;
	private JLabel lbltid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TypeEntry dialog = new TypeEntry();
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
	public TypeEntry() throws ClassNotFoundException {
		setTitle("Type Entry");
		setBounds(100, 100, 387, 205);
		getContentPane().setLayout(null);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
	     
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Type Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 11, 333, 111);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type ID : ");
		lblNewLabel.setBounds(24, 28, 77, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type Name : ");
		lblNewLabel_1.setBounds(22, 67, 79, 14);
		panel.add(lblNewLabel_1);
		
		lbltid = new JLabel("");
		lbltid.setBounds(111, 28, 132, 14);
		panel.add(lbltid);
		
		txtname = new JTextField();
		txtname.setBounds(111, 64, 204, 20);
		panel.add(txtname);
		txtname.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st[] = new String[1];
		        if(Checking.IsNull(txtname.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "First you must enter valid Brand name.");
		            txtname.requestFocus();
		            txtname.selectAll();
		        }
		        else{
		            st[0] = (String)txtname.getText();
		            boolean ee = mySQLQueries.isduplicate("type", st);
		            if(!ee)
		            {
		                JOptionPane.showMessageDialog(null, "Duplicate Record!");
		                txtname.requestFocus();
		                txtname.selectAll();
		            }
		            else
		            {
		                String []str = new String [2];
		                str[0]= lbltid.getText();
		                str[1]=txtname.getText();
		                
		                boolean save = mySQLQueries.insertData("type", str);
		                if(save)
		                {
		                    JOptionPane.showMessageDialog(null, "Successfully saved record!","Save Record.",JOptionPane.INFORMATION_MESSAGE);
		                    try {
								AutoID();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                    txtname.setText("");
		                    txtname.requestFocus();
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
		btnNewButton.setBounds(30, 133, 83, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(144, 133, 83, 23);
		getContentPane().add(btnCancel);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(265, 133, 83, 23);
		getContentPane().add(btnClose);
		AutoID();
		
	}
	public void AutoID() throws ClassNotFoundException
    {
        lbltid.setText((String.valueOf(mySQLQueries.getAutoid("typeid", "type", "TY-"))));
    }
	public void clear()
    {
    	txtname.setText("");
    	txtname.requestFocus();
    }


}
