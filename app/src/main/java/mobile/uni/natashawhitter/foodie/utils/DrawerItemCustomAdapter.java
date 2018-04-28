package mobile.uni.natashawhitter.foodie.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mobile.uni.natashawhitter.foodie.R;
import mobile.uni.natashawhitter.foodie.activities.HomeActivity;
import mobile.uni.natashawhitter.foodie.db.FoodieDatabase;
import mobile.uni.natashawhitter.foodie.db.data.User;

public class DrawerItemCustomAdapter extends ArrayAdapter<DataModel>
{
	
	private Context mContext;
	private int layoutResourceId;
	private List<DataModel> data;
	
	public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, List<DataModel> data)
	{
		
		super(mContext, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.mContext = mContext;
		this.data = data;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View listItem;
		LayoutInflater inflater = ((AppCompatActivity) mContext).getLayoutInflater();
		listItem = inflater.inflate(layoutResourceId, parent, false);
		
		// If first element, then add account information
		if (position == 0)
		{
			User user = Utils.getCurrentUser(mContext);
			// Check if the user is logged in
			if (user != null && new SessionManager(mContext).isLoggedIn())
			{
			
			}
		}
		
		TextView textViewName = listItem.findViewById(R.id.textViewName);
		
		DataModel folder = data.get(position);
		
		textViewName.setText(folder.name);
		
		return listItem;
	}
}