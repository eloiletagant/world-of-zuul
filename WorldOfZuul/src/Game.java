/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.  Users
 * can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * <p>
 * To play this game, create an instance of this class and call the "play"
 * method.
 * <p>
 * This main class creates and initialises all the others: it creates all
 * rooms, creates the parser and starts the game.  It also evaluates and
 * executes the commands that the parser returns.
 *
 * @author Group 4
 * @version November 2016
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.border.Border;

import java.util.ArrayList;
import java.util.HashMap;

import character.NPC;
import character.Player;
import event.Enigma;
import event.Event;
import event.Fight;
import event.Trade;
import room.Door;
import room.LockedDoor;
import room.Room;
import item.*;


public class Game extends JFrame {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Room currentRoom;
    private Player player;
    private Weapon w1, w2, w3, w4,w5;
    private Consumable c1, c2, c3, c4, c5, c6, c7,c8,c9;
    private Key k1, k2, k3, k4, k5, k6, k7;
    private Lock l1, l2, l3, l4, l5, l6, l7;
    private Chest ch1, ch2, ch3, ch4,ch5;
    private ArrayList<Room> rooms; 
    public  Sound sound;
   
    private int maxHealth = 20; //declared here to build the GUI
    
    private JButton left, behind, front, right, bag, search, speak, enigmaButton; 
    //direction arrows and bag (inventory)
    private JLabel textDescRoom, textEvent, pictureRoom, health, textEnigma;
    private JPanel globalPanel, buttonsPanel, healthBag, healthBarPanel, panelFB, buttonDirection, textDisplay;
    private JTextField typingArea;
    
    private ImageIcon room, arrowRight, arrowLeft, arrowFront, arrowBehind, inventory, healthIcons, wen, bubble;
    private InventoryInterface showInventory;
    private GameListener l;
    private JFrame enigmaFrame;
    private boolean isEnemy;
    private String question;
    
