package mobile.uni.natashawhitter.foodie.db.converter;

import android.arch.persistence.room.TypeConverter;

import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;

import java.util.Date;


public class InstantConverter
{
	@TypeConverter
	public static Instant toInstant(long date)
	{
		return Instant.ofEpochMilli(date);
	}
	
	@TypeConverter
	public static long fromInstant(Instant date)
	{
		return date.toEpochMilli();
	}
}
