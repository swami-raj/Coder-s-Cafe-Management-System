
package university.management.system;

/**
 *
 * @author swamiraj
 */

import java.awt.Choice;
import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class LeaveStudentDetail extends JFrame implements ActionListener{
    
    Choice  crollno;
    JTable table;
    JButton search,print,update,add,cancel;
    
    LeaveStudentDetail(){
        getContentPane().setBackground(Color.gray);
        setLayout(null);
        
        JLabel heading=new JLabel ("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        crollno=new Choice();
        crollno.setBounds(180,20,150,20);
        add(crollno);
        
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        try{
            connec c=new connec();
            ResultSet rs=c.s.executeQuery("select *from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        table=new JTable();
        
         try{
            connec c=new connec();
            ResultSet rs=c.s.executeQuery("select *from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1200,600);
        add(jsp);
        
        
        
        
        setSize(1200,700);
        setLocation(150,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from studentleave where rollno='"+crollno.getSelectedItem()+"'";
            try{
                connec c=new connec();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print){
            try{
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);       
        }
    }
    
    public static void main(String[] args){
        new LeaveStudentDetail();
    }
    
}
