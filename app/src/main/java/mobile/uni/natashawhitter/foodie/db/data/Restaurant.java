package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.OffsetTime;

import java.util.Date;

import mobile.uni.natashawhitter.foodie.utils.enums.Location;
import mobile.uni.natashawhitter.foodie.utils.enums.Cuisine;

import static mobile.uni.natashawhitter.foodie.utils.Utils.*;

@Entity(inheritSuperIndices = true, tableName = RESTAURANT_TABLE)
public final class Restaurant extends Base
{
	@ColumnInfo(name = RESTAURANT_TITLE)
	@NonNull
	private String title;
	@ColumnInfo(name = RESTAURANT_LOCATION)
	@NonNull
	private Location location;
	@ColumnInfo(name = RESTAURANT_TYPE)
	@NonNull
	private Cuisine type;
	@ColumnInfo(name = RESTAURANT_POST_CODE)
	@NonNull
	private String postCode;
	@ColumnInfo(name = RESTAURANT_NUM_TABLES)
	@NonNull
	private int numSpaces;
	@ColumnInfo(name = RESTAURANT_OPENING_HOURS)
	@NonNull
	private OffsetTime openingHours;
	@ColumnInfo(name = RESTAURANT_CLOSING_HOURS)
	@NonNull
	private OffsetTime closingHours;
	
	public Restaurant(@NonNull long id, @NonNull Instant lastModified, @NonNull Instant createdAt, @NonNull String title, @NonNull Location location, @NonNull Cuisine type, @NonNull String postCode, @NonNull int numSpaces, @NonNull OffsetTime openingHours, @NonNull OffsetTime closingHours)
	{
		super(id, lastModified, createdAt);
		this.title = title;
		this.location = location;
		this.type = type;
		this.postCode = postCode;
		this.numSpaces = numSpaces;
		this.openingHours = openingHours;
		this.closingHours = closingHours;
	}
	
	@Ignore
	public Restaurant(@NonNull String title, @NonNull Location location, @NonNull Cuisine type, @NonNull String postCode, @NonNull int numSpaces, @NonNull OffsetTime openingHours, @NonNull OffsetTime closingHours)
	{
		this.title = title;
		this.location = location;
		this.type = type;
		this.postCode = postCode;
		this.numSpaces = numSpaces;
		this.openingHours = openingHours;
		this.closingHours = closingHours;
	}
	
	@NonNull
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(@NonNull String title)
	{
		this.title = title;
	}
	
	@NonNull
	public Location getLocation()
	{
		return location;
	}
	
	public void setLocation(@NonNull Location location)
	{
		this.location = location;
	}
	
	@NonNull
	public Cuisine getType()
	{
		return type;
	}
	
	public void setType(@NonNull Cuisine type)
	{
		this.type = type;
	}
	
	@NonNull
	public String getPostCode()
	{
		return postCode;
	}
	
	public void setPostCode(@NonNull String postCode)
	{
		this.postCode = postCode;
	}
	
	@NonNull
	public int getNumSpaces()
	{
		return numSpaces;
	}
	
	public void setNumSpaces(@NonNull int numSpaces)
	{
		this.numSpaces = numSpaces;
	}
	
	@NonNull
	public OffsetTime getOpeningHours()
	{
		return openingHours;
	}
	
	public void setOpeningHours(@NonNull OffsetTime openingHours)
	{
		this.openingHours = openingHours;
	}
	
	@NonNull
	public OffsetTime getClosingHours()
	{
		return closingHours;
	}
	
	public void setClosingHours(@NonNull OffsetTime closingHours)
	{
		this.closingHours = closingHours;
	}
	
	@Override
	public String toString()
	{
		return "Restaurant{" +
				"title='" + title + '\'' +
				", location=" + location +
				", type=" + type +
				", postCode='" + postCode + '\'' +
				", numSpaces=" + numSpaces +
				", openingHours=" + openingHours +
				", closingHours=" + closingHours +
				'}';
	}
}
