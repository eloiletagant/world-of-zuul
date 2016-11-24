import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener; 

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Scanner;

public class Interface extends JFrame {
    
    
    
    //button building
    protected JButton myButton1= new JButton("PLAY");
    protected JButton myButton2= new JButton("SETTING");
    protected JButton left = new JButton("left");
    protected JButton back = new JButton ("back");
    protected JButton right,front;
    protected Icon myIcon;
    
    
    public Interface (String salle)
    {
        //Icon myIcon= new ImageIcon("./chateau.jpg");
        JPanel myPanel = new JPanel(new BorderLayout ());
        JPanel panelButton = new JPanel (new BorderLayout ());
        JPanel Button = new JPanel (new GridLayout (2,1));

        Icon flecheRIght = new ImageIcon("./Fdroite.jpg");
        Icon flecheFront = new ImageIcon("./Fhaut.jpg");
        Icon flecheRecul = new ImageIcon ("./Fbas.jpg");
        Icon flecheGauche = new ImageIcon("./Fgauche.jpg");

        right= new JButton(flecheRIght);
        right.setBackground(Color.black);
        front = new JButton(flecheFront);
        front.setBackground(Color.black);
        back = new JButton(flecheRecul);
        back.setBackground(Color.black);
        left = new JButton(flecheGauche);
        left.setBackground(Color.black);
      
        left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        right.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        back.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        front.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        
        
        
        if (salle == "Acceuil")
        {      
        	//Image on the background
            Icon myIcon= new ImageIcon("./chateau.jpg"); 
            JLabel label = new JLabel (myIcon);
        
            //Buttons design
            Font police = new Font ("Kristen ITC", Font.BOLD, 14);
            myButton1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            myButton1.setBackground(Color.black);
            myButton1.setForeground(Color.white);
            myButton1.setFont(police);
        
            myButton2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            myButton2.setBackground(Color.black);
            myButton2.setForeground(Color.yellow);
            myButton2.setFont(police);
        
            
            //Add buttons on the panel
            panelButton.add(myButton1,BorderLayout.WEST);
            panelButton.add(myButton2,BorderLayout.EAST);
        
            //Creation final panel
            myPanel.add(label,BorderLayout.NORTH);
            myPanel.add(panelButton, BorderLayout.SOUTH);
        
               
        }   
        else if (salle == "3Doors")
        {        
        	//Image on the background
            Icon myIcon= new ImageIcon("./Room3Doors.png");
            JLabel label = new JLabel (myIcon);
            
            JPanel buttonDirection = new JPanel(new GridLayout(2,2));
            
            //Add buttons on the panel
            buttonDirection.add(left);
            buttonDirection.add(right);
            buttonDirection.add(front);
            buttonDirection.add(back);
            
            panelButton.add(buttonDirection, BorderLayout.EAST);
            
            //Creation final panel
            myPanel.add(label,BorderLayout.NORTH);
            myPanel.add(panelButton, BorderLayout.SOUTH);
        
   
        }  
         else if (salle == "2Doors")
        {        
        	//Image on the background
            Icon myIcon= new ImageIcon("./Room2Doors.png");
            JLabel label = new JLabel (myIcon);
            
            JPanel buttonDirection = new JPanel(new GridLayout(1,1));
            
            //Add buttons on the panel
        	buttonDirection.add(right);
        	buttonDirection.add(front);
        	buttonDirection.add(back);
        	
        	panelButton.add(buttonDirection, BorderLayout.EAST);
        
        	//Creation final panel
            myPanel.add(label,BorderLayout.NORTH);
            myPanel.add(panelButton, BorderLayout.SOUTH);
        } 
         
      //Display the final panel with specifics parameters 
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("WOZ");    
      this.add(myPanel);
      this.setSize(500, 500);
      this.pack();
      this.setVisible(true);
 }
      

}