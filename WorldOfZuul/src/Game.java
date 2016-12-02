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
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.HashMap;

import character.Player;
import room.Door;
import room.Room;
import item.*;


public class Game extends JFrame {
	
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private ArrayList<Room> rooms; 
    private InventoryInterface inventoryInterface;
    private boolean inventoryIsOpen = false;
    public  Sound s;
    
    private JButton left, behind, front, right; //direction arrows
    private JButton bag; //inventory
    
    protected JLabel title;
    private JLabel text;
    protected Icon room;
    public JLabel pictureRoom;
    protected JPanel myPanel, HealthBag;
    private JLabel Health;

    /**
     * Create the game and initialize its internal map.
     */
    public Game() {
    	/*****************************
         ****** Pictures instantiation
         *****************************/
        ImageIcon room = new ImageIcon ("pictures/Room0.png");
        Icon arrowRight = new ImageIcon("pictures/arrowRight.png");
        Icon arrowFront = new ImageIcon("pictures/arrowFront.png");
        Icon arrowBehind = new ImageIcon ("pictures/arrowBehind.png");
        Icon arrowLeft = new ImageIcon("pictures/arrowLeft.png");
        Icon inventory = new ImageIcon("pictures/bag.jpg");
        Icon HealthBar = new ImageIcon("pictures/barredeVie.jpg");
         
        /**********************
         ******* Window content
         **********************/
        text = new JLabel ("Welcome to Dungeon Clicker. You are in the Room 0");
        pictureRoom = new JLabel(room);
        
        //Game Listener creation
        GameListener l = new GameListener(this, player, inventoryIsOpen);
         
        //Creation of a panel which will contain the room picture at the top and the buttons at the below
        JPanel myPanel = new JPanel(new BorderLayout ());
         
        //Creation of a panel which will contain all buttons(direction, inventory ..)
        JPanel panelButton = new JPanel (new  BorderLayout ());
        panelButton.setBackground(Color.black);    
         
        /******************
         * Health bar / bag
         ******************/
        //Panel which contains bag + bar life
        HealthBag = new JPanel (new GridLayout (2,1));
        HealthBag.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        HealthBag.setBackground(Color.black);
        
        //Label which contains the player's bar life
        Health = new JLabel (HealthBar); 
        Health.setBackground(Color.black);
         
        bag = new JButton(inventory);
        bag.setBackground(Color.black);
        bag.addActionListener(l);
                   
        HealthBag.add(Health);
        HealthBag.add(bag);
            
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
        JPanel panelFB = new JPanel (new BorderLayout());
        panelFB.add(front,BorderLayout.NORTH);
        panelFB.add(behind,BorderLayout.SOUTH);
        panelFB.setBackground(Color.black);
          
        //Panel which contains each direction buttons         
        JPanel buttonDirection = new JPanel(new GridLayout(1,3));
        buttonDirection.setBackground(Color.black);

        //Adding buttons on the direction panel
        buttonDirection.add(left);
        buttonDirection.add(panelFB);
        buttonDirection.add(right); 
             

        //Adding buttons in the panelButton
        panelButton.add(HealthBag, BorderLayout.WEST);
        panelButton.add(text, BorderLayout.CENTER);
        panelButton.add(buttonDirection, BorderLayout.EAST);
             
             
        //Final panel creation
        myPanel.add(pictureRoom,BorderLayout.CENTER);
        myPanel.add(panelButton, BorderLayout.SOUTH);
       
             
        /*********************
         **** Frame parameters
         *********************/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("WOZ");    
        this.add(myPanel);
        this.setSize(500, 500);
        this.pack();
        this.setVisible(true);
    	
    	s = new Sound();
    	rooms = new ArrayList<Room>();
        createAllRooms();
        createAllDoors(rooms);
        manageDirectionButton();
    	player= new Player ("Kaamelott");
    	createItems();
    	parser = new Parser();
        s.playSound("music/SoundCave.wav");
        //inventory ?
           
    }
    
    public Player getPlayer() {
    	return player;
    }

    public JButton getFrontB() {
    	return front;
    }

    public JButton getBehindB() {
    	return behind;
    }

    public JButton getRightB() {
    	return right;
    }

    public JButton getLeftB() {
    	return left;
    }
    
    public JButton getBagB() {
    	return bag;
    }
    
