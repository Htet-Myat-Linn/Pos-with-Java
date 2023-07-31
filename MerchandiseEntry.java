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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MerchandiseEntry extends JDialog {
	private JLabel lblmerid;
	private JLabel lblbrandname;
	private JComboBox cbotypeid;
	private JLabel lbltype;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnClose;
	private JComboBox cbobrandid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MerchandiseEntry dialog = new MerchandiseEntry();
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
	public MerchandiseEntry() throws ClassNotFoundException {
		setTitle("Merchandise Entry");
		setBounds(100, 100, 348, 335);
		getContentPane().setLayout(null);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Merchandise Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 310, 239);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Merchandise ID:");
		lblNewLabel.setBounds(10, 26, 91, 14);
		panel.add(lblNewLabel);
		
		JLabel lblBrandId = new JLabel("Brand ID:");
		lblBrandId.setBounds(40, 68, 59, 14);
		panel.add(lblBrandId);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setBounds(55, 112, 65, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type ID:");
		lblNewLabel_3.setBounds(48, 148, 53, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Type:");
		lblNewLabel_4.setBounds(65, 188, 45, 14);
		panel.add(lblNewLabel_4);
		
		lbltype = new JLabel("");
		lbltype.setBounds(120, 188, 144, 14);
		panel.add(lbltype);
		
		lblmerid = new JLabel("");
		lblmerid.setBounds(111, 26, 124, 14);
		panel.add(lblmerid);
		
		cbobrandid = new JComboBox();
		cbobrandid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBrand();
			}
		});
		cbobrandid.setBounds(112, 64, 152, 22);
		panel.add(cbobrandid);
		
		lblbrandname = new JLabel("");
		lblbrandname.setBounds(111, 104, 153, 22);
		panel.add(lblbrandname);
		
		cbotypeid = new JComboBox();
		cbotypeid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showType();
			}
		});
		cbotypeid.setBounds(114, 144, 152, 22);
		panel.add(cbotypeid);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        if(cbobrandid.getSelectedIndex()==0)
		            JOptionPane.showMessageDialog(null,"Please choose brand id!");
		        else if(cbotypeid.getSelectedIndex()==0)
		            JOptionPane.showMessageDialog(null,"Please choose type id!");
		        else
		        {
		            String st[]=new String[2];
		            st[0]=(String)cbobrandid.getSelectedItem();
		            st[1]=(String)cbotypeid.getSelectedItem();
		            boolean br=(mySQLQueries.isduplicate("merchandise",st));
		            if(!br)
		                JOptionPane.showMessageDialog(null,"Duplicate Record!");
		            else
		            {
		                String[] str=new String[3];
		                str[2]=(String)cbotypeid.getSelectedItem();
		                str[1]=(String)cbobrandid.getSelectedItem();
		                str[0]=lblmerid.getText();
		                boolean save=(mySQLQueries.insertData("merchandise",str));
		                if(save)
		                    JOptionPane.showMessageDialog(null,"Successfully save record!","Save Record",JOptionPane.INFORMATION_MESSAGE);
		                else
		                    JOptionPane.showMessageDialog(null,"Failed to save record!","Save Failed",JOptionPane.INFORMATION_MESSAGE);
		            }
		            try {
						AutoID();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            clear();
		            cbobrandid.requestFocus();
		        }

			}
		});
		btnSave.setBounds(10, 261, 89, 23);
		getContentPane().add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(125, 261, 89, 23);
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
		btnClose.setBounds(231, 261, 89, 23);
		getContentPane().add(btnClose);
		
		fillBrand();
		fillType();
		AutoID();
	}
	
	public void AutoID() throws ClassNotFoundException
    {
        lblmerid.setText((String.valueOf(mySQLQueries.getAutoid("merid","merchandise","ME-"))));
    }

    public void fillBrand()
    {
        String str[]=mySQLQueries.getIDForChoice("brand");
        cbobrandid.addItem("-Select-");
        for(int i=0;i<str.length;i++)
            cbobrandid.addItem(str[i].toString());
    }
    public void fillType()
    {
        String str[]=mySQLQueries.getIDForChoice("type");
        cbotypeid.addItem("-Select-");
        for(int i=0;i<str.length;i++)
            cbotypeid.addItem(str[i].toString());
    }
    public void showBrand()
    {
        if(cbobrandid.getSelectedIndex()==0)
            lblbrandname.setText("");
        else
        {
            String result=mySQLQueries.getBrandName(cbobrandid.getSelectedItem().toString());
            lblbrandname.setText(result);
        }
    }
    public void showType()
    {
        if(cbotypeid.getSelectedIndex()==0)
            lbltype.setText("");
        else
        {
            String result=mySQLQueries.getTypeName(cbotypeid.getSelectedItem().toString());
            lbltype.setText(result);
        }
    }
    public void clear()
    {
        lblbrandname.setText("");
        lbltype.setText("");
        cbobrandid.setSelectedIndex(0);
        cbotypeid.setSelectedIndex(0);
    }

}
