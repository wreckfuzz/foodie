package mobile.uni.natashawhitter.foodie.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mobile.uni.natashawhitter.foodie.R;
import mobile.uni.natashawhitter.foodie.db.FoodieDatabase;
import mobile.uni.natashawhitter.foodie.db.data.Restaurant;
import mobile.uni.natashawhitter.foodie.db.data.User;
import mobile.uni.natashawhitter.foodie.utils.DataModel;
import mobile.uni.natashawhitter.foodie.utils.DrawerItemAdapter;
import mobile.uni.natashawhitter.foodie.utils.DrawerItemCustomAdapter;
import mobile.uni.natashawhitter.foodie.utils.SessionManager;
import mobile.uni.natashawhitter.foodie.utils.Utils;

public class HomeActivity extends AppCompatActivity
{
	private SessionManager session;
	private List<String> mNavigationDrawerItemTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	Toolbar toolbar;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		session  = new SessionManager(HomeActivity.this);
		mTitle = mDrawerTitle = getTitle();
		mNavigationDrawerItemTitles = getNavItems();
		mDrawerLayout = findViewById(R.id.drawer_layout);
		mDrawerList = findViewById(R.id.left_drawer);
		
		setupToolbar();
		
		ArrayList<DataModel> drawerItem1 = new ArrayList<>();
		
		for (String item : mNavigationDrawerItemTitles)
		{
			drawerItem1.add(new DataModel(item));
		}
		
		
		//drawerItem[0] = new DataModel("Connect");
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		getSupportActionBar().setHomeButtonEnabled(true);
		
		//DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem1);
		DrawerItemAdapter adapter1 = new DrawerItemAdapter(this, drawerItem1);
		mDrawerList.setAdapter(adapter1);
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		mDrawerLayout = findViewById(R.id.drawer_layout);
		mDrawerLayout.addDrawerListener(mDrawerToggle);
		setupDrawerToggle();
		selectItem(1);
	}
	
	private List<String> getNavItems()
	{
		User user = Utils.getCurrentUser(HomeActivity.this);
		List<String> menuList = new ArrayList<>();
		menuList.add("");
		// Check if the user is logged in
		if (user != null && session.isLoggedIn())
		{
			// Check if the user is admin of any restaurants, if so display admin options
			if (FoodieDatabase.getInstance(HomeActivity.this).getUserRestaurantDao().checkUserIsAdmin(user.getId()))
			{
				menuList.add("Manage Restaurants".toUpperCase());
			}
		}
		menuList.add("Browse Restaurants");
		menuList.add("Search");
		if (user != null && session.isLoggedIn())
		{
			menuList.add("Bookings".toUpperCase());
		}
		menuList.add("");
		menuList.add("Settings");
		menuList.add("Send Feedback");
		menuList.add("Rate Us");
		menuList.add("About Us");
		
		return menuList;
	}
	
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			selectItem(position);
		}
		
	}
	
	private void selectItem(int position) {
		
		Fragment fragment = null;
		
		switch (position) {
			case 0:
				fragment = new RestaurantsFragment();
				break;
			
			default:
				break;
		}
		
		if (fragment != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
			
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(mNavigationDrawerItemTitles.get(position));
			mDrawerLayout.closeDrawer(mDrawerList);
			
		} else {
			Log.e("MainActivity", "Error in creating fragment_restaurants");
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	void setupToolbar()
	{
		toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
	}
	
	void setupDrawerToggle(){
		mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
		//This is necessary to change the icon of the Drawer Toggle upon state change.
		mDrawerToggle.syncState();
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		mDrawerLayout.removeDrawerListener(mDrawerToggle);
	}
}
