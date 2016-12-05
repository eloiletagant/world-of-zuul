import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import character.*;
import item.*;
import room.*;

/**
 * This method creates the frame with the design of the inventory.
 * It allows displaying items of the inventory of the player.
 * 
 * @author Group4
 * @version 01/12/2016
 */
public class InventoryInterface extends JFrame {
	
    //button building
    private JButton back, back2, use, sell, equip, unequip, aButton;
    private JLabel title, goldLabel, goldIconLabel, iconLabel, nom, description, price, care, damages, effects;
    private JPanel myPanel, up, inventory, down, gold, view, actions, completeDescription;
    private JFrame inventoryFrame, itemFrame;
    private Inventory inventoryPlayer;
    private Player player;
    private Icon anIcon, backIcon, goldIcon;
    private int counter = 0;
    private Item myItem;
    private Weapon myWeapon;
    private Consumable myConsumable;
    private boolean viewInventory = true;
    private boolean aWeapon,lock;
    private InventoryInterfaceListener evt;
    private String name;
    private JButton[] buttonItems;
    private Game game;
    private HashMap<String,Door> doors;
    

    /**
     * Constructor for objects of class InventoryInterface
     */
    public InventoryInterface(Inventory anInventory, Player aPlayer, Game aGame)
    {
    	inventoryPlayer = anInventory;
    	player = aPlayer;
    	game = aGame;
        myPanel = new JPanel(new BorderLayout ());
        up = new JPanel (new GridLayout (1,3));
        inventory = new JPanel (new GridLayout (0,5,10,10));
        inventory.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        inventory.setBackground(Color.black);
        down = new JPanel (new GridLayout (1,1));
        
        Font police = new Font ("Kristen ITC", Font.BOLD, 14);
        
        
        title = new JLabel ("INVENTORY", JLabel.CENTER);
        title.setBackground(Color.black);
        title.setOpaque(true);
        title.setForeground(Color.yellow);
        title.setFont(police);
        
        
        myPanel.setBackground(Color.black);
        
		
        backIcon = new ImageIcon("pictures/back.png");
		back = new JButton ("BACK", backIcon);
        back.setBackground(Color.black);
        back.setOpaque(true);
        back.setForeground(Color.yellow);
        back.setFont(police);


        goldLabel = new JLabel("GOLD :" + inventoryPlayer.getGold());
        goldLabel.setBackground(Color.black);
        goldLabel.setOpaque(true);
        goldLabel.setForeground(Color.yellow);
        goldLabel.setFont(police);
        goldIcon = new ImageIcon("pictures/gold.png");
        goldIconLabel = new JLabel(goldIcon);
        goldIconLabel.setBackground(Color.black);
        goldIconLabel.setOpaque(true);
		gold = new JPanel ();
		gold.add(goldIconLabel);
		gold.add(goldLabel);
		gold.setBackground(Color.black);
        gold.setOpaque(true);

        
        up.add(back);
        up.add(title);
        up.add(gold);
        
        
      //Listeners for buttons action
        evt= new InventoryInterfaceListener(this);
        back.addMouseListener(evt);
        
        buttonItems = new JButton[inventoryPlayer.getNbItems()];
        for (Item item : inventoryPlayer.getItems())
        {
        	aButton=getJButton(item);
        	buttonItems[counter] = aButton;
        	buttonItems[counter].addMouseListener(evt);
           	inventory.add(buttonItems[counter]);
           	counter+=1;
        }
    	
        while (counter!=inventoryPlayer.getMaxItems())
		{
			JPanel empty = new JPanel();
			empty.setBackground(new Color(70, 63, 55));
			inventory.add(empty);
			counter+=1;
		}    
        
        
        myPanel.add(up,BorderLayout.NORTH);
        myPanel.add(inventory,BorderLayout.CENTER);
        myPanel.add(down,BorderLayout.SOUTH);
        
        inventoryFrame= new JFrame("My inventory");  
        inventoryFrame.add(myPanel);
        inventoryFrame.setSize(500, 500);
        inventoryFrame.pack();
        inventoryFrame.setVisible(true);
    }

    /**
     * This method returns an item from the inventory of the player according to its name.
     * @param name of the item to return
     * @return an item
     */
    public Item searchItem(String name)
    {
    	for (Item item : inventoryPlayer.getItems())
    	{
    		if (item.getName() == name)
    		{
    			myItem=item;
    		}
    	}
    	return myItem;
    }
    
    /**
     * This method returns the item which is managed in the inventory of the player.
     * @return an item
     */
    public Item searchItemDisplayed()
    {
    	for (Item item : inventoryPlayer.getItems())
    	{
    		if ((item.getDisplay() == true))
    		{
    			myItem=item;
    			item.setManaged();
    		}
    	}
    	return myItem;
    }
    
