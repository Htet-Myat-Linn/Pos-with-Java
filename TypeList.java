package MasterData;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TypeList extends JDialog {
	private JButton btnPrint;
	private JPanel panel;
	private JTable tbltype;
	DefaultTableModel dtm = new DefaultTableModel();
	Statement ste = null ;
	Connection con = null ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TypeList dialog = new TypeList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TypeList() throws ClassNotFoundException {
		setTitle("Type List");
		setBounds(100, 100, 471, 338);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		 int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	     int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	     setLocation(centerX, centerY);
	     setResizable(false);
	     
		getContentPane().setLayout(null);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Type List:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 435, 277);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JButton btnClose = new JButton("Close");
				btnClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
						{	
							dispose();
						}
					}
				});
				btnClose.setBounds(336, 243, 89, 23);
				panel.add(btnClose);
			}
			{
				btnPrint = new JButton("Print");
				btnPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
				            tbltype.print();
				        }catch(Exception e1) {
				            JOptionPane.showMessageDialog(null, e1);
				        }

					}
				});
				btnPrint.setBounds(237, 243, 89, 23);
				panel.add(btnPrint);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 22, 415, 211);
				panel.add(scrollPane);
				{
					tbltype = new JTable();
					scrollPane.setViewportView(tbltype);
				}
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
        fillType();
    

	}
	 public void createtable()
	    {
	        dtm.addColumn("Type ID");
	        dtm.addColumn("Type Name");

	        tbltype.setModel(dtm);
	        setColumnWidth(0,30);
	        setColumnWidth(1,60);


}
	 public void setColumnWidth(int index , int width)
	    {
	        DefaultTableColumnModel tcm = (DefaultTableColumnModel)tbltype.getColumnModel();
	        TableColumn tc = tcm.getColumn(index);
	        tc.setPreferredWidth(width);
	    }
	    public void fillType()
	    {
	        String strdataitem[]=new String[2];
	        String strquery[]=new String[2];
	        try{
	            Statement ste = (Statement) con.createStatement();
	            String str = "select * from type order by typeid desc";
	            ResultSet rs = ste.executeQuery(str);
	            while(rs.next())
	            {
	                strdataitem[0]=rs.getString(1);

	                strdataitem[1]=rs.getString(2);

	               dtm.addRow(strdataitem);
	            }
	            tbltype.setModel(dtm);
	        }
	        catch(SQLException sqle)
	        {
	            System.out.println(sqle);
	        }
	    }
}
