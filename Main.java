package MasterData;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Main extends JFrame {
	private JMenu mnuBrand;
	private JMenuItem mnubrandentry;
	private JMenuItem mnubrandupdate;
	private JMenuItem mnubrandlist;
	private JMenu mnutype;
	private JMenuItem mnutypeentry;
	private JMenuItem mnutypeupdate;
	private JMenuItem mnutypelist;
	private JMenu mnuItem;
	private JMenuItem mnuMerchandise;
	private JMenuItem mnuitementry;
	private JMenuItem mnuitemupdate;
	private JMenuItem mnuitemlist;
	private JMenuItem mnuitemsearch;
	private JMenu mnuSupplier;
	private JMenuItem mnuSupplierEntry;
	private JMenuItem mnuSupplierUpdate;
	private JMenuItem mnuSupplieList;
	private JMenu mnuCustomer;
	private JMenuItem mnuCustomerEntry;
	private JMenuItem mnuCustomerUpdate;
	private JMenuItem mnuCustomerList;
	private JMenuItem mnuCustomerSearch;
	private JMenu mnuPurchase;
	private JMenuItem mnuPurchaseEntry;
	private JMenuItem mnuPurchaseList;
	private JMenuItem mnupurchasesearch;
	private JMenu mnuSale;
	private JMenuItem mnuSaleentry;
	JTable tblitem;
	private JButton btnClose;
	private JScrollPane scrollPane;
	DefaultTableModel dtm = new DefaultTableModel();
	
	Statement ste = null ;
	Connection con = null ;
	static clsDBConnection connect = new clsDBConnection();
	private JButton btnFresh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() throws ClassNotFoundException {
		setTitle("Point  Of Sale System");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1363, 721);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnuBrand = new JMenu("Brand");
		menuBar.add(mnuBrand);
		
		mnubrandentry = new JMenuItem("Brand Entry");
		mnubrandentry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BrandEntry b=new BrandEntry();
					b.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnuBrand.add(mnubrandentry);
		
		mnubrandupdate = new JMenuItem("Brand Update");
		mnubrandupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrandUpdate b=new BrandUpdate();
				b.show();
				
			}
		});
		mnuBrand.add(mnubrandupdate);
		
		mnubrandlist = new JMenuItem("Brand List");
		mnubrandlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BrandList b=new BrandList();
					b.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnuBrand.add(mnubrandlist);
		
		mnutype = new JMenu("Type");
		menuBar.add(mnutype);
		
		mnutypeentry = new JMenuItem("Type Entry");
		mnutypeentry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TypeEntry t=new TypeEntry();
					t.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnutype.add(mnutypeentry);
		
		mnutypeupdate = new JMenuItem("Type Update");
		mnutypeupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeUpdate t=new TypeUpdate();
				t.show();
			}
		});
		mnutype.add(mnutypeupdate);
		
		mnutypelist = new JMenuItem("Type List");
		mnutypelist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TypeList t=new TypeList();
					t.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnutype.add(mnutypelist);
		
		mnuItem = new JMenu("Item");
		menuBar.add(mnuItem);
		
		mnuMerchandise = new JMenuItem("Merchandise");
		mnuMerchandise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MerchandiseEntry m=new MerchandiseEntry();
					m.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		mnuItem.add(mnuMerchandise);
		
		mnuitementry = new JMenuItem("Item Entry");
		mnuitementry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ItemEntry i=new ItemEntry();
					i.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnuItem.add(mnuitementry);
		
		mnuitemupdate = new JMenuItem("Item Update");
		mnuitemupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemUpdate i=new ItemUpdate();
				i.show();
			}
		});
		mnuItem.add(mnuitemupdate);
		
		mnuitemlist = new JMenuItem("Item List");
		mnuitemlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ItemList i=new ItemList();
					i.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnuItem.add(mnuitemlist);
		
		mnuitemsearch = new JMenuItem("Item Searching");
		mnuitemsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemSearch i;
				try {
					i = new ItemSearch();
					i.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnuItem.add(mnuitemsearch);
		
		mnuSupplier = new JMenu("Supplier");
		menuBar.add(mnuSupplier);
		
		mnuSupplierEntry = new JMenuItem("Supplier Entry");
		mnuSupplierEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				SupplierEntry s=new SupplierEntry();
				s.show();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
		mnuSupplier.add(mnuSupplierEntry);
		
		mnuSupplierUpdate = new JMenuItem("Supplier Update");
		mnuSupplierUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierUpdate s=new SupplierUpdate();
				s.show();
			}
		});
		mnuSupplier.add(mnuSupplierUpdate);
		
		mnuSupplieList = new JMenuItem("Supplier List");
		mnuSupplieList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SupplierList s=new SupplierList();
					s.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnuSupplier.add(mnuSupplieList);
		
		mnuCustomer = new JMenu("Customer");
		menuBar.add(mnuCustomer);
		
		mnuCustomerEntry = new JMenuItem("Customer Entry");
		mnuCustomerEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CustomerEntry c=new CustomerEntry();
					c.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnuCustomer.add(mnuCustomerEntry);
		
		mnuCustomerUpdate = new JMenuItem("Customer Update");
		mnuCustomerUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerUpdate c=new CustomerUpdate();
				c.show();
			}
		});
		mnuCustomer.add(mnuCustomerUpdate);
		
		mnuCustomerList = new JMenuItem("Customer List");
		mnuCustomerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CustomerList c=new CustomerList();
					c.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnuCustomer.add(mnuCustomerList);
		
		mnuCustomerSearch = new JMenuItem("Customer Searching");
		mnuCustomerSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerSearching c=new CustomerSearching();
				c.show();
			}
		});
		mnuCustomer.add(mnuCustomerSearch);
		
		mnuPurchase = new JMenu("Purchase");
		menuBar.add(mnuPurchase);
		
		mnuPurchaseEntry = new JMenuItem("New Purchase");
		mnuPurchaseEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Purchase p=new Purchase();
					p.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnuPurchase.add(mnuPurchaseEntry);
		
		mnuPurchaseList = new JMenuItem("Purchase List");
		mnuPurchase.add(mnuPurchaseList);
		
		mnupurchasesearch = new JMenuItem("Purcahse Searching");
		mnupurchasesearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PurchaseSearch p=new PurchaseSearch();
					p.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnuPurchase.add(mnupurchasesearch);
		
		mnuSale = new JMenu("Sale");
		menuBar.add(mnuSale);
		
		mnuSaleentry = new JMenuItem("Sale Process");
		mnuSaleentry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SaleEntry s=new SaleEntry();
					s.show();
					//dispose();
					//fillSaleInfo();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnuSale.add(mnuSaleentry);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 1315, 603);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 33, 1284, 570);
		panel.add(scrollPane);
		
		tblitem = new JTable();
		scrollPane.setViewportView(tblitem);
		
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(1229, 614, 96, 40);
		getContentPane().add(btnClose);
		
		btnFresh = new JButton("Refresh");
		btnFresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
				try {
					Main m=new Main();
					m.show();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnFresh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFresh.setBounds(1121, 614, 96, 40);
		getContentPane().add(btnFresh);
		
		try{
            con=connect.getConnection();
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        createtable();
        fillSaleInfo();

	}

    public void createtable()
   {
       dtm.addColumn("Sale ID");
       dtm.addColumn("Date");
       dtm.addColumn("Customer Name");
       dtm.addColumn("Item Name | Brand | Type");
       dtm.addColumn("Price");
       dtm.addColumn("Quantity");
       tblitem.setModel(dtm);
       setColumnWidth(0,40);
       setColumnWidth(1,40);
       setColumnWidth(2,60);
       setColumnWidth(3,300);
       setColumnWidth(4,30);
       setColumnWidth(5,10);

   }
   public void setColumnWidth(int index , int width)
   {
       DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblitem.getColumnModel();
       TableColumn tc = tcm.getColumn(index);
       tc.setPreferredWidth(width);
   }
   public void fillSaleInfo()
   {
       String strdataitem[]=new String[6];
       String strquery[]=new String[6];
       try{
    	   //this.dtm.getDataVector().removeAllElements();
    	   //this.dtm.fireTableDataChanged();
           Statement ste = (Statement) con.createStatement();
           String str = "select * from sale,saledetail where sale.saleid=saledetail.saleid order by saledetail.saleid desc";
           ResultSet rs = ste.executeQuery(str);
           while(rs.next())
           {
              strdataitem[0]=rs.getString(1);//purchaseid
              strdataitem[1]=rs.getString(3);//purchasedate
              strquery = mySQLQueries.getCustomerData(rs.getString(2));
              strdataitem[2]=strquery[0];
              strquery=mySQLQueries.getItemData(rs.getString(7));
              strdataitem[3]=strquery[1];
              strdataitem[4]=strquery[2];
              strdataitem[5]=strquery[5];
              strquery = mySQLQueries.getMerchandise(strquery[3]);
              strdataitem[3]+="|"+mySQLQueries.getBrandName(strquery[0]);
              strdataitem[3]+="|"+mySQLQueries.getTypeName(strquery[1]);
              dtm.addRow(strdataitem);
           }
           tblitem.setModel(dtm);
       }
       catch(SQLException sqle)
       {
           System.out.println(sqle);
       }
   }


}
