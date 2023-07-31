package MasterData;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class ItemUpdate extends JDialog {
	private JTextField txtitemname;
	private JTextField txtremark;
	private JTextField txtsaleprice;
	private JLabel lbltypename;
	private JLabel lblbrandname;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ItemUpdate dialog = new ItemUpdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ItemUpdate() {
		setTitle("Item Update");
		setBounds(100, 100, 351, 390);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Item Update Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 317, 288);
			getContentPane().add(panel);
			{
				JLabel lblNewLabel = new JLabel("Item ID:");
				lblNewLabel.setBounds(51, 31, 46, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblBrandName = new JLabel("Brand Name:");
				lblBrandName.setBounds(25, 71, 85, 14);
				panel.add(lblBrandName);
			}
			{
				JLabel lblTypeName = new JLabel("Type Name:");
				lblTypeName.setBounds(29, 109, 68, 14);
				panel.add(lblTypeName);
			}
			{
				JLabel lblItemName = new JLabel("Item Name:");
				lblItemName.setBounds(24, 151, 76, 14);
				panel.add(lblItemName);
			}
			{
				lblbrandname = new JLabel("");
				lblbrandname.setBounds(103, 71, 171, 14);
				panel.add(lblbrandname);
			}
			{
				lbltypename = new JLabel("");
				lbltypename.setBounds(103, 109, 171, 14);
				panel.add(lbltypename);
			}
			{
				txtitemname = new JTextField();
				txtitemname.setText("");
				txtitemname.setColumns(10);
				txtitemname.setBounds(103, 148, 175, 20);
				panel.add(txtitemname);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Remark:");
				lblNewLabel_1.setBounds(39, 244, 65, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txtremark = new JTextField();
				txtremark.setText("");
				txtremark.setColumns(10);
				txtremark.setBounds(103, 241, 175, 20);
				panel.add(txtremark);
			}
			{
				JComboBox cboitemid = new JComboBox();
				cboitemid.setBounds(103, 27, 171, 22);
				panel.add(cboitemid);
			}
			
			txtsaleprice = new JTextField();
			txtsaleprice.setText("");
			txtsaleprice.setColumns(10);
			txtsaleprice.setBounds(103, 195, 175, 20);
			panel.add(txtsaleprice);
			
			JLabel lblSalePrice = new JLabel("Sale Price:");
			lblSalePrice.setBounds(34, 198, 76, 14);
			panel.add(lblSalePrice);
		}
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(10, 310, 89, 30);
		getContentPane().add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(123, 310, 89, 30);
		getContentPane().add(btnCancel);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(238, 310, 89, 30);
		getContentPane().add(btnClose);
	}
}
