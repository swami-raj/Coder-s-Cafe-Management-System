
package university.management.system;

/**
 *
 * @author swamiraj
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateTeacherDetail extends JFrame implements ActionListener {
    
    JTextField tname,tfname,tadd,tmob,tmail,tadha,cbcourse,cbran;
    JLabel tid;
    JButton submit,cancel;
    Choice  emid;
    
    
    UpdateTeacherDetail(){
        getContentPane().setBackground(Color.gray);
        setSize(900,700);
        setLocation(350,500);
        setLayout(null);
        
        
        JLabel heading=new JLabel("Update Teacher Details");
        heading.setBounds(340,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel lblrollno=new JLabel ("Select Employee ID");
        lblrollno.setBounds(50,70,200,20);
        lblrollno.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollno);
        
        emid=new Choice();
        emid.setBounds(250,70,200,20);
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
        
        JLabel name=new JLabel("Name");
        name.setBounds(70,120,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
        tname=new JTextField();
        tname.setBounds(230,120,180,30);
        tname.setFont(new Font("serif",Font.PLAIN,20));
        add(tname);
        
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(450,120,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        
        tfname=new JTextField();
        tfname.setBounds(600,120,180,30);
        tfname.setFont(new Font("serif",Font.PLAIN,20));
        add(tfname);
        
        JLabel roll=new JLabel("Employee ID");
        roll.setBounds(70,180,200,30);
        roll.setFont(new Font("serif",Font.BOLD,20));
        add(roll);
        
        tid=new JLabel();
        tid.setBounds(230,180,180,30);
        tid.setFont(new Font("serif",Font.PLAIN,20));
        add(tid);
        
        JLabel dobas=new JLabel("Date of birth");
        dobas.setBounds(450,180,200,30);
        dobas.setFont(new Font("serif",Font.BOLD,20));
        add(dobas);
        
        JLabel datebi=new JLabel();
        datebi.setBounds(600,180,180,30);
        datebi.setFont(new Font("serif",Font.PLAIN,20));
        add(datebi);
        
        JLabel addr=new JLabel("Address");
        addr.setBounds(70,240,200,30);
        addr.setFont(new Font("serif",Font.BOLD,20));
        add(addr);
        
        tadd=new JTextField();
        tadd.setBounds(230,240,180,30);
        tadd.setFont(new Font("serif",Font.PLAIN,20));
        add(tadd);
        
        JLabel mobi=new JLabel("Mobile No");
        mobi.setBounds(450,240,200,30);
        mobi.setFont(new Font("serif",Font.BOLD,20));
        add(mobi);
        
        tmob=new JTextField();
        tmob.setBounds(600,240,180,30);
        tmob.setFont(new Font("serif",Font.PLAIN,20));
        add(tmob);
        
        JLabel mail=new JLabel("Email");
        mail.setBounds(70,300,200,30);
        mail.setFont(new Font("serif",Font.BOLD,20));
        add(mail);
        
        tmail=new JTextField();
        tmail.setBounds(230,300,180,30);
        tmail.setFont(new Font("serif",Font.PLAIN,20));
        add(tmail);
        
        JLabel mark=new JLabel("X Marks(%)");
        mark.setBounds(450,300,200,30);
        mark.setFont(new Font("serif",Font.BOLD,20));
        add(mark);
        
        JLabel tmark=new JLabel();
        tmark.setBounds(600,300,180,30);
        tmark.setFont(new Font("serif",Font.PLAIN,20));
        add(tmark);
        
        JLabel mar=new JLabel("XII Marks(%)");
        mar.setBounds(70,360,200,30);
        mar.setFont(new Font("serif",Font.BOLD,20));
        add(mar);
        
        JLabel tmar=new JLabel();
        tmar.setBounds(230,360,180,30);
        tmar.setFont(new Font("serif",Font.PLAIN,20));
        add(tmar);
        
        JLabel adha=new JLabel("Aadhar No");
        adha.setBounds(450,360,200,30);
        adha.setFont(new Font("serif",Font.BOLD,20));
        add(adha);
        
        tadha=new JTextField();
        tadha.setBounds(600,360,180,30);
        tadha.setFont(new Font("serif",Font.PLAIN,20));
        add(tadha);
        
        JLabel cour=new JLabel("Education");
        cour.setBounds(70,420,200,30);
        cour.setFont(new Font("serif",Font.BOLD,20));
        add(cour);
        
        cbcourse=new JTextField();
        cbcourse.setBounds(230,420,180,30);
        cbcourse.setFont(new Font("serif",Font.PLAIN,20));
        cbcourse.setBackground(Color.white);
        add(cbcourse);
        
        JLabel bran=new JLabel("Department");
        bran.setBounds(450,420,200,30);
        bran.setFont(new Font("serif",Font.BOLD,20));
        add(bran);
        
        cbran=new JTextField();
        cbran.setBounds(600,420,180,30);
        cbran.setFont(new Font("serif",Font.PLAIN,20));
        cbran.setBackground(Color.white);
        add(cbran);
        
        try{
            connec c=new connec();
            String query="select * from teacher where id='"+emid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tid.setText(rs.getString("id"));
                datebi.setText(rs.getString("dob"));
                tadd.setText(rs.getString("address"));
                tmob.setText(rs.getString("phone"));
                tmail.setText(rs.getString("email"));
                tmark.setText(rs.getString("x"));
                tmar.setText(rs.getString("xii"));
                tadha.setText(rs.getString("aadhar"));
                cbcourse.setText(rs.getString("qualification"));
                cbran.setText(rs.getString("department"));
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        emid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
            connec c=new connec();
            String query="select * from teacher where id='"+emid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tid.setText(rs.getString("id"));
                datebi.setText(rs.getString("dob"));
                tadd.setText(rs.getString("address"));
                tmob.setText(rs.getString("phone"));
                tmail.setText(rs.getString("email"));
                tmark.setText(rs.getString("x"));
                tmar.setText(rs.getString("xii"));
                tadha.setText(rs.getString("aadhar"));
                cbcourse.setText(rs.getString("qualification"));
                cbran.setText(rs.getString("department"));
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            }
        });
        
        
        submit=new JButton("Update");
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
            String id=tid.getText();
            String fname=tfname.getText();
            String address=tadd.getText();
            String phone=tmob.getText();
            String email=tmail.getText();
            String aadhar=tadha.getText();
            String course=cbcourse.getText();
            String branch=cbran.getText();
            
            try{
                String query="update teacher set name='"+name+"',fname='"+fname+"',address='"+address+"',phone='"+phone+"',email='"+email+"',aadhar='"+aadhar+"',qualification='"+course+"',department='"+branch+"'where id='"+id+"'";
                
                connec c=new connec();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Teacher details Updated successfully");
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
        new UpdateTeacherDetail();
    }
}
