package tourism.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //for actionlisterner


public class Signup extends JFrame implements ActionListener{
 
    JButton create,back;
    JTextField tfname,tfusername,tfpassword,tfanswer;
    Choice security;
    
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);
        
         tfusername=new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
         JLabel lblname=new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpassword.setBounds(50,100,125,25);
        p1.add(lblpassword);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lblsecurity=new JLabel("Security Questions");
        lblsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
        lblsecurity.setBounds(50,140,125,25);
        p1.add(lblsecurity);
        
        security =new Choice();
        security.add("fav fruit");
        security.add("fav marvel");
        security.add("your nickname");
        security.add("your lucky number");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
         JLabel lblanswer=new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lblanswer.setBounds(50,180,125,25);
        p1.add(lblanswer);
        
        tfanswer=new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        create =new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this); //for creating event on click of create button
        p1.add(create);
        
         back =new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.addActionListener(this); //for creating event and it will gonna call actionPerfomed method implicitely
        p1.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signin.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae )//must override for ActionListner
    {
        if(ae.getSource()==create){
        String username=tfusername.getText(); //for taking text entered from login/signup
        String name=tfname.getText();
        String password=tfpassword.getText();
        String question=security.getSelectedItem();//for taking values from dropdown
        String answer=tfanswer.getText();
        
        String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')" ; //inserting into sql
        try{
            Conn c=new Conn();//for making connection which we had already made
            c.s.executeUpdate(query); //passing query to the statement...update is because this is dml command
            
            JOptionPane.showMessageDialog(null,"Account Created succesfully");//giving ack to user that data is succesfully entered
            setVisible(false);
            new Login();
            
        }catch(Exception e){
            e.getStackTrace();
        }
        
        }else if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String args[]){
        new Signup();
    }
}
