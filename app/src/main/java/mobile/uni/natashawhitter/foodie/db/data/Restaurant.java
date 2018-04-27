package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

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
	private long openingHours;
	@ColumnInfo(name = RESTAURANT_CLOSING_HOURS)
	@NonNull
	private long closingHours;
	
	public Restaurant(@NonNull int id, @NonNull Date lastModified, @NonNull Date createdAt, @NonNull String title, @NonNull Location location, @NonNull Cuisine type, @NonNull String postCode, @NonNull int numSpaces, @NonNull long openingHours, @NonNull long closingHours)
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
	public long getOpeningHours()
	{
		return openingHours;
	}
	
	public void setOpeningHours(@NonNull long openingHours)
	{
		this.openingHours = openingHours;
	}
	
	@NonNull
	public long getClosingHours()
	{
		return closingHours;
	}
	
	public void setClosingHours(@NonNull long closingHours)
	{
		this.closingHours = closingHours;
	}
}
