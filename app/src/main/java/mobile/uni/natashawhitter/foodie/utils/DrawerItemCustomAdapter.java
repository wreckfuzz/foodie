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

import mobile.uni.natashawhitter.foodie.R;

public class DrawerItemCustomAdapter extends ArrayAdapter<DataModel>
{
	
	private Context mContext;
	private int layoutResourceId;
	private DataModel data[];
	
	public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, DataModel[] data)
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
		
		TextView textViewName = listItem.findViewById(R.id.textViewName);
		
		DataModel folder = data[position];
		
		textViewName.setText(folder.name);
		
		return listItem;
	}
}