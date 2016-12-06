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
    
	private JButton start;
    private JLabel text, title, pictureLabel;
    private JPanel globalPanel, buttonsPanel, topPanel; 
    
    private ImageIcon backPicture, room, room2;
    
    private int nbrRoom = 0; 
    private Game game;
    
    private Font font, titleFont, playFont;

    public MainPlay() {
    	
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("World Of Zuul"); 
    	
        font = new Font("Kristen ITC", Font.BOLD, 14);
        titleFont = new Font("Kristen ITC", Font.ITALIC, 28);
        playFont = new Font("Kristen ITC", Font.BOLD, 40);
    
        
        title = new JLabel ("Dungeon Clicker", JLabel.CENTER );
        title.setFont(titleFont);
        title.setBackground(Color.BLACK);
        title.setForeground(Color.WHITE);
        
        topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        topPanel.add(title);
    	
    	
        //Image on the background
        backPicture = new ImageIcon("pictures/chateau.jpg");
        pictureLabel = new JLabel();
        pictureLabel.setIcon(backPicture);
        
        
    	buttonsPanel = new JPanel (new BorderLayout ());
        buttonsPanel.setBackground(Color.black);
        
    	start = new JButton("PLAY");
    	start.addActionListener(this);
        start.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        start.setBackground(Color.black);
        start.setForeground(Color.yellow);
        start.setFont(playFont);
        
                  
        //Add buttons on the panel
        buttonsPanel.add(start);
        
        //Creation final panel
        globalPanel = new JPanel(new BorderLayout ());
        globalPanel.add(topPanel, BorderLayout.NORTH);
        globalPanel.add(pictureLabel ,BorderLayout.CENTER);
        globalPanel.add(buttonsPanel, BorderLayout.SOUTH);
    
        
        //Display the final panel with specifics parameters 
        this.add(globalPanel);
        this.pack();
        this.setLocationRelativeTo(null);//place in the middle
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
            
      