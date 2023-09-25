
package university.management.system;


/**
 *
 * @author swamiraj
 */
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,cancel;
    JTextField tfpass,tfusername;
    
    Login(){
        
        getContentPane().setLayout(new BorderLayout());
        setLayout(null);
       
        JLabel username=new JLabel("Username");
        username.setBounds(40, 20, 100, 20);
        add(username);
        
        tfusername=new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(40, 70, 100, 20);
        add(pass);
        
        tfpass=new JTextField();
        tfpass.setBounds(150,70,150,20);
        add(tfpass);
        
        login=new JButton("Login");
        login.setBounds(20,200,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.RED);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma",Font.BOLD,15));
        login.setOpaque(true);
        add(login); 
        
        
        cancel=new JButton("Cancel");
        cancel.setBounds(200,200,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.RED);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel.setOpaque(true);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 50, 200, 200);
        add(image);
        
        
        setSize(600,350);
        setLocation(450,300);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()==login){
            String username=tfusername.getText();
            String password=tfpass.getText();
            
            String query="select * from login where username='"+username+"'and password='"+password+"'";
            try{
                connec c=new connec();
                ResultSet rs=c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new project();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username and password");
                    setVisible(false);
                }
                c.s.close();
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
