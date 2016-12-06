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
import javax.swing.border.Border;

import java.util.ArrayList;
import java.util.HashMap;

import character.NPC;
import character.Player;
import event.Event;
import event.Fight;
import room.Door;
import room.LockedDoor;
import room.Room;
import item.*;



public class Game extends JFrame {
	
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private Weapon w1, w2, w3, w4;
    private Consumable c1, c2, c3, c4, c5, c6, c7,c8;
    private Key k1, k2, k3, k4, k5, k6, k7;
    private Lock l1, l2, l3, l4, l5, l6, l7;
    private Chest ch1, ch2, ch3, ch4;
    private ArrayList<Room> rooms; 
    private boolean inventoryIsOpen = false;
    public  Sound sound;
   
    
    private JButton left, behind, front, right, bag, search, speak; //direction arrows and bag (inventory)
    private JLabel title, text, pictureRoom, health, answer;
    private JPanel globalPanel, buttonsPanel, healthBag, panelFB, buttonDirection, textDisplay;
    private JTextField typingArea;
    
    private Icon room, arrowRight, arrowLeft, arrowFront, arrowBehind, inventory, healthBar, wen, bubble;
    private InventoryInterface showInventory;
    private GameListener l;
    
    
    
    //for the clicker game
    private Clicker clicker;
    private JFrame clickerFrame;
    private JButton clickButton, doneButton;
    private JPanel clickerDownPanel;
    private JLabel clickLabel;
    private JProgressBar bar;
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
        parser = new Parser(this);
        
        Font font = new Font ("Kristen ITC", Font.BOLD, 14);
        
    	/*****************************
         ****** Pictures instantiation
         *****************************/
        room = new ImageIcon ("pictures/Room0.png");
        arrowRight = new ImageIcon("pictures/arrowRight.png");
        arrowFront = new ImageIcon("pictures/arrowFront.png");
        arrowBehind = new ImageIcon ("pictures/arrowBehind.png");
        arrowLeft = new ImageIcon("pictures/arrowLeft.png");
        inventory = new ImageIcon("pictures/bag.png");
        healthBar = new ImageIcon("pictures/barredeVie.jpg");
        wen = new ImageIcon("pictures/loupe_5.png");
        bubble = new ImageIcon("pictures/Dialogue.png");
        
         
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
        health = new JLabel (healthBar); 
        health.setBackground(Color.black);
         
        bag = new JButton(inventory);
        bag.setBackground(Color.black);
        bag.addActionListener(l);
        
        search = new JButton(wen);
        search.setBackground(Color.black);
        search.addActionListener(l);
        
        speak = new JButton(bubble);
        speak.setBackground(Color.black);
        speak.setEnabled(false);
        speak.addActionListener(l);
        
        healthBag.add(health);
        healthBag.add(speak);
        healthBag.add(bag);
        healthBag.add(search);
        
        
        //TEXT DISPLAY --> EN COURS (ANATOLE)
        
        
        text = new JLabel("Welcome to Dungeon Clicker", JLabel.CENTER);
        text.setForeground(Color.yellow);
        text.setFont(font);

        //button = new JButton("Clear");
        //button.addActionListener(this);
         
        answer = new JLabel("test", JLabel.CENTER);
        answer.setForeground(Color.yellow);
        answer.setFont(font);
        
        //typingArea = new JTextField(20);
        //typingArea.setBackground(Color.black);
        //typingArea.setForeground(Color.WHITE);
        //typingArea.addKeyListener(parser);
        //Create new custom border for JTextField
        //Border border = BorderFactory.createLineBorder(Color.red);
        //:typingArea.setBorder(border);
        
        //create the panel which contains all the text
        textDisplay = new JPanel();
        textDisplay.setBackground(Color.black);
        textDisplay.add(text); 
        //textDisplay.add(typingArea); 
        //textDisplay.add(answer);
        
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
        this.setTitle("WOZ");    
        this.add(globalPanel);
        this.setSize(500, 500);
        this.pack();
        this.setVisible(true);
    	
    	player = new Player ("Kaamelott");
    	rooms = new ArrayList<Room>();
    	
