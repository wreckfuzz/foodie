package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.OffsetTime;
import org.threeten.bp.ZonedDateTime;

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
	private ZonedDateTime availableFrom;
	@ColumnInfo(name = MENU_AVAILABILITY_TILL)
	@NonNull
	private ZonedDateTime availableTill;
	
	public Menu(@NonNull long id, @NonNull Instant lastModified, @NonNull Instant createdAt, @NonNull String title, @NonNull MenuCategory category, @NonNull int restaurantId, @NonNull ZonedDateTime availableFrom, @NonNull ZonedDateTime availableTill)
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
	public ZonedDateTime getAvailableFrom()
	{
		return availableFrom;
	}
	
	public void setAvailableFrom(@NonNull ZonedDateTime availableFrom)
	{
		this.availableFrom = availableFrom;
	}
	
	@NonNull
	public ZonedDateTime getAvailableTill()
	{
		return availableTill;
	}
	
	public void setAvailableTill(@NonNull ZonedDateTime availableTill)
	{
		this.availableTill = availableTill;
	}
}
