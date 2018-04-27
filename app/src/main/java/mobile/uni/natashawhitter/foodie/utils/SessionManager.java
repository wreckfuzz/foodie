package mobile.uni.natashawhitter.foodie.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;

import mobile.uni.natashawhitter.foodie.activities.LoginActivity;
import mobile.uni.natashawhitter.foodie.db.FoodieDatabase;
import mobile.uni.natashawhitter.foodie.db.data.User;

public class SessionManager
{
	// Shared Preferences
	SharedPreferences pref;
	
	// Editor for Shared Preferences
	Editor editor;
	
	// Context
	Context _context;
	
	// Shared pref mode
	int PRIVATE_MODE = 0;
	
	// Sharedpref file name
	private static final String PREF_NAME = "FoodiePref";
	
	// All Shared Preferences Keys
	private static final String IS_LOGIN = "IsLoggedIn";
	
	// User's ID (make variable public to access from outside)
	public static final String KEY_USER_ID = "userId";
	
	// Constructor
	public SessionManager(Context context){
		this._context = context;
		pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
		editor = pref.edit();
	}
	
	public void createLoginSession(int userId){
		// Storing login value as TRUE
		editor.putBoolean(IS_LOGIN, true);
		
		// Storing user ID in pref
		editor.putInt(KEY_USER_ID, userId);
		
		// commit changes
		editor.commit();
	}
	
	public User getUserDetails()
	{
		// user's ID
		int userId = pref.getInt(KEY_USER_ID, 0);
		
		// return user
		return FoodieDatabase.getInstance(_context).getUserDao().getUser(userId);
	}
	
	public void checkLogin(){
		// Check login status
		if(!this.isLoggedIn()){
			// user is not logged in redirect him to Login Activity
			Intent i = new Intent(_context, LoginActivity.class);
			// Closing all the Activities
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			
			// Add new Flag to start new Activity
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			// Staring Login Activity
			_context.startActivity(i);
		}
		
	}
	
	/**
	 * Clear session details
	 * */
	public void logoutUser(){
		// Clearing all data from Shared Preferences
		editor.clear();
		editor.commit();
		
		// After logout redirect user to Loing Activity
		Intent i = new Intent(_context, LoginActivity.class);
		// Closing all the Activities
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		// Add new Flag to start new Activity
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		// Staring Login Activity
		_context.startActivity(i);
	}
	
	// Get Login State
	public boolean isLoggedIn(){
		return pref.getBoolean(IS_LOGIN, false);
	}
}
