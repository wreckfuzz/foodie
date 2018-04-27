package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

import static mobile.uni.natashawhitter.foodie.utils.Utils.BASE_ID_NAME;
import static mobile.uni.natashawhitter.foodie.utils.Utils.RESTAURANT_CATEGORY_CATEGORY;
import static mobile.uni.natashawhitter.foodie.utils.Utils.RESTAURANT_CATEGORY_RESTAURANT_ID;
import static mobile.uni.natashawhitter.foodie.utils.Utils.RESTAURANT_CATEGORY_TABLE;

@Entity(tableName = RESTAURANT_CATEGORY_TABLE,
	primaryKeys = {RESTAURANT_CATEGORY_RESTAURANT_ID, RESTAURANT_CATEGORY_CATEGORY},
		foreignKeys = {
		@ForeignKey(entity = Restaurant.class,
		parentColumns = BASE_ID_NAME,
		childColumns = RESTAURANT_CATEGORY_RESTAURANT_ID)
		}
)
public final class RestaurantCategory
{
	@ColumnInfo(name = RESTAURANT_CATEGORY_RESTAURANT_ID, index = true)
	@NonNull
	private int restaurantId;
	@ColumnInfo(name = RESTAURANT_CATEGORY_CATEGORY)
	@NonNull
	private String category;
	
	public RestaurantCategory(@NonNull int restaurantId, @NonNull String category)
	{
		this.restaurantId = restaurantId;
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
	public String getCategory()
	{
		return category;
	}
	
	public void setCategory(@NonNull String category)
	{
		this.category = category;
	}
}
