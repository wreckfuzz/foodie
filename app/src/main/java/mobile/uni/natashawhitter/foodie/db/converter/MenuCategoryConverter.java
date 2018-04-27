package mobile.uni.natashawhitter.foodie.db.converter;

import android.arch.persistence.room.TypeConverter;

import mobile.uni.natashawhitter.foodie.utils.enums.MenuCategory;
import mobile.uni.natashawhitter.foodie.utils.enums.RestaurantCategory;

public class MenuCategoryConverter
{
	@TypeConverter
	public static MenuCategory toMenuCategory(String category)
	{
		return MenuCategory.getCategory(category);
	}
	
	@TypeConverter
	public static String fromMenuCategory(MenuCategory category)
	{
		return category.getCategory();
	}
}