    /**
     * This method returns the back button
     * @return JButton back
     */
    public JButton getBack()
    {
    	return back;
    }
    
    /**
     * This method returns the use button
     * @return JButton use
     */
    public JButton getUse()
    {
    	return use;
    }
    
    /**
     * This method returns the equip button
     * @return JButton use
     */
    public JButton getEquip()
    {
    	return equip;
    }
    
    /**
     * This method returns the unequip button
     * @return JButton use
     */
    public JButton getUnequip()
    {
    	return unequip;
    }
    /**
     * This method returns the sell button
     * @return JButton sell
     */
    public JButton getSell()
    {
    	return sell;
    }
    
    /**
     * This method returns an item button
     * @param i : index of button Items
     * @return JButton
     */
    public JButton getItemToDisplay(int i)
    {
    	return buttonItems[i];
    }
    
    /**
     * This method creates a new window and display all information of the given item.
     * @param anItem to display
     */
    public void displayItem(Item anItem)
    {
    	anItem.setManaged();
    	exitInventory();
    	Font police = new Font ("Kristen ITC", Font.BOLD, 14);
    	Font police2 = new Font ("Kristen ITC", Font.BOLD, 12);
    	
    	backIcon = new ImageIcon("pictures/back.png");
		back2 = new JButton ("BACK", backIcon);
        back2.setBackground(Color.black);
        back2.setOpaque(true);
        back2.setForeground(Color.yellow);
        back2.setFont(police);
        
        back2.addMouseListener(evt);
        
        title = new JLabel ("INVENTORY : " + anItem.getName(), JLabel.CENTER);
        title.setBackground(Color.black);
        title.setOpaque(true);
        title.setForeground(Color.yellow);
        title.setFont(police);
        
        up = new JPanel (new GridLayout (1,2));
        up.add(back);
        up.add(title);
    	
    	itemFrame = new JFrame(anItem.getName());
    	itemFrame.setSize(500, 500);
    	
    	iconLabel=new JLabel(getIcon(anItem));
    	iconLabel.setBackground(new Color(70, 63, 55));
        iconLabel.setOpaque(true);
        
        completeDescription=new JPanel(new GridLayout(0,1));
        completeDescription.setBackground(new Color(70, 63, 55));
        completeDescription.setOpaque(true);
        
        nom=new JLabel("Name : "+anItem.getName());
        nom.setForeground(Color.white);
        nom.setFont(police2);
        completeDescription.add(nom);
        description=new JLabel("Description : "+anItem.getDescription());
        description.setForeground(Color.white);
        description.setFont(police2);
        completeDescription.add(description);
        price=new JLabel("Price : "+anItem.getPrice() + " golds");
        price.setForeground(Color.white);
        price.setFont(police2);
        completeDescription.add(price);
        
        sell= new JButton("SELL");
        sell.setBackground(Color.black);
        sell.setForeground(Color.yellow);
        sell.setFont(police);
        
        actions= new JPanel(new GridLayout(1,2));
        
        aWeapon=false;
    	for (Item item : inventoryPlayer.getItems())
    	 {
    		 if (item instanceof Weapon)
    		 {
    			 if (((Weapon) item).getEquiped()==true)
    			 {
    				 aWeapon=true;
    			 }
    		 }
    	 }
        
        if (anItem instanceof Weapon)
        {
        	myWeapon = new Weapon(anItem.getName(), anItem.getDescription(), anItem.getPrice(), anItem.getSellAble(), ((Weapon) anItem).getDamages());
        	damages=new JLabel("Damages : "+myWeapon.getDamages());
        	damages.setForeground(Color.white);
        	damages.setFont(police2);
        	completeDescription.add(damages);
        	if (((Weapon) anItem).getEquiped()==false)
        	{
        		equip= new JButton("EQUIP");
        		equip.setBackground(Color.black);
        		equip.setForeground(Color.yellow);
        		equip.setFont(police);
        		actions.add(equip);
        		equip.addMouseListener(evt);
        		if (aWeapon==true)
        		{
        			equip.setEnabled(false);
        		}
        	}
        	else
        	{
        		unequip= new JButton("UNEQUIP");
        		unequip.setBackground(Color.black);
        		unequip.setForeground(Color.yellow);
        		unequip.setFont(police);
        		actions.add(unequip);
        		unequip.addMouseListener(evt);
        	}
        	actions.add(sell);
            sell.addMouseListener(evt);           
        }
        else
        {
        	use= new JButton("USE");
        	use.setBackground(Color.black);
            use.setForeground(Color.yellow);
            use.setFont(police);
            actions.add(use);
    		use.addMouseListener(evt);
    		if (anItem instanceof Key)
            {
            	doors=player.getLocation().getDoors();
            	lock=false;
            	for (Map.Entry<String,Door> door : doors.entrySet())
       		 	{
            		if (door.getValue().isLocked()==true)
            		{
            			lock=true;
            		}
       		 	}
            	if (player.getLocation().hasChest()==true)
            	{
            		lock=true;
            	}
            	if (lock==false)
            	{
            		use.setEnabled(false);
            	}
            }
    		if (aWeapon==false)
    		{
    			if (anItem instanceof Consumable)
    			{
    				if (((Consumable) anItem).getWeapon()==true)
    				{
    					use.setEnabled(false);
    				}
    			}
    		}
    		actions.add(sell);
    		sell.addMouseListener(evt);
            if (anItem.getSellAble()==false)
        	{
        		sell.setEnabled(false);
        	}
            if(anItem instanceof Consumable)
            {
            	myConsumable = new Consumable(anItem.getName(), anItem.getDescription(), anItem.getPrice(), anItem.getSellAble(), ((Consumable) anItem).getEffect(), ((Consumable) anItem).getCare(), ((Consumable) anItem).getDamage(), ((Consumable) anItem).getWeapon());
            	effects=new JLabel("Effect : "+myConsumable.getEffect());
            	effects.setForeground(Color.white);
            	effects.setFont(police2);
            	completeDescription.add(effects);
            	if (myConsumable.getCare()!=0)
            	{
            		care=new JLabel("Care : "+myConsumable.getCare()+" HP");
                	care.setForeground(Color.white);
                	care.setFont(police2);
                	completeDescription.add(care);
            	}
            	else
            	{
            		if (myConsumable.getWeapon()==true)
            		{
            			damages=new JLabel("Damages added to your weapon : "+myConsumable.getDamage()+" HP");
            		}
            		else
            		{
            			damages=new JLabel("Damages added : "+myConsumable.getDamage()+" HP");

            		}
                	damages.setForeground(Color.white);
                	damages.setFont(police2);
                	completeDescription.add(damages);
            	}
            }
        }
        
        
        
    	view=new JPanel(new BorderLayout());
    	view.add(up,BorderLayout.NORTH);
    	view.add(iconLabel,BorderLayout.CENTER);
    	view.add(completeDescription,BorderLayout.EAST);
    	view.add(actions,BorderLayout.SOUTH);
    	
    	itemFrame.add(view);
    	itemFrame.pack();
    	itemFrame.setVisible(true);
    }
    
