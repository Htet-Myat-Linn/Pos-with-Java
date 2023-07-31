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
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BrandUpdate extends JDialog {
	private JTextField txtbrandname;
	private JButton btnUpdate;
	private JButton btnCancel;
	private JButton btnClose;
	private JComboBox cbobrandid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BrandUpdate dialog = new BrandUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BrandUpdate() {
		setTitle("Brand Update");
		setBounds(100, 100, 332, 217);
		getContentPane().setLayout(null);
		
		
		 Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Brand Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 294, 117);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Brand ID:");
		lblNewLabel.setBounds(23, 25, 63, 14);
		panel.add(lblNewLabel);
		
		cbobrandid = new JComboBox();
		cbobrandid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBrand();
			}
		});
		cbobrandid.setBounds(84, 21, 156, 22);
		panel.add(cbobrandid);
		
		JLabel lblNewLabel_1 = new JLabel("Brand Name:");
		lblNewLabel_1.setBounds(10, 69, 76, 14);
		panel.add(lblNewLabel_1);
		
		txtbrandname = new JTextField();
		txtbrandname.setBounds(84, 66, 155, 20);
		panel.add(txtbrandname);
		txtbrandname.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		          if(cbobrandid.getSelectedIndex()==0)
		        {
		            JOptionPane.showMessageDialog(null,"Please choose Brand ID");
		            cbobrandid.requestFocus();
		        }
		        else if(Checking.IsNull(txtbrandname.getText()))
		        {
		            JOptionPane.showMessageDialog(null,"Please enter Brand name.");
		            txtbrandname.requestFocus();
		            txtbrandname.selectAll();
		        }

		         else
		         {
		            String st[]=new String[2];
		            st[0]=(String)txtbrandname.getText();
		            st[1]=(String)cbobrandid.getSelectedItem();
		            boolean br = mySQLQueries.isduplicate("brand", st);
		            if(!br)
		            {
		                JOptionPane.showMessageDialog(null,"Duplicate Record!");
		            }
		            else
		            {
		                String[]str=new String[1];
		                str[0]=txtbrandname.getText();

		                String id = cbobrandid.getSelectedItem().toString();
		                boolean save = mySQLQueries.updateRecord("brand", id, str);
		                if(save)
		                {
		                    JOptionPane.showMessageDialog(null,"Successfully updated record!","Updated Record.",JOptionPane.INFORMATION_MESSAGE);
		                    clear();
		                    cbobrandid.requestFocus();
		                }
		                else
		                {
		                    JOptionPane.showMessageDialog(null,"Failed to update the specified record","Cannot Update.",JOptionPane.INFORMATION_MESSAGE);
		                    clear();
		                    cbobrandid.requestFocus();

		                }
		                clear();
		                cbobrandid.requestFocus();
		            }
		         }

			}
		});
		btnUpdate.setBounds(10, 139, 89, 23);
		getContentPane().add(btnUpdate);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(116, 139, 89, 23);
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
		btnClose.setBounds(215, 139, 89, 23);
		getContentPane().add(btnClose);
		fillBrandID();
	}
	public void clear()
	{

	    txtbrandname.setText("");
	    cbobrandid.setSelectedIndex(0);

	}

    public void fillBrandID()
    {
    String str[]=mySQLQueries.getIDForChoice("brand");
    cbobrandid.addItem("-Selected-");
    for(int i=0 ; i<str.length ; i++)
        cbobrandid.addItem(str[i].toString());
    }
    
    public void showBrand()
	{
	    String result[]= mySQLQueries.getBrandData(cbobrandid.getSelectedItem().toString());
	    txtbrandname.setText(result[0]);
	    
	}
}
