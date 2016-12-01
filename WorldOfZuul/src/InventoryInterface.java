import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import character.*;
import item.Inventory;
import item.Item;

/**
 * Write a description of class InventoryInterface here.
 * 
 * @author Group4
 * @version 01/12/2016
 */
public class InventoryInterface extends JFrame
{
    //button building
    public JButton back, axe, mincingMachine, bow, eggplant, key1, key2, bread, potion, sword, pineapple, cookies, brioche, use, sell;
    private JLabel title, goldLabel, goldIconLabel;
    private JPanel myPanel, up, inventory, down, gold, action;
    private Inventory inventoryPlayer;
    private Icon backIcon, goldIcon, axeIcon, bowIcon, mincingMachineIcon, swordIcon, breadIcon, briocheIcon, cookiesIcon, eggplantIcon, pineappleIcon, potionIcon, key1Icon, key2Icon;
    private int counter =0;
    protected Listener evt, c1, c2, c3, c4, c5, c6, w1, w2, w3, w4, k1, k2;

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
        use.setForeground(Color.white);
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
    		if(item.getName() == "Pineapple")
    		{
    			inventory.add(pineapple);
    			counter+=1;
    		}
    		if (item.getName() == "Axe")
			{
				inventory.add(axe);
				counter+=1;
			}
			if (item.getName() == "Bow")
			{
				inventory.add(bow);
				counter+=1;
			}
			if (item.getName() == "Butcher knife")
			{
				inventory.add(mincingMachine);
				counter+=1;
			}
			if (item.getName() == "Sword")
			{
				inventory.add(sword);
				counter+=1;
			}
			if (item.getName() == "Eggplant")
			{
				inventory.add(eggplant);
				counter+=1;
			}
			if (item.getName() == "Bread")
			{
				inventory.add(bread);
				counter+=1;
			}
			if (item.getName() == "Brioche")
			{
				inventory.add(brioche);
				counter+=1;
			}
			if (item.getName() == "Cookies")
			{
				inventory.add(cookies);
				counter+=1;
			}
			if (item.getName() == "Potion")
			{
				inventory.add(potion);
				counter+=1;
			}
						
			if (item.getName() == "Hodor" || item.getName() == "Nu-Clef-ère" || item.getName() == "Gy-Clef")
			{
				inventory.add(key1);
				counter+=1;
			}
			if (item.getName() == "Sésame" || item.getName() == "Musse-Clef" || item.getName() == "Tabou-Clef" || item.getName() == "Clef-Bar")
			{
				inventory.add(key2);
				counter+=1;
			}			
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
        
        c1= new Listener(this);
        brioche.addMouseListener(c1);
        c2= new Listener(this);
        bread.addMouseListener(c2);
        c3= new Listener(this);
        cookies.addMouseListener(c3);
        c4= new Listener(this);
        pineapple.addMouseListener(c4);
        c5= new Listener(this);
        eggplant.addMouseListener(c5);
        c6= new Listener(this);
        potion.addMouseListener(c6);
        w1= new Listener(this);
        axe.addMouseListener(w1);
        w2= new Listener(this);
        bow.addMouseListener(w2);
        w3= new Listener(this);
        mincingMachine.addMouseListener(w3);
        w4= new Listener(this);
        sword.addMouseListener(w4);
        k1= new Listener(this);
        key1.addMouseListener(k1);
        k2= new Listener(this);
        key2.addMouseListener(k2);
        
        
        
        myPanel.add(up,BorderLayout.NORTH);
        myPanel.add(inventory,BorderLayout.CENTER);
        myPanel.add(down,BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My inventory");    
        this.add(myPanel);
        this.setSize(500, 500);
        this.pack();
        this.setVisible(true);
    }
    
    public void displayItem(Item anItem)
    {
    	
    }
    
    public Item searchItem(String name)
    {
    	for (Item item : inventoryPlayer.getItems())
    	{
    		if (item.getName() == name)
    		{
    			return item;
    		}
    	} 	
    }
    
    public Inventory getInventory()
    {
    	return inventoryPlayer;
    }
} 
