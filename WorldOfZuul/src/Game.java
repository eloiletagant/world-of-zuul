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

import java.util.ArrayList;
import java.util.HashMap;
import character.Player;
import room.Door;
import room.Room;
import item.*;


public class Game {
    private Parser parser;
    private Room currentRoom;
    private Player player, playerTest;
    private ArrayList<Room> rooms; 
    private InventoryInterface atest;
    public  Sound s;

    /**
     * Create the game and initialize its internal map.
     */
    public Game()
    {
    	rooms = new ArrayList<Room>();
    	createItems();
        createAllRooms();
        createAllDoors(rooms);
    	playerTest= new Player ("Kaamelott");
    	parser = new Parser();
        atest = new InventoryInterface(playerTest.getInventory());
        play();
        s = new Sound();
        s.playSound("music/SoundCave.wav");
    }
    
    public Player getPlayer()
    {
    	return playerTest;
    }
    public static void main (String[] args)
    {
        new Game();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createAllRooms() {   	
    	int fin=32;
    	for(int i=0; i<=fin; i++){
    		if (i < 14 || i > 29)
    			rooms.add(new Room("Room " + i, 0));
    		else
    			rooms.add(new Room("Room " + i, 1));
    	}
    	currentRoom = rooms.get(0);
    }
    
    private void createAllDoors(ArrayList<Room> rooms){
    	createTwoDoors(rooms.get(0), rooms.get(1) , "front");
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
        Consumable c1 = new Consumable("Brioche", "This brioche was cooked by the best people in the world and comes from Vendée !!!.", 10, true, "It gets 2 health points to the person who eats it.", 2, 0, false);
        Consumable c2 = new Consumable("Bread", "This bread was cooked by the baker of the village.", 5, true, "It gets 1 health point to the person who eats it.", 1, 0, false);
        Consumable c3 = new Consumable("Cookies", "This cookies was cooked by the Mie caline and it is delicious.", 15, true, "It gets 3 health points to the person who eats it.", 3, 0, false);
        Consumable c4 = new Consumable("Pineapple", "This fruit allow adding damage point. It was cultivated by Guethenoc", 15, true, "It gets 1 damage point to a weapon when the player scrubs it into his weapon.", 0, 1, true);
        Consumable c5 = new Consumable("Eggplant", "This vegetable allow adding damage point. It was cultivated by Guethenoc", 10, true, "It gets 1 damage point to the person who eats it.", 0, 1, false);
        Consumable c6 = new Consumable("Potion", "This potion was prepared by Merlin with all his love", 20, true, "It gets 2 damage point to a weapon when the player flips it on his weapon.", 0, 2, true);
        Key k1 = new Key("Hodor", "This key opens a very cold door.", 20, false);
        Key k2 = new Key("Sésame", "This key has magic power and will help you to find a treasure.", 20, false);
        Key k3 = new Key("Musse-Clef", "This key opens something.", 20, false);
        Key k4 = new Key("Tabou-Clef", "This key opens something.", 20, false);
        Key k5 = new Key("Clef-Bar", "This key opens something.", 20, false);
        Key k6 = new Key("Nu-Clef-ère", "This key opens something.", 20, false);
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
        playerTest.getInventory().addItem(c4);
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
    private void createTwoDoors(Room room, Room nextRoom, String way) {
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
}
