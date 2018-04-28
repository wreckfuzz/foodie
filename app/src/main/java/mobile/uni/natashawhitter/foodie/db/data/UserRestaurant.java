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
						childColumns = RESTAURANT_USER_USER_ID,
				onDelete = ForeignKey.CASCADE),
				@ForeignKey(entity = Restaurant.class,
						parentColumns = BASE_ID_NAME,
						childColumns = RESTAURANT_USER_USER_ID,
						onDelete = ForeignKey.CASCADE)
		})
public final class UserRestaurant
{
	@ColumnInfo(name = RESTAURANT_USER_USER_ID, index = true)
	@NonNull
	private long userId;
	@ColumnInfo(name = RESTAURANT_USER_RESTAURANT_ID, index = true)
	@NonNull
	private long restaurantId;
	
	public UserRestaurant(@NonNull final long userId, @NonNull final long restaurantId)
	{
		this.userId = userId;
		this.restaurantId = restaurantId;
	}
	
	@NonNull
	public long getUserId()
	{
		return userId;
	}
	
	public void setUserId(@NonNull long userId)
	{
		this.userId = userId;
	}
	
	@NonNull
	public long getRestaurantId()
	{
		return restaurantId;
	}
	
	public void setRestaurantId(@NonNull long restaurantId)
	{
		this.restaurantId = restaurantId;
	}
}
