
package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener{
   
    Choice chotel,cac,cfood;
    JTextField tfperson,tfdays;
    String username;
    JLabel labelusername,labelid,labelnum,labelphone,labelprice;
    JButton checkprice,bookhotel,back;
    
    BookHotel(String username){
        this.username=username;
      setBounds(150,100,1000,600); 
      setLayout(null);
      
      JLabel text = new JLabel("BOOK HOTEL");
      text.setBounds(100,10,300,30);
      text.setFont(new Font("Tahoma",Font.BOLD,30));
      add(text);
      
      JLabel lblusername=new JLabel("Username");
      lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblusername.setBounds(40,70,100,20);
       add(lblusername);
       
       labelusername=new JLabel();
       labelusername.setBounds(250,70,200,20);
       add(labelusername);
       
       JLabel lblhotel=new JLabel("Select Hotel");
       lblhotel.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblhotel.setBounds(40,110,200,20);
       add(lblhotel);
       
       chotel =new Choice();
       chotel.setBounds(250,110,200,20);
       add(chotel);
       
       try{
           
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from hotel");
           while(rs.next()){
               chotel.add(rs.getString("name"));
           }
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       JLabel lblnumber=new JLabel("Total Person");
       lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblnumber.setBounds(40,150,150,20);
       add(lblnumber);
       
       tfperson=new JTextField("1");
       tfperson.setBounds(250,150,200,25);
       add(tfperson);
       
       JLabel lbldays=new JLabel("No. of Days");
       lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
       lbldays.setBounds(40,190,150,20);
       add(lbldays);
       
       tfdays=new JTextField("1");
       tfdays.setBounds(250,190,200,25);
       add(tfdays);
       
        JLabel lblac=new JLabel("AC/Non-AC");
       lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblac.setBounds(40,230,150,20);
       add(lblac);
       
       cac =new Choice();
       cac.setBounds(250,230,200,20);
       cac.add("AC");
       cac.add("Non-AC");
       add(cac);
       
       JLabel lblfood=new JLabel("Food Included");
       lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblfood.setBounds(40,270,150,20);
       add(lblfood);
       
       cfood =new Choice();
       cfood.setBounds(250,270,200,20);
       cfood.add("Yes");
       cfood.add("No");
       add(cfood);
       
       JLabel lblid=new JLabel("Id");
       lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblid.setBounds(40,310,150,20);
       add(lblid);
       
       labelid=new JLabel();
       labelid.setBounds(250,310,200,25);
       add(labelid);
       
       JLabel lblnum=new JLabel("Number");
       lblnum.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblnum.setBounds(40,350,150,25);
       add(lblnum);
       
       labelnum=new JLabel();
       labelnum.setBounds(250,350,150,25);
       add(labelnum);
      
       JLabel lblphone=new JLabel("Phone");
       lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblphone.setBounds(40,390,150,20);
       add(lblphone);
       
       labelphone=new JLabel();
       labelphone.setBounds(250,390,200,25);
       add(labelphone);
       
       JLabel lblprice=new JLabel("Total Price");
       lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
       lblprice.setBounds(40,430,150,25);
       add(lblprice);
       
       labelprice=new JLabel();
       labelprice.setBounds(250,430,150,25);
       add(labelprice);
       
        try{
           Conn c=new Conn();
           String query="select * from customer where username='"+username+"'";
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next()){
               labelusername.setText(rs.getString("username"));
               labelid.setText(rs.getString("id"));
               labelnum.setText(rs.getString("number")); 
               labelphone.setText(rs.getString("phone"));
           }
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
        checkprice=new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookhotel=new JButton("Book Hotel");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200,490,120,25);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        add(back);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/def.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l12=new JLabel(i3);
        l12.setBounds(500,40,450,400);
        add(l12);
        
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            
            try{
                 Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
            
            while(rs.next()){
                int cost=Integer.parseInt(rs.getString("costperperson")); //cost per person 
                int ac=Integer.parseInt(rs.getString("acroom"));
                int food=Integer.parseInt(rs.getString("foodincluded"));
                
                int person=Integer.parseInt(tfperson.getText());
                int days=Integer.parseInt(tfdays.getText());
                
                String acSelected=cac.getSelectedItem();//check whether user selected ac or not
                String foodSelected=cfood.getSelectedItem();
                
                if(person*days>0){
                    int total=0;
                    total+=acSelected.equals("AC")?ac:0;
                    total+=foodSelected.equals("Yes") ? food : 0;
                    total+=cost;
                    total=total * person * days;
                    labelprice.setText("Rs "+total);
                            
                }else{
                    JOptionPane.showMessageDialog(null,"Please Enter A Valid Number");
                   
                }
                
            }
            
           }catch(Exception e){
            e.printStackTrace();
        }
            }
           else if(ae.getSource()==bookhotel){
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnum.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                
                
                JOptionPane.showMessageDialog(null, "Hotel Booked sucessfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String arg[]){
        new BookHotel("");
    }
}