    	//create the frame of the clicker
    	createClickerFrame();
    	createItems();
    	createAllRooms();
    	setEvents();
        createAllDoors(rooms);
        manageDirectionButtons();
        testAddItemsToInventory();
        player.moveRoom(rooms.get(0));
        addChestsToRooms();
        
        
    	sound = new Sound();
    	sound.playSound("music/SoundCave.wav");
    }
    
    public void setAnswer(String s) {
    	answer.setText(s);
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
        bar.setStringPainted(true);
        //bar.setUI(new MyProgressUI());
        
        
        Icon clickIcon = new ImageIcon("pictures/clicker_swords.png");
        clickButton = new JButton("Click to attack!", clickIcon);
        clickButton.addActionListener(clicker);
        clickButton.setFont(new Font("Kristen ITC", Font.BOLD, 40));
        clickButton.setOpaque(true);
        
        clickLabel = new JLabel("Clicks: " + clicker.getClicks(), JLabel.CENTER);
        clickLabel.setFont(new Font("Kristen ITC", Font.BOLD, 30));
        
        
        clickerGlobalPanel = new JPanel(new BorderLayout());
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
    
    public void setOpenningInventory(boolean state) {
    	inventoryIsOpen = state;
    }
    
    /**
     * Method used to open the inventory from the GameListener
     * @param open
     */
    public void openInventory(boolean open) {
    	if (open) {
    		showInventory = new InventoryInterface(player.getInventory(), player,this);
    	}
    	else
    	{
    		if (showInventory.getVisibility()==true)
    		{
    			showInventory.exitInventory();
    		}
    	}
    }
    
    public boolean getInventoryIsOpen()
    {
    	return inventoryIsOpen;
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
			//Trade trade1 = new Fight("trade1",w1,player,bohort);
			//rooms.get(24).addEvent(trade1);
			//LANCELOT
			NPC lancelot = new NPC("Lancelot",10, 2, true);
			//Trade trade2 = new Fight("trade2",w1,player,lancelot);
			//rooms.get(31).addEvent(trade2);
			
			//NPC ENIGMA
			//MERLIN
			NPC merlin = new NPC("Merlin",15, 2, false);
			//Enigma enigma1 = new Enigma("Enigma1",k1,player,merlin);
			//rooms.get(9).addEvent(enigma1);
			//KARADOC
			NPC karadoc = new NPC("Karadoc",15, 2, false);
			//Enigma enigma2 = new Enigma("Enigma2",k2,player,karadoc);
			//rooms.get(4).addEvent(enigma2);
			//PERCEVAL
			NPC perceval = new NPC("Perceval",20, 2, false);
			//Enigma enigma3 = new Enigma("Enigma3",k5,player,perceval);
			//rooms.get(27).addEvent(enigma3);
			
		//NPC Enemy
			//MINOTAUR
			NPC minotaur = new NPC("Minotaur",5, 2, true);
			Fight fight1 = new Fight("fight1",w3,player,minotaur);
			rooms.get(1).addEvent(fight1);
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
			Fight fight4 = new Fight("fight4",k6,player,skeleton);
			rooms.get(20).addEvent(fight4);
			//CREEPER
			NPC creeper = new NPC("Creeper",30, 2, true);
			Fight fight5 = new Fight("fight5",w1,player,creeper);
			rooms.get(16).addEvent(fight5);
			//MONKEY KING
			NPC monkey = new NPC("Monkey King",100, 2, true);
			Fight fight6 = new Fight("fight boss !",w2,player,monkey);
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
        createLockedDoor(rooms.get(27),  rooms.get(28), "front", l6);
        createDoor(rooms.get(27), rooms.get(25) , "left");
        //Room 28
        createDoor(rooms.get(28), rooms.get(29) , "front");
        createDoor(rooms.get(28), rooms.get(27) , "behind");
        //Room 29
        createDoor(rooms.get(29), rooms.get(28) , "behind");
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
        c1 = new Consumable("Brioche", "This brioche was cooked by the best people in the world and comes from Vend�e !!!.", 10, true, "It gets 2 health points to the person who eats it.", 2, 0, false);
        c2 = new Consumable("Bread", "This bread was cooked by the baker of the village.", 5, true, "It gets 1 health point to the person who eats it.", 1, 0, false);
        c3 = new Consumable("Cookies", "This cookies was cooked by the Mie caline and it is delicious.", 15, true, "It gets 3 health points to the person who eats it.", 3, 0, false);
        c4 = new Consumable("Pineapple", "This fruit allow adding damage point. It was cultivated by Guethenoc", 15, true, "It gets 1 damage point to a weapon when the player scrubs it into his weapon.", 0, 1, true);
        c5 = new Consumable("Eggplant", "This vegetable allow adding damage point. It was cultivated by Guethenoc", 10, true, "It gets 1 damage point to the person who eats it.", 0, 1, false);
        c6 = new Consumable("Potion", "This potion was prepared by Merlin with all his love", 20, true, "It gets 2 damage point to a weapon when the player flips it on his weapon.", 0, 2, true);
        c7 = new Consumable("Pineapple", "This fruit allow adding damage point. It was cultivated by Guethenoc", 15, true, "It gets 1 damage point to a weapon when the player scrubs it into his weapon.", 0, 1, true);
        c8 = new Consumable("Potion", "This potion was prepared by Merlin with all his love", 20, true, "It gets 2 damage point to a weapon when the player flips it on his weapon.", 0, 2, true);
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
        l4.addKey(k5);
        l5 = new Lock();
        l5.addKey(k6);
        l6 = new Lock();
        l6.addKey(k7);
        l7 = new Lock();
        l7.addKey(k1);
        ch1 = new Chest("Ali baba box", "This box contains something for you.", 2, 5, l1);
        ch1.addItem(c2);
        ch1.addItem(w1);
        ch2 = new Chest("Little box","This box contains something for you.", 3, 15, l2);
        ch2.addItem(c1);
        ch2.addItem(c6);
        ch2.addItem(w2);
        ch3 = new Chest("Gift Box", "This box contains something for you.", 2, 30, l3);
        ch3.addItem(c5);
        ch3.addItem(w3);
        ch4 = new Chest("Treasure box", "This box contains something for you.", 4, 60, l4);
        ch4.addItem(c8);
        ch4.addItem(c4);
        ch4.addItem(c3);
        ch4.addItem(k6);

    }
    
    
   private void testAddItemsToInventory(){
	   player.getInventory().addItem(k1);
	   player.getInventory().addItem(k2);
	   player.getInventory().addItem(k3);
	   player.getInventory().addItem(k4);
	   player.getInventory().addItem(k5);
	   player.getInventory().addItem(k7);
	   player.getInventory().addItem(c1);
	   player.getInventory().addItem(w1);
	   player.getInventory().addItem(w2);
	   player.getInventory().addItem(c5);
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
    	 rooms.get(8).addChest(ch1);
    	 rooms.get(29).addChest(ch4);
    	 rooms.get(15).addChest(ch3);
    	 rooms.get(12).addChest(ch2);
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
	  		  text.setText("This chest is empty.");
	  		 
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
    		  text.setText(itemAdded); 
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
    public void manageDirectionButtons()
    {
            HashMap<String, Door> doors;
            doors = currentRoom.getDoors();
           
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
    }
    
    /**
     * Method used to upgrade the picture of the room with the current room picture
     */
    private void changePicture()
    {
        room = new ImageIcon("pictures/"+ currentRoom.getDescription()+".png");
        pictureRoom.setIcon(room); 
    }
    
    /**
     * Method used to move in a next room linked to the current room
     * @param result 
     * @param way: The direction of the next room
     */
    public void move(String way) {
    	
        currentRoom = currentRoom.getDoors().get(way).getNextRoom();
        setText(currentRoom.getDescription());
        player.moveRoom(currentRoom);
        changePicture();
        manageDirectionButtons();
        manageEgnimButton();
        
        if (!player.getLocation().getEvents().isEmpty()) {
        	
        	if (player.getLocation().getEvents().get(0).getNpc().getEnemy()) {
        		
				clicker.clickerLauncher(10);
				System.out.println("clicker launched");

        	}
        
        }
        
    }
    
    /**
     * calculates the score when a fight (clicker game) is over
     */
    public void updateFightScore() {
    	
    	System.out.println(clicker.getClicks());
    	
    	//erase the frame
    	clickerFrame.setVisible(false);
    	manageDirectionButtons();
		result = clicker.getClicks();
		
		int nbr = Integer.valueOf(player.getLocation().getDescription().split("m")[1]);
		boolean win = player.getLocation().getEvents().get(0).runFight(result,nbr * 10);
		if(win) {
			player.getLocation().getEvents().remove(0);
		}
		
    }
    
    /**
     * This method allows to active and disactive the speak button in fonction of the room. 
     */
    public void manageEgnimButton ()
    {
        if (player.getLocation() == rooms.get(4) || player.getLocation() == rooms.get(9) || player.getLocation() == rooms.get(27))
        { 
        	//System.out.print("noimom"); 
            speak.setEnabled(true);
        }                
        else 
        {
        	speak.setEnabled(false);
        }
    }
    
    /**
     * This method modifies the text which is displays in the game
     * @param aText the text to display in the game
     */
    public void setText(String aText)
    {
    	text.setText("<html>You are in the "+ currentRoom.getDescription()+"<br>"+aText+"</html>");    	 
    }
    void displayEnigma()
    {
        JFrame enigmaFrame = new JFrame();
        JPanel globalFram = new JPanel (new GridLayout (1,2));
        JPanel egnima = new JPanel (new GridLayout (2,1));
        JLabel logo = new JLabel();
         
        
        JPanel image = new JPanel();   
        image.setBackground(Color.BLACK);
        Icon interogationPoint = new ImageIcon("./pictures/Question.png");
        logo = new JLabel (interogationPoint);
        // logo.setBackground(Color.BLACK);
         
         JLabel textEgnima = new JLabel ("EGnimeeeee", JLabel.CENTER);
         textEgnima.setBackground(Color.BLACK);
         textEgnima.setForeground(Color.YELLOW);
         textEgnima.setOpaque(true);
         Font police = new Font ("Kristen ITC", Font.BOLD, 14);
         textEgnima.setFont(police);
         
         JTextField typingArea = new JTextField(20);
       
        
        
        //typingArea.addKeyListener(parser);
        
        //Create new custom border for JTextField
     //   Border border = BorderFactory.createLineBorder(Color.red);
      //  typingArea.setBorder(border);
         
       
        
       
        
        typingArea = new JTextField(20);
        typingArea.setBackground(Color.black);
        typingArea.setForeground(Color.WHITE);
       // typingArea.addKeyListener(parser);
        
        image.add(logo);
        
        egnima.add(textEgnima);
        egnima.add(typingArea);
        
        globalFram.add(image);
        globalFram.add(egnima);
        
        enigmaFrame.setSize(500,500);
        
        
        enigmaFrame.add(globalFram);
        enigmaFrame.pack();
        enigmaFrame.setVisible(true);
        
    }
    
}
