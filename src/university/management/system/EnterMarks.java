
package university.management.system;

/**
 *
 * @author swamiraj
 */

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener{
    
    Choice  crollno;
    JButton submit,cancel;
    JComboBox cbsemester;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    
    EnterMarks(){
        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.gray);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,95,400,300);
        add(image);
        
        JLabel heading=new JLabel("Enter Marks of Student");
        heading.setBounds(340,0,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel lblrollno=new JLabel ("Select Roll Number");
        lblrollno.setBounds(50,70,200,20);
        lblrollno.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollno);
        
        crollno=new Choice();
        crollno.setBounds(250,70,200,20);
        add(crollno);
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
        
        JLabel seme=new JLabel ("Choose Semester");
        seme.setBounds(50,100,200,20);
        seme.setFont(new Font("serif",Font.PLAIN,20));
        add(seme);
        
        String semester[]={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        cbsemester=new JComboBox(semester);
        cbsemester.setBounds(250,100,200,20);
        add(cbsemester);
        
        JLabel sub=new JLabel ("Enter Subject");
        sub.setBounds(90,150,200,40);
        sub.setFont(new Font("serif",Font.PLAIN,20));
        add(sub);
        
        JLabel marks=new JLabel ("Enter Marks");
        marks.setBounds(310,150,200,40);
        marks.setFont(new Font("serif",Font.PLAIN,20));
        add(marks);
        
        tfsub1=new JTextField();
        tfsub1.setBounds(40,190,200,30);
        add(tfsub1);
        
        tfsub2=new JTextField();
        tfsub2.setBounds(40,220,200,30);
        add(tfsub2);
        
        tfsub3=new JTextField();
        tfsub3.setBounds(40,250,200,30);
        add(tfsub3);
        
        tfsub4=new JTextField();
        tfsub4.setBounds(40,280,200,30);
        add(tfsub4);
        
        tfsub5=new JTextField();
        tfsub5.setBounds(40,310,200,30);
        add(tfsub5);
        
        tfmarks1=new JTextField();
        tfmarks1.setBounds(250,190,200,30);
        add(tfmarks1);
        
        tfmarks2=new JTextField();
        tfmarks2.setBounds(250,220,200,30);
        add(tfmarks2);
        
        tfmarks3=new JTextField();
        tfmarks3.setBounds(250,250,200,30);
        add(tfmarks3);
        
        tfmarks4=new JTextField();
        tfmarks4.setBounds(250,280,200,30);
        add(tfmarks4);
        
        tfmarks5=new JTextField();
        tfmarks5.setBounds(250,310,200,30);
        add(tfmarks5);
        
        submit=new JButton("Submit");
        submit.setBounds(100,400,120,30);
        submit.setBackground(Color.RED);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
//        submit.setOpaque(true);
        add(submit); 
        
        cancel=new JButton("Cancel");
        cancel.setBounds(250,400,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
//        cancel.setOpaque(true);
        add(cancel);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                connec c=new connec();
                
                String query1="insert into subject values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";
                String query2="insert into marks values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Marks inserted sucesfully");
                setVisible(false);
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String [] args){
        new EnterMarks();
    }
    
}
