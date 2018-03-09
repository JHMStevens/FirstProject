import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class MainMenu extends JFrame
{ 
	/***** CONSTANT SECTION *****/
	private final String BROWSE = "Browse Cocktails";
	private final String SEARCH = "Search Cocktails";
	private final String ADD = "Add a Cocktail";
	private final String REMOVE = "Delete a Cocktail";
	private final String EXIT = "Exit Program";
	private final int BUTTON_WIDE = 170;
	private final int BUTTON_TALL = 30;
	
	/***** DECLARATION SECTION *****/
	private JButton browseButton;
	private JButton searchButton;
	private JButton addButton;
	private JButton removeButton;
	private JButton exitButton;
	
	//private JPanel mainPanel;
	private JPanel browsePanel;
	private JPanel searchPanel;
	private JPanel addPanel;
	private JPanel removePanel;
	private JPanel exitPanel;
	
	private static ArrayList<Ingredients> allIngredients;
    private static ArrayList<Ingredients> firstDrink;
    private static ArrayList<Ingredients> secondDrink;
    private static ArrayList<Ingredients> thirdDrink;
    private static ArrayList<Ingredients> fourthDrink;
    private static ArrayList<Ingredients> fifthDrink;
    private static ArrayList<Drinks> drinkList;
    	
	//CONSTRUCTOR
	public MainMenu()
	{
		/***** FORMATTING FRAME *****/
		super("MAIN MENU");
		setLayout(new GridLayout(5, 1, 5, 5));
		setVisible(true);
		setSize(225, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pack();
		
		/***** INITIATING ARRAYLISTS *****/
		allIngredients = new ArrayList<Ingredients>();
		firstDrink = new ArrayList<Ingredients>();
		secondDrink = new ArrayList<Ingredients>();
		thirdDrink = new ArrayList<Ingredients>();
		fourthDrink = new ArrayList<Ingredients>();
		fifthDrink = new ArrayList<Ingredients>();
		drinkList = new ArrayList<Drinks>();
		
		/***** HARDCODING IN A FEW COCKTAILS *****/
		firstDrink.add(new Ingredients("Tequila", 4, true));
    	firstDrink.add(new Ingredients("Cointreau", 2, true));
    	firstDrink.add(new Ingredients("Lime juice", 1.5, false));
    	secondDrink.add(new Ingredients("Dry Gin", 2, true));
    	secondDrink.add(new Ingredients("Vermouth", 1, true));
    	secondDrink.add(new Ingredients("Orange Bitters", 0.1, false));
    	thirdDrink.add(new Ingredients("Rye Whiskey", 4, true));
    	thirdDrink.add(new Ingredients("Sweet Vermouth", 2, true));
    	thirdDrink.add(new Ingredients
    							("Angostura Bitters", 0.2, false));
    	thirdDrink.add(new Ingredients
    							("Maraschino Cherries", 2, false));
    	fourthDrink.add(new Ingredients("Whiskey", 2, true));
    	fourthDrink.add(new Ingredients("lemon juice", 1, false));
    	fourthDrink.add(new Ingredients("sugar", .5, false));
    	fifthDrink.add(new Ingredients("Jamaican Rum", 2, true));
    	fifthDrink.add(new Ingredients("Lime Juice", 1, false));
    	fifthDrink.add(new Ingredients("Curacao", 0.5, true));
    	fifthDrink.add(new Ingredients("Orgeat", 0.25, false));
    	fifthDrink.add(new Ingredients("Simple Syrup", 0.25, false));
    	
    	drinkList.add(new Drinks ("Margarita", 
    				"Rocks or Margarita Glass", firstDrink, 
    				true, "Rim glass with coarse salt,"+
    				" garnish with lime rounds."));
    	drinkList.add(new Drinks ("Martini", 
    				"Cocktail Glass", secondDrink, 
    				true, "Combine over ice, strain into glass"));
    	drinkList.add(new Drinks ("Manhattan", "Cocktail Glass", 
    				thirdDrink, true, 
    				"Combine over ice, pour over cherry in glass"));
    	drinkList.add(new Drinks ("Whiskey Sour", 
    				"Old Fashioned Glass", fourthDrink, true, 
    				"Shake with ice for 10 seconds, "+
    				"strain into glass"));
    	drinkList.add(new Drinks ("Mai Tai", "Old Fashioned Glass", 
    				fifthDrink, true, "Shake with ice for 10 "+
    				"seconds, strain into glass. Garnish with mint"));
    	
		
		/***** CREATING BUTTONS *****/
		browseButton = new JButton(BROWSE);
		browseButton.setPreferredSize
						(new Dimension(BUTTON_WIDE, BUTTON_TALL));
		searchButton = new JButton(SEARCH);
		searchButton.setPreferredSize
						(new Dimension(BUTTON_WIDE, BUTTON_TALL));
		addButton = new JButton(ADD);
		addButton.setPreferredSize
						(new Dimension(BUTTON_WIDE, BUTTON_TALL));
		removeButton = new JButton(REMOVE);
		removeButton.setPreferredSize
						(new Dimension(BUTTON_WIDE, BUTTON_TALL));
		exitButton = new JButton(EXIT);
		exitButton.setPreferredSize
						(new Dimension(BUTTON_WIDE, BUTTON_TALL));
		
		/***** CREATING PANELS *****/
		//this is to allow them to be in grid 
		//layout without filling the entire grid cell
		browsePanel = new JPanel();
		searchPanel = new JPanel();
		addPanel = new JPanel();
		removePanel = new JPanel();
		exitPanel = new JPanel();
		
		/***** ADDING BUTTONS TO PANELS *****/
		browsePanel.add(browseButton);
		searchPanel.add(searchButton);
		addPanel.add(addButton);
		removePanel.add(removeButton);
		exitPanel.add(exitButton);
		
		/***** ADDING PANELS TO MENU *****/
		add(browsePanel);
		add(searchPanel);
		add(addPanel);
		add(removePanel);
		add(exitPanel);
		
		/***** ADDING LISTENER TO BUTTONS *****/
		browseButton.addActionListener(new MainMenuListener());
		searchButton.addActionListener(new MainMenuListener());
		addButton.addActionListener(new MainMenuListener());
		removeButton.addActionListener(new MainMenuListener());
		exitButton.addActionListener(new MainMenuListener());
	}
	
	/***** MUTATOR METHODS *****/
	public static void addDrink(Drinks newDrink)
	{
		drinkList.add(newDrink);
	}
	
	public static void addIngredient(Ingredients newIngredient)
	{
		allIngredients.add(newIngredient);
	}
	
	/***** ACCESSOR METHODS *****/
	public static ArrayList<Drinks> getDrinkList()
	{
		return drinkList;
	}
	
	/***** OTHER METHODS *****/
	
	private class MainMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			
			if(command.equals(BROWSE))
			{
				new Browser();
			}
			else if(command.equals(SEARCH))
			{
				new Search();
			}
			else if(command.equals(ADD))
			{
				new AddDrink();
			}
			else if(command.equals(REMOVE))
			{
				new RemoveDrink();
			}
			else if(command.equals(EXIT))
			{
				JOptionPane.showMessageDialog(null, "Bye!");
				System.exit(0);
			}
		}
	}
		
	public void setVisibility(boolean isVisible)
	{
		super.setVisible(isVisible);
	}
}
