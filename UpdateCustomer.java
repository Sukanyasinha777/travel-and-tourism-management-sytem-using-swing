
package tourism.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername ,labelname,labelgender;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphoneno,tfid,tfgender;
    JRadioButton rmale,rfemale;
    JButton add,back;
    
    UpdateCustomer(String username){
        setBounds(300,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text =new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,10,300,25);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid=new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
         tfid = new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        labelname=new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        labelgender=new JLabel("Gender");
        labelgender.setBounds(30,210,150,25);
        add(labelgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);
       
        
        JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        
        JLabel lbladdress=new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);
        
        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(30,330,150,25);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220,330,150,25);
        add(tfemail);
        
        JLabel lblphoneno=new JLabel("Phone No");
        lblphoneno.setBounds(30,370,150,25);
        add(lblphoneno);
        
        tfphoneno = new JTextField();
        tfphoneno.setBounds(220,370,150,25);
        add(tfphoneno);
        
        add=new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);//clicked event
        add(add);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/cust.jpg"));
        Image i2 =i1.getImage().getScaledInstance(300, 350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(380,10,500,450);
        add(image);
        
        try{
            Conn c=new Conn();
           ResultSet rs= c.s.executeQuery("select * from customer where username='"+username+"'");
           while(rs.next()){
               labelusername.setText(rs.getString("Username"));
               labelname.setText(rs.getString("Name"));
               tfid.setText(rs.getNString("id"));
               tfnumber.setText(rs.getNString("number"));
               tfgender.setText(rs.getNString("gender"));
               tfcountry.setText(rs.getNString("country"));
               tfaddress.setText(rs.getNString("address"));
               tfemail.setText(rs.getNString("email"));
               tfphoneno.setText(rs.getNString("phone"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username=labelusername.getText();
            String id=tfid.getText();
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender=tfgender.getText();
            
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphoneno.getText();
            String email=tfemail.getText();
            
            try{
             Conn c=new Conn();
             String query="update customer set username='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',email='"+email+"',phone='"+phone+"'";
             c.s.executeUpdate(query);
             
             JOptionPane.showMessageDialog(null,"Customer Details Updated Sucessfully");
             setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
 public static void main(String arg []){
     new UpdateCustomer("");
 }   
}
