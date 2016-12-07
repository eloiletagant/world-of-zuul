import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Victory extends JFrame implements ActionListener {
    //button building
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton restart;
    private JLabel pictureLabel;
    private JPanel globalPanel, buttonsPanel; 
    
    private ImageIcon backPicture;
    
    private Font playFont;

    public Victory() {
    	
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setTitle("Victory"); 
    	
        playFont = new Font("Kristen ITC", Font.BOLD, 40);
    	   	
        //Image on the background
        backPicture = new ImageIcon("pictures/Victory.jpg");
        pictureLabel = new JLabel();
        pictureLabel.setIcon(backPicture);
        
        
    	buttonsPanel = new JPanel (new BorderLayout ());
        buttonsPanel.setBackground(Color.black);
        
    	restart = new JButton("RESTART");
    	restart.addActionListener(this);
    	restart.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
    	restart.setBackground(Color.black);
    	restart.setForeground(Color.yellow);
        restart.setFont(playFont);
        
                  
        //Add buttons on the panel
        buttonsPanel.add(restart);
        
        //Creation final panel
        globalPanel = new JPanel(new BorderLayout ());
        globalPanel.add(pictureLabel ,BorderLayout.CENTER);
        globalPanel.add(buttonsPanel, BorderLayout.SOUTH);
    
        
        //Display the final panel with specifics parameters 
        this.add(globalPanel);
        this.pack();
        this.setLocationRelativeTo(null);//place in the middle
        this.setVisible(true);
        
    }    

    public void actionPerformed(ActionEvent e) {
        new Game();
        this.dispose();
    }

}