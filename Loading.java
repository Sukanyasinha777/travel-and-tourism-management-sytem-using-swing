
package tourism.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    
    Thread t;
    JProgressBar  bar;
    String username;
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max=bar.getMaximum(); //100
                int value=bar.getValue();
                
                if(value<max){ //101<100
                    bar.setValue(bar.getValue()+1);
                   
                   
                }else{
                    setVisible(false);
                    //new class object
                     new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    Loading(String username){
        this.username=username;
        t=new Thread(this);
        
        setBounds(350,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.BOLD,35));
        add(text);
        
        bar=new JProgressBar();//progrss bar
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading=new JLabel("Loading, Please Wait");
        loading.setBounds(220,130,180,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Tahoma",Font.BOLD,16));
        add(loading);
        
        JLabel lblusername=new JLabel("Welcome " + username);
        lblusername.setBounds(20,310,400,40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblusername);
        
        t.start();
        setVisible(true);
    }
    
    public static void main(String arg[]){
        new Loading("");
    }
}
