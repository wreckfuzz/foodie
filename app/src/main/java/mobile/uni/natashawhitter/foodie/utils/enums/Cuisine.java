package mobile.uni.natashawhitter.foodie.utils.enums;

public enum Cuisine
{
	AMERICAN("American"),
	BRITISH("British"),
	CHINESE("Chinese"),
	DESSERT("Dessert"),
	INDIAN("Indian"),
	ITALIAN("Italian"),
	MEXICAN("Mexican"),
	TURKISH("Turkish"),
	VEGETARIAN("Vegetarian"),
	VEGAN("Vegan"),
	OTHER("Other"),
	NONE("None");
	
	private final String type;
	
	Cuisine(String type)
	{
		this.type = type;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public static Cuisine getType(String type)
	{
		switch (type)
		{
			case "American":
				return AMERICAN;
				
			case "British":
				return BRITISH;
				
			case "Chinese":
				return CHINESE;
				
			case "Indian":
				return INDIAN;
				
			case "Italian":
				return ITALIAN;
				
			case "Mexican":
				return MEXICAN;
				
			case "Turkish":
				return TURKISH;
				
			case "Vegetarian":
				return VEGETARIAN;
				
			case "Vegan":
				return VEGAN;
				
			case "Other":
				return OTHER;
				
			default:
				return NONE;
		}
	}
}