    //for the clicker game
    private Clicker clicker;
    private JFrame clickerFrame;
    private JButton clickButton;
    private JLabel clickLabel;
    private JProgressBar bar, healthBar;
    private static int MIN = 0;
    private static int MAX = 1500; //hundredth of seconds
    private Container clickerGlobalPanel;
    private int result;
    
    
    /**
     * Create the game and initialize its internal map.
     */
    public Game() {
    	
    	//Game Listener creation
        l = new GameListener(this);
        
        Font font = new Font ("Kristen ITC", Font.BOLD, 14);
        
    	/*****************************
         ****** Pictures instantiation
         *****************************/

        room = new ImageIcon(Game.class.getResource("/Room0.png"));
        arrowRight = new ImageIcon(Game.class.getResource("/arrowRight.png"));
        arrowFront = new ImageIcon(Game.class.getResource("/arrowFront.png"));
        arrowBehind = new ImageIcon (Game.class.getResource("/arrowBehind.png"));
        arrowLeft = new ImageIcon(Game.class.getResource("/arrowLeft.png"));
        inventory = new ImageIcon(Game.class.getResource("/bag.png"));
        healthIcons = new ImageIcon(Game.class.getResource("/healthIcons.jpg"));
        wen = new ImageIcon(Game.class.getResource("/loupe_5.png"));
        bubble = new ImageIcon(Game.class.getResource("/Dialogue.png"));
        
         
        /**********************
         ******* Window content
         **********************/
        //display of the first room of the game
        pictureRoom = new JLabel(room);

        //Creation of a panel which will contain all buttons(direction, inventory ..)
        buttonsPanel = new JPanel (new  BorderLayout ());
        buttonsPanel.setBackground(Color.black);    
         
        /******************
         * health bar / bag
         ******************/
        //Panel which contains bag + bar life
        healthBag = new JPanel (new GridLayout (2,2));
        healthBag.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        healthBag.setBackground(Color.black);
        
        
        
        //Label which contains the player's bar life
        health = new JLabel (healthIcons); 
        health.setBackground(Color.black);
        healthBar = new JProgressBar();
        healthBar.setMinimum(0);
        healthBar.setMaximum(maxHealth);
        healthBar.setValue(maxHealth);
        healthBar.setBackground(Color.black);
        healthBar.setForeground(Color.yellow);
        healthBar.setOpaque(true);
        
        healthBarPanel = new JPanel(new GridLayout(2,1));
        healthBarPanel.setBackground(Color.black);
        healthBarPanel.add(healthBar);
        healthBarPanel.add(health);
         
        bag = new JButton(inventory);
        bag.setBackground(Color.black);
        bag.addActionListener(l);
        bag.setBorderPainted(false);
        
        search = new JButton(wen);
        search.setBackground(Color.black);
        search.addActionListener(l);
        search.setBorderPainted(false);
        
        speak = new JButton(bubble);
        speak.setBackground(Color.black);
        speak.setEnabled(false);
        speak.addActionListener(l);
        speak.setBorderPainted(false);
        
        healthBag.add(healthBarPanel);
        healthBag.add(speak);
        healthBag.add(bag);
        healthBag.add(search);
        
        
        //TEXT DISPLAY 
        
        
        textDescRoom = new JLabel("Welcome to Dungeon Clicker", JLabel.CENTER);
        textDescRoom.setForeground(Color.yellow);
        textDescRoom.setFont(font);
        
        textEvent = new JLabel("", JLabel.CENTER);
        textEvent.setForeground(Color.yellow);
        textEvent.setFont(font);
        
        //create the panel which contains all the text
        textDisplay = new JPanel(new GridLayout(2,1));
        textDisplay.setBackground(Color.black);
        textDisplay.add(textDescRoom);
        textDisplay.add(textEvent);

        
        /*******************************************
         ****** Declaration of all direction buttons 
         *******************************************/
          
        right = new JButton(arrowRight);
        right.setBackground(Color.black);
        right.addActionListener(l);
        right.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
         
        front = new JButton(arrowFront);
        front.setBackground(Color.black);
        front.addActionListener(l);
        front.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
         
        left = new JButton(arrowLeft);
        left.setBackground(Color.black);
        left.addActionListener(l);
        left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
         
        behind = new JButton(arrowBehind);
        behind.setBackground(Color.black);
        behind.addActionListener(l);
        behind.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
         
        //Panel which contains front and behind buttons
        panelFB = new JPanel (new BorderLayout());
        panelFB.add(front,BorderLayout.NORTH);
        panelFB.add(behind,BorderLayout.SOUTH);
        panelFB.setBackground(Color.black);

        //Panel which contains each direction buttons         
        buttonDirection = new JPanel(new GridLayout(1,3));
        buttonDirection.setBackground(Color.black);
        buttonDirection.add(left);
        buttonDirection.add(panelFB);
        buttonDirection.add(right); 
             
        //Adding buttons in the buttonsPanel
        buttonsPanel.add(healthBag, BorderLayout.WEST);
        buttonsPanel.add(textDisplay, BorderLayout.CENTER);
        buttonsPanel.add(buttonDirection, BorderLayout.EAST);
             
        //Creation of a panel which will contain the room picture at the top and the buttons at the below
        globalPanel = new JPanel(new BorderLayout ());
        //Final panel creation
        globalPanel.add(pictureRoom, BorderLayout.CENTER);
        globalPanel.add(buttonsPanel, BorderLayout.SOUTH);
       
        /*********************
         **** Frame parameters
         *********************/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Dungeon Clicker");    
        this.add(globalPanel);
        this.setSize(500, 500);
        this.pack();
        this.setVisible(true);
    	
    	player = new Player ("Kaamelott", maxHealth);
    	rooms = new ArrayList<Room>();
    	
    	//create the frame of the clicker
    	createClickerFrame();
    	createItems();
    	createAllRooms();
    	setEvents();
        createAllDoors(rooms);
        manageButtons();
        player.moveRoom(rooms.get(0));
        addChestsToRooms();
        
    	sound = new Sound();
    	sound.playSound("/SoundCave.wav");
    }
    
    public void setTextEvent(String s) {
    	textEvent.setText(s);
    	textEvent.repaint();
    }
    
