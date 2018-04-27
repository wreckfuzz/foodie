package mobile.uni.natashawhitter.foodie.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import mobile.uni.natashawhitter.foodie.db.data.User;

import static mobile.uni.natashawhitter.foodie.utils.Utils.*;

@Dao
public interface UserDao
{
	// Query
	
	// Get all users' details
	@Query("SELECT * FROM tb_users ORDER BY first_name, last_name")
	public List<User> getUsers();
	
	// Get user's details by id
	@Query("SELECT * FROM tb_users WHERE " + BASE_ID_NAME + " = :id ORDER BY first_name, last_name")
	public User getUser(final int id);
	
	// Get user's details by username/email and password
	@Query("SELECT EXISTS (SELECT 1 FROM tb_users WHERE email_address LIKE :email AND password LIKE :password)")
	public boolean checkUserExists(final String email, final String password);
	
	// Find users by name
	@Query("SELECT * FROM tb_users WHERE " + USER_FIRST_NAME + " LIKE :firstName OR " + USER_LAST_NAME + " LIKE :lastName ORDER BY first_name, last_name")
	public List<User> getUsersByName(final String firstName, final String lastName);
	
	// Find users by mobile number
	@Query("SELECT * FROM tb_users WHERE " + USER_AREA_CODE + " LIKE :areaCode OR " + USER_MOBILE_NUM + " LIKE :mobileNum ORDER BY first_name, last_name")
	public List<User> getUsersByMobileNumber(final String areaCode, final String mobileNum);
	
	// Insert
	
	@Insert
	void insert(User user);
	
	@Insert
	void insert(User... users);
	
	@Insert
	void insert(List<User> users);
	
	// Update
	
	@Update
	void update(User user);
	
	// Delete
	
	@Delete
	void delete(User user);
}