    public void setOpenningInventory(boolean state) {
    	inventoryIsOpen = state;
    }
    
    public void openInventory() {
    	inventoryInterface = new InventoryInterface(player.getInventory());
    }
    
    /**
     * Create all the rooms and link their exits together.
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
    
    private void createAllDoors(ArrayList<Room> rooms){
        createDoor(rooms.get(0), rooms.get(1) , "front");
        createDoor(rooms.get(1), rooms.get(2) , "left");
        createDoor(rooms.get(1), rooms.get(4) , "front");
        createDoor(rooms.get(1), rooms.get(9) , "right");
        createDoor(rooms.get(1), rooms.get(9) , "right");
        createDoor(rooms.get(2), rooms.get(3) , "front");
        createDoor(rooms.get(3), rooms.get(4) , "right");
        createDoor(rooms.get(3), rooms.get(5) , "left");
        createDoor(rooms.get(5), rooms.get(8) , "front");
        createDoor(rooms.get(5), rooms.get(6) , "left");
        createDoor(rooms.get(6), rooms.get(7) , "left");
        createDoor(rooms.get(6), rooms.get(26) , "front");
        createDoor(rooms.get(9), rooms.get(10) , "right");
        createDoor(rooms.get(10), rooms.get(11) , "front");
        createDoor(rooms.get(11), rooms.get(12) , "right");
        createDoor(rooms.get(11), rooms.get(13) , "front");
        createDoor(rooms.get(26), rooms.get(25) , "front");
        createDoor(rooms.get(25), rooms.get(27) , "right");
        createDoor(rooms.get(25), rooms.get(24) , "front");
        createDoor(rooms.get(24), rooms.get(23) , "left");
        createDoor(rooms.get(27), rooms.get(28) , "front");
        createDoor(rooms.get(28), rooms.get(29) , "front");
        createDoor(rooms.get(23), rooms.get(22) , "front");
        createDoor(rooms.get(23), rooms.get(20) , "left");
        createDoor(rooms.get(20), rooms.get(19) , "left");
        createDoor(rooms.get(20), rooms.get(21) , "front");
        createDoor(rooms.get(19), rooms.get(18) , "front");
        createDoor(rooms.get(18), rooms.get(16) , "front");
        createDoor(rooms.get(18), rooms.get(21) , "right");
        createDoor(rooms.get(16), rooms.get(17) , "left");
        createDoor(rooms.get(16), rooms.get(15) , "right");
        createDoor(rooms.get(15), rooms.get(14) , "front");
        createDoor(rooms.get(15), rooms.get(21) , "right");
        createDoor(rooms.get(14), rooms.get(22) , "front");   
        createDoor(rooms.get(17), rooms.get(30) , "front");   
        createDoor(rooms.get(30), rooms.get(31) , "front"); 
        createDoor(rooms.get(31), rooms.get(32) , "front");   
     }
    
    /**
     * Create all items
     */
    private void createItems()
    {
    	Weapon w1 = new Weapon("Axe", "This axe do not only allow cutting trees.", 20, true, 3, false);
    	Weapon w2 = new Weapon("Bow", "This bow is for a true Robin wood.", 90, true, 5, false);
        Weapon w3 = new Weapon("Butcher knife", "It is a terrible weapon for a real butcher.", 30, true, 7, true);
        Weapon w4 = new Weapon("Sword", "This sword is the weapon the most dreaded in the world of Kaamelott.", 90, true, 9, true);
        Consumable c1 = new Consumable("Brioche", "This brioche was cooked by the best people in the world and comes from Vend�e !!!.", 10, true, "It gets 2 health points to the person who eats it.", 2, 0, false);
        Consumable c2 = new Consumable("Bread", "This bread was cooked by the baker of the village.", 5, true, "It gets 1 health point to the person who eats it.", 1, 0, false);
        Consumable c3 = new Consumable("Cookies", "This cookies was cooked by the Mie caline and it is delicious.", 15, true, "It gets 3 health points to the person who eats it.", 3, 0, false);
        Consumable c4 = new Consumable("Pineapple", "This fruit allow adding damage point. It was cultivated by Guethenoc", 15, true, "It gets 1 damage point to a weapon when the player scrubs it into his weapon.", 0, 1, true);
        Consumable c5 = new Consumable("Eggplant", "This vegetable allow adding damage point. It was cultivated by Guethenoc", 10, true, "It gets 1 damage point to the person who eats it.", 0, 1, false);
        Consumable c6 = new Consumable("Potion", "This potion was prepared by Merlin with all his love", 20, true, "It gets 2 damage point to a weapon when the player flips it on his weapon.", 0, 2, true);
        Key k1 = new Key("Hodor", "This key opens a very cold door.", 20, false);
        Key k2 = new Key("S�same", "This key has magic power and will help you to find a treasure.", 20, false);
        Key k3 = new Key("Musse-Clef", "This key opens something.", 20, false);
        Key k4 = new Key("Tabou-Clef", "This key opens something.", 20, false);
        Key k5 = new Key("Clef-Bar", "This key opens something.", 20, false);
        Key k6 = new Key("Nu-Clef-�re", "This key opens something.", 20, false);
        Key k7 = new Key("Gy-Clef", "This key opens something.", 20, false);
        Lock l1 = new Lock();
        l1.addKey(k3);
        Lock l2 = new Lock();
        l2.addKey(k2);
        Lock l3 = new Lock();
        l3.addKey(k4);
        Lock l4 = new Lock();
        l4.addKey(k5);
        Lock l5 = new Lock();
        l5.addKey(k6);
        Lock l6 = new Lock();
        l6.addKey(k7);
        Lock l7 = new Lock();
        l7.addKey(k1);
        Chest ch1 = new Chest("Ali baba box", "This box contains something for you.", 1, 5, l1);
        Chest ch2 = new Chest("Little box","This box contains something for you.", 2, 15, l2);
        Chest ch3 = new Chest("Gift Box", "This box contains something for you.", 3, 30, l3);
        Chest ch4 = new Chest("Treasure box", "This box contains something for you.", 2, 60, l4);
        boolean ok = player.getInventory().addItem(k6);
    }
    	

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {
    	player = new Player(parser.getCommand());
        printWelcome();
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul " + player.getName() + " !!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription() + " Level : " + currentRoom.getLevel());
        System.out.print("Exits: ");


