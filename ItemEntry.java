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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemEntry extends JDialog {
	private JLabel lblitemid;
	private JComboBox cbomerid;
	private JLabel lblbrandname;
	private JLabel lbltypename;
	private JTextField txtitemname;
	private JTextField txtremark;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ItemEntry dialog = new ItemEntry();
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
	public ItemEntry() throws ClassNotFoundException {
		setTitle("Item Entry");
		setBounds(100, 100, 354, 401);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
	     
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Item Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 317, 300);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Item ID:");
				lblNewLabel.setBounds(29, 31, 46, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblMerchandiseId = new JLabel("Merchandise ID:");
				lblMerchandiseId.setBounds(10, 80, 94, 14);
				panel.add(lblMerchandiseId);
			}
			{
				JLabel lblBrandName = new JLabel("Brand Name:");
				lblBrandName.setBounds(29, 129, 85, 14);
				panel.add(lblBrandName);
			}
			{
				JLabel lblTypeName = new JLabel("Type Name:");
				lblTypeName.setBounds(29, 168, 68, 14);
				panel.add(lblTypeName);
			}
			{
				JLabel lblItemName = new JLabel("Item Name:");
				lblItemName.setBounds(28, 210, 76, 14);
				panel.add(lblItemName);
			}
			{
				lblitemid = new JLabel("");
				lblitemid.setBounds(91, 31, 187, 14);
				panel.add(lblitemid);
			}
			
			cbomerid = new JComboBox();
			cbomerid.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showBrandType();
				}
			});
			cbomerid.setBounds(107, 76, 171, 22);
			panel.add(cbomerid);
			
			lblbrandname = new JLabel("");
			lblbrandname.setBounds(107, 129, 171, 14);
			panel.add(lblbrandname);
			
			lbltypename = new JLabel("");
			lbltypename.setBounds(103, 168, 171, 14);
			panel.add(lbltypename);
			
			txtitemname = new JTextField();
			txtitemname.setBounds(103, 207, 175, 20);
			panel.add(txtitemname);
			txtitemname.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Remark:");
			lblNewLabel_1.setBounds(39, 257, 65, 14);
			panel.add(lblNewLabel_1);
			
			txtremark = new JTextField();
			txtremark.setColumns(10);
			txtremark.setBounds(103, 254, 175, 20);
			panel.add(txtremark);
		}
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        if(cbomerid.getSelectedIndex()==0)
		        {
		            JOptionPane.showMessageDialog(null, "Please choose Merchandise ID");
		            cbomerid.requestFocus();
		        }
		        else if(Checking.IsNull(txtitemname.getText()))
		        {
		            JOptionPane.showMessageDialog(null,"Please enter Item name.");
		            txtitemname.requestFocus();
		            txtitemname.selectAll();
		        }
		        
		        else if(!Checking.IsLetter(txtremark.getText()))
		        {
		            JOptionPane.showMessageDialog(null,"Please enter Remark.");
		            txtremark.requestFocus();
		            txtremark.selectAll();
		        }
		        else
		        {
		            String st[]=new String[2];
		            st[0]=(String)txtitemname.getText();
		            st[1]=(String)cbomerid.getSelectedItem();
		            boolean br = mySQLQueries.isduplicate("itemdetail", st);
		            if(!br)
		            {
		                JOptionPane.showMessageDialog(null, "Duplicate Record!");
		            }
		            else
		            {
		                String str[]=new String[4];
		                str[0]=lblitemid.getText();
		                str[1]=(String)cbomerid.getSelectedItem();
		                str[2]=txtitemname.getText();
		                str[3]=txtremark.getText();
		                
		                
		                
		                boolean save = mySQLQueries.insertData("itemdetail", str);
		                if(save)
		                {
		                    JOptionPane.showMessageDialog(null,"Successfully saved record!","Saved Record.",JOptionPane.INFORMATION_MESSAGE);
		                }
		                else
		                {
		                    JOptionPane.showMessageDialog(null,"Failed to save new record","Cannot Saved.",JOptionPane.INFORMATION_MESSAGE);
		                }
		         }
		                 try {
							AutoID();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                 clear();
		                 cbomerid.requestFocus();
		        }
			}
		});
		btnSave.setBounds(10, 322, 89, 30);
		getContentPane().add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(123, 322, 89, 30);
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
		btnClose.setBounds(238, 322, 89, 30);
		getContentPane().add(btnClose);
		fillMerchandise();
		AutoID();
		clear();
	}

    public void clear()
    {
        lblbrandname.setText("");
        lbltypename.setText("");
        txtitemname.setText("");
        txtremark.setText("");
        cbomerid.setSelectedIndex(0);
    }

    public void fillMerchandise()
    {
        String str[]=mySQLQueries.getIDForChoice("merchandise");
        cbomerid.addItem("-Selected-");
        for(int i=0 ; i<str.length ; i++)
           cbomerid.addItem(str[i].toString());
    }

    public void showBrandType()
    {
        if(cbomerid.getSelectedIndex()==0)
        {
            lblbrandname.setText("");
            lbltypename.setText("");
        }
        else{
            String result[]=mySQLQueries.getMerchandise(cbomerid.getSelectedItem().toString());
            String brandname = mySQLQueries.getBrandName((String)result[0]);
            lblbrandname.setText(brandname);
            String typename = mySQLQueries.getTypeName((String)result[1]);
            lbltypename.setText(typename);
            txtitemname.requestFocus();

        }
    }

    public void AutoID() throws ClassNotFoundException
    {
        lblitemid.setText((String.valueOf(mySQLQueries.getAutoid("itemid","itemdetail","IT_"))));
    }




}
