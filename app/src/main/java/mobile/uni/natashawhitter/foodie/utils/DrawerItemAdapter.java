package mobile.uni.natashawhitter.foodie.utils;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import mobile.uni.natashawhitter.foodie.R;
import mobile.uni.natashawhitter.foodie.db.data.User;

public class DrawerItemAdapter extends BaseAdapter
{
	private static final int TYPE_HEADER = 0;
	private static final int TYPE_ITEM = 1;
	private static final int TYPE_SEPARATOR = 2;
	private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;
	
	private List<DataModel> mData;
	private SessionManager session;
	private LayoutInflater mInflater;
	private TreeSet mSeparatorsSet = new TreeSet();
	
	public DrawerItemAdapter(final Context context, final List<DataModel> data)
	{
		mData = data;
		session = new SessionManager(context);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount()
	{
		return mData.size();
	}
	
	@Override
	public int getViewTypeCount() {
		return TYPE_MAX_COUNT;
	}
	
	@Override
	public Object getItem(int position)
	{
		return mData.get(position);
	}
	
	@Override
	public int getItemViewType(int position) {
		return mData.get(position).getType();
	}
	
	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder = null;
		int type = getItemViewType(position);
		
		if (convertView == null)
		{
			holder = new ViewHolder();
			switch (type)
			{
				case TYPE_HEADER:
					User user = session.getUserDetails();
					
					convertView = mInflater.inflate(R.layout.list_view_item_header_row, null);
					holder.textView = convertView.findViewById(R.id.nav_header_email);
					holder.textViewA = convertView.findViewById(R.id.nav_header_name);
					holder.textView.setText(mData.get(position).getMenuItem());
					holder.textViewA.setText(mData.get(position).getEmail());
					break;
				case TYPE_ITEM:
					convertView = mInflater.inflate(R.layout.list_view_item_row, null);
					holder.textView = convertView.findViewById(R.id.textViewName);
					holder.textView.setText(((DataModel) mData.get(position)).getMenuItem());
					break;
				case TYPE_SEPARATOR:
					convertView = mInflater.inflate(R.layout.list_view_item_seperator, null);
					holder.textView = convertView.findViewById(R.id.textSeparator);
					holder.textView.setText("");
					break;
			}
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}
	
	public static class ViewHolder {
		public TextView textView;
		public TextView textViewA;
	}
}