package mobile.uni.natashawhitter.foodie.utils.enums;

public enum Location
{
	NORTH("North"),
	EAST("East"),
	WEST("West"),
	SOUTH("South"),
	NONE("None");
	
	private final String location;
	
	Location(String location)
	{
		this.location = location;
	}
	
	public static Location getLocation(String location)
	{
		switch (location)
		{
			case "North":
				return NORTH;
			
			case "East":
				return EAST;
			
			case "West":
				return WEST;
			
			case "South":
				return SOUTH;
			
			default:
				return NONE;
		}
	}
	
	public String getLocationType()
	{
		return this.location;
	}
}
