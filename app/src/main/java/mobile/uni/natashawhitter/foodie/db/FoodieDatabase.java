package mobile.uni.natashawhitter.foodie.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import org.threeten.bp.OffsetTime;
import org.threeten.bp.ZonedDateTime;

import java.util.ArrayList;
import java.util.List;

import mobile.uni.natashawhitter.foodie.db.converter.CuisineConverter;
import mobile.uni.natashawhitter.foodie.db.converter.DateConverter;
import mobile.uni.natashawhitter.foodie.db.converter.InstantConverter;
import mobile.uni.natashawhitter.foodie.db.converter.LocationConverter;
import mobile.uni.natashawhitter.foodie.db.converter.MenuCategoryConverter;
import mobile.uni.natashawhitter.foodie.db.converter.OffsetTimeConverter;
import mobile.uni.natashawhitter.foodie.db.converter.RestaurantCategoryConverter;
import mobile.uni.natashawhitter.foodie.db.converter.ZonedDateTimeConverter;
import mobile.uni.natashawhitter.foodie.db.dao.RestaurantDao;
import mobile.uni.natashawhitter.foodie.db.dao.UserDao;
import mobile.uni.natashawhitter.foodie.db.dao.UserRestaurantDao;
import mobile.uni.natashawhitter.foodie.db.data.Booking;
import mobile.uni.natashawhitter.foodie.db.data.BookingMeals;
import mobile.uni.natashawhitter.foodie.db.data.Meal;
import mobile.uni.natashawhitter.foodie.db.data.Menu;
import mobile.uni.natashawhitter.foodie.db.data.Restaurant;
import mobile.uni.natashawhitter.foodie.db.data.RestaurantCategory;
import mobile.uni.natashawhitter.foodie.db.data.User;
import mobile.uni.natashawhitter.foodie.db.data.UserRestaurant;
import mobile.uni.natashawhitter.foodie.utils.enums.Cuisine;
import mobile.uni.natashawhitter.foodie.utils.enums.Location;

import static mobile.uni.natashawhitter.foodie.utils.Utils.DB_NAME;

@Database(entities = { Meal.class, Menu.class, Restaurant.class, Booking.class, RestaurantCategory.class,
		User.class, UserRestaurant.class, BookingMeals.class}, version = 2)
@TypeConverters({ DateConverter.class, LocationConverter.class, RestaurantCategoryConverter.class,
		MenuCategoryConverter.class, CuisineConverter.class, InstantConverter.class, ZonedDateTimeConverter.class, OffsetTimeConverter.class})
public abstract class FoodieDatabase extends RoomDatabase
{
	private static volatile FoodieDatabase INSTANCE;
	
	public synchronized static FoodieDatabase getInstance(Context context)
	{
		if (INSTANCE == null)
		{
			INSTANCE = create(context);
			//clearAddToDatabase();
		}
		return INSTANCE;
	}
	
	private static FoodieDatabase create(final Context context)
	{
		return Room.databaseBuilder(context, FoodieDatabase.class, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
	}
	
	private static void clearAddToDatabase()
	{
		INSTANCE.getUserDao().delete();
		INSTANCE.getRestaurantDao().delete();
		
		List<User> users = new ArrayList<>();
		
		users.add(new User("user1", "user1", "test1@test.com", "Test123", "Test", "Test", ZonedDateTime.now(), "+44", "0000000000", Cuisine.AMERICAN));
		users.add(new User("user2", "user1", "test2@test.com", "Test123", "Test", "Test", ZonedDateTime.now(), "+44", "0000000000", Cuisine.CHINESE));
		users.add(new User("user3", "user1", "test3@test.com", "Test123", "Test", "Test", ZonedDateTime.now(), "+44", "0000000000", Cuisine.INDIAN));
		
		List<Long> userIds = INSTANCE.getUserDao().insert(users);
		
		List<Restaurant> restaurants = new ArrayList<>();
		
		restaurants.add(new Restaurant("restaurant1", Location.SOUTH, Cuisine.AMERICAN, "E2CA 3HJ", 100, OffsetTime.now().minusHours(3), OffsetTime.now().plusHours(3)));
		restaurants.add(new Restaurant("restaurant2", Location.EAST, Cuisine.MEXICAN, "DA16 3JQ", 56, OffsetTime.now().minusHours(-1), OffsetTime.now().plusHours(7)));
		restaurants.add(new Restaurant("restaurant3", Location.NORTH, Cuisine.CHINESE, "NW3 8UI", 12, OffsetTime.now().minusHours(0), OffsetTime.now().plusHours(8)));
		restaurants.add(new Restaurant("restaurant4", Location.WEST, Cuisine.DESSERT, "SE18 9JK", 80, OffsetTime.now().minusHours(-6), OffsetTime.now().plusHours(4)));
		
		List<Long> restaurantIds = INSTANCE.getRestaurantDao().insert(restaurants);
		
		List<UserRestaurant> userRestaurants = new ArrayList<>();
		
		userRestaurants.add(new UserRestaurant(userIds.get(0), restaurantIds.get(0)));
		userRestaurants.add(new UserRestaurant(userIds.get(0), restaurantIds.get(1)));
		userRestaurants.add(new UserRestaurant(userIds.get(1), restaurantIds.get(0)));
		userRestaurants.add(new UserRestaurant(userIds.get(1), restaurantIds.get(2)));
		userRestaurants.add(new UserRestaurant(userIds.get(2), restaurantIds.get(2)));
		userRestaurants.add(new UserRestaurant(userIds.get(2), restaurantIds.get(3)));
		
		INSTANCE.getUserRestaurantDao().insert(userRestaurants);
		
		System.out.print("Hi");
	}
	
	public abstract RestaurantDao getRestaurantDao();
	public abstract UserDao getUserDao();
	public abstract UserRestaurantDao getUserRestaurantDao();
}