    public void createClickerFrame() {
        
    	clicker = new Clicker(this, MAX);
    	
    	clickerFrame = new JFrame();
    	clickerFrame.setSize(700, 300);
    	clickerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	clickerFrame.setResizable(false);
    	
    	
        //bar.setStringPainted(true);
    	bar = new JProgressBar();
        bar.setMinimum(MIN);
        bar.setMaximum(MAX);
        //bar.setStringPainted(true);
        //bar.setUI(new MyProgressUI());
        
        
        Icon clickIcon = new ImageIcon(Game.class.getResource("/clicker.jpeg"));
        clickButton = new JButton("Click to attack!", clickIcon);
        clickButton.addActionListener(clicker);
        clickButton.setBackground(Color.BLACK);
        clickButton.setForeground(Color.YELLOW);
        clickButton.setFont(new Font("Kristen ITC", Font.BOLD, 40));
        clickButton.setOpaque(true);
        clickButton.setBorderPainted(false);
        
        clickLabel = new JLabel("Clicks: " + clicker.getClicks(), JLabel.CENTER);
        clickLabel.setBackground(Color.BLACK);
        clickLabel.setForeground(Color.YELLOW);
        clickLabel.setFont(new Font("Kristen ITC", Font.BOLD, 30));
        
        
        clickerGlobalPanel = new JPanel(new BorderLayout());
        clickerGlobalPanel.setBackground(Color.BLACK);
        clickerGlobalPanel.add(bar, BorderLayout.NORTH);
        clickerGlobalPanel.add(clickButton, BorderLayout.CENTER);
        clickerGlobalPanel.add(clickLabel, BorderLayout.SOUTH);
        
        clickerFrame.add(clickerGlobalPanel);
        clickerFrame.setLocationRelativeTo(null);
        clickerFrame.setVisible(false);

    }
    
    public JLabel getClickLabel() {
    	return clickLabel;
    }
    
    public JButton getClickButton() {
    	return clickButton;
    }
    
    public JProgressBar getBar() {
    	return bar;
    }
    
    public JProgressBar getHealthBar() {
    	return healthBar;
    }
    
    public int getMaxHealth() {
    	return maxHealth;
    }
    
    /**
     * Accessor for the "player" attribute
     * @return player: The player which plays the game
     */
    public Player getPlayer() {
    	return player;
    }
    
    public JFrame getClickerFrame() {
    	return clickerFrame;
    }

    /**
     * Accessor for the "front" attribute
     * @return front: The button used to go in the "front" direction into the game
     */
    public JButton getFrontB() {
    	return front;
    }

    /**
     * Accessor for the "behind" attribute
     * @return behind: The button used to go in the "behind" direction into the game
     */
    public JButton getBehindB() {
    	return behind;
    }

    /**
     * Accessor for the "right" attribute
     * @return right: The button used to go in the "right" direction into the game
     */
    public JButton getRightB() {
    	return right;
    }

    /**
     * Accessor for the "left" attribute
     * @return left: The button used to go in the "left" direction into the game
     */
    public JButton getLeftB() {
    	return left;
    }
    
    /**
     * Accessor for the "speak" attribute
     * @return left: 
     */
    public JButton getSpeak() {
    	return speak;
    }
    
    
    /**
     * Accessor for the bag attribute
     * @return bag: The button used to open the player inventory into the game
     */
    public JButton getBagB() {
    	return bag;
    }
    
    /**
     * Accessor for the search attribute
     * @return search: The button used to search for a chest in a room
     */
    public JButton getSearch() {
    	return search;
    }
    
    /**
     * get the typing area
     * @return
     */
    public JTextField getTypingArea() {
    	return typingArea;
    }
    
    
    /**
     * Method used to open the inventory from the GameListener
     * @param open
     */
    public void openInventory() {
    	if (showInventory==null)
    	{
    		showInventory = new InventoryInterface(player.getInventory(), player,this);
    	}
    	else
    	{
    		showInventory.manageInventory();
    	}
    }
    
    public InventoryInterface getShowInventory()
    {
    	return showInventory;
    }
    
    
    /**
     * Method used to create all the 33 rooms present in the game
     */
    private void createAllRooms() {   	
    	int fin=32;
    	for(int i=0; i<=fin; i++){
    		if (i < 14 || i > 29)
    			rooms.add(new Room("Room" + i, 0));
    		else
    			rooms.add(new Room("Room" + i, 1));
    	}
    	currentRoom = rooms.get(0);
    }
    
