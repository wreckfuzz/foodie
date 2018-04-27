package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

import java.util.Date;

import mobile.uni.natashawhitter.foodie.utils.enums.MenuCategory;

import static mobile.uni.natashawhitter.foodie.utils.Utils.*;

@Entity(inheritSuperIndices = true, tableName = MENU_TABLE, foreignKeys = {
		@ForeignKey(entity = Restaurant.class,
				parentColumns = BASE_ID_NAME,
				childColumns = MENU_RESTAURANT_ID,
		onDelete = ForeignKey.CASCADE)
})
public final class Menu extends Base
{
	@ColumnInfo(name = MENU_TITLE)
	@NonNull
	private String title;
	@ColumnInfo(name = MENU_CATEGORY)
	@NonNull
	private MenuCategory category;
	@ColumnInfo(name = MENU_RESTAURANT_ID, index = true)
	@NonNull
	private int restaurantId;
	@ColumnInfo(name = MENU_AVAILABILITY_FROM)
	@NonNull
	private long availableFrom;
	@ColumnInfo(name = MENU_AVAILABILITY_TILL)
	@NonNull
	private long availableTill;
	
	public Menu(@NonNull int id, @NonNull Date lastModified, @NonNull Date createdAt, @NonNull String title, @NonNull MenuCategory category, @NonNull int restaurantId, @NonNull long availableFrom, @NonNull long availableTill)
	{
		super(id, lastModified, createdAt);
		this.title = title;
		this.category = category;
		this.restaurantId = restaurantId;
		this.availableFrom = availableFrom;
		this.availableTill = availableTill;
	}
	
	@NonNull
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(@NonNull String title)
	{
		this.title = title;
	}
	
	@NonNull
	public MenuCategory getCategory()
	{
		return category;
	}
	
	public void setCategory(@NonNull MenuCategory category)
	{
		this.category = category;
	}
	
	@NonNull
	public int getRestaurantId()
	{
		return restaurantId;
	}
	
	public void setRestaurantId(@NonNull int restaurantId)
	{
		this.restaurantId = restaurantId;
	}
	
	@NonNull
	public long getAvailableFrom()
	{
		return availableFrom;
	}
	
	public void setAvailableFrom(@NonNull long availableFrom)
	{
		this.availableFrom = availableFrom;
	}
	
	@NonNull
	public long getAvailableTill()
	{
		return availableTill;
	}
	
	public void setAvailableTill(@NonNull long availableTill)
	{
		this.availableTill = availableTill;
	}
}
