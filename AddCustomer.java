
package tourism.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername ,labelname,labelgender;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphoneno;
    JRadioButton rmale,rfemale;
    JButton add,back;
    
    AddCustomer(String username){
        setBounds(250,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
         JLabel text =new JLabel("ADD CUSTOMER ");
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
        
        comboid=new JComboBox(new String[] {"Passport", "Aadhar card", "Voter id", "PAN Card"});//dropdown menu with JComboBox
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
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
        
        rmale=new JRadioButton("Male"); //creating radio button
        rmale.setBounds(220,210,70,25);
        rmale.setBackground( Color.WHITE);
        add(rmale);
        
        rfemale=new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground( Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg=new ButtonGroup(); //for selection one at a time so we grouped the buttons together
        bg.add(rmale);
        bg.add(rfemale);
       
        
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
        
        JLabel elab= new JLabel();
        elab.setBounds(390,340,70,10);
        add(elab);
        
    /**
     *
     * @param e
     */
    /*@Override
    public void keyTyped(KeyEvent e){
        
    }
*/
        
        String pattern="^[a-zA-Z0-9]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
        Pattern patt=Pattern.compile(pattern);
        Matcher match = patt.matcher(tfemail.getText());
        if(!match.matches()){
            elab.setText("incorrect");
        }else{
             elab.setText(null);
        }
           
        
        
        JLabel lblphoneno=new JLabel("Phone No");
        lblphoneno.setBounds(30,370,150,25);
        add(lblphoneno);
        
        tfphoneno = new JTextField();
        tfphoneno.setBounds(220,370,150,25);
        add(tfphoneno);
        
        JLabel plab= new JLabel();
        plab.setBounds(390,380,70,10);
        add(plab);
        
        String pattern1="^[0-9]{0,12}$";
        Pattern patt1=Pattern.compile(pattern1);
        Matcher match1 = patt1.matcher(tfphoneno.getText());
        if(!match1.matches()){
            plab.setText("incorrect");
        }else{
             plab.setText(null);
        }
        
        add=new JButton("Add");
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
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/customer.jpg"));
        Image i2 =i1.getImage().getScaledInstance(350, 350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(400,10,450,420);
        add(image);
        
        try{
            Conn c=new Conn();
           ResultSet rs= c.s.executeQuery("select * from account where username='"+username+"'");
           while(rs.next()){
               labelusername.setText(rs.getString("Username"));
               labelname.setText(rs.getString("Name"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username=labelusername.getText();
            String id=(String)comboid.getSelectedItem();//returning object to we converted into string
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender=null;
            if(rmale.isSelected()){
                gender="male";
                
            }else{
                gender="female";
            }
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phone=tfphoneno.getText();
            String email=tfemail.getText();
            
            try{
             Conn c=new Conn();
             String query="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+email+"','"+phone+"')";
             c.s.executeUpdate(query);
             
             JOptionPane.showMessageDialog(null,"Customer Details Added Sucessfully");
             setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
 public static void main(String arg []){
     new AddCustomer("");
 }   
}
