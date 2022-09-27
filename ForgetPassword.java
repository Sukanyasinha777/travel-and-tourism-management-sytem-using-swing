
package tourism.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
    
    JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
    JButton search,retrive,back;
    
    ForgetPassword(){
        setBounds(320,200,850,380); //combo of setsize and setlocation
        getContentPane().setBackground(Color.WHITE); //getcontentpane take the whole frame and it will color it whith white color
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forget_pass.png"));//taking image from workspace
        Image i2= i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); //scaling the image that it would be fit 
        ImageIcon i3=new ImageIcon(i2); //converting into icon
        JLabel image =new JLabel(i3); //converting into label
        image.setBounds(580,70,200,200); //setting bounderies
        add(image); //adding image on the pane
        

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
        JLabel lblusername=new JLabel("Username"); //creating a label with name username
        lblusername.setBounds(40,20,100,25);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14)); //setting font and style
        p1.add(lblusername);
        
        tfusername=new JTextField();
        tfusername.setBounds(220,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search=new JButton("Search"); //creating search button
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
       JLabel lblname=new JLabel("Name"); //creating a label with name name
        lblname.setBounds(40,60,100,25);
        lblname.setFont(new Font("Tahoma",Font.BOLD,14)); //setting font and style
        p1.add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(220,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblquestion=new JLabel("Security Question"); //creating a label 
        lblquestion.setBounds(40,100,150,25);
        lblquestion.setFont(new Font("Tahoma",Font.BOLD,14)); //setting font and style
        p1.add(lblquestion);
        
        tfquestion=new JTextField();
        tfquestion.setBounds(220,100,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel lblanswer=new JLabel("Answer"); //creating a label 
        lblanswer.setBounds(40,140,150,25);
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14)); //setting font and style
        p1.add(lblanswer);
        
        tfanswer=new JTextField();
        tfanswer.setBounds(220,140,150,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrive=new JButton("Retrive"); //creating search button
        retrive.setBackground(Color.GRAY);
        retrive.setForeground(Color.WHITE);
        retrive.setBounds(380,140,100,25);
        retrive.addActionListener(this);
        p1.add(retrive);
        
        JLabel lblpassword=new JLabel("Password"); //creating a label 
        lblpassword.setBounds(40,180,150,25);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14)); //setting font and style
        p1.add(lblpassword);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(220,180,150,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back=new JButton("Back"); //creating search button
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource()==search){
            
            try{
                String query="select * from account where username='"+tfusername.getText()+"'";
                Conn c= new Conn();
                
               ResultSet rs= c.s.executeQuery(query); //return the whole tuple
               while(rs.next()){ //trying to take only wanted data from tuple
                  tfname.setText(rs.getString("name")); //putting value into textfield by setText 
                  tfquestion.setText(rs.getString("security"));
                   
               }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==retrive){
            try{
                String query="select * from account where answer='"+tfanswer.getText()+"'AND username='"+tfusername.getText()+"'"; //if many user having the same answer then checking for both
                Conn c= new Conn();
                
               ResultSet rs= c.s.executeQuery(query); //return the whole tuple
               while(rs.next()){ //trying to take only wanted data from tuple
                  tfpassword.setText(rs.getString("password")); //putting value into textfield by setText 
                  
                   
               }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }
 public static void main(String arg[]){
     new ForgetPassword();
 }   
}
