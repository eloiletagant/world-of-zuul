import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Scanner;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import character.*;
import item.Inventory;

/**
 * Write a description of class InventoryInterface here.
 * 
 * @author Group4
 * @version 01/12/2016
 */
public class InventoryInterface extends JFrame
{
    //button building
    protected JButton useButton= new JButton("USE");
    protected JButton deleteButton= new JButton("DELETE");
    protected JButton sellButton= new JButton("SELL");
    private JFrame myFrame;
    private JButton back, axeButton, mincingMachineButton, bowButton, eggplantButton, key1Button, key2Button, breadButton, potionButton, swordButton,pineappleButton, cookiesButton, briocheButton;
    private JLabel goldLabel;
    protected Listener evt;
    private Inventory inventoryPlayer;

    /**
     * Constructor for objects of class InventoryInterface
     */
    public InventoryInterface(Inventory anInventory)
    {
    	inventoryPlayer = anInventory;
        JPanel myPanel = new JPanel(new BorderLayout ());
        JPanel up = new JPanel (new GridLayout (1,3));
        JPanel inventory = new JPanel (new GridLayout (2,5,10,10));
        inventory.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        inventory.setBackground(Color.black);
        JPanel down = new JPanel (new GridLayout (1,1));
        
        Font police = new Font ("Kristen ITC", Font.BOLD, 14);
        
        
        JLabel title = new JLabel ("INVENTORY", JLabel.CENTER);
        title.setBackground(Color.black);
        title.setOpaque(true);
        title.setForeground(Color.yellow);
        title.setFont(police);
        
        
        myPanel.setBackground(Color.black);
        
        
        useButton.setBackground(Color.black);
        useButton.setForeground(Color.white);
        useButton.setFont(police);
        deleteButton.setBackground(Color.black);
        deleteButton.setForeground(Color.white);
        deleteButton.setFont(police);
        sellButton.setBackground(Color.black);
        sellButton.setForeground(Color.yellow);
        sellButton.setFont(police);
        
		
        Icon backIcon = new ImageIcon("pictures/back.png");
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
        Icon goldIcon = new ImageIcon("pictures/gold.png");
        JLabel goldIconLabel = new JLabel(goldIcon);
        goldIconLabel.setBackground(Color.black);
        goldIconLabel.setOpaque(true);
		JPanel gold = new JPanel ();
		gold.add(goldIconLabel);
		gold.add(goldLabel);
		gold.setBackground(Color.black);
        gold.setOpaque(true);

        
        up.add(back);
        up.add(title);
        up.add(gold);
        
        Icon axe = new ImageIcon("pictures/axe.png");
        axeButton = new JButton(axe);
        axeButton.setBackground(new Color(70, 63, 55));
        
        Icon mincingMachine = new ImageIcon("pictures/mincing_machine.png");
        mincingMachineButton = new JButton(mincingMachine);
        mincingMachineButton.setBackground(new Color(70, 63, 55));
        
        Icon bow= new ImageIcon("pictures/Bow.png");
        bowButton = new JButton(bow);
        bowButton.setBackground(new Color(70, 63, 55));
        
        Icon eggplant= new ImageIcon("pictures/eggplant.png");
        eggplantButton = new JButton(eggplant);
        eggplantButton.setBackground(new Color(70, 63, 55));
        
        Icon key1 = new ImageIcon("pictures/key1.png"); 
        key1Button = new JButton(key1);
        key1Button.setBackground(new Color(70, 63, 55));
        
        Icon key2= new ImageIcon("pictures/key2.png");
        key2Button = new JButton(key2);
        key2Button.setBackground(new Color(70, 63, 55));
        
        Icon bread= new ImageIcon("pictures/bread.png");
        breadButton = new JButton(bread);
        breadButton.setBackground(new Color(70, 63, 55));
        
        Icon potion= new ImageIcon("pictures/potion.png");
        potionButton = new JButton(potion);
        potionButton.setBackground(new Color(70, 63, 55));
        
        Icon sword= new ImageIcon("pictures/sword.png");
        swordButton = new JButton(sword);
        swordButton.setBackground(new Color(70, 63, 55));
        
        Icon pineapple= new ImageIcon("pictures/pineapple.png");
        pineappleButton = new JButton(pineapple);
        pineappleButton.setBackground(new Color(70, 63, 55));
        
        Icon brioche= new ImageIcon("pictures/brioche.png");
        briocheButton = new JButton(brioche);
        briocheButton.setBackground(new Color(70, 63, 55));
        
        Icon cookies= new ImageIcon("pictures/cookies.png");
        cookiesButton = new JButton(cookies);
        cookiesButton.setBackground(new Color(70, 63, 55));
        
        
        
        inventory.add(axeButton);
        inventory.add(mincingMachineButton);
        inventory.add(bowButton);
        inventory.add(eggplantButton);
        inventory.add(key1Button);
        inventory.add(key2Button);
        inventory.add(breadButton);
        inventory.add(briocheButton);
        inventory.add(cookiesButton);
        inventory.add(pineappleButton);
        
        //Listeners for buttons action
        evt= new Listener(this);
        sellButton.addMouseListener(evt);
        deleteButton.addMouseListener(evt);
        back.addMouseListener(evt);
        useButton.addMouseListener(evt);
        
        
        myPanel.add(up,BorderLayout.NORTH);
        myPanel.add(inventory,BorderLayout.CENTER);
        myPanel.add(down,BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("WOZ");    
        this.add(myPanel);
        this.setSize(500, 500);
        this.pack();
        this.setVisible(true);
    }

} 
