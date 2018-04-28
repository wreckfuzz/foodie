package mobile.uni.natashawhitter.foodie.utils;

import android.content.Context;
import android.support.design.widget.TextInputLayout;

import mobile.uni.natashawhitter.foodie.db.data.User;

public class Utils
{
	public static final String DB_NAME = "Foodie_DB";
	public static final String MEAL_TABLE = "tb_meals";
	public static final String MENU_TABLE = "tb_menus";
	public static final String RESTAURANT_TABLE = "tb_restaurants";
	public static final String USER_TABLE = "tb_users";
	public static final String USER_RESTAURANT_TABLE = "tb_users_restaurants";
	public static final String RESTAURANT_CATEGORY_TABLE = "tb_restaurants_category";
	public static final String BOOKING_MEAL_TABLE = "tb_booking_meal";
	public static final String BOOKING_TABLE = "tb_bookings";
	
	public static final String BASE_ID_NAME = "_id";
	public static final String BASE_LAST_MODIFIED_NAME = "last_modified";
	public static final String BASE_CREATED_AT_NAME = "created_at";
	
	public static final String USER_FIRST_NAME = "first_name";
	public static final String USER_LAST_NAME = "last_name";
	public static final String USER_EMAIL_ADDRESS = "email_address";
	public static final String USER_PASSWORD = "password";
	public static final String USER_BIRTH_DATE = "birth_date";
	public static final String USER_SECRET_QUESTION = "secret_question";
	public static final String USER_SECRET_ANSWER = "secret_answer";
	public static final String USER_AREA_CODE = "area_code";
	public static final String USER_MOBILE_NUM = "mobile_number";
	public static final String USER_FAV_CUISINE = "favorite_cuisine";
	
	public static final String RESTAURANT_TITLE = "title";
	public static final String RESTAURANT_LOCATION = "location";
	public static final String RESTAURANT_TYPE = "type";
	public static final String RESTAURANT_POST_CODE = "post_code";
	public static final String RESTAURANT_NUM_TABLES = "num_tables";
	public static final String RESTAURANT_OPENING_HOURS = "opening_hours";
	public static final String RESTAURANT_CLOSING_HOURS = "closing_hours";
	
	public static final String RESTAURANT_CATEGORY_RESTAURANT_ID = "restaurant_id";
	public static final String RESTAURANT_CATEGORY_CATEGORY = "category";
	
	public static final String RESTAURANT_USER_USER_ID = "user_id";
	public static final String RESTAURANT_USER_RESTAURANT_ID = "restaurant_id";
	
	public static final String BOOKING_MEAL_BOOKING_ID = "booking_id";
	public static final String BOOKING_MEAL_MEAL_ID = "meal_id";
	
	public static final String MEAL_TITLE = "title";
	public static final String MEAL_DESCRIPTION = "description";
	public static final String MEAL_PRICE = "price";
	public static final String MEAL_IMAGE_URL = "image_url";
	public static final String MEAL_MENU_ID = "menu_id";
	
	public static final String MENU_TITLE = "title";
	public static final String MENU_CATEGORY = "category";
	public static final String MENU_RESTAURANT_ID = "restaurant_id";
	public static final String MENU_AVAILABILITY_FROM = "available_from";
	public static final String MENU_AVAILABILITY_TILL = "available_till";
	
	public static final String BOOKING_USER_ID = "user_id";
	public static final String BOOKING_RESTAURANT_ID = "restaurant_id";
	public static final String BOOKING_SPACES = "num_spaces_booked";
	public static final String BOOKING_DATE_TIME = "date_time";
	public static final String BOOKING_COMMENTS = "comments";
	
	public static boolean checkLoginDetails(TextInputLayout email, TextInputLayout password)
	{
		boolean isEmailCorrect = isValidEmailAddress(email);
		boolean isPasswordCorrect = isValidPassword(password);
		
		return isEmailCorrect && isPasswordCorrect;
	}
	
	public static boolean isValidEmailAddress(TextInputLayout emailTil)
	{
		return isValidEmailAddress(emailTil, true);
	}
	
	public static boolean isValidEmailAddress(TextInputLayout emailTil, boolean displayError)
	{
		String email = emailTil.getEditText().getText().toString();
		
		if (!email.isEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
		{
			emailTil.setError(null);
			return true;
		}
		
		if (displayError)
		{
			emailTil.setError("Incorrect Email Address");
		}
		return false;
	}
	
	public static boolean isValidPassword(TextInputLayout passwordTil)
	{
		String password = passwordTil.getEditText().getText().toString();
		
		if (!password.isEmpty())
		{
			passwordTil.setError(null);
			return true;
		}
		
		passwordTil.setError("Incorrect Password");
		return false;
	}
	
	public static boolean isValidName(TextInputLayout nameTil)
	{
		String name = nameTil.getEditText().getText().toString();
		
		if (!name.isEmpty())
		{
			nameTil.setError(null);
			return true;
		}
		
		if (nameTil.getHint() != null)
		{
			nameTil.setError("Incorrect + " + nameTil.getHint().toString() + " + Entered");
		} else
		{
			nameTil.setError("Incorrect Data Supplied");
		}
		return false;
	}
	
	public static User getCurrentUser(Context context)
	{
		SessionManager session = new SessionManager(context);
		return session.getUserDetails();
	}
}
