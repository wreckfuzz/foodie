package mobile.uni.natashawhitter.foodie.db.converter;

import android.arch.persistence.room.TypeConverter;

import mobile.uni.natashawhitter.foodie.utils.enums.Cuisine;
import mobile.uni.natashawhitter.foodie.utils.enums.RestaurantCategory;

public class CuisineConverter
{
	@TypeConverter
	public static Cuisine toCuisine(String cuisine)
	{
		return Cuisine.getType(cuisine);
	}
	
	@TypeConverter
	public static String fromCuisine(Cuisine cuisine)
	{
		return cuisine.getType();
	}
}
