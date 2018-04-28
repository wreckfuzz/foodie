package mobile.uni.natashawhitter.foodie.db.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZonedDateTime;

import java.util.Date;

import mobile.uni.natashawhitter.foodie.utils.enums.Cuisine;

import static mobile.uni.natashawhitter.foodie.utils.Utils.*;

@Entity(inheritSuperIndices = true, tableName = USER_TABLE)
public final class User extends Base
{
	@ColumnInfo(name = USER_FIRST_NAME)
	@NonNull
	private String firstName;
	@ColumnInfo(name = USER_LAST_NAME)
	@NonNull
	private String lastName;
	@ColumnInfo(name = USER_EMAIL_ADDRESS)
	@NonNull
	private String email;
	@ColumnInfo(name = USER_PASSWORD)
	@NonNull
	private String password;
	@ColumnInfo(name = USER_SECRET_QUESTION)
	@NonNull
	private String secretQuestion;
	@ColumnInfo(name = USER_SECRET_ANSWER)
	@NonNull
	private String secretAnswer;
	@ColumnInfo(name = USER_BIRTH_DATE)
	@NonNull
	private ZonedDateTime birthDate;
	@ColumnInfo(name = USER_AREA_CODE)
	@NonNull
	private String areaCode;
	@ColumnInfo(name = USER_MOBILE_NUM)
	@NonNull
	private String mobileNum;
	@ColumnInfo(name = USER_FAV_CUISINE)
	private Cuisine favCuisine;
	
	public User(@NonNull long id, @NonNull Instant lastModified, @NonNull Instant createdAt, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, @NonNull String secretQuestion, @NonNull String secretAnswer, @NonNull ZonedDateTime birthDate, @NonNull String areaCode, @NonNull String mobileNum, @NonNull Cuisine favCuisine)
	{
		super(id, lastModified, createdAt);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.birthDate = birthDate;
		this.areaCode = areaCode;
		this.mobileNum = mobileNum;
		this.favCuisine = favCuisine;
	}
	
	@Ignore
	public User(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, @NonNull String secretQuestion, @NonNull String secretAnswer, @NonNull ZonedDateTime birthDate, @NonNull String areaCode, @NonNull String mobileNum, Cuisine favCuisine)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.birthDate = birthDate;
		this.areaCode = areaCode;
		this.mobileNum = mobileNum;
		this.favCuisine = favCuisine;
	}
	
	@NonNull
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(@NonNull String firstName)
	{
		this.firstName = firstName;
	}
	
	@NonNull
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(@NonNull String lastName)
	{
		this.lastName = lastName;
	}
	
	@NonNull
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(@NonNull String email)
	{
		this.email = email;
	}
	
	@NonNull
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(@NonNull String password)
	{
		this.password = password;
	}
	
	@NonNull
	public String getSecretQuestion()
	{
		return secretQuestion;
	}
	
	public void setSecretQuestion(@NonNull String secretQuestion)
	{
		this.secretQuestion = secretQuestion;
	}
	
	@NonNull
	public String getSecretAnswer()
	{
		return secretAnswer;
	}
	
	public void setSecretAnswer(@NonNull String secretAnswer)
	{
		this.secretAnswer = secretAnswer;
	}
	
	@NonNull
	public ZonedDateTime getBirthDate()
	{
		return birthDate;
	}
	
	public void setBirthDate(@NonNull ZonedDateTime ZonedDateTime)
	{
		this.birthDate = birthDate;
	}
	
	@NonNull
	public String getAreaCode()
	{
		return areaCode;
	}
	
	public void setAreaCode(@NonNull String areaCode)
	{
		this.areaCode = areaCode;
	}
	
	@NonNull
	public String getMobileNum()
	{
		return mobileNum;
	}
	
	public void setMobileNum(@NonNull String mobileNum)
	{
		this.mobileNum = mobileNum;
	}
	
	@NonNull
	public Cuisine getFavCuisine()
	{
		return favCuisine;
	}
	
	public void setFavCuisine(@NonNull Cuisine favCuisine)
	{
		this.favCuisine = favCuisine;
	}
}
