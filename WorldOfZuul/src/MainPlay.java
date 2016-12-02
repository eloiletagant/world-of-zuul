import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class MainPlay extends JFrame implements ActionListener {
    //button building
    
	protected JButton start= new JButton("PLAY");
    protected JButton setting= new JButton("SETTING");
    protected JLabel text, title;
    protected Icon myIcon, room, room2;
    public JLabel pictureRoom;
    public ImageIcon flecheRight; 
    protected JPanel myPanel, textHaut; 
    protected int nbrRoom = 0;
    private Game game;


    public MainPlay() {
    	
    	pictureRoom = new JLabel();
    	JPanel myPanel = new JPanel(new BorderLayout ());
    	JPanel panelButton = new JPanel (new  BorderLayout ());
        panelButton.setBackground(Color.black);
        start.addActionListener(this);
         
        //Image on the background
        myIcon= new ImageIcon("pictures/chateau.jpg");
        pictureRoom.setIcon(myIcon);
            
        textHaut = new JPanel();
        textHaut.setBackground(Color.BLACK);
            
        Font police = new Font ("Kristen ITC", Font.BOLD, 14);
        Font police2 = new Font ("Kristen ITC", Font.ITALIC, 28);
       
        start.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        start.setBackground(Color.black);
        start.setForeground(Color.white);
        start.setFont(police);
        
        setting.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        setting.setForeground(Color.yellow);
        setting.setFont(police);
        
        title = new JLabel ("Dungeon Clicker", JLabel.CENTER );
        title.setFont(police2);
        title.setBackground(Color.BLACK);
        title.setForeground(Color.WHITE);
            
        textHaut.add(title);
            
        //Add buttons on the panel
        panelButton.add(start,BorderLayout.NORTH);
        panelButton.add(setting,BorderLayout.SOUTH);
       
        //Creation final panel
        myPanel.add(textHaut, BorderLayout.NORTH);
        myPanel.add(pictureRoom ,BorderLayout.CENTER);
        myPanel.add(panelButton, BorderLayout.SOUTH);
    
        //Disstart the final panel with specifics parameters 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("WOZ");    
        this.add(myPanel);
        this.setSize(500, 500);
        this.pack();
        this.setVisible(true);
        
    }    
     
    public static void main(String[] args) {
        MainPlay main = new MainPlay();
    }

    public void actionPerformed(ActionEvent e) {
        game = new Game();
        this.dispose();
    }

}    
            
      