    /**
     * method to implement all events and NPC on rooms
     */
    private void setEvents()
    {
		//NPC FRIENDLY
			//Roi Arthur
			//NPC roiArthur = new NPC("Roi Arthur",10, 2, true);
			//Fight fight = new Fight("Hello",w1,player,roiArthur);
			//rooms.get(1).addEvent(fight);
			
    	//TRADER 
			//BOHORT
			NPC bohort = new NPC("Borhort",10, 2, true); 
			Trade trade1 = new Trade("trade1",w1,player,bohort);
			rooms.get(24).addEvent(trade1);
			//LANCELOT 
			NPC lancelot = new NPC("Lancelot",10, 2, true);
			Trade trade2 = new Trade("trade2",w1,player,lancelot);
			rooms.get(31).addEvent(trade2);
			
		//NPC ENIGMA
			//MERLIN
			NPC merlin = new NPC("Merlin", 15, 2, false);
			String q1 = "<html>\"Frankly, a potion to make piss blue, it necessarily presses the minute\" <br> I never far from my twist, I am often associated with the vomiting perfum <br/> From a part of the boby which is not really beautiful <br/> Located far from the olfactory organ! </html>";
			String a1 = "socks";
			Enigma enigma1 = new Enigma("Enigma1", k1, player, merlin, q1, a1);
			rooms.get(9).addEvent(enigma1);
			
			//KARADOC
			NPC karadoc = new NPC("Karadoc", 15, 2, false);
			Enigma enigma2 = new Enigma("Enigma2", k2, player, karadoc, "<html>\"As long as i have my cauldron, nothing can happen to me!!\"<br>What begins with T, ends with T and has T in it?</html>", "teapot");
			rooms.get(4).addEvent(enigma2);
			
			//PERCEVAL
			NPC perceval = new NPC("Perceval", 20, 2, false);
			String a3 = "letter e";
			Enigma enigma3 = new Enigma("Enigma3", k5, player, perceval, "<html>I am the beginning of everything, the end of time and space, the beginning of every end, and the end of every place. What am I?</html>", a3);
			rooms.get(27).addEvent(enigma3);
			
		//NPC Enemy
			//MINOTAUR
			NPC minotaur = new NPC("Minotaur",5, 2, true);
			Fight fight1 = new Fight("fight1",k7,player,minotaur);
			rooms.get(3).addEvent(fight1);
			//SPIDER
			NPC spider = new NPC("Spider",5, 2, true);
			Fight fight2 = new Fight("fight2",k3,player,spider);
			rooms.get(11).addEvent(fight2);
			//ZOMBIE
			NPC zombie = new NPC("Zombie",10, 2, true);
			Fight fight3 = new Fight("fight3",k4,player,zombie);
			rooms.get(25).addEvent(fight3);
			//SKELETON
			NPC skeleton = new NPC("Skeleton",10, 2, true);
			Fight fight4 = new Fight("fight4",c6,player,skeleton);
			rooms.get(20).addEvent(fight4);
			//CREEPER 
			NPC creeper = new NPC("Creeper",30, 2, true);
			Fight fight5 = new Fight("fight5",w4,player,creeper);
			rooms.get(16).addEvent(fight5);
			//MONKEY KING
			NPC monkey = new NPC("Monkey King",150, 4, true);
			monkey.getInventory().addItem(w5);
			monkey.getInventory().getItems().get(0).equip();
			Fight fight6 = new Fight("fight boss !",w5,player,monkey);
			rooms.get(32).addEvent(fight6);
    }
    
