import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class AddDrink extends JFrame
{
	/***** CONSTANT SECTION *****/
	private final String BUTTON_DRINK = "Drink Completed";
	private final String BUTTON_INGREDIENT = "Add to Cocktail";
	
	/***** DECLARATION SECTION (Instance Variables) *****/
	private ArrayList<Ingredients> newIngredients;
	private Drinks newDrink;
	private boolean isAlcoholic = false;
	private String directions;
		
	/***** DECLARATION SECTION (GUI) *****/
	private ButtonGroup glasses;
	private JRadioButton shotGlass;
	private JRadioButton highball;
	private JRadioButton collins;
	private JRadioButton pint;
	private JRadioButton martini;
	private JRadioButton other;
	private JLabel drinkName;
	private JLabel ingredientName;
	private JLabel ouncesName;
	private JLabel instructionsName;
	private JTextField writeName;
	private JTextField writeOunces;
	private JTextField writeIngredient;
	private JTextField writeOther;
	private JTextField writeInstructions;
	private JCheckBox alcohol;
	private JButton addIngredient;
	private JButton addDrink;
	private JPanel top;
	private JPanel mid;
	private JPanel bottom;
	
 	public AddDrink() 
	{
		/***** FORMATTING FRAME *****/
		super("ADD COCKTAIL");
		//MainMenu.setVisibility(false);
		setLayout(new GridLayout(3, 1, 5, 5));
		setVisible(true);
		setSize(385, 450);
		setLocationRelativeTo(null);
		//setResizable(false);
		
		/***** INSTANTIATE ARRAYLIST *****/
		newIngredients = new ArrayList<Ingredients>();
		
		/***** CREATING GUIS *****/
		drinkName = new JLabel("Name of Cocktail");
		ingredientName = new JLabel("Ingredient");
		instructionsName = new JLabel("Write Directions here");
		ouncesName = new JLabel("Add how many ounces?");
		writeName = new JTextField(15);
		writeIngredient = new JTextField(15);
		writeOther = new JTextField(8);
		writeInstructions = new JTextField(30);
		writeOunces  = new JTextField(2);
		alcohol = new JCheckBox
					("check box if ingredient is alcoholic");
		addIngredient = new JButton(BUTTON_INGREDIENT);
		addDrink = new JButton(BUTTON_DRINK);
		shotGlass = new JRadioButton("Shot Glass");
		highball = new JRadioButton("Highball Glass", true);
	 	collins = new JRadioButton("Collins Glass");
		pint = new JRadioButton("Pintglass");
		martini = new JRadioButton("Cocktail Glass");
		other = new JRadioButton("Other");
		
		/***** CREATING BUTTON GROUP *****/
		glasses = new ButtonGroup();
		glasses.add(shotGlass);
		glasses.add(highball);
		glasses.add(collins);
		glasses.add(pint);
		glasses.add(martini);
		glasses.add(other);
		
		/***** CREATING PANELS *****/
		top = new JPanel();
		top.add(drinkName);
		top.add(writeName);
		top.add(highball);
		top.add(collins);
		top.add(martini);
		top.add(pint);
		top.add(shotGlass);
		top.add(other);
		top.add(writeOther);
		writeOther.setText(" ");
		top.setBorder
				(BorderFactory.createTitledBorder("Create Drink"));
		mid = new JPanel();
		mid.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		mid.add(ingredientName);
		mid.add(writeIngredient);
		mid.add(alcohol);
		mid.add(ouncesName);
		mid.add(writeOunces);
		mid.add(addIngredient);
		mid.setBorder
				(BorderFactory.createTitledBorder("Add Ingredients"));
		bottom = new JPanel();
		bottom.add(instructionsName);
		bottom.add(writeInstructions);
		bottom.add(addDrink);
		bottom.setBorder
				(BorderFactory.createTitledBorder("Finish Drink"));
		
		
		/***** CREATING FRAME *****/
		add(top);
		add(mid);
		add(bottom);
		
		/***** ADDING LISTENERS *****/
		addIngredient.addActionListener(new DrinkMenuListener());
		addDrink.addActionListener(new DrinkMenuListener());
	}
	
	private class DrinkMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			
			if(command.equals(BUTTON_INGREDIENT))
			{
				boolean isAlcohol = false;
				if(alcohol.isSelected())
				{
					isAlcohol = true;//marks the ingredient as alcohol
					isAlcoholic = true;//marks the drink as alcoholic
				}
				//adds ingredient to the cocktail
				newIngredients.add
						(new Ingredients(writeIngredient.getText(), 
						Double.parseDouble(writeOunces.getText()), 
						isAlcohol));
						
				//adds ingredient to the list of all ingredients
				MainMenu.addIngredient
						(new Ingredients(writeIngredient.getText(), 
						Double.parseDouble(writeOunces.getText()), 
						isAlcohol));
				
				JOptionPane.showMessageDialog
							(null, writeIngredient.getText()+
							" was added to the cocktail" );
				
				writeIngredient.setText("");
				alcohol.setSelected(false);
			}
			else if(command.equals(BUTTON_DRINK))
			{
				String glass = "Pint";
				if(shotGlass.isSelected())
				{
					glass = "Shot Glass";
				}
				else if(highball.isSelected())
				{
					glass = "Highball Glass";
				}
				else if(collins.isSelected())
				{
					glass = "Collins Glass";
				}
				else if(pint.isSelected())
				{
					glass = "Pint";
				}
				else if(martini.isSelected())
				{
					glass = "Martini Glass";
				}
				else if(other.isSelected())
				{
					glass = writeOther.getText();
					
				}
				
				newDrink = new Drinks(writeName.getText(), glass, newIngredients, isAlcoholic, writeInstructions.getText());
				MainMenu.addDrink(newDrink);
				JOptionPane.showMessageDialog(null, writeName.getText()
											+" was added to the program");
				//MainMenu.setVisibility(true);
				closeFrame();
			}
		}
	}
	
	private void closeFrame()
	{
		super.dispose();
	}
}
