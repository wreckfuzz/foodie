package mobile.uni.natashawhitter.foodie.db.converter;

import android.arch.persistence.room.TypeConverter;

import mobile.uni.natashawhitter.foodie.utils.enums.RestaurantCategory;

public class RestaurantCategoryConverter
{
	@TypeConverter
	public static RestaurantCategory toRestaurantCategory(String category)
	{
		return RestaurantCategory.getCategory(category);
	}
	
	@TypeConverter
	public static String fromRestaurantCategory(RestaurantCategory category)
	{
		return category.getCategory();
	}
}
