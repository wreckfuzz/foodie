package mobile.uni.natashawhitter.foodie.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import mobile.uni.natashawhitter.foodie.db.data.Restaurant;
import mobile.uni.natashawhitter.foodie.db.data.User;
import mobile.uni.natashawhitter.foodie.db.data.UserRestaurantJoin;

@Dao
public interface UserRestaurantJoinDao
{
	// Query
	
	// Get all admin users of a restaurant
	@Query("SELECT * FROM tb_users INNER JOIN tb_users_restaurants ON user_id = tb_users_restaurants.user_id WHERE tb_users_restaurants.restaurant_id = :restaurantId")
	public List<User> getAdminsByRestaurantId(final int restaurantId);
	
	// Get all restaurants 'owned' by admin
	@Query("SELECT * FROM tb_restaurants INNER JOIN tb_users_restaurants ON restaurant_id = tb_users_restaurants.restaurant_id WHERE tb_users_restaurants.user_id = :userId")
	public List<Restaurant> getRestaurantsByAdminId(final int userId);
	
	// Insert
	
	@Insert
	void insert(UserRestaurantJoin userRestaurantJoin);
	
	@Insert
	void insert(UserRestaurantJoin... userRestaurantJoins);
	
	@Insert
	void insert(List<UserRestaurantJoin> userRestaurantJoins);
	
	// Update
	
	@Update
	void update(UserRestaurantJoin userRestaurantJoin);
	
	@Update
	void update(UserRestaurantJoin... userRestaurantJoins);
	
	@Update
	void update(List<UserRestaurantJoin> userRestaurantJoins);
	
	// Delete
	
	@Delete
	void delete(UserRestaurantJoin userRestaurantJoin);
	
	@Delete
	void delete(UserRestaurantJoin... userRestaurantJoins);
	
	@Delete
	void delete(List<UserRestaurantJoin> userRestaurantJoins);
}
