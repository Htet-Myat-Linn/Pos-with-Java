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
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TypeUpdate extends JDialog {
	private JTextField txttype;
	private JComboBox cbotypeid;
	private JButton btnUpdate;
	private JButton btnCancel;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TypeUpdate dialog = new TypeUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TypeUpdate() {
		setBounds(100, 100, 365, 213);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "Type Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 333, 111);
			
			Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
			 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
		     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
		     setLocation(centerX, centerY);
		     setResizable(false);
		     
			getContentPane().add(panel);
			{
				JLabel lblNewLabel = new JLabel("Type ID : ");
				lblNewLabel.setBounds(24, 28, 77, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Type Name : ");
				lblNewLabel_1.setBounds(22, 67, 79, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txttype = new JTextField();
				txttype.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				txttype.setColumns(10);
				txttype.setBounds(111, 64, 204, 20);
				panel.add(txttype);
			}
			{
				cbotypeid = new JComboBox();
				cbotypeid.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						showType();
					}
				});
				cbotypeid.setBounds(111, 24, 204, 22);
				panel.add(cbotypeid);
			}
		}
		{
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cbotypeid.getSelectedIndex()==0) {
			            JOptionPane.showMessageDialog(null,"Please choose Type ID");
			            cbotypeid.requestFocus();
			        } else if(Checking.IsNull(txttype.getText())) {
			            JOptionPane.showMessageDialog(null,"Please enter Type name.");
			            txttype.requestFocus();
			            txttype.selectAll();
			        }

			        else {
			            String st[]=new String[2];
			            st[0]=(String)txttype.getText();
			            st[1]=(String)cbotypeid.getSelectedItem();
			            boolean br = mySQLQueries.isduplicate("type", st);
			            if(!br) {
			                JOptionPane.showMessageDialog(null,"Duplicate Record!");
			            } else {
			                String[]str=new String[1];
			                str[0]=txttype.getText();

			                String id = cbotypeid.getSelectedItem().toString();
			               
			                boolean save = mySQLQueries.updateRecord("type", id, str);
			                if(save) {
			                    JOptionPane.showMessageDialog(null,"Successfully updated record!","Updated Record.",JOptionPane.INFORMATION_MESSAGE);
			                    clear();
			                    cbotypeid.requestFocus();
			                } else {
			                    JOptionPane.showMessageDialog(null,"Failed to update the specified record","Cannot Update.",JOptionPane.INFORMATION_MESSAGE);
			                    clear();
			                    cbotypeid.requestFocus();

			                }
			                clear();
			                txttype.requestFocus();
			            }
			        }

				}
			});
			btnUpdate.setBounds(20, 133, 83, 23);
			getContentPane().add(btnUpdate);
		}
		{
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clear();
				}
			});
			btnCancel.setBounds(134, 133, 83, 23);
			getContentPane().add(btnCancel);
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
			btnClose.setBounds(255, 133, 83, 23);
			getContentPane().add(btnClose);
		}
		fillTypeID();
	}
	public void fillTypeID()
    {
    String str[]=mySQLQueries.getIDForChoice("type");
    cbotypeid.addItem("-Selected-");
    for(int i=0 ; i<str.length ; i++)
        cbotypeid.addItem(str[i].toString());
    }
	public void showType()
	{
	    String result[]= mySQLQueries.getTypeData(cbotypeid.getSelectedItem().toString());
	    txttype.setText(result[0]);
	    
	}
	public void clear()
	{
	    txttype.setText("");
	    cbotypeid.setSelectedIndex(0);

	}


    

}
