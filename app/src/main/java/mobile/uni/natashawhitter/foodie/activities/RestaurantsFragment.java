package mobile.uni.natashawhitter.foodie.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobile.uni.natashawhitter.foodie.R;

public class RestaurantsFragment extends Fragment
{
	
	public RestaurantsFragment()
	{
	}
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_restaurants, container, false);
		return rootView;
	}
}
