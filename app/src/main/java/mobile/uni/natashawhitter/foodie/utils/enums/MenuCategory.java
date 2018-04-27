package mobile.uni.natashawhitter.foodie.utils.enums;

public enum MenuCategory
{
	BREAKFAST("Breakfast"),
	BRUNCH("Brunch"),
	LUNCH("Lunch"),
	DINNER("Dinner"),
	NONE("None");
	
	private final String category;
	
	MenuCategory(String category)
	{
		this.category = category;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public static MenuCategory getCategory(String category)
	{
		switch (category)
		{
			case "Breakfast":
				return BREAKFAST;
			
			case "Brunch":
				return BRUNCH;
			
			case "Lunch":
				return LUNCH;
			
			case "Dinner":
				return DINNER;
				
				default:
					return NONE;
		}
	}
}
