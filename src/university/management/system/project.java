
package university.management.system;

/**
 * @author swamiraj
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener {
    
    project(){
        setSize(1560,850);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/n3.jpg"));
        Image i2=i1.getImage().getScaledInstance(1560, 850, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        JMenuBar mb=new JMenuBar();
        
        // new information
        
        JMenu newinfo=new JMenu("New Information");
        newinfo.setForeground(Color.BLUE);
        mb.add(newinfo);
        
        JMenuItem faculty=new JMenuItem ("New Head Information");
        faculty.setBackground(Color.white);
        faculty.addActionListener(this);
        newinfo.add(faculty);
        
        JMenuItem students=new JMenuItem ("New Students Information");
        students.setBackground(Color.white);
        students.addActionListener(this);
        newinfo.add(students);
        
        //Details
        
        JMenu detail=new JMenu("View Details");
        detail.setForeground(Color.RED);
        mb.add(detail);
        
        JMenuItem facultydetail=new JMenuItem ("View Head Information");
        facultydetail.setBackground(Color.white);
        facultydetail.addActionListener(this);
        detail.add(facultydetail);
        
        JMenuItem studentsdetail=new JMenuItem ("View Students Information");
        studentsdetail.addActionListener(this);
        studentsdetail.setBackground(Color.white);
        detail.add(studentsdetail);
        
        //Leave
        
        JMenu Leave=new JMenu("Leave");
        detail.setForeground(Color.RED);
        mb.add(Leave);
        
        JMenuItem facultyLeave=new JMenuItem ("Head Leave");
        facultyLeave.setBackground(Color.white);
        facultyLeave.addActionListener(this);
        Leave.add(facultyLeave);
        
        JMenuItem studentsLeave=new JMenuItem ("Students Leave");
        studentsLeave.setBackground(Color.white);
        studentsLeave.addActionListener(this);
        Leave.add(studentsLeave);
        
        //Leave details
        
        JMenu Leavedetails=new JMenu("Leave Details");
        detail.setForeground(Color.RED);
        mb.add(Leavedetails);
        
        JMenuItem facultyLeavedetails=new JMenuItem ("head Leave Details");
        facultyLeavedetails.setBackground(Color.white);
        facultyLeavedetails.addActionListener(this);
        Leavedetails.add(facultyLeavedetails);
        
        JMenuItem studentsLeavedetails=new JMenuItem ("Students Leave Details");
        studentsLeavedetails.setBackground(Color.white);
        studentsLeavedetails.addActionListener(this);
        Leavedetails.add(studentsLeavedetails);
        
        //Exam details
        
        JMenu Exam=new JMenu("Examination");
        Exam.setForeground(Color.RED);
        mb.add(Exam);
        
        JMenuItem marksdetails=new JMenuItem ("Students Marks Details");
        marksdetails.setBackground(Color.white);
        marksdetails.addActionListener(this);
        Exam.add(marksdetails);
        
        JMenuItem entermarks=new JMenuItem ("Enter Marks Details");
        entermarks.setBackground(Color.white);
        entermarks.addActionListener(this);
        Exam.add(entermarks);
        
        //Update details
        
        JMenu updateinfo=new JMenu("Update Info");
        updateinfo.setForeground(Color.RED);
        mb.add(updateinfo);
        
        JMenuItem updatefaculty=new JMenuItem ("Update Head Details");
        updatefaculty.setBackground(Color.white);
        updatefaculty.addActionListener(this);
        updateinfo.add(updatefaculty);
        
        JMenuItem updatestudent=new JMenuItem ("Update Students Details");
        updatestudent.setBackground(Color.white);
        updatestudent.addActionListener(this);
        updateinfo.add(updatestudent);
        
//        //FEE
//        
//        JMenu fee=new JMenu("Fee Details");
//        fee.setForeground(Color.RED);
//        mb.add(fee);
//        
//        JMenuItem feestruct=new JMenuItem ("Fee Structure");
//        feestruct.setBackground(Color.white);
//        fee.add(feestruct);
//        
//        JMenuItem feeform=new JMenuItem ("Students Fee Form");
//        feeform.setBackground(Color.white);
//        fee.add(feeform);
        
        //Utility
        
        JMenu Utility=new JMenu("Utility");
        Utility.setForeground(Color.RED);
        mb.add(Utility);
        
        JMenuItem notepad=new JMenuItem ("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        Utility.add(notepad);
        
        JMenuItem calc=new JMenuItem ("Calculator");
        calc.setBackground(Color.white);
        calc.addActionListener(this);
        Utility.add(calc);
        
        //Exit
        
        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        JMenuItem ex=new JMenuItem ("Exit");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);
       
        
        setJMenuBar(mb);
        
        
        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae){
        String s=ae.getActionCommand();
        
        if(s.equals("Exit")){
            setVisible(false);
        }
        else if(s.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("open -a Calculator");
            }
                
            catch(Exception e){
            e.printStackTrace();
            }
        }
        else if(s.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("open -a TextEdit");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(s.equals("New Head Information")){
            new AddFaculty();
        }
        else if(s.equals("New Students Information")){
            new AddStudent();
        }
        else if(s.equals("View Head Information")){
            new DetailFaculty();
        }
        else if(s.equals("View Students Information")){
            new DetailStudent();
        }
        else if(s.equals("Head Leave")){
            new FacultyLeave();
        }
        else if(s.equals("Students Leave")){
            new StudentLeave();
        }
        else if(s.equals("head Leave Details")){
            new LeaveTeacherDetail();
        }
        else if(s.equals("Students Leave Details")){
            new LeaveStudentDetail();
        }
        else if(s.equals("Update Head Details")){
            new UpdateTeacherDetail();
        }
        else if(s.equals("Update Students Details")){
            new UpdateStudentDetail();
        }
        else if(s.equals("Enter Marks Details")){
            new EnterMarks();
        }
        else if(s.equals("Students Marks Details")){
            new MarksDetail();
        }
    }
    
    
    public static void main(String[] args){
        
        new project();
    }
    
}
