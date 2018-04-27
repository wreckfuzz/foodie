package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZonedDateTime;

import java.util.Date;

import mobile.uni.natashawhitter.foodie.utils.Utils;

import static mobile.uni.natashawhitter.foodie.utils.Utils.*;

@Entity(inheritSuperIndices = true, tableName = Utils.BOOKING_TABLE,
foreignKeys = {
		@ForeignKey(entity = User.class,
		parentColumns = BASE_ID_NAME,
		childColumns = BOOKING_USER_ID,
		onDelete = ForeignKey.CASCADE),
		@ForeignKey(entity = Restaurant.class,
		parentColumns = BASE_ID_NAME,
		childColumns = BOOKING_RESTAURANT_ID,
		onDelete = ForeignKey.CASCADE)
})
public final class Booking extends Base
{
	@ColumnInfo(name = BOOKING_USER_ID, index = true)
	@NonNull
	private int userId;
	@ColumnInfo(name = BOOKING_RESTAURANT_ID, index = true)
	@NonNull
	private int restaurantId;
	@ColumnInfo(name = BOOKING_SPACES)
	@NonNull
	private int numSpacesBooked;
	@ColumnInfo(name = BOOKING_DATE_TIME)
	@NonNull
	private ZonedDateTime dateTime;
	@ColumnInfo(name = BOOKING_COMMENTS)
	private String comments;
	
	public Booking(@NonNull int id, @NonNull Instant lastModified, @NonNull Instant createdAt, int userId, int restaurantId, int numSpacesBooked, ZonedDateTime dateTime, String comments)
	{
		super(id, lastModified, createdAt);
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.numSpacesBooked = numSpacesBooked;
		this.dateTime = dateTime;
		this.comments = comments;
	}
	
	public int getUserId()
	{
		return userId;
	}
	
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	public int getRestaurantId()
	{
		return restaurantId;
	}
	
	public void setRestaurantId(int restaurantId)
	{
		this.restaurantId = restaurantId;
	}
	
	public int getNumSpacesBooked()
	{
		return numSpacesBooked;
	}
	
	public void setNumSpacesBooked(int numSpacesBooked)
	{
		this.numSpacesBooked = numSpacesBooked;
	}
	
	public ZonedDateTime getDateTime()
	{
		return dateTime;
	}
	
	public void setDateTime(ZonedDateTime dateTime)
	{
		this.dateTime = dateTime;
	}
	
	public String getComments()
	{
		return comments;
	}
	
	public void setComments(String comments)
	{
		this.comments = comments;
	}
}
