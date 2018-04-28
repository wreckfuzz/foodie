package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import org.threeten.bp.Instant;

import static mobile.uni.natashawhitter.foodie.utils.Utils.BASE_CREATED_AT_NAME;
import static mobile.uni.natashawhitter.foodie.utils.Utils.BASE_LAST_MODIFIED_NAME;
import static mobile.uni.natashawhitter.foodie.utils.Utils.BASE_ID_NAME;

public abstract class Base
{
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = BASE_ID_NAME, index = true)
	private long id;
	@ColumnInfo(name = BASE_LAST_MODIFIED_NAME)
	@NonNull
	private Instant lastModified;
	@ColumnInfo(name = BASE_CREATED_AT_NAME)
	@NonNull
	private Instant createdAt;
	
	public Base(@NonNull long id, @NonNull Instant lastModified, @NonNull Instant createdAt)
	{
		this.id = id;
		this.lastModified = lastModified;
		this.createdAt = createdAt;
	}
	
	public Base()
	{
		this.setLastModified();
		this.setCreatedAt();
	}
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	@NonNull
	public Instant getLastModified()
	{
		return lastModified;
	}
	
	public void setLastModified(@NonNull Instant lastModified)
	{
		this.lastModified = lastModified;
	}
	
	public void setLastModified()
	{
		this.lastModified = Instant.now();
	}
	
	@NonNull
	public Instant getCreatedAt()
	{
		return createdAt;
	}
	
	public void setCreatedAt(@NonNull Instant createdAt)
	{
		this.createdAt = createdAt;
	}
	
	public void setCreatedAt()
	{
		this.createdAt = Instant.now();
	}
}
