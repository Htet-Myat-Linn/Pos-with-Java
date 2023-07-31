package MasterData;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Purchase extends JDialog {
	private JComboBox cbosupplierid;
	private JLabel lblsuppliername;
	private JLabel lbladdress;
	private JLabel lblemail;
	private JLabel lblphno;
	private JLabel lblitemname;
	private JLabel lblitemtype;
	private JTextField txtprice;
	private JTextField txtQuantity;
	private JButton btnadd;
	private JButton btndelete;
	private JButton btnupdate;
	private JComboBox cboitemid;
	private JLabel lblpurchaseid;
	String strdataitem[]=new String[9];
	String strquery[]=new String[5];
	private JTable tblpurchase;
	private JScrollPane scrollPane;
	DefaultTableModel dtm = new DefaultTableModel();
	Vector vid = new Vector();
	Vector vamount = new Vector();
	String str[],stri[];
	private JLabel lbltotalamount;
	private JLabel lbldate;

boolean b = false ;
   date d=new date();




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Purchase dialog = new Purchase();
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
	public Purchase() throws ClassNotFoundException {
		setTitle("Purchase Process");
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBounds(100, 100, 791, 685);
		

		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
	     
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(10, 11, 755, 624);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Supplier ID:");
				lblNewLabel.setBounds(20, 22, 84, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblSupplierName = new JLabel("Supplier Name:");
				lblSupplierName.setBounds(10, 77, 94, 14);
				panel.add(lblSupplierName);
			}
			{
				JLabel lblNewLabel = new JLabel("Address:");
				lblNewLabel.setBounds(36, 129, 68, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel = new JLabel("Phone No:");
				lblNewLabel.setBounds(32, 195, 72, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel = new JLabel("Email:");
				lblNewLabel.setBounds(48, 257, 68, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel = new JLabel("Purchase ID:");
				lblNewLabel.setBounds(418, 22, 78, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel = new JLabel("Date:");
				lblNewLabel.setBounds(450, 77, 46, 14);
				panel.add(lblNewLabel);
			}
			{
				//Border blackline = BorderFactory.createLineBorder(Color.black);
				lblsuppliername = new JLabel("");
				lblsuppliername.setBounds(104, 69, 188, 22);
				lblsuppliername.setBorder(blackline);
				panel.add(lblsuppliername);
			}
			{
				cbosupplierid = new JComboBox();
				cbosupplierid.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						showSupplier();
					}
				});
				cbosupplierid.setBounds(103, 18, 200, 22);
				panel.add(cbosupplierid);
			}
			{
				
				lbladdress = new JLabel("");
				lbladdress.setBounds(104, 129, 188, 22);
				lbladdress.setBorder(blackline);
				panel.add(lbladdress);
			}
			{
				lblemail = new JLabel("");
				lblemail.setBounds(104, 249, 188, 22);
				lblemail.setBorder(blackline);
				panel.add(lblemail);
			}
			{
				lblphno = new JLabel("");
				lblphno.setBounds(104, 187, 188, 22);
				lblphno.setBorder(blackline);
				panel.add(lblphno);
			}
			{
				lblpurchaseid = new JLabel("");
				lblpurchaseid.setBounds(506, 18, 188, 22);
				lblpurchaseid.setBorder(blackline);
				panel.add(lblpurchaseid);
			}
			{
				lbldate = new JLabel("");
				lbldate.setBounds(506, 69, 188, 22);
				lbldate.setBorder(blackline);
				panel.add(lbldate);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Item Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 294, 725, 148);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Item ID:");
					lblNewLabel_1.setBounds(10, 33, 58, 14);
					panel_1.add(lblNewLabel_1);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Item Name:");
					lblNewLabel_1.setBounds(10, 74, 85, 14);
					panel_1.add(lblNewLabel_1);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Item Type:");
					lblNewLabel_1.setBounds(10, 118, 67, 14);
					panel_1.add(lblNewLabel_1);
				}
				{
					cboitemid = new JComboBox();
					cboitemid.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(cboitemid.getSelectedIndex()<=0)
			                    clearItem();
			                else
			                {
			                    /*5*/strquery = mySQLQueries.getItemData(cboitemid.getSelectedItem().toString());
			                    /*9*/ strdataitem[1]=strquery[0];//itemid
			                    strdataitem[2]=strquery[1];//itemname
			                    lblitemname.setText(strdataitem[2]);
			                    strdataitem[8]=(!strquery[4].equals(""))?strquery[4]:"-";//remark
			                    strquery = mySQLQueries.getMerchandise(strquery[3]);//merid to brandid,typeid
			                    strdataitem[6]=mySQLQueries.getBrandName(strquery[0]);//brandid to brandname
			                    strdataitem[7]=mySQLQueries.getTypeName(strquery[1]);
			                    lblitemtype.setText(strdataitem[7]);
			                    txtprice.requestFocus();
			                    //strdata 0,3,4,5
			                }

						}
					});
					cboitemid.setBounds(87, 29, 197, 22);
					panel_1.add(cboitemid);
				}
				{
					lblitemname = new JLabel("");
					lblitemname.setBounds(87, 74, 197, 22);
					lblitemname.setBorder(blackline);
					panel_1.add(lblitemname);
				}
				{
					lblitemtype = new JLabel("");
					lblitemtype.setBounds(87, 110, 197, 22);
					lblitemtype.setBorder(blackline);
					panel_1.add(lblitemtype);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Price:");
					lblNewLabel_2.setBounds(439, 33, 46, 14);
					panel_1.add(lblNewLabel_2);
				}
				{
					txtprice = new JTextField();
					txtprice.setBounds(495, 30, 187, 20);
					panel_1.add(txtprice);
					txtprice.setColumns(10);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Quantity:");
					lblNewLabel_2.setBounds(439, 74, 67, 14);
					panel_1.add(lblNewLabel_2);
				}
				{
					txtQuantity = new JTextField();
					txtQuantity.setColumns(10);
					txtQuantity.setBounds(495, 71, 187, 20);
					panel_1.add(txtQuantity);
				}
				{
					btnadd = new JButton("add");
					btnadd.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

			                if(cboitemid.getSelectedIndex()==0)
			                {
			                    JOptionPane.showMessageDialog(null, "You must choose Item ID!");
			                    cboitemid.requestFocus();
			                }
			                else if(!Checking.checktxtprice(txtprice.getText()))
			                {
			                    txtprice.requestFocus();
			                    txtprice.selectAll();
			                }
			                else if(!Checking.checktxtquantity(txtQuantity.getText()))
			                {
			                    txtQuantity.requestFocus();
			                    txtQuantity.selectAll();
			                }
			                else if(Checking.IsContain(cboitemid.getSelectedItem().toString(), vid))
			                {
			                    JOptionPane.showMessageDialog(null, "The item you selected is already existed!");
			                    cboitemid.requestFocus();
			                    clearItem();
			                    cboitemid.setSelectedIndex(0);
			                }
			                else
			                {
			                    itemaddmethod();
			                    lbltotalamount.setText(Checking.Sumamount(vamount,1)+"Kyats");
			                    clearItem();
			                    cboitemid.setSelectedIndex(0);
			                }

						}
					});
					btnadd.setBounds(396, 114, 89, 23);
					panel_1.add(btnadd);
				}
				{
					btndelete = new JButton("Delete");
					btndelete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

			                if(tblpurchase.getSelectedRow()<0)
			                    JOptionPane.showMessageDialog(null, "Please select row to delete.");
			                else
			                {
			                    deleteRow();
			                    clearItem();
			                    cboitemid.setSelectedIndex(0);
			                    lbltotalamount.setText(Checking.Sumamount(vamount, 1)+"Kyats");
			                }

						}
					});
					btndelete.setBounds(505, 114, 89, 23);
					panel_1.add(btndelete);
				}
				{
					btnupdate = new JButton("Update");
					btnupdate.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(tblpurchase.getSelectedRow()<0)
			                {
			                    JOptionPane.showMessageDialog(null, "Please select row to update");
			                }
			                else if(!Checking.checktxtprice(txtprice.getText()))
			                {
			                    txtprice.requestFocus();
			                    txtprice.selectAll();
			                }
			                else if(!Checking.checktxtquantity(txtQuantity.getText()))
			                {
			                    txtQuantity.requestFocus();
			                    txtQuantity.selectAll();
			                }
			                else
			                {
			                	deleteRow();
			                    ////delete selected row
			                    itemaddmethod();
			                    //update selected row
			                    lbltotalamount.setText(Checking.Sumamount(vamount,1)+"Kyats");//calculate different amount
			                    clearItem();//clear labels
			                    cboitemid.setSelectedIndex(0);//focus at cboitemid
			                }
						}
					});
					btnupdate.setBounds(626, 114, 89, 23);
					panel_1.add(btnupdate);
				}
			}
			
			lbltotalamount = new JLabel("");
			lbltotalamount.setBounds(578, 568, 171, 22);
			lbltotalamount.setBorder(blackline);
			panel.add(lbltotalamount);
			
			JLabel lblNewLabel_3 = new JLabel("Total Amount:");
			lblNewLabel_3.setBounds(493, 576, 86, 14);
			panel.add(lblNewLabel_3);
			
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBounds(182, 552, 290, 49);
			panel.add(panel_1);
			
			JButton btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {


			        if(cbosupplierid.getSelectedIndex()==0)
			        {
			            JOptionPane.showMessageDialog(null, "You must select a Supplier ID!");
			            cbosupplierid.requestFocus();
			        }
			        else if(vid.size()==0)
			        {

			            JOptionPane.showMessageDialog(null, "There is no item for Purchase!");
			            cbosupplierid.requestFocus();
			        }
			        else
			        {
			            if(JOptionPane.showConfirmDialog(null, "Are you sure to Save ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
			            {
			                boolean save;
			                String[]savedata1=new String[3];
			                String []savedata2=new String[4];
			                savedata1[0]=lblpurchaseid.getText();
			                savedata1[1]=cbosupplierid.getSelectedItem().toString();
			                savedata1[2]=lbldate.getText();
			                save=mySQLQueries.insertData("purchase", savedata1);
			                //System.out.print("Purchase");
			                if(save)
			                {
			                	//System.out.print("Purchase Detail");
			                    for(int i=0 ; i<vid.size() ; i++)
			                    {
			                        savedata2[0]=lblpurchaseid.getText();
			                        savedata2[1]=(String)tblpurchase.getValueAt(i, 1);//itemid
			                        savedata2[2]=(String)tblpurchase.getValueAt(i, 3);//price
			                        savedata2[3]=(String)tblpurchase.getValueAt(i, 4);//qty
			                        save=mySQLQueries.insertData("purchasedetail", savedata2);
			                        mySQLQueries.P_updateitemquantity("purchasedetail", savedata2[1], savedata2[2], savedata2[3]);
			                    }
			                }
			               
			        if(save)
			        {
			            JOptionPane.showMessageDialog(null, "All records are successfully SAVED!");
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
			            JOptionPane.showMessageDialog(null, "Records cannot be saved because of some ERROR!");
			            clear();
			        }
			    }//GEN-LAST:event_btnsaveActionPerformed
			  }


				}
			});
			btnSave.setBounds(31, 11, 89, 27);
			panel_1.add(btnSave);
			
			JButton btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					{	
						dispose();
					}
				}
			});
			btnClose.setBounds(159, 11, 89, 27);
			panel_1.add(btnClose);
			
			scrollPane = new JScrollPane();
			scrollPane.setToolTipText("");
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

	                

				}
			});
			scrollPane.setBounds(20, 453, 703, 81);
			panel.add(scrollPane);
			
			tblpurchase = new JTable();
			tblpurchase.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int r = tblpurchase.getSelectedRow();
	                cboitemid.setSelectedItem(tblpurchase.getValueAt(r, 1));
	                txtprice.setText(tblpurchase.getValueAt(r, 3).toString());
	                txtQuantity.setText(tblpurchase.getValueAt(r, 4).toString());
				}
			});
			scrollPane.setViewportView(tblpurchase);
		}
		AutoID();
		fillItem();
		fillSupplier();
		createtable();
		lbldate.setText(d.getMySQLDateFormat());
	}
	
	
	public void AutoID() throws ClassNotFoundException
    {
        lblpurchaseid.setText((String.valueOf( mySQLQueries.getAutoid("purchaseid", "purchase", "P-"))));
    }

    public void fillItem()
    {
        
       String  stri[]=mySQLQueries.getIDForChoice("itemdetail");
        cboitemid.addItem("-Selected-");
        for(int i = 0 ; i<stri.length ; i++)
            cboitemid.addItem(stri[i]);
        cboitemid.setSelectedIndex(0);
    }

    public void fillSupplier()
    {
       cbosupplierid.removeAllItems();
        String str[]=mySQLQueries.getIDForChoice("supplier");
        cbosupplierid.addItem("-Selected-");
        for(int i = 0 ; i<str.length ; i++)
        	cbosupplierid.addItem(str[i]);
        cbosupplierid.setSelectedIndex(0);
    }
    
    public void showSupplier()
    {
        String result1[]=new String[4];
        result1 = mySQLQueries.getSupplierData(cbosupplierid.getSelectedItem().toString());
        lblsuppliername.setText(result1[0]);
        lbladdress.setText(result1[1]);
        lblphno.setText(result1[2]);
        lblemail.setText(result1[3]);

    }
    public void clearItem()
    {
        lblitemname.setText("");
        lblitemtype.setText("");
        txtprice.setText("");
        txtQuantity.setText("");
        cboitemid.setSelectedIndex(0);
    }

    public void setColumnWidth(int index , int width)
   {
       DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblpurchase.getColumnModel();
       TableColumn tc = tcm.getColumn(index);
       tc.setPreferredWidth(width);
   }
    public void createtable()
    {
        dtm.addColumn("No");//0
        dtm.addColumn("Item ID");//1
        dtm.addColumn("Item Detail");
        dtm.addColumn("Price");//3
        dtm.addColumn("Quantity");//4
        dtm.addColumn("Amount");
        tblpurchase.setModel(dtm);
        setColumnWidth(0,5);
         setColumnWidth(1,60);
         setColumnWidth(2,250);
          setColumnWidth(3,40);
           setColumnWidth(4,20);
            setColumnWidth(5,50);
    }
    public void itemaddmethod()
    {
    	//strdataitem 0/,/3,/4,/5
        strdataitem[0]=String.valueOf(vid.size()+1);// no
        vid.addElement(strdataitem[1]);//itemid
        strdataitem[2]+="|"+strdataitem[6]+"|"+strdataitem[7]+"|"+strdataitem[8];//2itemaname,6brandname,7typename,8remark
        strdataitem[3]=txtprice.getText();//price
        strdataitem[4]=txtQuantity.getText();//qutantity
        Long amount = Integer.parseInt(strdataitem[4])*Long.parseLong(strdataitem[3]);//calculate amount
        strdataitem[5]=String.valueOf(amount);//toatlamount
        vamount.addElement(strdataitem[5]);//insert toatlamount into vamount
        dtm.addRow(strdataitem);//add row into dafault table model
        tblpurchase.setModel(dtm);
        cboitemid.requestFocus();
    }
    public void deleteRow()
    {
    	//3row in table
        int i = tblpurchase.getSelectedRow();//selected row 2 index 1 
        //i=1
        //System.out.print(i);
        vamount.remove(i);//vamount 1 deleted
        int no ;
        if((!vid.lastElement().equals(vid.get(i))))
        {
            vid.remove(i);//vid 1 id deleted
            
            no = vid.indexOf(vid.get(i));//1 1
          // System.out.print(no); no=1
            dtm.removeRow(i);// 1 row deleted
            for(int j=0; j<vid.size()-i;j++) {
             	dtm.setValueAt(i+j+1, i+j, 0);
             }
            
        }
        else
        {
            vid.remove(i);
            dtm.removeRow(i);

        }
        tblpurchase.setModel(dtm);
        lbltotalamount.setText(Checking.Sumamount(vamount, 1)+"Kyats");
        
    }

    public void clear()
    {
        lblsuppliername.setText("");
        lbladdress.setText("");
        lblphno.setText("");
        lblitemname.setText("");
        lbltotalamount.setText("");
        cbosupplierid.setSelectedIndex(0);
        cboitemid.setSelectedIndex(0);
        while(dtm.getRowCount()>0)
            dtm.removeRow(0);
        tblpurchase.setModel(dtm);
        vid.removeAllElements();
        vamount.removeAllElements();
    }




}
