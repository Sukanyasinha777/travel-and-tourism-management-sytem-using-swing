
package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    
    
    About(){
  
        setBounds(200,100,550,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1=new JLabel("About");
        l1.setBounds(100,10,200,30);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        String s="About Project \n" +
                "\n"+
                "The objective of this travel and tourism management system project is to develope a program which helps user to book a whole package of travelling \n"+
                "\nThis application helps in accessing the information related to a travel to the perticuler place \n"+
                "Advantage of Project: \n"
                +"Simplifies the manual work \n"+
                "It minimizes the documantation work \n"+
                "Provides friendly environment \n"+
                "Travelers details can be provided \n"
                 ;
        
        TextArea area=new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);
        
        JButton back =new JButton("Back");
        back.setBounds(200,420,100,25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String arg[]){
        new About();
    }
}
