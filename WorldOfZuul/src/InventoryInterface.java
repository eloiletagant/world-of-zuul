import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import character.*;
import item.Inventory;
import item.Item;

/**
 * This method creates the frame with the design of the inventory.
 * It allows displaying items of the inventory of the player.
 * 
 * @author Group4
 * @version 01/12/2016
 */
public class InventoryInterface extends JFrame
{
    //button building
    public JButton back, axe, mincingMachine, bow, eggplant, key1, key2, bread, potion, sword, pineapple, cookies, brioche, use, sell, aButton;
    private JLabel title, goldLabel, goldIconLabel, iconLabel, nom, description, price;
    private JPanel myPanel, up, inventory, down, gold, view, actions, completeDescription;
    private JFrame inventoryFrame, itemFrame;
    private Inventory inventoryPlayer;
    private Icon anIcon, backIcon, goldIcon, axeIcon, bowIcon, mincingMachineIcon, swordIcon, breadIcon, briocheIcon, cookiesIcon, eggplantIcon, pineappleIcon, potionIcon, key1Icon, key2Icon;
    private int counter =0;
    private Item myItem;
    private boolean found = false;
    protected Listener evt;

    /**
     * Constructor for objects of class InventoryInterface
     */
    public InventoryInterface(Inventory anInventory)
    {
    	inventoryPlayer = anInventory;
        myPanel = new JPanel(new BorderLayout ());
        up = new JPanel (new GridLayout (1,3));
        inventory = new JPanel (new GridLayout (2,5,10,10));
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
        
        use= new JButton("USE");
        use.setBackground(Color.black);
        use.setForeground(Color.yellow);
        use.setFont(police);
        sell= new JButton("SELL");
        sell.setBackground(Color.black);
        sell.setForeground(Color.yellow);
        sell.setFont(police);
        
		
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
        
        
        
        axeIcon = new ImageIcon("pictures/axe.png");
        axe = new JButton(axeIcon);
        axe.setBackground(new Color(70, 63, 55));
        
        mincingMachineIcon = new ImageIcon("pictures/mincing_machine.png");
        mincingMachine = new JButton(mincingMachineIcon);
        mincingMachine.setBackground(new Color(70, 63, 55));
        
        bowIcon= new ImageIcon("pictures/Bow.png");
        bow = new JButton(bowIcon);
        bow.setBackground(new Color(70, 63, 55));
        
        eggplantIcon= new ImageIcon("pictures/eggplant.png");
        eggplant = new JButton(eggplantIcon);
        eggplant.setBackground(new Color(70, 63, 55));
        
        key1Icon = new ImageIcon("pictures/key1.png"); 
        key1 = new JButton(key1Icon);
        key1.setBackground(new Color(70, 63, 55));
        
        key2Icon= new ImageIcon("pictures/key2.png");
        key2 = new JButton(key2Icon);
        key2.setBackground(new Color(70, 63, 55));
        
        breadIcon= new ImageIcon("pictures/bread.png");
        bread = new JButton(breadIcon);
        bread.setBackground(new Color(70, 63, 55));
        
        potionIcon= new ImageIcon("pictures/potion.png");
        potion = new JButton(potionIcon);
        potion.setBackground(new Color(70, 63, 55));
        
        swordIcon= new ImageIcon("pictures/sword.png");
        sword = new JButton(swordIcon);
        sword.setBackground(new Color(70, 63, 55));
        
        pineappleIcon= new ImageIcon("pictures/pineapple.png");
        pineapple= new JButton(pineappleIcon);
        pineapple.setBackground(new Color(70, 63, 55));
        
        briocheIcon= new ImageIcon("pictures/brioche.png");
        brioche = new JButton(briocheIcon);
        brioche.setBackground(new Color(70, 63, 55));
        
        cookiesIcon= new ImageIcon("pictures/cookies.png");
        cookies = new JButton(cookiesIcon);
        cookies.setBackground(new Color(70, 63, 55));
        
        

        for (Item item : inventoryPlayer.getItems())
    	{
        	inventory.add(getJButton(item));
        	counter+=1;
    	}
        while (counter!=10)
		{
			JPanel empty = new JPanel();
			empty.setBackground(new Color(70, 63, 55));
			inventory.add(empty);
			counter+=1;
		}
     
        //Listeners for buttons action
        evt= new Listener(this);
        sell.addMouseListener(evt);
        back.addMouseListener(evt);
        use.addMouseListener(evt);

        brioche.addMouseListener(evt);
        bread.addMouseListener(evt);
        cookies.addMouseListener(evt);
        pineapple.addMouseListener(evt);
        eggplant.addMouseListener(evt);
        potion.addMouseListener(evt);
        axe.addMouseListener(evt);
        bow.addMouseListener(evt);
        mincingMachine.addMouseListener(evt);
        sword.addMouseListener(evt);
        key1.addMouseListener(evt);
        key2.addMouseListener(evt);
        
        
        
        myPanel.add(up,BorderLayout.NORTH);
        myPanel.add(inventory,BorderLayout.CENTER);
        myPanel.add(down,BorderLayout.SOUTH);
        
        inventoryFrame= new JFrame("My inventory");
        inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setTitle(    
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
     * This method create a new window and display all information of the given item.
     * @param anItem to display
     */
    public void displayItem(Item anItem)
    {
    	anItem.setManaged();
    	exitInventory();
    	Font police = new Font ("Kristen ITC", Font.BOLD, 14);
    	Font police2 = new Font ("Kristen ITC", Font.BOLD, 12);
    	
    	backIcon = new ImageIcon("pictures/back.png");
		back = new JButton ("BACK", backIcon);
        back.setBackground(Color.black);
        back.setOpaque(true);
        back.setForeground(Color.yellow);
        back.setFont(police);
        
        title = new JLabel ("INVENTORY : " + anItem.getName(), JLabel.CENTER);
        title.setBackground(Color.black);
        title.setOpaque(true);
        title.setForeground(Color.yellow);
        title.setFont(police);
        
        up = new JPanel (new GridLayout (1,2));
        up.add(back);
        up.add(title);
    	
    	itemFrame = new JFrame(anItem.getName());
    	itemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    	itemFrame.setSize(500, 500);
    	
    	actions= new JPanel(new GridLayout(1,2));
    	actions.add(use);
    	if (anItem.getSellAble()==false)
    	{
    		sell.setEnabled(false);
    	}
    	actions.add(sell);
    	
    	iconLabel=new JLabel(getIcon(anItem));
    	iconLabel.setBackground(new Color(70, 63, 55));
        iconLabel.setOpaque(true);
        
        nom=new JLabel("Name : "+anItem.getName());
        nom.setForeground(Color.white);
        nom.setFont(police2);
        description=new JLabel("Description : "+anItem.getDescription());
        description.setForeground(Color.white);
        description.setFont(police2);
        price=new JLabel("Price : "+anItem.getPrice() + " golds");
        price.setForeground(Color.white);
        price.setFont(police2);
        //rajouter les autres attributs selon le type d'objet
        
        completeDescription=new JPanel(new GridLayout(0,1));
        completeDescription.setBackground(new Color(70, 63, 55));
        completeDescription.setOpaque(true);
        completeDescription.add(nom);
        completeDescription.add(description);
        completeDescription.add(price);
        
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
     * This method returns the inventory of the player.
     * @return Inventory
     */
    public Inventory getInventory()
    {
    	return inventoryPlayer;
    }
    
    /**
     * This method returns the JButton according to the given item.
     * @param item
     * @return JButton
     */
    public JButton getJButton(Item item)
    {
    	if(item.getName() == "Pineapple")
		{
			aButton=pineapple;
		}
    	else if (item.getName() == "Axe")
		{
    		aButton=axe;
		}
    	else if (item.getName() == "Bow")
		{
    		aButton=bow;
		}
    	else if (item.getName() == "Butcher knife")
		{
    		aButton=mincingMachine;
		}
    	else if (item.getName() == "Sword")
		{
    		aButton=sword;
		}
    	else if (item.getName() == "Eggplant")
		{
    		aButton=eggplant;
		}
    	else if (item.getName() == "Bread")
		{
    		aButton=bread;
		}
		else if (item.getName() == "Brioche")
		{
			aButton=brioche;
		}
		else if (item.getName() == "Cookies")
		{
			aButton=cookies;
		}
		else if (item.getName() == "Potion")
		{
			aButton=potion;
		}					
		else if (item.getName() == "Hodor" || item.getName() == "Nu-Clef-ère" || item.getName() == "Gy-Clef")
		{
			aButton=key1;
		}
		else if (item.getName() == "Sésame" || item.getName() == "Musse-Clef" || item.getName() == "Tabou-Clef" || item.getName() == "Clef-Bar")
		{
			aButton=key2;
		}
    	return aButton;
    } 
    
    /**
     * This method returns the icon according to the given item.
     * @param item
     * @return JButton
     */
    public Icon getIcon(Item item)
    {
    	if(item.getName() == "Pineapple")
		{
			anIcon=new ImageIcon("pictures/axe.png");
		}
    	else if (item.getName() == "Axe")
		{
    		aButton=axe;
		}
    	else if (item.getName() == "Bow")
		{
    		aButton=bow;
		}
    	else if (item.getName() == "Butcher knife")
		{
    		aButton=mincingMachine;
		}
    	else if (item.getName() == "Sword")
		{
    		aButton=sword;
		}
    	else if (item.getName() == "Eggplant")
		{
    		aButton=eggplant;
		}
    	else if (item.getName() == "Bread")
		{
    		aButton=bread;
		}
		else if (item.getName() == "Brioche")
		{
			aButton=brioche;
		}
		else if (item.getName() == "Cookies")
		{
			aButton=cookies;
		}
		else if (item.getName() == "Potion")
		{
			aButton=potion;
		}					
		else if (item.getName() == "Hodor" || item.getName() == "Nu-Clef-ère" || item.getName() == "Gy-Clef")
		{
			anIcon=new ImageIcon("pictures/key1.png");;
		}
		else if (item.getName() == "Sésame" || item.getName() == "Musse-Clef" || item.getName() == "Tabou-Clef" || item.getName() == "Clef-Bar")
		{
			anIcon=new ImageIcon("pictures/key2.png");
		}
    	return anIcon;
    }
    
    /**
     * 
     */
    public void exitInventory()
    {
    	inventoryFrame.setVisible(false);
    }
    
    /**
     * 
     */
    public void exitInventory2()
    {
    	itemFrame.setVisible(false);
    	InventoryInterface(inventoryPlayer);
    }
} 
