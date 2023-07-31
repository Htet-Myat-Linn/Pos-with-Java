package MasterData;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Statement;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CustomerSearching extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private final JRadioButton rodName = new JRadioButton("Name");
	private final JRadioButton rdoBoth = new JRadioButton("Both");
	private JRadioButton rdoAddress;
	private JComboBox cboAddress;
	private JComboBox cboName;
	private JButton btnSearch;
	private JButton btnShowAll;
	private JTable tblCustomer;
	private JButton btnPrint;
	private JButton btnClose;
	DefaultTableModel dtm = new DefaultTableModel();
	Statement ste = null ;
	Connection con = null;
	static clsDBConnection connect = new clsDBConnection();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomerSearching dialog = new CustomerSearching();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomerSearching() {
		setTitle("Customer Searching");
		setBounds(100, 100, 793, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
		
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Customer Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 747, 349);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdoAddress = new JRadioButton("Address");
		rdoAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(rdoAddress.isSelected())
			        {
					 	rodName.setSelected(false);
			        	rdoBoth.setSelected(false);
			        	cboAddress.setVisible(true);
			        	cboAddress.setSelectedIndex(0);
				        cboName.setVisible(false);
				        cboName.setSelectedIndex(0);
			        }
			        else {
			        	cboName.setVisible(false);
			        	cboAddress.setVisible(false);
			        }

			}
		});
		rdoAddress.setBounds(225, 24, 76, 23);
		panel.add(rdoAddress);
		rodName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rodName.isSelected())
		        {
					rdoAddress.setSelected(false);
		        	rdoBoth.setSelected(false);
		        	cboName.setVisible(true);
		        	cboName.setSelectedIndex(0);
			        cboAddress.setVisible(false);
			        cboAddress.setSelectedIndex(0);
		        }
		        else {
		        	cboName.setVisible(false);
		        	cboAddress.setVisible(false);
		        }
			}
		});
		rodName.setBounds(80, 25, 63, 23);
		
		panel.add(rodName);
		rdoBoth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoBoth.isSelected())
		        {
					rodName.setSelected(false);
		        	rdoAddress.setSelected(false);
		        	cboName.setVisible(true);
		        	cboName.setSelectedIndex(0);
			        cboAddress.setVisible(true);
			       cboAddress.setSelectedIndex(0);
			        
		        }
		        else
		        {
		        	cboName.setVisible(false);
		        	cboAddress.setVisible(false);
		        }
			}
		});
		rdoBoth.setBounds(360, 26, 55, 23);
		
		panel.add(rdoBoth);
		
		cboAddress = new JComboBox();
		cboAddress.setBounds(229, 67, 130, 22);
		panel.add(cboAddress);
		
		cboName = new JComboBox();
		cboName.setBounds(75, 65, 130, 22);
		panel.add(cboName);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rodName.isSelected())
		        {

		            if(cboName.getSelectedIndex()==0)
		            {
		                JOptionPane.showMessageDialog(null,"Please choose Name");
		                cboName.requestFocus();
		            }
		            else
		            {
		                 String str = "select * from customer where name = '"+cboName.getSelectedItem()+"' order by customerid desc";
		                fillCusData(str);
		                
		             
		            }
		        }
		        else if(rdoAddress.isSelected())
		        {

		            if(cboAddress.getSelectedIndex()==0)
		            {
		                JOptionPane.showMessageDialog(null,"Please choose ID");
		                cboAddress.requestFocus();
		            }
		            else
		            {
		               String str = "select * from customer where address = '"+cboAddress.getSelectedItem()+"' order by customerid desc";
		                fillCusData(str);
		           }
		        }
		        else if (rdoBoth.isSelected())
		        {

		            if(cboName.getSelectedIndex()==0)
		            {
		                JOptionPane.showMessageDialog(null,"Please choose Name");
		                cboName.requestFocus();
		            }
		            else if(cboAddress.getSelectedIndex()==0)
		            {
		                JOptionPane.showMessageDialog(null,"Please choose address");
		                cboAddress.requestFocus();
		            }
		            else
		            {
		                 String str = "select * from customer where name='"+cboName.getSelectedItem()+"'and address='"+cboAddress.getSelectedItem()+"' order by customerid desc";
		                fillCusData(str);
		            }
		        }

			}
		});
		btnSearch.setBounds(410, 65, 89, 23);
		panel.add(btnSearch);
		
		btnShowAll = new JButton("ShowAll");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        fillCusData("select * from customer order by customerid desc");
		        rdoAddress.setSelected(false);
		        rodName.setSelected(false);
		        rdoBoth.setSelected(false);
		        cboName.setVisible(false);
		        cboName.setSelectedIndex(0);
		        cboAddress.setVisible(false);
		        cboAddress.setSelectedIndex(0);

			}
		});
		btnShowAll.setBounds(522, 65, 89, 23);
		panel.add(btnShowAll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 127, 702, 201);
		panel.add(scrollPane);
		
		tblCustomer = new JTable();
		scrollPane.setViewportView(tblCustomer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(541, 371, 216, 59);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        try{
		        	tblCustomer.print();
		        }catch(Exception e1) {
		            JOptionPane.showMessageDialog(null, e1);
		        }
			}
		});
		btnPrint.setBounds(10, 11, 89, 37);
		panel_1.add(btnPrint);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(117, 11, 89, 37);
		panel_1.add(btnClose);
		
		

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

        
		cboName.setVisible(false);
    	cboAddress.setVisible(false);
    	fill();
    	createtable();

        fillCusData("select * from customer order by customerid desc ");

		
	}
	public void fill()
	{
	    cboName.addItem("-Selected-");
	    String str[]= mySQLQueries.getNameForChoice("customer");
	    for(int i=0 ; i<str.length ; i++)
	    	cboName.addItem(str[i]);
	    cboAddress.addItem("-Selected-");
	     String str1[]= mySQLQueries.getNameForChoice("customeraddress");
	    for(int j=0 ; j<str1.length ; j++)
	        cboAddress.addItem(str1[j]);
	}
    public void setColumnWidth(int index , int width)
    {
        DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblCustomer.getColumnModel();
        TableColumn tc = tcm.getColumn(index);
        tc.setPreferredWidth(width);
    }

    public void createtable()
    {
        dtm.addColumn("Customer ID");
        dtm.addColumn("Name");
        dtm.addColumn("Address");
        dtm.addColumn("Phone No");
        dtm.addColumn("Email");
        
        tblCustomer.setModel(dtm);
        setColumnWidth(0,40);
        setColumnWidth(1,40);
        setColumnWidth(2,60);
        setColumnWidth(3,40);
        setColumnWidth(4,60);
       
    }

    public void fillCusData(String sql)
   {
       String strdataitem[]= new String[5];
       
       try
       {
           Statement ste = (Statement) con.createStatement();
            while(dtm.getRowCount()>0)
               dtm.removeRow(0);
           ResultSet rs = ste.executeQuery(sql);
           while(rs.next())
           {
               strdataitem[0]=rs.getString(1);//itemid

               strdataitem[1]=rs.getString(2);//name

               strdataitem[2]=rs.getString(3);//address
               strdataitem[3]=rs.getString(4);//phone
               strdataitem[4]=rs.getString(5);//email
               dtm.addRow(strdataitem);
           }
           tblCustomer.setModel(dtm);
       }
       catch(SQLException sqle)
       {
           System.out.println(sqle);
       }

   }





}
