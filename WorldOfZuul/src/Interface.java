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
    //protected JButton right = new JButton ("right");
    //protected JButton front= new JButton("front");
    protected JButton back = new JButton ("back");
    protected JButton right,front;
    protected Icon myIcon;
    
    
    public Interface (String salle)
    {
        //Icon myIcon= new ImageIcon("./chateau.jpg");
        JPanel myPanel = new JPanel(new BorderLayout ());
        JPanel panelButton = new JPanel (new BorderLayout ());
        JPanel buttonDirection = new JPanel (new GridLayout(2,2));
        JPanel Button = new JPanel (new GridLayout (2,1));

        Icon flecheRIght = new ImageIcon("./Fdroite.jpg");
        Icon flecheFront = new ImageIcon("./Fhaut.jpg");
        Icon flecheRecul = new ImageIcon ("./Fbas.jpg");
        Icon flecheGauche = new ImageIcon("./Fgauche.jpg");
        //(new javax.swing.ImageIcon(getClass().getResource("chateau.jpg"))).getImage();
   

        //Image on the background


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
            Icon myIcon= new ImageIcon("./chateau.jpg");
        
            //(new javax.swing.ImageIcon(getClass().getResource("chateau.jpg"))).getImage();
       
        
            //Image on the background
            JLabel label = new JLabel (myIcon);
        
            //Create button play
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
        
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("WOZ");
        
            panelButton.add(myButton1,BorderLayout.WEST);
            panelButton.add(myButton2,BorderLayout.EAST);
        
            myPanel.add(label,BorderLayout.NORTH);
            myPanel.add(panelButton, BorderLayout.SOUTH);
        
               
        }   
        else if (salle == "3Doors")
        {        
            Icon myIcon= new ImageIcon("./Room3Doors.png");
            JLabel label = new JLabel (myIcon);
            
            buttonDirection.add(left,BorderLayout.WEST);
            buttonDirection.add(right,BorderLayout.EAST);
            buttonDirection.add(front,BorderLayout.NORTH);
            buttonDirection.add(back,BorderLayout.SOUTH);
            
            
            myPanel.add(label,BorderLayout.NORTH);
            myPanel.add(buttonDirection, BorderLayout.SOUTH);
        
   
        }  
         else if (salle == "2Doors")
        {        
            Icon myIcon= new ImageIcon("./Room2Doors.png");
            JLabel label = new JLabel (myIcon);
            
        	buttonDirection.add(right,BorderLayout.EAST);
        	buttonDirection.add(front,BorderLayout.NORTH);
        	buttonDirection.add(back,BorderLayout.SOUTH);
        
            myPanel.add(label,BorderLayout.NORTH);
            myPanel.add(buttonDirection, BorderLayout.SOUTH);
        } 
         
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("WOZ");    
      this.add(myPanel);
      this.setSize(500, 500);
      this.pack();
      this.setVisible(true);
 }
    
  

}