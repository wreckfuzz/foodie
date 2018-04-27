package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;
import java.util.UUID;

import static java.sql.Types.INTEGER;
import static mobile.uni.natashawhitter.foodie.utils.Utils.BASE_CREATED_AT_NAME;
import static mobile.uni.natashawhitter.foodie.utils.Utils.BASE_LAST_MODIFIED_NAME;
import static mobile.uni.natashawhitter.foodie.utils.Utils.BASE_ID_NAME;

public abstract class Base
{
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = BASE_ID_NAME, index = true, typeAffinity = INTEGER)
	private int id;
	@ColumnInfo(name = BASE_LAST_MODIFIED_NAME)
	@NonNull
	private Date lastModified;
	@ColumnInfo(name = BASE_CREATED_AT_NAME)
	@NonNull
	private Date createdAt;
	
	public Base(@NonNull int id, @NonNull Date lastModified, @NonNull Date createdAt)
	{
		this.id = id;
		this.lastModified = lastModified;
		this.createdAt = createdAt;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	@NonNull
	public Date getLastModified()
	{
		return lastModified;
	}
	
	public void setLastModified(@NonNull Date lastModified)
	{
		this.lastModified = lastModified;
	}
	
	public void setLastModified()
	{
		this.lastModified = new Date();
	}
	
	@NonNull
	public Date getCreatedAt()
	{
		return createdAt;
	}
	
	public void setCreatedAt(@NonNull Date createdAt)
	{
		this.createdAt = createdAt;
	}
	
	public void setCreatedAt()
	{
		this.createdAt = new Date();
	}
}
