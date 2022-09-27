/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourism.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard  extends JFrame implements ActionListener{
    
    String username;
    JButton addPersonalDetails,viewPersonalDetails,updatePersonalDetails,viewPackages,checkPackages,viewHotels,deletePersonalDetails,bookPackages;
    JButton destinations,bookHotel,viewBookedHotel,payment,calculator,notepad,about,exit;
    Dashboard(String username){
        this.username=username;
        //setBounds(0,0,1380,750);
        setExtendedState(JFrame.MAXIMIZED_BOTH); //if we dont know the size of screen
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1400,65);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/aero2.jpg"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(10,0,70,70);
        p1.add(icon);
        
        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(90,10,300,40);
        heading.setForeground((Color.WHITE));
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
         JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,250,800);
        add(p2);
        
        addPersonalDetails=new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,40);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails=new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,40,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,40));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        viewPersonalDetails=new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0,80,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,35));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        deletePersonalDetails=new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,120,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,35));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);
        
        checkPackages=new JButton("Check Package");
        checkPackages.setBounds(0,160,300,50);
        checkPackages.setBackground(new Color(0,0,102));
        checkPackages.setForeground(Color.white);
        checkPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkPackages.setMargin(new Insets(0,0,0,50));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);
        
        bookPackages=new JButton("Book Package");
        bookPackages.setBounds(0,200,300,50);
        bookPackages.setBackground(new Color(0,0,102));
        bookPackages.setForeground(Color.white);
        bookPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookPackages.setMargin(new Insets(0,0,0,50));
        bookPackages.addActionListener(this);
        p2.add(bookPackages);
        
        viewPackages=new JButton("View Package");
        viewPackages.setBounds(0,240,300,50);
        viewPackages.setBackground(new Color(0,0,102));
        viewPackages.setForeground(Color.white);
        viewPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPackages.setMargin(new Insets(0,0,0,50));
        viewPackages.addActionListener(this);
        p2.add(viewPackages);
        
        viewHotels=new JButton("View Hotels");
        viewHotels.setBounds(0,280,300,50);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.white);
        viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewHotels.setMargin(new Insets(0,0,0,50));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);
        
        bookHotel=new JButton("Book Hotels");
        bookHotel.setBounds(0,320,300,50);
        bookHotel.setBackground(new Color(0,0,102));
        bookHotel.setForeground(Color.white);
        bookHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookHotel.setMargin(new Insets(0,0,0,50));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);
        
        viewBookedHotel=new JButton("View Booked Hotels");
        viewBookedHotel.setBounds(0,360,300,50);
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.white);
        viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,40));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);
        
        destinations=new JButton("Destinations");
        destinations.setBounds(0,400,300,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,50));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payment=new JButton("Payment");
        payment.setBounds(0,440,300,50);
        payment.setBackground(new Color(0,0,102));
        payment.setForeground(Color.white);
        payment.setFont(new Font("Tahoma",Font.PLAIN,20));
        payment.setMargin(new Insets(0,0,0,50));
        payment.addActionListener(this);
        p2.add(payment);
        
        calculator=new JButton("Calculator");
        calculator.setBounds(0,480,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,50));
        calculator.addActionListener(this);
        p2.add(calculator);
        
        notepad=new JButton("Notepad");
        notepad.setBounds(0,520,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,50));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about=new JButton("About");
        about.setBounds(0,560,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,50));
        about.addActionListener(this);
        p2.add(about);
        
         exit=new JButton("Exit");
        exit.setBounds(0,600,300,50);
        exit.setBackground(new Color(0,0,102));
        exit.setForeground(Color.white);
        exit.setFont(new Font("Tahoma",Font.PLAIN,20));
        exit.setMargin(new Insets(0,0,0,50));
        exit.addActionListener(this);
        p2.add(exit);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/destination.jpg"));
        Image i5 =i4.getImage().getScaledInstance(1400,750,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image= new JLabel(i6);
        image.setBounds(0,0,1400,750);
        add(image);
        
        JLabel text=new JLabel("Tourism Management System");
        text.setBounds(500,70,1000,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma",Font.PLAIN,40));
        image.add(text);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addPersonalDetails){
            new AddCustomer(username);
        }else if(ae.getSource()==viewPersonalDetails){
            new ViewCustomer(username);
        }else if(ae.getSource()==updatePersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource()==checkPackages){
            new CheckPackage();
        }else if(ae.getSource()==viewPackages){
            new ViewPackage(username);
        }else if(ae.getSource()==bookPackages){
            new BookPackage(username);
        }else if(ae.getSource()==viewHotels){
            new CheckHotels();
        }else if(ae.getSource()==destinations){
            new Destination();
        }else if(ae.getSource()==bookHotel){
            new BookHotel(username);
        }else if(ae.getSource()==viewBookedHotel){
            new ViewBookedHotel(username);
        }else if(ae.getSource()==payment){
            new Payment();
        }else if(ae.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==about){
            new About();
        }else if(ae.getSource()==deletePersonalDetails){
            new DeleteDetails(username);
        }else{
           System.exit(0);
        }
    }
public static void main(String arg []){
    new Dashboard(" "); 
}  
 
}
