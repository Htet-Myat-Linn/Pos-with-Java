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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Statement;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemSearch extends JDialog {
	private JTable tblitem;
	private JRadioButton rdobrand;
	private JRadioButton rdotype;
	private JRadioButton rdoboth;
	private JComboBox cbobrandname;
	private JComboBox cbotypename;
	private JButton btnSearch;
	private JButton btnShowall;
	private JButton btnPrint;
	private JButton btnClose;
	DefaultTableModel dtm = new DefaultTableModel();
	static clsDBConnection connect = new clsDBConnection();
	Statement ste = null ;
	Connection con = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ItemSearch dialog = new ItemSearch();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ItemSearch() throws ClassNotFoundException {
		setTitle("Item Searching");
		setBounds(100, 100, 741, 525);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
	     
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Item Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 705, 407);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		rdobrand = new JRadioButton("Brand");
		rdobrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        
		        
		        if(rdobrand.isSelected())
		        {
		        	rdotype.setSelected(false);
		        	rdoboth.setSelected(false);
		        	cbobrandname.setVisible(true);
			        cbobrandname.setSelectedIndex(0);
			        cbotypename.setVisible(false);
			        cbotypename.setSelectedIndex(0);
		        }
		        else {
		        	cbobrandname.setVisible(false);
			    	cbotypename.setVisible(false);
		        }

			}
		});
		rdobrand.setBounds(24, 30, 109, 23);
		panel.add(rdobrand);
		
		rdotype = new JRadioButton("Type");
		rdotype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        
		        
		        if(rdotype.isSelected())
		        {
		        	rdobrand.setSelected(false);
		        	rdoboth.setSelected(false);
		        	cbobrandname.setVisible(false);
			        cbobrandname.setSelectedIndex(0);
			        cbotypename.setVisible(true);
			        cbotypename.setSelectedIndex(0);
		        }
		        else
		        {
		        	cbobrandname.setVisible(false);
			    	cbotypename.setVisible(false);
		        }

			}
		});
		rdotype.setBounds(164, 30, 109, 23);
		panel.add(rdotype);
		
		rdoboth = new JRadioButton("Brand & Type");
		rdoboth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        
		        if(rdoboth.isSelected())
		        {
		        	rdobrand.setSelected(false);
		        	rdotype.setSelected(false);
		        	cbobrandname.setVisible(true);
			        cbobrandname.setSelectedIndex(0);
			        cbotypename.setVisible(true);
			        cbotypename.setSelectedIndex(0);
			        
		        }
		        else
		        {
		        	cbobrandname.setVisible(false);
			    	cbotypename.setVisible(false);
		        }

			}
		});
		rdoboth.setBounds(316, 30, 109, 23);
		panel.add(rdoboth);
		
		cbobrandname = new JComboBox();
		cbobrandname.setBounds(24, 68, 122, 22);
		panel.add(cbobrandname);
		
		cbotypename = new JComboBox();
		cbotypename.setBounds(166, 68, 122, 22);
		panel.add(cbotypename);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        while(dtm.getRowCount()>0)
		        {
		        	 dtm.removeRow(0);
		        }
	               
		        String brandID , typeID ;
		        if(rdobrand.isSelected())
		        {
		           
		            if(cbobrandname.getSelectedIndex()==0)
		            {
		                JOptionPane.showMessageDialog(null,"Please choose Brand Name");
		                cbobrandname.requestFocus();
		            }
		            else
		            {
		                brandID = mySQLQueries.getBrandID(cbobrandname.getSelectedItem().toString());
		                String merID[]=mySQLQueries.getMerID(brandID,null);
		                getQuery(merID);
		            }
		        }
		        else if(rdotype.isSelected())
		        {
		            
		            if(cbotypename.getSelectedIndex()==0)
		            {
		                JOptionPane.showMessageDialog(null,"Please choose Type Name");
		                cbotypename.requestFocus();
		            }
		            else
		            {
		                typeID = mySQLQueries.getTypeID(cbotypename.getSelectedItem().toString());
		                String merID[]=mySQLQueries.getMerID(null, typeID);
		                getQuery(merID);
		           }
		        }
		        else if (rdoboth.isSelected())
		        {
		            
		            if(cbobrandname.getSelectedIndex()==0)
		            {
		                JOptionPane.showMessageDialog(null,"Please choose Brand Name");
		                cbobrandname.requestFocus();
		            }
		            else if(cbotypename.getSelectedIndex()==0)
		            {
		                JOptionPane.showMessageDialog(null,"Please choose Type Name");
		                cbotypename.requestFocus();
		            }
		            else
		            {
		                brandID = mySQLQueries.getBrandID(cbobrandname.getSelectedItem().toString());
		                typeID = mySQLQueries.getTypeID(cbotypename.getSelectedItem().toString());
		                String merID[]=mySQLQueries.getMerID(brandID, typeID);
		                getQuery(merID);
		            }
		        }

			}
		});
		btnSearch.setBounds(327, 68, 98, 23);
		panel.add(btnSearch);
		
		btnShowall = new JButton("Show All");
		btnShowall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbobrandname.setVisible(false);
		    	cbotypename.setVisible(false);
		    	rdobrand.setSelected(false);
		    	rdotype.setSelected(false);
		    	rdoboth.setSelected(false);
		        fillItem("select * from itemdetail order by itemid desc");

			}
		});
		btnShowall.setBounds(454, 68, 98, 23);
		panel.add(btnShowall);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 112, 662, 268);
		panel.add(scrollPane);
		
		tblitem = new JTable();
		scrollPane.setViewportView(tblitem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(477, 429, 215, 46);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        try{
		            tblitem.print();
		        }catch(Exception e1) {
		            JOptionPane.showMessageDialog(null, e1);
		        }

			}
		});
		btnPrint.setBounds(10, 11, 89, 23);
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
		btnClose.setBounds(116, 11, 89, 23);
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
        
        createtable();
        fillItem("select * from itemdetail order by itemid desc" );
        cbobrandname.setVisible(false);
        cbotypename.setVisible(false);
        fillBrandType();

	}


    public void setColumnWidth(int index , int width)
    {
        DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblitem.getColumnModel();
        TableColumn tc = tcm.getColumn(index);
        tc.setPreferredWidth(width);
    }
    
    public void createtable()
    {
        dtm.addColumn("Item ID");
        dtm.addColumn("Item Name | Brand | Type");
        dtm.addColumn("Price");
        dtm.addColumn("Quantity");
        dtm.addColumn("Remark");
        tblitem.setModel(dtm);
        setColumnWidth(0,30);
        setColumnWidth(1,260);
        setColumnWidth(2,20);
        setColumnWidth(3,10);
        setColumnWidth(4,50);
    }
    
    public void fillItem(String sql)
    { 
    	
        String strdataitem[]= new String[5];
        String strquery[]=new String[2];
        try
        {
            Statement ste = (Statement) con.createStatement();
            while(dtm.getRowCount()>0)
            {
         	   dtm.removeRow(0);
            }
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next())
            {
                strdataitem[0]=rs.getString(1);//itemid
                strquery=mySQLQueries.getMerchandise(rs.getString(2));//merid
                strdataitem[1]=rs.getString(3);//itemname
                strdataitem[1]+="|"+mySQLQueries.getBrandName(strquery[0]);//brandname
                strdataitem[1]+="|"+mySQLQueries.getTypeName(strquery[1]);//typename
                strdataitem[2]=rs.getString(4);//price
                strdataitem[3]=rs.getString(6);//qty
                strdataitem[4]=rs.getString(5);//remark
                dtm.addRow(strdataitem);
            }
            tblitem.setModel(dtm);
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
        
    }
    public void fillBrandType()
    {
        cbobrandname.addItem("-Selected-");
        String str[]= mySQLQueries.getNameForChoice("brand");
        for(int i=0 ; i<str.length ; i++)
            cbobrandname.addItem(str[i]);
        cbotypename.addItem("-Selected-");
         String str1[]= mySQLQueries.getNameForChoice("type");
        for(int j=0 ; j<str1.length ; j++)
            cbotypename.addItem(str1[j]);
    }

    public void getQuery(String[]merid)
    {

        if(merid.length!=0)
        for(int i=0 ; i<merid.length ; i++)
            fillItem("Select * from itemdetail where merid='"+merid[i]+"' order by itemid desc");
    }




}