    /**
     * Method used to create all the doors (locked or not) linked to the rooms
     * Rooms 9, 16 and 27 have a locked door
     * @param rooms: The array which contains all rooms of the game
     */ 
    private void createAllDoors(ArrayList<Room> rooms){
    	//Room 0
        createDoor(rooms.get(0), rooms.get(1) , "front");
        //Room 1
        createDoor(rooms.get(1), rooms.get(0) , "behind");
        createDoor(rooms.get(1), rooms.get(2) , "left");
        createDoor(rooms.get(1), rooms.get(4) , "front");
        createDoor(rooms.get(1), rooms.get(9) , "right");
        //Room 2
        createDoor(rooms.get(2), rooms.get(3) , "front");
        createDoor(rooms.get(2), rooms.get(1) , "right");
        //Room 3
        createDoor(rooms.get(3), rooms.get(4) , "left");
        createDoor(rooms.get(3), rooms.get(5) , "right");
        createDoor(rooms.get(3), rooms.get(2) , "front");
        //Room 4
        createDoor(rooms.get(4), rooms.get(1) , "front");
        createDoor(rooms.get(4), rooms.get(3) , "right");
        //Room 5
        createDoor(rooms.get(5), rooms.get(8) , "front");
        createDoor(rooms.get(5), rooms.get(6) , "right");
        createDoor(rooms.get(5), rooms.get(3) , "left");
        //Room 6
        createDoor(rooms.get(6), rooms.get(7) , "left");
        createDoor(rooms.get(6), rooms.get(26) , "front");
        createDoor(rooms.get(6), rooms.get(5) , "behind");
        //Room 7
        createDoor(rooms.get(7), rooms.get(6) , "behind");
        //Room 8
        createDoor(rooms.get(8), rooms.get(5) , "behind");
        //Room 9
        createLockedDoor(rooms.get(9),  rooms.get(10), "right", l7);
        createDoor(rooms.get(9), rooms.get(1) , "left");
        //Room 10
        createDoor(rooms.get(10), rooms.get(11) , "front");
        createDoor(rooms.get(10), rooms.get(9) , "left");
        //Room 11
        createDoor(rooms.get(11), rooms.get(10) , "left");
        createDoor(rooms.get(11), rooms.get(12) , "front");
        createDoor(rooms.get(11), rooms.get(13) , "right");
        //Room 12
        createDoor(rooms.get(12), rooms.get(11) , "behind");
        //Room 13
        createDoor(rooms.get(13), rooms.get(11) , "left");
        createDoor(rooms.get(13), rooms.get(14) , "front");
        //Room 14
        createDoor(rooms.get(14), rooms.get(22) , "left");
        createDoor(rooms.get(14), rooms.get(13) , "behind");
        createDoor(rooms.get(14), rooms.get(15) , "front");
        //Room 15
        createDoor(rooms.get(15), rooms.get(21) , "front");
        createDoor(rooms.get(15), rooms.get(16) , "right");
        createDoor(rooms.get(15), rooms.get(14) , "left");
        //Room 16
        createLockedDoor(rooms.get(16),  rooms.get(17), "right", l5);
        createDoor(rooms.get(16), rooms.get(15) , "left");
        createDoor(rooms.get(16), rooms.get(18) , "front");
        //Room 17
        createDoor(rooms.get(17), rooms.get(30) , "front");
        createDoor(rooms.get(17), rooms.get(16) , "behind");
        //Room 18
        createDoor(rooms.get(18), rooms.get(16) , "left");
        createDoor(rooms.get(18), rooms.get(19) , "right");
        //Room 19
        createDoor(rooms.get(19), rooms.get(18) , "left");
        createDoor(rooms.get(19), rooms.get(20) , "right");
        //Room 20
        createDoor(rooms.get(20), rooms.get(19) , "left");
        createDoor(rooms.get(20), rooms.get(21) , "front");
        createDoor(rooms.get(20), rooms.get(23) , "right");
        //Room 21 
        createDoor(rooms.get(21), rooms.get(1) , "front");
        //Room 22
        createDoor(rooms.get(22), rooms.get(23) , "right");
        createDoor(rooms.get(22), rooms.get(14) , "left");
        //Room 23
        createDoor(rooms.get(23), rooms.get(22) , "front");
        createDoor(rooms.get(23), rooms.get(20) , "left");
        createDoor(rooms.get(23), rooms.get(24) , "right");
        //Room 24
        createDoor(rooms.get(24), rooms.get(25) , "right");
        createDoor(rooms.get(24), rooms.get(23) , "left");
        //Room 25
        createDoor(rooms.get(25), rooms.get(26) , "right");
        createDoor(rooms.get(25), rooms.get(27) , "front");
        createDoor(rooms.get(25), rooms.get(24) , "left");
        //Room 26
        createDoor(rooms.get(26), rooms.get(25) , "front");
        createDoor(rooms.get(26), rooms.get(6) , "behind");        
        //Room 27
        createLockedDoor(rooms.get(27),  rooms.get(29), "front", l6);
        createDoor(rooms.get(27), rooms.get(25) , "left");
        //Room 29
        createDoor(rooms.get(29), rooms.get(27) , "behind");
        //Room 30
        createDoor(rooms.get(30), rooms.get(17) , "right");
        createDoor(rooms.get(30), rooms.get(31) , "left");
        //Room 31
        createDoor(rooms.get(31), rooms.get(32) , "left");
        createDoor(rooms.get(31), rooms.get(30) , "right"); 
        //Room 32
        createDoor(rooms.get(32), rooms.get(31) , "behind"); 
     }
    
