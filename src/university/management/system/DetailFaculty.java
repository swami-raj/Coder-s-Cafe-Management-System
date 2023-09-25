
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

public class DetailFaculty extends JFrame implements ActionListener{
    
    Choice  eid;
    JTable table;
    JButton search,print,update,add,cancel;
    
    DetailFaculty(){
        getContentPane().setBackground(Color.gray);
        setLayout(null);
        
        JLabel heading=new JLabel ("Search by Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        eid=new Choice();
        eid.setBounds(180,20,150,20);
        add(eid);
        
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        update=new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        add=new JButton("Add");
        add.setBounds(320,70,80,20);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        try{
            connec c=new connec();
            ResultSet rs=c.s.executeQuery("select *from teacher");
            while(rs.next()){
                eid.add(rs.getString("id"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        table=new JTable();
        
         try{
            connec c=new connec();
            ResultSet rs=c.s.executeQuery("select *from teacher");
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
            String query="select * from teacher where id='"+eid.getSelectedItem()+"'";
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
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateTeacherDetail();
        }
        else if(ae.getSource()==add){
            setVisible(false);
            new AddFaculty();
        }
        else if(ae.getSource()==cancel){
            setVisible(false);       
        }
    }
    
    public static void main(String[] args){
        new DetailFaculty();
    }
    
}
