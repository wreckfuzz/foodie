package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.support.annotation.NonNull;

import static mobile.uni.natashawhitter.foodie.utils.Utils.BASE_ID_NAME;
import static mobile.uni.natashawhitter.foodie.utils.Utils.BOOKING_MEAL_BOOKING_ID;
import static mobile.uni.natashawhitter.foodie.utils.Utils.BOOKING_MEAL_MEAL_ID;
import static mobile.uni.natashawhitter.foodie.utils.Utils.BOOKING_MEAL_TABLE;

@Entity(tableName = BOOKING_MEAL_TABLE,
		primaryKeys = { BOOKING_MEAL_BOOKING_ID, BOOKING_MEAL_MEAL_ID },
		foreignKeys = {
				@ForeignKey(entity = Booking.class,
						parentColumns = BASE_ID_NAME,
						childColumns = BOOKING_MEAL_BOOKING_ID),
				@ForeignKey(entity = Meal.class,
				parentColumns = BASE_ID_NAME,
				childColumns = BOOKING_MEAL_MEAL_ID)
		}
)
public final class BookingMeals
{
	@ColumnInfo(name = BOOKING_MEAL_BOOKING_ID, index = true)
	@NonNull
	private int bookingId;
	
	@ColumnInfo(name = BOOKING_MEAL_MEAL_ID, index = true)
	@NonNull
	private int mealId;
	
	public BookingMeals(@NonNull int bookingId, @NonNull int mealId)
	{
		this.bookingId = bookingId;
		this.mealId = mealId;
	}
	
	@NonNull
	public int getBookingId()
	{
		return bookingId;
	}
	
	public void setBookingId(@NonNull int bookingId)
	{
		this.bookingId = bookingId;
	}
	
	@NonNull
	public int getMealId()
	{
		return mealId;
	}
	
	public void setMealId(@NonNull int mealId)
	{
		this.mealId = mealId;
	}
}
