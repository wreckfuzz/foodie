package mobile.uni.natashawhitter.foodie.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import mobile.uni.natashawhitter.foodie.db.converter.CuisineConverter;
import mobile.uni.natashawhitter.foodie.db.converter.DateConverter;
import mobile.uni.natashawhitter.foodie.db.converter.LocationConverter;
import mobile.uni.natashawhitter.foodie.db.converter.MenuCategoryConverter;
import mobile.uni.natashawhitter.foodie.db.converter.RestaurantCategoryConverter;
import mobile.uni.natashawhitter.foodie.db.dao.RestaurantDao;
import mobile.uni.natashawhitter.foodie.db.dao.UserDao;
import mobile.uni.natashawhitter.foodie.db.dao.UserRestaurantJoinDao;
import mobile.uni.natashawhitter.foodie.db.data.Booking;
import mobile.uni.natashawhitter.foodie.db.data.BookingMeals;
import mobile.uni.natashawhitter.foodie.db.data.Meal;
import mobile.uni.natashawhitter.foodie.db.data.Menu;
import mobile.uni.natashawhitter.foodie.db.data.Restaurant;
import mobile.uni.natashawhitter.foodie.db.data.RestaurantCategory;
import mobile.uni.natashawhitter.foodie.db.data.User;
import mobile.uni.natashawhitter.foodie.db.data.UserRestaurantJoin;

import static mobile.uni.natashawhitter.foodie.utils.Utils.DB_NAME;

@Database(entities = { Meal.class, Menu.class, Restaurant.class, Booking.class, RestaurantCategory.class,
		User.class, UserRestaurantJoin.class, BookingMeals.class}, version = 1)
@TypeConverters({ DateConverter.class, LocationConverter.class, RestaurantCategoryConverter.class,
		MenuCategoryConverter.class, CuisineConverter.class})
public abstract class FoodieDatabase extends RoomDatabase
{
		private static volatile FoodieDatabase INSTANCE;
		
		public synchronized static FoodieDatabase getInstance(Context context)
		{
			if (INSTANCE == null)
			{
				INSTANCE = create(context);
			}
			return INSTANCE;
		}
		
		private static FoodieDatabase create(final Context context)
		{
			return Room.databaseBuilder(context, FoodieDatabase.class, DB_NAME).allowMainThreadQueries().build();
		}
	public abstract RestaurantDao getRestaurantDao();
	public abstract UserDao getUserDao();
	public abstract UserRestaurantJoinDao getUserRestaurantJoinDao();
}
