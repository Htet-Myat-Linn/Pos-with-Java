package MasterData;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Statement;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class BrandList extends JDialog {
	private JButton btnprint;
	private JButton btnClose;
	private JTable tblbrand;
	private JScrollPane scrollPane;
	DefaultTableModel dtm = new DefaultTableModel();
	Statement ste = null ;
	Connection con = null ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BrandList dialog = new BrandList();
			   
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BrandList() throws ClassNotFoundException {
		setTitle("Brand List");
		setBounds(100, 100, 441, 308);
		getContentPane().setLayout(null);
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Brand List:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 405, 250);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnprint = new JButton("Print");
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            tblbrand.print();
		        }catch(Exception e1) {
		            JOptionPane.showMessageDialog(null, e1);
		        }

			}
		});
		btnprint.setBounds(208, 216, 89, 23);
		panel.add(btnprint);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(306, 216, 89, 23);
		panel.add(btnClose);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 385, 180);
		panel.add(scrollPane);
		
		tblbrand = new JTable();
		scrollPane.setViewportView(tblbrand);

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
      fillBrand();

	}

    public void createtable()
    {
        dtm.addColumn("Brand ID");
        dtm.addColumn("Brand Name");

        tblbrand.setModel(dtm);
        setColumnWidth(0,30);
        setColumnWidth(1,60);
    }
    public void fillBrand()
    {
        String strdataitem[]=new String[2];
        String strquery[]=new String[2];
        try{
            Statement ste = (Statement) con.createStatement();
            String str = "select * from brand order by brandid desc";
            ResultSet rs = ste.executeQuery(str);
            while(rs.next())
            {
                strdataitem[0]=rs.getString(1);

                strdataitem[1]=rs.getString(2);

               dtm.addRow(strdataitem);
            }
            tblbrand.setModel(dtm);
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
    }
    public void setColumnWidth(int index , int width)
    {
        DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblbrand.getColumnModel();
        TableColumn tc = tcm.getColumn(index);
        tc.setPreferredWidth(width);
    }

}
