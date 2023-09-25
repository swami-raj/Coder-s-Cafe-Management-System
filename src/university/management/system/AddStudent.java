
package university.management.system;

/**
 *
 * @author swamiraj
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener {
    
    JTextField tname,tfname,tadd,tmob,tmail,tmar,tmark,tadha;
    JLabel troll;
    JDateChooser datebi;
    JComboBox cbcourse,cbran;
    JButton submit,cancel;
    
    
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong()%9000L)+1000l);
    
    AddStudent(){
        getContentPane().setBackground(Color.gray);
        setSize(900,700);
        setLocation(350,500);
        setLayout(null);
        
        
        JLabel heading=new JLabel("New Student Details");
        heading.setBounds(340,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel name=new JLabel("Name");
        name.setBounds(70,120,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
        tname=new JTextField();
        tname.setBounds(230,120,180,30);
        add(tname);
        
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(450,120,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        
        tfname=new JTextField();
        tfname.setBounds(600,120,180,30);
        add(tfname);
        
        JLabel roll=new JLabel("Roll No");
        roll.setBounds(70,180,200,30);
        roll.setFont(new Font("serif",Font.BOLD,20));
        add(roll);
        
        troll=new JLabel("1543"+first4);
        troll.setBounds(230,180,180,30);
        troll.setFont(new Font("serif",Font.BOLD,20));
        add(troll);
        
        JLabel dobas=new JLabel("Date of birth");
        dobas.setBounds(450,180,200,30);
        dobas.setFont(new Font("serif",Font.BOLD,20));
        add(dobas);
        
        datebi=new JDateChooser();
        datebi.setBounds(600,180,180,30);
        add(datebi);
        
        JLabel addr=new JLabel("Address");
        addr.setBounds(70,240,200,30);
        addr.setFont(new Font("serif",Font.BOLD,20));
        add(addr);
        
        tadd=new JTextField();
        tadd.setBounds(230,240,180,30);
        add(tadd);
        
        JLabel mobi=new JLabel("Mobile No");
        mobi.setBounds(450,240,200,30);
        mobi.setFont(new Font("serif",Font.BOLD,20));
        add(mobi);
        
        tmob=new JTextField();
        tmob.setBounds(600,240,180,30);
        add(tmob);
        
        JLabel mail=new JLabel("Email");
        mail.setBounds(70,300,200,30);
        mail.setFont(new Font("serif",Font.BOLD,20));
        add(mail);
        
        tmail=new JTextField();
        tmail.setBounds(230,300,180,30);
        add(tmail);
        
        JLabel mark=new JLabel("X Marks(%)");
        mark.setBounds(450,300,200,30);
        mark.setFont(new Font("serif",Font.BOLD,20));
        add(mark);
        
        tmark=new JTextField();
        tmark.setBounds(600,300,180,30);
        add(tmark);
        
        JLabel mar=new JLabel("XII Marks(%)");
        mar.setBounds(70,360,200,30);
        mar.setFont(new Font("serif",Font.BOLD,20));
        add(mar);
        
        tmar=new JTextField();
        tmar.setBounds(230,360,180,30);
        add(tmar);
        
        JLabel adha=new JLabel("Aadhar No");
        adha.setBounds(450,360,200,30);
        adha.setFont(new Font("serif",Font.BOLD,20));
        add(adha);
        
        tadha=new JTextField();
        tadha.setBounds(600,360,180,30);
        add(tadha);
        
        JLabel cour=new JLabel("Course");
        cour.setBounds(70,420,200,30);
        cour.setFont(new Font("serif",Font.BOLD,20));
        add(cour);
        
        String course[]={"B.tech","M.tech","BBA","Bca","Bsc","Msc","MBA","M.com"};
        cbcourse=new JComboBox(course);
        cbcourse.setBounds(230,420,180,30);
        cbcourse.setBackground(Color.white);
        add(cbcourse);
        
        JLabel bran=new JLabel("Branch");
        bran.setBounds(450,420,200,30);
        bran.setFont(new Font("serif",Font.BOLD,20));
        add(bran);
        
        String branch[]={"Computer Science and Engineering","Civil Engineering","Electrical Engineering","Mechanical Engineering","Artificial Intelligence","Electrical and Electronics Engineering","Electronics & Communication"};
        cbran=new JComboBox(branch);
        cbran.setBounds(600,420,180,30);
        cbran.setBackground(Color.white);
        add(cbran);
        
        submit=new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.RED);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
//        submit.setOpaque(true);
        add(submit); 
        
        cancel=new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
//        cancel.setOpaque(true);
        add(cancel);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            
            String name=tname.getText();
            String fname=tfname.getText();
            String rollno=troll.getText();
            String dob=((JTextField) datebi.getDateEditor().getUiComponent()).getText();
            String address=tadd.getText();
            String phone=tmob.getText();
            String email=tmail.getText();
            String x=tmark.getText();
            String xii=tmar.getText();
            String aadhar=tadha.getText();
            String course=(String)cbcourse.getSelectedItem();
            String branch=(String)cbran.getSelectedItem();
            
            try{
                String query="insert into student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
                
                connec c=new connec();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Student details Inserted successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddStudent();
    }
}
