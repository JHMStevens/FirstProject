import java.util.ArrayList;

class Drinks 
{
	/***** Instance Variables *****/
	private String name;
	private String glass;
	private boolean isAlcoholic;
	private ArrayList<Ingredients> ingredientList;
	private String instructions;
	
	/***** CONSTRUCTORS *****/
	public Drinks()
	{
		setName("Water");
		setGlass("glass");
		setIsAlcoholic(false);
		ingredientList = new ArrayList<Ingredients>();
		ingredientList.add(new Ingredients("Water", 1.0, false));
		setInstructions("");
	}
	
	public Drinks(String title, String cup, boolean isBooze, ArrayList<Ingredients> recipe, String directions)
	{
		setName(title);
		setGlass(cup);
		setIsAlcoholic(isBooze);
		setInstructions(directions);
		ingredientList = new ArrayList<Ingredients>();
		
		for (int i = 0; i < recipe.size(); i++)
		{
			ingredientList.add
			(new Ingredients(recipe.get(i).getName(), recipe.get(i).getOunces(), recipe.get(i).getIsAlcohol()));
		}
	}
	
	public Drinks(String title, String cup, ArrayList<Ingredients> recipe, boolean isBooze, String directions)
	{
		setName(title);
		setGlass(cup);
		setIsAlcoholic(isBooze);
		setInstructions(directions);
		ingredientList = new ArrayList<Ingredients>();
		
		for (int i = 0; i < recipe.size(); i++)
		{
			ingredientList.add(new Ingredients(recipe.get(i).getName(), recipe.get(i).getOunces(), recipe.get(i).getIsAlcohol()));
		}
	}
	
	/***** MUTATOR METHODS *****/
	public void setName(String title)
	{
		name = title;
	}
	
	public void setGlass(String cup)
	{
		glass = cup;
	}
	
	public void setIsAlcoholic(boolean isBooze)
	{
		isAlcoholic = isBooze;
	}
	
	public void setInstructions(String directions)
	{
		instructions = directions;
	}
	
	/***** ACCESSOR METHODS *****/
	public String getName()
	{
		return name;
	}
	
	public String getGlass()
	{
		return glass;
	}
	
	public boolean getIsAlcohoic()
	{
		return isAlcoholic;
	}
	
	public String getInstructions()
	{
		return instructions;
	}
	
	public ArrayList<Ingredients> getIngredients()
	{
		return ingredientList;
	}
	
	/***** OTHER METHODS *****/
	public String toString()
	{
		String tempString;
		
		tempString = String.format("COCKTAIL NAME: %s\n", getName());
		tempString += String.format("GLASS: %s\nINGREDIENTS:\n", getGlass());
		for(int i = 0; i<ingredientList.size(); i++)
		{
			tempString += ingredientList.get(i).toString();
		}
		
		tempString += "DIRECTIONS: \n" + getInstructions();
		
		return tempString;
	}
}
