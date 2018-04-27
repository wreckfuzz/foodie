package mobile.uni.natashawhitter.foodie.utils.enums;

public enum RestaurantCategory
{
	RESTAURANT("Restaurant"),
	BISTRO("Bistro"),
	CAFE("Cafe"),
	NONE("None");
	
	private final String category;
	
	RestaurantCategory(String category)
	{
		this.category = category;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public static RestaurantCategory getCategory(String category)
	{
		switch (category)
		{
			case "Restaurant":
				return RESTAURANT;
				
			case "Bistro":
				return BISTRO;
				
			case "Cafe":
				return CAFE;
				
				default:
					return NONE;
		}
	}
}