        for (HashMap.Entry<String, Door> entry : currentRoom.getDoors().entrySet()) {
            System.out.println(entry.getKey() + " / " + entry.getValue().getNextRoom().getDescription() + " / " + entry.getValue().getNextRoom().getLevel());
        }

        System.out.println();

    }


    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }


    /**
     * method to associate a key and a lock
     * maybe not really useful
     */
    private Lock createLock(String keyName, String keyDescription, int keyPrice, boolean keySellAble) {
        Lock lock = new Lock();
        lock.addKey(new Key(keyName, keyDescription, keyPrice, keySellAble));
        return lock;
    }
    
    /**
     * method to associate a key and a lock
     * maybe not really useful
     */
    private void createDoor(Room room, Room nextRoom, String way) {
    	Door door1 = new Door(nextRoom);
    	room.addExit(door1, way);
    	Door door2 = new Door(room);
    	String oppositeWay;
    	
    	switch (way)
    	{
    	  case "front":
    	    oppositeWay = "behind";
    	    break;  
    	  case "behind":
      	    oppositeWay = "front";
      	    break;
    	  case "right":
      	    oppositeWay = "left";
      	    break;
    	  case "left":
        	oppositeWay = "right";
        	break;
    	  case "upstair":
        	oppositeWay = "downstair";
        	break;
    	  case "downstair":
          	oppositeWay = "upstair";
          	break; 
    	  default:
    		oppositeWay="";
    	    break;             
    	}
    	nextRoom.addExit(door2, oppositeWay);
    }
    
    /**
     * The method allows to check were are the exit of each room. In fonction of the exit, the arrow of direction are activated or disactivated.
     */
    private void manageDirectionButton ()
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
     * This methode allows to change the picture in fonction of the room where is the player
     */
    private void changePicture()
    {
        room = new ImageIcon("pictures/"+ currentRoom.getDescription()+".png");
        pictureRoom.setIcon(room); 
    }
    /**
     * this method allows to go in the nextRoom;
     */
    public void move(String way)
    {
        currentRoom = currentRoom.getDoors().get(way).getNextRoom();
        text.setText("You are in the " + currentRoom.getDescription());
        changePicture();
        manageDirectionButton ();
    }
}
