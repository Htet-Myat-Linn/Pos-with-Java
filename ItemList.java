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

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemList extends JDialog {
	private JTable tblitem;
	private JButton btnPrint;
	private JButton btnClose;
	DefaultTableModel dtm = new DefaultTableModel();
	Statement ste = null ;
	Connection con = null ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ItemList dialog = new ItemList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ItemList() throws ClassNotFoundException {
		setBounds(100, 100, 639, 366);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
	     
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Item List:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 608, 305);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 24, 580, 240);
				panel.add(scrollPane);
				{
					tblitem = new JTable();
					scrollPane.setViewportView(tblitem);
				}
			}
			{
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
				btnPrint.setBounds(405, 275, 89, 23);
				panel.add(btnPrint);
			}
			{
				btnClose = new JButton("Close");
				btnClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
						{	
							dispose();
						}
					}
				});
				btnClose.setBounds(501, 275, 89, 23);
				panel.add(btnClose);
			}
		}
		try{
			clsDBConnection c=new clsDBConnection();
            con=c.getConnection();
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

		createtable();
		 fillItem();
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
       setColumnWidth(0,50);
       setColumnWidth(1,260);
       setColumnWidth(2,30);
       setColumnWidth(3,20);
       setColumnWidth(4,50);

   }

    public void fillItem()
    {
        String strdataitem[]=new String[5];
        String strquery[]=new String[2];
        try{
        	
            Statement ste = (Statement) con.createStatement();
            String str = "select * from itemdetail order by itemid desc";
            ResultSet rs = ste.executeQuery(str);
            while(rs.next())
            {
                strdataitem[0]=rs.getString(1);
                strquery = mySQLQueries.getMerchandise(rs.getString(2));
                strdataitem[1]=rs.getString(3);
               strdataitem[1]+="|"+mySQLQueries.getBrandName(strquery[0]);
               strdataitem[1]+="|"+mySQLQueries.getTypeName(strquery[1]);
               strdataitem[2]=rs.getString(4);
               strdataitem[3]=rs.getString(6);
               strdataitem[4]=rs.getString(5);
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
