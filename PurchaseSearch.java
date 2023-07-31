package MasterData;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Statement;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class PurchaseSearch extends JDialog {
	private JTable tblpurchase;
	private JRadioButton rdomonth;
	private JRadioButton rdoyear;
	private JRadioButton rdoboth;
	private JButton btnSearch;
	private JButton btnShowAll;
	private JButton btnprint;
	private JButton btnClose;
	DefaultTableModel dtm = new DefaultTableModel();
	static clsDBConnection connect = new clsDBConnection();
	Statement ste = null ;
	Connection con = null;
	private JComboBox cbomonth;
	private JComboBox cboyear;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PurchaseSearch dialog = new PurchaseSearch();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PurchaseSearch() throws ClassNotFoundException {
		setTitle("Purchase Searching");
		setBounds(100, 100, 796, 468);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
	     
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Purchase Search:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setForeground(new Color(0, 0, 0));
			panel.setBounds(10, 11, 758, 407);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				rdomonth = new JRadioButton("Monthly");
				rdomonth.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdomonth.isSelected())
						{
							rdoyear.setSelected(false);
							rdoboth.setSelected(false);
							cboyear.setVisible(false);
					        cboyear.setSelectedIndex(0);
					        cbomonth.setVisible(true);
					        cbomonth.setSelectedIndex(0);
						}
						else
						{
							cbomonth.setVisible(false);
						}
					}
				});
				rdomonth.setBounds(20, 29, 109, 23);
				panel.add(rdomonth);
			}
			{
				rdoyear = new JRadioButton("Yearly");
				rdoyear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdoyear.isSelected())
						{
							rdomonth.setSelected(false);
							rdoboth.setSelected(false);

					        cbomonth.setVisible(false);
					        cbomonth.setSelectedIndex(0);
					        cboyear.setVisible(true);
					        cboyear.setSelectedIndex(0);

						}
						else {
							cboyear.setVisible(false);
						}
					}
				});
				rdoyear.setBounds(180, 29, 109, 23);
				panel.add(rdoyear);
			}
			{
				rdoboth = new JRadioButton("Month & Yearly");
				rdoboth.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdoboth.isSelected())
						{
							rdoyear.setSelected(false);
							rdomonth.setSelected(false);

					        cbomonth.setVisible(true);
					        cbomonth.setSelectedIndex(0);
					        cboyear.setVisible(true);
					        cboyear.setSelectedIndex(0);
						}
						else {
							cbomonth.setVisible(false);
							cboyear.setVisible(false);
						}

					}
				});
				rdoboth.setBounds(312, 29, 120, 23);
				panel.add(rdoboth);
			}
			
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdomonth.isSelected()) {

			            if(cbomonth.getSelectedIndex()==0) {
			                JOptionPane.showMessageDialog(null,"Please choose Month");
			                cbomonth.requestFocus();
			            } else {
			                String str = "select * from purchase,purchasedetail where purchase.purchaseid=purchasedetail.purchaseid and Month(purchase.purchasedate)='"+cbomonth.getSelectedIndex()+"'order by purchasedetail.purchaseid desc";
			                fillPurData(str);
			            }
			        } else if(rdoyear.isSelected()) {

			            if(cboyear.getSelectedIndex()==0) {
			            	
			                JOptionPane.showMessageDialog(null,"Please choose Year");
			                cboyear.requestFocus();
			            } else {
			                String str = "select * from purchase,purchasedetail where purchase.purchaseid=purchasedetail.purchaseid and Year(purchase.purchasedate)='"+cboyear.getSelectedItem().toString()+"'order by purchasedetail.purchaseid desc";
			                fillPurData(str);
			            }
			        } else if (rdoboth.isSelected()) {

			            if(cbomonth.getSelectedIndex()==0) {
			                JOptionPane.showMessageDialog(null,"Please choose Month");
			                cbomonth.requestFocus();
			            } else if(cboyear.getSelectedIndex()==0) {
			                JOptionPane.showMessageDialog(null,"Please choose Year");
			                cboyear.requestFocus();
			            } else {
			                String str = "select * from purchase,purchasedetail where purchase.purchaseid=purchasedetail.purchaseid and Month(purchase.purchasedate)= '"+cbomonth.getSelectedIndex()+"' and Year(purchase.purchasedate)="+cboyear.getSelectedItem().toString()+" order by purchasedetail.purchaseid desc";
			                fillPurData(str);
			            }
			        }

				}
			});
			btnSearch.setBounds(343, 59, 89, 23);
			panel.add(btnSearch);
			
			btnShowAll = new JButton("Show All");
			btnShowAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillPurData("select * from purchase,purchasedetail where purchase.purchaseid=purchasedetail.purchaseid order by purchasedetail.purchaseid desc");
					 cbomonth.setVisible(false);
				     cboyear.setVisible(false);
				     rdoboth.setSelected(false);
				     rdoyear.setSelected(false);
					rdomonth.setSelected(false);

				}
			});
			btnShowAll.setBounds(472, 59, 89, 23);
			panel.add(btnShowAll);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 100, 720, 240);
			panel.add(scrollPane);
			
			tblpurchase = new JTable();
			scrollPane.setViewportView(tblpurchase);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				panel_1.setBounds(491, 351, 236, 45);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					btnprint = new JButton("Print");
					btnprint.setBounds(10, 11, 89, 23);
					panel_1.add(btnprint);
				}
				{
					btnClose = new JButton("Close");
					btnClose.setBounds(137, 11, 89, 23);
					panel_1.add(btnClose);
				}
			}
			{
				cbomonth = new JComboBox();
				cbomonth.setModel(new DefaultComboBoxModel(new String[] { "-Selected-", "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
				cbomonth.setBounds(20, 59, 120, 22);
				panel.add(cbomonth);
			}
			{
				cboyear = new JComboBox();
				cboyear.setBounds(180, 59, 132, 22);
				panel.add(cboyear);
			}
		}

        try
       {
        	con=connect.getConnection();
       }
       catch(SQLException sqle)
       {
           System.out.println(sqle);
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        createtable();
        fillYear();
        fillPurData("select * from purchase,purchasedetail where purchase.purchaseid=purchasedetail.purchaseid order by purchasedetail.purchaseid desc");
        cbomonth.setVisible(false);
        cboyear.setVisible(false);
        setResizable(false);


        
	}

    public void createtable()
   {
       dtm.addColumn("Purchase ID");
       dtm.addColumn("Date");
       dtm.addColumn("Supplier Name");
       dtm.addColumn("Item Name | Brand | Tye");
       dtm.addColumn("Price");
       dtm.addColumn("Quantity");
       tblpurchase.setModel(dtm);
       setColumnWidth(0,60);
       setColumnWidth(1,60);
       setColumnWidth(2,90);
       setColumnWidth(3,260);
       setColumnWidth(4,60);
       setColumnWidth(5,60);
   }
   public void setColumnWidth(int index , int width)
   {
       DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblpurchase.getColumnModel();
       TableColumn tc = tcm.getColumn(index);
       tc.setPreferredWidth(width);
   }

   public void fillPurData(String sql)
   {
       String strdataitem[]=new String[6];
       String strquery[]=new String[6];
       String strquery1[]=new String[3];
       try
       {
    	   con=connect.getConnection();
           Statement ste = (Statement) con.createStatement();
           while(dtm.getRowCount()>0)
           {
        	   dtm.removeRow(0);
           }
            
          ResultSet rs = ste.executeQuery(sql) ;
          while(rs.next())
          {
              strdataitem[0]=rs.getString(1);//purchaseid
              strdataitem[1]=rs.getString(3);//purchasedate
              strquery = mySQLQueries.getSupplierData(rs.getString(2));//supplierid to supplierdata
              strdataitem[2]=strquery[0];//suppliername
               strquery = mySQLQueries.getItemData(rs.getString(7));//itemid to itemdata
              strdataitem[3]=strquery[1];//itemname
              strdataitem[4]=rs.getString(5);//price
              strdataitem[5]=rs.getString(6);//qty
              strquery = mySQLQueries.getMerchandise(strquery[3]);
              strdataitem[3]+="|"+mySQLQueries.getBrandName(strquery[0]);//brandid to brandname
              strdataitem[3]+="|"+mySQLQueries.getTypeName(strquery[1]);//typeid to typename
              dtm.addRow(strdataitem);


          }
          tblpurchase.setModel(dtm);
       }
       catch(SQLException sqle)
       {
           System.out.println(sqle);
       }
   }
   public void fillYear()
   {
       cboyear.addItem("-Selected-");
       for(int i=2010 ; i<=2050 ; i++ )
           cboyear.addItem(i);
   }


}
