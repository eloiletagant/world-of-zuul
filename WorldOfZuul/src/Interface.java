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
    
    public Interface ()
    {
        
        Icon myIcon= new ImageIcon("./chateau.jpg");
        
                //(new javax.swing.ImageIcon(getClass().getResource("chateau.jpg"))).getImage();
       
        JPanel myPanel = new JPanel(new BorderLayout ());
        JPanel panelBouton = new JPanel (new GridLayout (2,1));
        
        //Mise d'une image en fond
        JLabel label = new JLabel (myIcon);
        
        //CRéatio bouton play
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
        
        panelBouton.add(myButton1,BorderLayout.WEST);
        panelBouton.add(myButton2,BorderLayout.EAST);
        
        myPanel.add(label,BorderLayout.NORTH);
        myPanel.add(panelBouton, BorderLayout.SOUTH);
        
                
        this.add(myPanel);
        this.setSize(500, 500);
        this.pack();
        this.setVisible(true);
        
        
    }
    
    
    

}
