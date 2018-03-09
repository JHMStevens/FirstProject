
class Ingredients 
{
	/***** INSTANCE VARIABLES *****/
	private String name;
	private double ounces;
	private boolean isAlcohol;
	
	/***** CONSTRUCTOR METHODS *****/
	public Ingredients()
	{
		setName("Water");
		setOunces(1);
		setIsAlcohol(false);
	}
	
	public Ingredients(String title, double amount, boolean isBooze)
	{
		setName(title);
		setOunces(amount);
		setIsAlcohol(isBooze);
	}
	
	/***** MUTATOR METHODS *****/
	public void setName(String title)
	{
		name = title;
	}
	
	public void setIsAlcohol(boolean isBooze)
	{
		isAlcohol = isBooze;
	}
	
	public void setOunces(double amount)
	{
		ounces = amount;
	}
	
	/***** ACCESSOR METHODS *****/
	public String getName()
	{
		return name;
	}
	
	public boolean getIsAlcohol()
	{
		return isAlcohol;
	}
	
	public double getOunces()
	{
		return ounces;
	}
	
	/***** OTHER METHODS *****/
	public String toString()
	{
		return String.format("%.2f oz of %s\n", getOunces(), getName());
	}
	
	public boolean equals(Ingredients other)
	{
		boolean isEqual = false;
		if(this.getName().equals(other.getName()))
		{
			isEqual = true;
		}
		return isEqual;
	}
}
