package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

import static mobile.uni.natashawhitter.foodie.utils.Utils.*;

@Entity(tableName = USER_RESTAURANT_TABLE,
		primaryKeys = {RESTAURANT_USER_USER_ID, RESTAURANT_USER_RESTAURANT_ID},
		foreignKeys = {
				@ForeignKey(entity = User.class,
						parentColumns = BASE_ID_NAME,
						childColumns = RESTAURANT_USER_USER_ID),
				@ForeignKey(entity = Restaurant.class,
						parentColumns = BASE_ID_NAME,
						childColumns = RESTAURANT_USER_USER_ID)
		})
public final class UserRestaurantJoin
{
	@ColumnInfo(name = RESTAURANT_USER_USER_ID, index = true)
	@NonNull
	private int userId;
	@ColumnInfo(name = RESTAURANT_USER_RESTAURANT_ID, index = true)
	@NonNull
	private int restaurantId;
	
	public UserRestaurantJoin(@NonNull final int userId, @NonNull final int restaurantId)
	{
		this.userId = userId;
		this.restaurantId = restaurantId;
	}
	
	@NonNull
	public int getUserId()
	{
		return userId;
	}
	
	public void setUserId(@NonNull int userId)
	{
		this.userId = userId;
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
}
