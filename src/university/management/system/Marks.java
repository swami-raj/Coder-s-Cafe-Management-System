
package university.management.system;

/**
 *
 * @author swamiraj
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {
    
    String rollno;
    JButton cancel;
    
    Marks(String rollno){
        this.rollno=rollno;
        
        setSize(500,600);
        setLocation(500,100);
        setVisible(true);
        setLayout(null);
        
        getContentPane().setBackground(Color.gray);
        
        JLabel heading=new JLabel("Jaipur Engineering College");
        heading.setBounds(135,10,500,30);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);
        
        JLabel subheading=new JLabel("Result of Examination");
        subheading.setBounds(155,50,500,20);
        subheading.setFont(new Font("serif",Font.BOLD,18));
        add(subheading);
        
        JLabel lblrollno=new JLabel("Roll Number:  "+rollno);
        lblrollno.setBounds(65,100,500,30);
        lblrollno.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollno);
        
        JLabel lblsemester=new JLabel();
        lblsemester.setBounds(65,150,500,20);
        lblsemester.setFont(new Font("serif",Font.PLAIN,18));
        add(lblsemester);
        
        JLabel sub1=new JLabel();
        sub1.setBounds(100,200,500,20);
        sub1.setFont(new Font("serif",Font.PLAIN,18));
        add(sub1);
        
        JLabel sub2=new JLabel();
        sub2.setBounds(100,230,500,20);
        sub2.setFont(new Font("serif",Font.PLAIN,18));
        add(sub2);
        
        JLabel sub3=new JLabel();
        sub3.setBounds(100,260,500,20);
        sub3.setFont(new Font("serif",Font.PLAIN,18));
        add(sub3);
        
        JLabel sub4=new JLabel();
        sub4.setBounds(100,290,500,20);
        sub4.setFont(new Font("serif",Font.PLAIN,18));
        add(sub4);
        
        JLabel sub5=new JLabel();
        sub5.setBounds(100,320,500,20);
        sub5.setFont(new Font("serif",Font.PLAIN,18));
        add(sub5);
        
        try{
            connec c=new connec();
            ResultSet rs1=c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }
            ResultSet rs2=c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText()+"-----------------  "+rs2.getString("marks1"));
                sub2.setText(sub2.getText()+"-----------------  "+rs2.getString("marks2"));
                sub3.setText(sub3.getText()+"-----------------  "+rs2.getString("marks3"));
                sub4.setText(sub4.getText()+"-----------------  "+rs2.getString("marks4"));
                sub5.setText(sub5.getText()+"-----------------  "+rs2.getString("marks5"));
                lblsemester.setText("Semester:   "+rs2.getString("semester"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        cancel=new JButton("Cancel");
        cancel.setBounds(200,450,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
//        cancel.setOpaque(true);
        add(cancel);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args){
        new Marks("");
    }
    
}