    /**
     * Create all items
     */
    private void createItems()
    {
    	w1 = new Weapon("Axe", "This axe do not only allow cutting trees.", 20, true, 3);
    	w2 = new Weapon("Bow", "This bow is for a true Robin wood.", 90, true, 5);
        w3 = new Weapon("Butcher knife", "It is a terrible weapon for a real butcher.", 30, true, 7);
        w4 = new Weapon("Sword", "This sword is the weapon the most dreaded in the world of Kaamelott.", 90, true, 9);
        w5 = new Weapon("spoon", "This is a spoon", 30, true, 1);
        c1 = new Consumable("Brioche", "This brioche was cooked by the best people in the world and comes from Vend�e !!!.", 10, true, "It gets 2 health points to the person who eats it.", 2, 0, false);
        c2 = new Consumable("Bread", "This bread was cooked by the baker of the village.", 5, true, "It gets 1 health point to the person who eats it.", 1, 0, false);
        c3 = new Consumable("Cookies", "This cookies was cooked by the Mie caline and it is delicious.", 15, true, "It gets 3 health points to the person who eats it.", 3, 0, false);
        c4 = new Consumable("Pineapple", "This fruit allow adding damage point. It was cultivated by Guethenoc", 15, true, "It gets 1 damage point to a weapon when the player scrubs it into his weapon.", 0, 1, true);
        c5 = new Consumable("Eggplant", "This vegetable allow adding damage point. It was cultivated by Guethenoc", 10, true, "It gets 1 damage point to the person who eats it.", 0, 1, false);
        c6 = new Consumable("Potion", "This potion was prepared by Merlin with all his love", 20, true, "It gets 2 damage point to a weapon when the player flips it on his weapon.", 0, 2, true);
        c7 = new Consumable("Pineapple", "This fruit allow adding damage point. It was cultivated by Guethenoc", 15, true, "It gets 1 damage point to a weapon when the player scrubs it into his weapon.", 0, 1, true);
        c8 = new Consumable("Potion", "This potion was prepared by Merlin with all his love", 20, true, "It gets 2 damage point to a weapon when the player flips it on his weapon.", 0, 2, true);
        c9 = new Consumable("Cookies", "This cookies was cooked by the Mie caline and it is delicious.", 15, true, "It gets 3 health points to the person who eats it.", 3, 0, false);
        k1 = new Key("Hodor", "This key opens a very cold door.", 20, false);
        k2 = new Key("Sesame", "This key has magic power and will help you to find a treasure.", 20, false);
        k3 = new Key("Musse-Clef", "This key opens a chest.", 20, false);
        k4 = new Key("Tabou-Clef", "This key opens a chest.", 20, false);
        k5 = new Key("Clef-Bar", "This key opens a chest.", 20, false);
        k6 = new Key("Nu-Clef-ere", "This key opens a door.", 20, false);
        k7 = new Key("Gy-Clef", "This key opens a door.", 20, false);
        l1 = new Lock();
        l1.addKey(k3);
        l2 = new Lock();
        l2.addKey(k2);
        l3 = new Lock();
        l3.addKey(k4);
        l4 = new Lock();
        l4.addKey(k7);
        l5 = new Lock();
        l5.addKey(k6);
        l6 = new Lock();
        l6.addKey(k5);
        l7 = new Lock();
        l7.addKey(k1); 
        ch1 = new Chest("Little box", "This box contains something for you.", 2, 5, l1);
        ch1.addItem(c2);
        ch1.addItem(w1);
        ch2 = new Chest("Ali baba box","This box contains something for you.", 3, 15, l2);
        ch2.addItem(c1);
        ch2.addItem(c6);
        ch2.addItem(w2);
        ch3 = new Chest("Gift Box", "This box contains something for you.", 2, 30, l3);
        ch3.addItem(c5);
        ch3.addItem(w3);
        ch4 = new Chest("Treasure box", "This box contains something for you.", 4, 60, l6);
        ch4.addItem(c3);
        ch4.addItem(k6);
        ch4.addItem(c9);
        ch5 = new Chest("Cheast", "This box contains something for you.", 2, 30, l4);
        ch5.addItem(c8);
        ch5.addItem(c4);

    }
    
 
   /**
    * Method used to create a door
    * @param room: The room which contains the door 
    * @param nextRoom: The next room linked to the previous room
    * @param way: The direction to access to the next room
    */ 
    private void createDoor(Room room, Room nextRoom, String way) {
    	Door door1 = new Door(nextRoom);
    	room.addExit(door1, way);
    }
    
    
    /**
     * Method used to add a chest in a room
     * @param aChest: The chest adding to the room
     */ 
     private void addChestsToRooms() {
    	 rooms.get(8).addChest(ch2);
    	 rooms.get(7).addChest(ch5);
    	 rooms.get(29).addChest(ch4);
    	 rooms.get(15).addChest(ch3);
    	 rooms.get(12).addChest(ch1);
     }
     
