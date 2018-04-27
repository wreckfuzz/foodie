package mobile.uni.natashawhitter.foodie.db.converter;

import android.arch.persistence.room.TypeConverter;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalTime;
import org.threeten.bp.OffsetTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalField;

import static org.threeten.bp.temporal.ChronoField.MILLI_OF_SECOND;


public class OffsetTimeConverter
{
	@TypeConverter
	public static OffsetTime toOffsetTime(long time)
	{
		Instant instant = Instant.ofEpochSecond(time);
		return OffsetTime.ofInstant(instant, ZoneOffset.UTC);
	}
	
	@TypeConverter
	public static long fromOffsetTime(OffsetTime time)
	{
		Instant instant = Instant.ofEpochSecond(time.getLong(ChronoField.MILLI_OF_SECOND));
		return time.get(MILLI_OF_SECOND);
	}
}
