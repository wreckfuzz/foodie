package mobile.uni.natashawhitter.foodie.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import mobile.uni.natashawhitter.foodie.db.data.Restaurant;
import mobile.uni.natashawhitter.foodie.db.data.User;

import static mobile.uni.natashawhitter.foodie.utils.Utils.BASE_ID_NAME;
import static mobile.uni.natashawhitter.foodie.utils.Utils.RESTAURANT_LOCATION;
import static mobile.uni.natashawhitter.foodie.utils.Utils.RESTAURANT_POST_CODE;
import static mobile.uni.natashawhitter.foodie.utils.Utils.RESTAURANT_TABLE;
import static mobile.uni.natashawhitter.foodie.utils.Utils.RESTAURANT_TITLE;
import static mobile.uni.natashawhitter.foodie.utils.Utils.RESTAURANT_TYPE;

@Dao
public interface RestaurantDao
{
	// Query
	
	// Get all restaurants' details
	@Query("SELECT * FROM tb_restaurants ORDER BY title")
	public List<Restaurant> getRestaurants();
	
	// Get restaurants's details by id
	@Query("SELECT * FROM tb_restaurants WHERE " + BASE_ID_NAME + " = :id ORDER BY title")
	public Restaurant getRestaurants(final int id);
	
	// Find restaurants by title
	@Query("SELECT * FROM tb_restaurants WHERE " + RESTAURANT_TITLE + " LIKE :title")
	public List<Restaurant> getRestaurantsByTitle(final String title);
	
	// Find restaurants by location
	@Query("SELECT * FROM tb_restaurants WHERE " + RESTAURANT_LOCATION + " LIKE :location")
	public List<Restaurant> getRestaurantsByLocation(final String location);
	
	// Find restaurants by type
	@Query("SELECT * FROM tb_restaurants WHERE " + RESTAURANT_TYPE + " LIKE :type")
	public List<Restaurant> getRestaurantsByType(final String type);
	
	// Find restaurants by post code
	@Query("SELECT * FROM tb_restaurants WHERE " + RESTAURANT_POST_CODE + " LIKE :postCode")
	public List<Restaurant> getRestaurantsByPostCode(final String postCode);
	
	// Find restaurants by category
	@Query("SELECT * FROM tb_restaurants INNER JOIN tb_restaurants_category ON category = tb_restaurants_category.category WHERE tb_restaurants_category.restaurant_id = :category")
	public List<Restaurant> getRestaurantsByCategory(final String category);
	
	// Insert
	
	@Insert
	long insert(Restaurant restaurant);
	
	@Insert
	long[] insert(Restaurant... restaurants);
	
	@Insert
	List<Long> insert(List<Restaurant> restaurants);
	
	// Update
	
	@Update
	void update(Restaurant restaurant);
	
	// Delete
	
	@Delete
	void delete(Restaurant restaurant);
	
	@Query("DELETE FROM " + RESTAURANT_TABLE)
	void delete();
}
