package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;

import java.util.Date;

import static mobile.uni.natashawhitter.foodie.utils.Utils.*;

@Entity(tableName = MEAL_TABLE, foreignKeys = {
		@ForeignKey(entity = Menu.class,
		parentColumns = BASE_ID_NAME,
		childColumns = MEAL_MENU_ID,
		onDelete = ForeignKey.CASCADE)
})
public final class Meal extends Base
{
	@ColumnInfo(name = MEAL_TITLE)
	@NonNull
	private String title;
	@ColumnInfo(name = MEAL_DESCRIPTION)
	@NonNull
	private String desc;
	@ColumnInfo(name = MEAL_PRICE)
	@NonNull
	private double price;
	@ColumnInfo(name = MEAL_IMAGE_URL)
	private String imageUrl;
	@ColumnInfo(name = MEAL_MENU_ID, index = true)
	@NonNull
	private int menuId;
	
	public Meal(@NonNull long id, @NonNull Instant lastModified, @NonNull Instant createdAt, @NonNull String title, @NonNull String desc, @NonNull double price, @NonNull String imageUrl, @NonNull int menuId)
	{
		super(id, lastModified, createdAt);
		this.title = title;
		this.desc = desc;
		this.price = price;
		this.imageUrl = imageUrl;
		this.menuId = menuId;
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
	public String getDesc()
	{
		return desc;
	}
	
	public void setDesc(@NonNull String desc)
	{
		this.desc = desc;
	}
	
	@NonNull
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(@NonNull double price)
	{
		this.price = price;
	}
	
	@NonNull
	public String getImageUrl()
	{
		return imageUrl;
	}
	
	public void setImageUrl(@NonNull String imageUrl)
	{
		this.imageUrl = imageUrl;
	}
	
	@NonNull
	public int getMenuId()
	{
		return menuId;
	}
	
	public void setMenuId(@NonNull int menuId)
	{
		this.menuId = menuId;
	}
}
