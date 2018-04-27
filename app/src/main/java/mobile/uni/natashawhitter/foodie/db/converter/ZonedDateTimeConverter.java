package mobile.uni.natashawhitter.foodie.db.converter;

import android.arch.persistence.room.TypeConverter;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalTime;
import org.threeten.bp.OffsetTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalField;

import java.util.Date;


public class ZonedDateTimeConverter
{
	@TypeConverter
	public static ZonedDateTime toZonedDateTime(long dateLong)
	{
		Instant instant = Instant.ofEpochMilli(dateLong);
		return ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
	}
	
	@TypeConverter
	public static long fromZonedDateTime(ZonedDateTime date)
	{
		Instant instant = date.toInstant();
		return instant.toEpochMilli();
	}
}
