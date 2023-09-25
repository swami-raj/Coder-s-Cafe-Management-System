
package university.management.system;

/**
 *
 * @author swamiraj
 */

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class MarksDetail extends JFrame implements ActionListener {
    
    JTextField search;
    JButton submit,cancel;
    JTable table;
    
    MarksDetail(){
        setSize(1300,555);
        setLocation(100,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.gray);
        
        JLabel heading=new JLabel("Check Result");
        heading.setBounds(400,0,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        search =new JTextField();
        search.setBounds(80,90,210,30);
        search.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(search);
        
        submit=new JButton("Result");
        submit.setBounds(300,90,120,30);
        submit.setBackground(Color.RED);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
//        submit.setOpaque(true);
        add(submit); 
        
        cancel=new JButton("Back");
        cancel.setBounds(450,90,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
//        cancel.setOpaque(true);
        add(cancel);
        
        table =new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));
        
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,130,1300,300);
        add(jsp);
        
        try{
            connec c=new connec();
            ResultSet rs=c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        
        
        setVisible(true);
        
         
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            setVisible(false);
            new Marks(search.getText());
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new MarksDetail();
    }
}