    /**
     * This method returns the inventory of the player.
     * @return Inventory
     */
    public Inventory getInventory()
    {
    	return inventoryPlayer;
    }
    
    /**
     * This method returns the player according to the inventory.
     * @return Player
     */
    public Player getPlayer()
    {
    	return player;
    }
    
    /**
     * This method returns the game according to the inventory.
     * @return game
     */
    public Game getGame()
    {
    	return game;
    }
    
    /**
     * This method returns the JButton according to the given item.
     * @param item
     * @return JButton
     */
    public JButton getJButton(Item anItem)
    {
    	anIcon=getIcon(anItem);
		aButton= new JButton(anIcon);
		aButton.setBackground(new Color(70, 63, 55));
    	return aButton;
    }
    
    
    /**
     * This method returns the icon according to the given item.
     * @param item
     * @return JButton
     */
    public Icon getIcon(Item anItem)
    {
    	for (Item item : inventoryPlayer.getItems())
    	{
    		name=item.getName();
    		if (anItem instanceof Key)
    		{
    			if (anItem.getDescription().contains("door"))
    			{
    				anIcon=new ImageIcon("pictures/key1.png");
    			}
    			else if (anItem.getDescription().contains("chest") || anItem.getDescription().contains("treasure"))
    			{
    				anIcon=new ImageIcon("pictures/key2.png");
    			}
    		}
    		else if (anItem.getName()==name)
    		{
    			name=name.toLowerCase();
    			anIcon=new ImageIcon("pictures/"+name+".png");
    		}
    	}
    	return anIcon;
    }
    
    public boolean getVisibility()
    {
    	if (inventoryFrame.isVisible()==true)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    /**
     * This method changes the view of the inventory : general view or focus on an item.
     */
    public void exitInventory()
    {
    	if (viewInventory == true)
    	{
    		inventoryFrame.setVisible(false);
    		viewInventory=false;
    	}
    	else
    	{
    		itemFrame.setVisible(false);
        	inventoryFrame = new InventoryInterface(inventoryPlayer, player,game);
    		viewInventory=true;
    	}    	
    }
    
    
} 
