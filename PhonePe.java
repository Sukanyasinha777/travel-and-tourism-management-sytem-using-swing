
package tourism.management.system;

import javax.swing.*;
import java.awt.event.*;


public class PhonePe extends JFrame implements ActionListener{
    
    PhonePe(){
        
        setBounds(200,100,800,550);
        
        JEditorPane pane=new JEditorPane();
        pane.setEditable(false);
        
        try{
            pane.setPage("https://www.phonepe.com");
            
        }catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html> could not load page error 404</html>");
        }
        
        JScrollPane sp=new JScrollPane(pane);
        getContentPane().add(sp);
        
        JButton back = new JButton("Back");
        back.setBounds(610,20,80,40);
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
       
            setVisible(false);
        
    }
    public static void main(String arg[]){
        new PhonePe();
    }
}