     /**
      * Method used to add a chest in a room
      * @param aChest: The chest adding to the room
      */ 
      public void getItemsFromChest(Chest aChest)
      {
    	  ArrayList<Item> chestInv = aChest.getItems();
    	  int i = 0;
    	  String textToAdd="";
    	  String itemAdded="You won ";
    	  if (aChest.getNbItems()==0)
		  {
	  		  textEvent.setText("This chest is empty.");
		  }
    	  else
    	  {
    		  int gold=0;
    		  if (aChest.getGold() > 0)
        	  {
        		  player.getInventory().manageGold(aChest.getGold());
        		  gold = aChest.getGold();
        		  aChest.manageGold(- gold);
        	  }
    		  for (Item item: chestInv)
    		  {
    			  if (player.getInventory().addItem(item))
    			  {
    				  i+=1;
    				  itemAdded=itemAdded+item.getName()+", ";
    			  }
    			  else
    			  {
    				  textToAdd="Your bag is full. You need to sell some items. Come back later";
    			  }
    		  }
    		  itemAdded=itemAdded+" and "+gold+" gold."+textToAdd;
    		  textEvent.setText(itemAdded); 
    		  while (i!=0)
    		  {
    			  aChest.deleteItem(chestInv.get(0));
    			  i-=1;
    		  }
    	  }
    	  
      }
     
    /**
     * Method used to create a locked door
     * @param room: The room which contains the locked door 
     * @param nextRoom: The next room linked to the previous room
     * @param way: The direction to access to the next room
     * @param aLock: The lock linked to the locked door
     */ 
    private void createLockedDoor(Room room, Room nextRoom, String way, Lock aLock) {
    	LockedDoor door1 = new LockedDoor(nextRoom, aLock);
    	room.addExit(door1, way);
    }
    
    /**
     * Method used to manage the state of the direction buttons (enabled or not)
     * This method checks the presence of doors for the current room. 
     * A direction button is activated if the door associated to the direction is present and unlocked
     */
    public void manageButtons() {
        HashMap<String, Door> doors;
        doors = currentRoom.getDoors();
       
        //directions
        front.setEnabled(false);
        behind.setEnabled(false);
        left.setEnabled(false);
        right.setEnabled(false);
        
        if (doors.containsKey("front"))
            front.setEnabled(true);
        if (doors.containsKey("behind"))
            behind.setEnabled(true);
        if (doors.containsKey("left"))
            left.setEnabled(true);
        if (doors.containsKey("right"))
            right.setEnabled(true);    
            
      //enigmas
        //This method allows to active and disabled the speak button in fonction of the room.
        boolean hasEvent = false;
        for (Event event : currentRoom.getEvents()) {
        	if (event instanceof Enigma) { 
        		hasEvent = true;
        		break;
        	}
        }
        speak.setEnabled(hasEvent);
                
    }
    
    /**
     * Method used to upgrade the picture of the room with the current room picture
     */
    private void changePicture()
    {
        room = new ImageIcon(Game.class.getResource("/" + currentRoom.getDescription() + ".png"));
        pictureRoom.setIcon(room); 
    }
    
    /**
     * Method used to move in a next room linked to the current room
     * @param result 
     * @param way: The direction of the next room
     */
    public void move(String way) {
    	
    	
        currentRoom = currentRoom.getDoors().get(way).getNextRoom();
        if(currentRoom==rooms.get(1))
        {
        	textDescRoom.setText("<html>Welcome in this dungeon! Are you ready to fight this terrific world ? You must kill the<br>"
        			                 + "boss to save the world and loot the holy grall! You will have to find your path in<br>"
        			                 + "this creepy labyrinth! But your path will be strewn with pitfalls. To access the boss, you<br>"
        			                 + "will have to answer several enigma by staying alive. But it will be not easy because you <br>"
        			                 + "will meet a lot of beasts. To help you get started you just earned 100 pieces. Use them <br>"
        			                 + "wisely. Good luck ...");
        }
        else if (currentRoom==rooms.get(24)) 
        {
        	textDescRoom.setText("<html>Must stop this bullshit from north and south! Once and for all, the north, depending <br>"
        			+ "on our orientation, it changes everything!");
        }
        else if (currentRoom==rooms.get(31))
        {
        	textDescRoom.setText("Good luck for the monkey is very hard ! Equip your best weapon to beat this monster");
        }
        else 
        {
        	textDescRoom.setText("You are in the "+ currentRoom.getDescription());
        }
       // textDescRoom.setText(currentRoom.getDescription());
        player.moveRoom(currentRoom);
        changePicture();
        manageButtons();
        textEvent.setText(""); 
        isEnemy = false;
        
        //get the eventual fight of the room
        for (Event event : currentRoom.getEvents()) {
        	if (event instanceof Fight) {
        		isEnemy = ((Fight) event).getNpc().getEnemy();
        	}
        }

        //if there is an event
        if (!currentRoom.getEvents().isEmpty()) {
        	//if the npc is an enemy :
        	if (isEnemy) {
        		//launch the clicker game
        		clicker.resetClicker();
				clicker.clickerLauncher(10);
        	}
        }
    }
    
