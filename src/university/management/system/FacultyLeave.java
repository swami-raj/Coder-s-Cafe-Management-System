
package university.management.system;

/**
 *
 * @author swamiraj
 */
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class FacultyLeave extends JFrame implements ActionListener{
    
    Choice  emid,ctime;
    JDateChooser datebi;
    JButton submit,cancel;
    
    FacultyLeave(){
    setSize(500,500);
    setLocation(500,100);
    setLayout(null);
    getContentPane().setBackground(Color.gray);
    
    JLabel heading=new JLabel ("Apply Leave");
    heading.setBounds(40,50,300,30);
    heading.setFont(new Font("Tahoma",Font.BOLD,20));
    add(heading);
    
    
    JLabel rollnum=new JLabel ("Search by Employee ID");
    rollnum.setBounds(30,100,200,20);
    rollnum.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(rollnum);
    
    emid=new Choice();
    emid.setBounds(250,100,200,20);
    add(emid);
    
    try{
        connec c=new connec();
        ResultSet rs=c.s.executeQuery("select *from teacher");
        while(rs.next()){
           emid.add(rs.getString("id"));
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    JLabel lbldate=new JLabel ("Date");
    lbldate.setBounds(30,180,200,20);
    lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(lbldate);
    
    datebi=new JDateChooser();
    datebi.setBounds(150,180,200,25);
    add(datebi);
    
    JLabel time=new JLabel ("Time Duration");
    time.setBounds(30,250,125,20);
    time.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(time);
    
    ctime=new Choice();
    ctime.setBounds(150,250,250,20);
    ctime.add("Full Day");
    ctime.add("Half Day");
    add(ctime);
    
    submit=new JButton("Submit");
        submit.setBounds(120,350,120,30);
        submit.setBackground(Color.RED);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
//        submit.setOpaque(true);
        add(submit); 
        
        cancel=new JButton("Cancel");
        cancel.setBounds(250,350,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
//        cancel.setOpaque(true);
        add(cancel);
    
    setVisible(true);
}
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()==submit){
            String emmid=emid.getSelectedItem();
            String date =((JTextField)datebi.getDateEditor().getUiComponent()).getText();
            String duration=ctime.getSelectedItem();
            
            String query = "insert into leaveteacher values('"+emmid+"','"+date+"','"+duration+"')";
            
            try{
                connec c=new connec();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
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
        new FacultyLeave();
    }
}
