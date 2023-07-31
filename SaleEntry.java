package MasterData;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import MasterData.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class SaleEntry extends JDialog {
	private JTextField txtquantity;
	private JLabel lblsaleid;
	private JLabel lblcustomername;
	private JLabel lbladdress;
	private JLabel lblphno;
	private JLabel lblemail;
	private JLabel lbldate;
	private JLabel lblprice;
	private JLabel lblitemname;
	private JLabel lblitemtype;
	private JButton btnadd;
	private JButton btndelete;
	private JButton btnupdate;
	private JTable tblsale;
	private JButton btnSave;
	private JButton btnClose;
	private JButton btnNew;
	Border blackline = BorderFactory.createLineBorder(Color.black);
	public JComboBox cboCustomer;
	private JComboBox cboitemid;
	date d=new date();
	String str[],stri[];
	String strdataitem[]=new String[9];
	String strquery[]=new String[6];
	Vector vid = new Vector();
	Vector vamount = new Vector();
	Long l = 0l ;
	DefaultTableModel dtm = new DefaultTableModel();
	private JLabel lbltotalamount;
	private JLabel lblNewLabel_2_3;
	private JLabel lblinstockqty;
	private JPanel panel;
    public int b;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SaleEntry dialog = new SaleEntry();
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
	public SaleEntry() throws ClassNotFoundException {
		setTitle("Sale Process");
		setBounds(100, 100, 791, 678);
		

		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
	     
		getContentPane().setLayout(null);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 755, 624);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Customer ID:");
		lblNewLabel.setBounds(20, 77, 84, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCustomerName = new JLabel("CustomerName:");
		lblCustomerName.setBounds(400, 77, 107, 14);
		panel.add(lblCustomerName);
		
		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setBounds(48, 129, 68, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone No:");
		lblNewLabel_2.setBounds(425, 137, 72, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(58, 182, 68, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblSaleId = new JLabel("Sale ID:");
		lblSaleId.setBounds(48, 22, 78, 14);
		panel.add(lblSaleId);
		
		JLabel lblNewLabel_5 = new JLabel("Date:");
		lblNewLabel_5.setBounds(451, 22, 46, 14);
		panel.add(lblNewLabel_5);
		
		lblcustomername = new JLabel("");
		lblcustomername.setBounds(493, 77, 188, 22);
		lblcustomername.setBorder(blackline);
		panel.add(lblcustomername);
		
		lbladdress = new JLabel("");
		lbladdress.setBounds(104, 129, 188, 22);
		lbladdress.setBorder(blackline);
		panel.add(lbladdress);
		
		lblemail = new JLabel("");
		lblemail.setBounds(104, 182, 188, 22);
		lblemail.setBorder(blackline);
		panel.add(lblemail);
		
		lblphno = new JLabel("");
		lblphno.setBounds(493, 129, 188, 22);
		lblphno.setBorder(blackline);
		panel.add(lblphno);
		
		lblsaleid = new JLabel("");
		lblsaleid.setBounds(104, 18, 188, 22);
		lblsaleid.setBorder(blackline);
		panel.add(lblsaleid);
		
		lbldate = new JLabel("");
		lbldate.setBounds(493, 18, 188, 22);
		lbldate.setBorder(blackline);
		panel.add(lbldate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Item Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 215, 725, 227);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Item ID:");
		lblNewLabel_1_1.setBounds(231, 29, 58, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Item Name:");
		lblNewLabel_1_2.setBounds(33, 82, 85, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Item Type:");
		lblNewLabel_1_3.setBounds(51, 136, 67, 14);
		panel_1.add(lblNewLabel_1_3);
		
		lblitemname = new JLabel("");
		lblitemname.setBounds(117, 74, 197, 22);
		lblitemname.setBorder(blackline);
		panel_1.add(lblitemname);
		
		lblitemtype = new JLabel("");
		lblitemtype.setBounds(117, 128, 197, 22);
		lblitemtype.setBorder(blackline);
		panel_1.add(lblitemtype);
		
		JLabel lblNewLabel_2_1 = new JLabel("Price:");
		lblNewLabel_2_1.setBounds(439, 74, 46, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Sale Quantity:");
		lblNewLabel_2_2.setBounds(425, 133, 85, 14);
		panel_1.add(lblNewLabel_2_2);
		
		txtquantity = new JTextField();
		txtquantity.setColumns(10);
		txtquantity.setBounds(505, 130, 187, 20);
		panel_1.add(txtquantity);
		
		btnadd = new JButton("add");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        if(cboitemid.getSelectedIndex()==0) {
		            JOptionPane.showMessageDialog(null, "You must choose Item ID!");
		            cboitemid.requestFocus();
		        }
		         else if(!Checking.checktxtquantity(txtquantity.getText())) {
		            txtquantity.requestFocus();
		            txtquantity.selectAll();
		            //lblinstockqty.setText("");
		        } 
		       
		         else if(!Checking.checksaleQuantity(txtquantity.getText(), strdataitem[1]))
		         {
		           clear();
		           lblinstockqty.setText("");
		         }
		         else if(Checking.IsContain(cboitemid.getSelectedItem().toString(), vid))
	                {
	                    JOptionPane.showMessageDialog(null, "The item you selected is already existed!");
	                    cboitemid.requestFocus();
	                    clearItem();
	                    cboitemid.setSelectedIndex(0);
	                }
		         else {
		            try {
		                itemaddmethod();
		            } catch (SQLException ex) {
		              System.out.print(ex);
		            }
		            lbltotalamount.setText(Checking.Sumamount(vamount,1)+"Kyats");
		            clearItem();
		            lblinstockqty.setText("");
		        }
		        
		    
			}
		});
		btnadd.setBounds(396, 172, 89, 23);
		panel_1.add(btnadd);
		
		btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblsale.getSelectedRow()<0)
		            JOptionPane.showMessageDialog(null, "Please select row to delete.");
		        else {
		            deleteRow();
		            clearItem();
		            lbltotalamount.setText(Checking.Sumamount(vamount, 1)+"Kyats");
		        }

			}
		});
		btndelete.setBounds(505, 172, 89, 23);
		panel_1.add(btndelete);
		
		btnupdate = new JButton("Update");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnupdate.setBounds(626, 172, 89, 23);
		panel_1.add(btnupdate);
		
		lblprice = new JLabel("");
		lblprice.setBounds(505, 74, 187, 22);
		lblprice.setBorder(blackline);
		panel_1.add(lblprice);
		
		cboitemid = new JComboBox();
		cboitemid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboitemid.getSelectedIndex()==0)
				{ clearItem();
				  lblinstockqty.setText("");
				}
				
                else
                { 
                	 //strdataitem 9//   0 /1<=id /2<=itemname /3<=price / 8<=remark/6<=brandname 7<=typename
                	//strquery 6 <= str from getitemdat 0<=id 1<=name 2<=price 3<=merid 4<=remark 5<=qty
                     strquery = mySQLQueries.getItemData(cboitemid.getSelectedItem().toString());
                    strdataitem[1]=strquery[0];//itemid
                    strdataitem[2]=strquery[1];//itemname
                    strdataitem[3]=strquery[2];
                    lblinstockqty.setText(strquery[5]); //5<=qty
                    lblitemname.setText(strdataitem[2]);
                    strdataitem[8]=(!strquery[4].equals(""))?strquery[4]:"-";//remark
                    strquery = mySQLQueries.getMerchandise(strquery[3]);//merid to brandid,typeid
                    //strquery 0 1<===brandid typeid
                    strdataitem[6]=mySQLQueries.getBrandName(strquery[0]);//brandid to brandname
                    strdataitem[7]=mySQLQueries.getTypeName(strquery[1]);
                    lblitemtype.setText(strdataitem[7]);
                    lblprice.setText(strdataitem[3]);
                    txtquantity.requestFocus();
                }
            
			}
		});
		cboitemid.setBounds(308, 25, 197, 22);
		panel_1.add(cboitemid);
		
		lblinstockqty = new JLabel("");
		lblinstockqty.setBounds(113, 172, 171, 23);
		panel_1.add(lblinstockqty);
		lblinstockqty.setFont(lblinstockqty.getFont().deriveFont(lblinstockqty.getFont().getStyle() | Font.BOLD));
		lblinstockqty.setBorder(blackline);
		
		lblNewLabel_2_3 = new JLabel("Instock Quantity:");
		lblNewLabel_2_3.setBounds(10, 176, 108, 14);
		panel_1.add(lblNewLabel_2_3);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lbltotalamount = new JLabel("");
		lbltotalamount.setBounds(578, 568, 171, 22);
		lbltotalamount.setBorder(blackline);
		panel.add(lbltotalamount);
		
		JLabel lblNewLabel_3_1 = new JLabel("Total Amount:");
		lblNewLabel_3_1.setBounds(493, 576, 86, 14);
		panel.add(lblNewLabel_3_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(182, 552, 290, 49);
		panel.add(panel_1_1);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        if(cboCustomer.getSelectedIndex()==0) {
		            JOptionPane.showMessageDialog(null, "You must select a Customer ID!");
		            cboCustomer.requestFocus();
		        }//if
		        else if(vid.size()==0) {
		            JOptionPane.showMessageDialog(null, "There is no item for Sale!");
		            cboCustomer.requestFocus();
		        }//end else if
		        else {
		            if(JOptionPane.showConfirmDialog(null, "Are you sure to Save ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
		            {
		                boolean save;
		                String[]savedata1=new String[3];
		                String []savedata2=new String[4];
		                savedata1[0]=lblsaleid.getText();//saleid
		                savedata1[1]=cboCustomer.getSelectedItem().toString();//custid
		                savedata1[2]=lbldate.getText();//saledate
		                save=mySQLQueries.insertData("sale", savedata1);
		                if(save) {
		                    for(int i=0 ; i<vid.size() ; i++) {
		                        savedata2[0]=lblsaleid.getText();//saleid
		                        savedata2[1]=(String)tblsale.getValueAt(i, 1);//itemid
		                        savedata2[2]=(String)tblsale.getValueAt(i, 3);//price
		                        savedata2[3]=(String)tblsale.getValueAt(i, 4);//Qty
		                        save=mySQLQueries.insertData("saledetail", savedata2);
		                        mySQLQueries.S_updateitemquantity("itemdetail",strdataitem[1], strdataitem[4]);//itemid //qty
		                    }
		                    try {
								Main m=new Main();
								//m.show();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                }

		                if(save) {
		                    JOptionPane.showMessageDialog(null, " Sale process Success! . Thank You !\nHave a good Day!");
		                    try {
								AutoID();
								
								
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                    clear();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Records cannot be saved because of some ERROR!");
		                    clear();
		                }
		            	/*Main m;
						try {
							m = new Main();
							m.tblitem.removeAll();
							  m.dtm.fireTableDataChanged();
							  m.fillSaleInfo();
							  

						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					System.out.print("aa");*/
		              
		            }
		        }

			}
		});
		btnSave.setBounds(31, 11, 89, 27);
		panel_1_1.add(btnSave);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(159, 11, 89, 27);
		panel_1_1.add(btnClose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 453, 708, 88);
		panel.add(scrollPane);
		
		tblsale = new JTable();
		tblsale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tblsale.getSelectedRow();
		        cboitemid.setSelectedItem(tblsale.getValueAt(r, 1));
		        lblprice.setText(tblsale.getValueAt(r, 3).toString());
		        txtquantity.setText(tblsale.getValueAt(r, 4).toString());
			}
		});
		scrollPane.setViewportView(tblsale);
		
		btnNew = new JButton("New  Customer");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//cboCustomer.removeAllItems();
					CustomerEntry c=new CustomerEntry();
					c.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNew.setBounds(556, 170, 125, 34);
		panel.add(btnNew);
		
		cboCustomer = new JComboBox();
		cboCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        if(cboCustomer.getSelectedIndex()>0)
		        showCustomer();

			}
		});
		cboCustomer.setBounds(104, 73, 188, 22);
		panel.add(cboCustomer);
		lbldate.setText(d.getMySQLDateFormat());
		
		JLabel lblNewLabel_4 = new JLabel("To Insert New  Customer Click  Here");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(338, 182, 225, 14);
		panel.add(lblNewLabel_4);
		AutoID();
		fillCustomer();
		fillItem();
		createtable();
	}

    public void AutoID() throws ClassNotFoundException
    {
        lblsaleid.setText((String.valueOf(mySQLQueries.getAutoid("saleid", "sale", "S-"))));
    }

    public void fillCustomer()
    {
        cboCustomer.removeAllItems();
         str=mySQLQueries.getIDForChoice("customer");
         cboCustomer.addItem("-Selected-");
        for(int i = 0 ; i<str.length ; i++)
        	cboCustomer.addItem(str[i]);
        cboCustomer.setSelectedIndex(0);
    }
    public void showCustomer()
    {
        String result1[]=new String[4];
        result1 = mySQLQueries.getCustomerData(cboCustomer.getSelectedItem().toString());
        lblcustomername.setText(result1[0]);;
        lbladdress.setText(result1[1]);
        lblphno.setText(result1[2]);
        lblemail.setText(result1[3]);
    }
    public void fillItem()
    {
        cboitemid.removeAllItems();
        stri=mySQLQueries.getItemIDForSale("itemdetail");
        cboitemid.addItem("-Selected-");
        for(int i = 0 ; i<stri.length ; i++)
            cboitemid.addItem(stri[i]);
        cboitemid.setSelectedIndex(0);
    }
    public void clearItem()
    {
        lblitemname.setText("");
        lblitemtype.setText("");
        lblprice.setText("");
        txtquantity.setText("");
        lblemail.setText("");
        cboitemid.setSelectedIndex(0);
    }

    public void clear()
    {
        lblcustomername.setText("");
        lbladdress.setText("");
        lblphno.setText("");
        lblemail.setText("");
        lblitemname.setText("");
        lbltotalamount.setText("");
        cboCustomer.setSelectedIndex(0);
        cboitemid.setSelectedIndex(0);
        while(dtm.getRowCount()>0)
            dtm.removeRow(0);
        tblsale.setModel(dtm);
        vid.removeAllElements();
        vamount.removeAllElements();
    }
    public void createtable()
    {
        dtm.addColumn("No");
        dtm.addColumn("Sale ID");
        dtm.addColumn("Item Detail");
        dtm.addColumn("Price");
        dtm.addColumn("Quantity");
        dtm.addColumn("Amount");
        tblsale.setModel(dtm);
        setColumnWidth(0,10);
         setColumnWidth(1,40);
         setColumnWidth(2,250);
          setColumnWidth(3,40);
           setColumnWidth(4,20);
            setColumnWidth(5,50);
    }
     public void setColumnWidth(int index , int width)
    {
        DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblsale.getColumnModel();
        TableColumn tc = tcm.getColumn(index);
        tc.setPreferredWidth(width);
    }
     public void itemaddmethod() throws SQLException
     {
    	//strdataitem 9//   0 <=1 // 1<=id // 2<=itemname|| //3<=price //4 saleqty//5<=amount // 8<=remark//6<=brandname //7<=typename
     	//strquery 6 <= str from getitemdat 0<=id 1<=name 2<=price 3<=merid 4<=remark 5<=qty
         strdataitem[0]=String.valueOf(vid.size()+1); // vid itemid vector 
         vid.addElement(strdataitem[1]);//itemid
         strdataitem[2]+="|"+strdataitem[6]+"|"+strdataitem[7]+"|"+strdataitem[8];
         strdataitem[3]=lblprice.getText();
         strdataitem[4]=txtquantity.getText();
         Long amount = Long.parseLong(txtquantity.getText())*Long.parseLong(strdataitem[3]);
         strdataitem[5]=String.valueOf(amount);
         vamount.addElement(strdataitem[5]);
         dtm.addRow(strdataitem);
         tblsale.setModel(dtm);
         cboitemid.requestFocus();
     }
     public void deleteRow()
     {
         int i = tblsale.getSelectedRow();
         vamount.remove(i);
         int no ;
         if(!vid.lastElement().equals(vid.get(i)))
         {
             vid.remove(i);
             no = vid.indexOf(vid.get(i));
             dtm.removeRow(i);
             for(int j=0; j<vid.size()-i;j++) {
              	dtm.setValueAt(i+j+1, i+j, 0);
              }
         }
         else
         {
             vid.remove(i);
             dtm.removeRow(i);

         } 
         tblsale.setModel(dtm);
         lbltotalamount.setText(Checking.Sumamount(vamount, 1)+"Kyats");
     }
}