    /**
     * calculates the score when a fight (clicker game) is over
     */
    public void updateFightScore() {
    	
    	//erase the frame
    	clickerFrame.setVisible(false);
    	manageButtons();
		result = clicker.getClicks();
		String toReturn;
		int nbr = Integer.valueOf(currentRoom.getDescription().split("m")[1]);
		boolean win = currentRoom.getEvents().get(0).runFight(result,nbr * 10);
		
		if(win)
		{
			if (player.getInventory().addItem(currentRoom.getEvents().get(0).getItem())==false)
            {
				setText("<html>Well done, you get it!<br>Your bag is full... You need to sell some items. Come back later please </html>");
            }
            else
            {
            	player.getInventory().addItem(currentRoom.getEvents().get(0).getItem());
            	setText("<html>Well done, you won the fight!<br>You won "+currentRoom.getEvents().get(0).getItem().getName()+". Congratulations !!!</html>");
            	currentRoom.getEvents().get(0).setItem(null);
            } 
			currentRoom.getEvents().remove(0);
		}
		healthBar.setValue(player.getHealth()); 
		if(player.getHealth()==0)
        {
        	this.dispose();
        	new GameOver();
        }
    }
    
    
    /**
     * This method modifies the text which is displays in the game
     * @param aText the text to display in the game
     */
    
    public void setText(String aText)
    {
    	textDescRoom.setText("<html>You are in the "+ currentRoom.getDescription()+"<br>"+aText+"</html>");    	 
    }
    
    /**
     * display a frame which contains the enigma
     */
    void displayEnigma()
    {
        enigmaFrame = new JFrame();
        JPanel globalFrame = new JPanel(new GridLayout(2,1));
        JPanel image = new JPanel(); 
        JPanel enigma = new JPanel(new BorderLayout());
        JPanel answer = new JPanel(new GridLayout(2,1));
        JLabel logo = new JLabel();
        Font police = new Font ("Kristen ITC", Font.BOLD, 14);
        
        enigmaButton = new JButton("Submit!");
        enigmaButton.setFont(police);
        enigmaButton.addActionListener(l);
        enigmaButton.setBackground(Color.black);
        enigmaButton.setOpaque(true);
        enigmaButton.setForeground(Color.YELLOW);
        enigmaButton.setBorderPainted(false);
          
        image.setBackground(Color.BLACK);
        Icon interogationPoint = new ImageIcon(Game.class.getResource("/interrogation.jpg"));
        logo = new JLabel (interogationPoint);
        // logo.setBackground(Color.BLACK);
        
        
        for (Event event : currentRoom.getEvents()) {
        	if (event instanceof Enigma) {
        		question = ((Enigma) event).getQuestion();
        	}
        }
        
        textEnigma = new JLabel (question, JLabel.CENTER);
        textEnigma.setBackground(Color.BLACK);
        textEnigma.setForeground(Color.YELLOW);
        textEnigma.setOpaque(true);
        textEnigma.setFont(police);

        typingArea = new JTextField(20);
        typingArea.setBackground(Color.black);
        typingArea.setForeground(Color.YELLOW);
        
        //Create new custom border for JTextField
        //Border border = BorderFactory.createLineBorder(Color.red);
        //typingArea.setBorder(border);
        
        image.add(logo);
        
        answer.add(typingArea);
        answer.add(enigmaButton);
        
        enigma.add(image, BorderLayout.WEST);
        enigma.add(answer, BorderLayout.CENTER);
         
        globalFrame.add(textEnigma);
        globalFrame.add(enigma);
        

        enigmaFrame.add(globalFrame);
        enigmaFrame.pack();
        enigmaFrame.setSize(550,180);
        enigmaFrame.setLocationRelativeTo(null);
        enigmaFrame.setResizable(false);
        
        enigmaFrame.setVisible(true);
        
    }
    
    public JButton getEnigmaButton() {
    	return enigmaButton;
    }
    
    public JLabel getEnigmaLabel() {
    	return textEnigma;
    }
    
    public JFrame getEnigmaFrame() {
    	return enigmaFrame;
    }
    
}
