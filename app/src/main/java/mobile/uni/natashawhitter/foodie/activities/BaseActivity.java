package mobile.uni.natashawhitter.foodie.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity
{
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState)
	{
		super.onCreate(savedInstanceState, persistentState);
	}
	
//	public boolean isGooglePlayServicesAvailable(Context context)
//	{
//		GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
//		int resultCode = apiAvailability.isGooglePlayServicesAvailable(context);
//		return resultCode == ConnectionResult.SUCCESS;
//	}
}
