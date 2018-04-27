package mobile.uni.natashawhitter.foodie.db.converter;

import android.arch.persistence.room.TypeConverter;

import mobile.uni.natashawhitter.foodie.utils.enums.Location;

public class LocationConverter
{
	@TypeConverter
	public static Location toLocation(String location)
	{
		return Location.getLocation(location);
	}
	
	@TypeConverter
	public static String fromLocation(Location location)
	{
		return location.getLocationType();
	}
}
