package mobile.uni.natashawhitter.foodie.utils;

public class DataModel
{
	private static final int TYPE_HEADER = 0;
	private static final int TYPE_ITEM = 1;
	private static final int TYPE_SEPARATOR = 2;
	private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;
	
	private String menuItem;
	private String email;
	private int type;
	
	// Constructor.
	public DataModel(String menuItem, int type) {
		
		this.menuItem = menuItem;
		this.type = type;
	}
	
	public DataModel(String menuItem, String email, int type) {
		
		this.menuItem = menuItem;
		this.email = email;
		this.type = type;
	}
	
	public String getMenuItem()
	{
		return menuItem;
	}
	
	public void setMenuItem(String menuItem)
	{
		this.menuItem = menuItem;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public int getType()
	{
		return type;
	}
	
	public void setType(int type)
	{
		this.type = type;
	}
}
