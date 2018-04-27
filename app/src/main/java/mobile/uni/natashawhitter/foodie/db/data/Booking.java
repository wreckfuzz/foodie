package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

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
	private Date dateTime;
	@ColumnInfo(name = BOOKING_COMMENTS)
	private String comments;
	
	public Booking(@NonNull int id, @NonNull Date lastModified, @NonNull Date createdAt, int userId, int restaurantId, int numSpacesBooked, Date dateTime, String comments)
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
	
	public Date getDateTime()
	{
		return dateTime;
	}
	
	public void setDateTime(Date dateTime)
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
