package mobile.uni.natashawhitter.foodie.utils.enums;

public enum Allegy
{
	DIARYFREE("Diary-Free"),
	GLUTENFREE("Gluten-Fee"),
	PESCETARIAN("Pescetarian"),
	NUTFREE("Nut-Free"),
	VEGAN("Vegan"),
	VEGETARIAN("Vegetarian"),
	OTHER("Other");
	
	private final String type;
	
	Allegy(String type)
	{
		this.type = type;
	}
	
	public String getType()
	{
		return this.type;
	}
}
