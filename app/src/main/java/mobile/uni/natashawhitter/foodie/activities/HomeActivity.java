package mobile.uni.natashawhitter.foodie.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mobile.uni.natashawhitter.foodie.R;
import mobile.uni.natashawhitter.foodie.db.FoodieDatabase;
import mobile.uni.natashawhitter.foodie.db.data.User;
import mobile.uni.natashawhitter.foodie.utils.DataModel;
import mobile.uni.natashawhitter.foodie.utils.DrawerItemAdapter;
import mobile.uni.natashawhitter.foodie.utils.SessionManager;
import mobile.uni.natashawhitter.foodie.utils.Utils;

public class HomeActivity extends AppCompatActivity
{
	private TextView mTextMessage;
	private HomeActivity.NavigationListener navigationListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		navigationListener = new NavigationListener();
		
		SessionManager sessionManager = new SessionManager(this);
		setContentView(R.layout.activity_home);
		User user = sessionManager.getUserDetails();
		mTextMessage = findViewById(R.id.message);
		ViewStub navigation;
		
		if (user != null)
		{
			boolean isAdmin = FoodieDatabase.getInstance(this).getUserRestaurantDao().checkUserIsAdmin(user.getId());
			
			if (isAdmin)
			{
				navigation = findViewById(R.id.navigation);
				navigation.setLayoutResource(R.layout.bottom_nav_admin);
			}
			else
			{
				navigation = findViewById(R.id.navigation);
				navigation.setLayoutResource(R.layout.bottom_nav_customer);
			}
		}
		else
		{
			navigation = findViewById(R.id.navigation);
			navigation.setLayoutResource(R.layout.bottom_nav_anonymous);
		}
		BottomNavigationView nav2 = (BottomNavigationView) navigation.inflate();
		nav2.setOnNavigationItemSelectedListener(navigationListener);
		navigationListener.setFragment(R.id.navigation_bookings);
	}
	
	private class NavigationListener implements BottomNavigationView.OnNavigationItemSelectedListener
	{
		
		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item)
		{
			return setFragment(item);
		}
		
		public boolean setFragment(MenuItem item)
		{
			Fragment fragment = getFragment(item.getItemId());
			
			if (fragment != null) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
				return true;
				
			} else {
				Log.e("MainActivity", "Error in creating fragment_restaurants");
			}
			return false;
		}
		
		public boolean setFragment(int item)
		{
			Fragment fragment = getFragment(item);
			
			if (fragment != null) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
				return true;
				
			} else {
				Log.e("MainActivity", "Error in creating fragment_restaurants");
			}
			return false;
		}
		
		private Fragment getFragment(int id)
		{
			switch (id)
			{
				case R.id.navigation_bookings:
					mTextMessage.setText(R.string.nav_bookings);
					return new RestaurantsFragment();
				case R.id.navigation_manage_restaurants:
					mTextMessage.setText(R.string.nav_manage_restaurants);
					return new RestaurantsFragment();
				case R.id.navigation_search:
					mTextMessage.setText(R.string.nav_search);
					return new RestaurantsFragment();
				case R.id.navigation_view_restaurants:
					mTextMessage.setText(R.string.nav_view_restaurants);
					return new RestaurantsFragment();
				case R.id.navigation_settings:
					mTextMessage.setText(R.string.nav_settings);
					return new RestaurantsFragment();
			}
			return null;
		}
	}

//	private static final int TYPE_HEADER = 0;
//	private static final int TYPE_ITEM = 1;
//	private static final int TYPE_SEPARATOR = 2;
//	private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;
//
//	private SessionManager session;
//	private List<DataModel> mNavigationDrawerItemTitles;
//	private DrawerLayout mDrawerLayout;
//	private ListView mDrawerList;
//	Toolbar toolbar;
//	private CharSequence mDrawerTitle;
//	private CharSequence mTitle;
//	android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_home);
//		session  = new SessionManager(HomeActivity.this);
//		mTitle = mDrawerTitle = getTitle();
//		mNavigationDrawerItemTitles = getNavItems();
//		mDrawerLayout = findViewById(R.id.drawer_layout);
//		mDrawerList = findViewById(R.id.left_drawer);
//
//		setupToolbar();
//
//
//		//drawerItem[0] = new DataModel("Connect");
//
//		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//		getSupportActionBar().setHomeButtonEnabled(true);
//
//		//DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem1);
//		DrawerItemAdapter adapter1 = new DrawerItemAdapter(this, mNavigationDrawerItemTitles);
//		mDrawerList.setAdapter(adapter1);
//		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
//		mDrawerLayout = findViewById(R.id.drawer_layout);
//		mDrawerLayout.addDrawerListener(mDrawerToggle);
//		setupDrawerToggle();
//		selectItem(1);
//	}
//
//	private List<DataModel> getNavItems()
//	{
//		User user = Utils.getCurrentUser(HomeActivity.this);
//		List<DataModel> menuList = new ArrayList<>();
//		// Check if the user is logged in
//		if (user != null && session.isLoggedIn())
//		{
//			menuList.add(new DataModel(user.getFirstName() + " " + user.getLastName(), user.getEmail(), TYPE_HEADER));
//			// Check if the user is admin of any restaurants, if so display admin options
//			if (FoodieDatabase.getInstance(HomeActivity.this).getUserRestaurantDao().checkUserIsAdmin(user.getId()))
//			{
//				menuList.add(new DataModel("Manage Restaurants", TYPE_ITEM));
//			}
//		}
//		else {
//			menuList.add(new DataModel("Sign Up", TYPE_ITEM));
//			menuList.add(new DataModel("Login", TYPE_ITEM));
//
//		}
//		menuList.add(new DataModel("Browse Restaurants", TYPE_ITEM));
//		menuList.add(new DataModel("Search", TYPE_ITEM));
//		if (user != null && session.isLoggedIn())
//		{
//			menuList.add(new DataModel("Bookings", TYPE_ITEM));
//		}
//		menuList.add(new DataModel("", TYPE_SEPARATOR));
//		menuList.add(new DataModel("Settings", TYPE_ITEM));
//		menuList.add(new DataModel("About Us", TYPE_ITEM));
//
//		return menuList;
//	}
//
//	private class DrawerItemClickListener implements ListView.OnItemClickListener {
//
//		@Override
//		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//			selectItem(position);
//		}
//
//	}
//
//	private void selectItem(int position) {
//
//		Fragment fragment = null;
//
//		switch (position) {
//			case 0:
//				Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
//				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//				startActivity(intent);
//				break;
//			case 1:
//				fragment = new RestaurantsFragment();
//				break;
//
//			default:
//				break;
//		}
//
//		if (fragment != null) {
//			FragmentManager fragmentManager = getSupportFragmentManager();
//			fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
//
//			mDrawerList.setItemChecked(position, true);
//			mDrawerList.setSelection(position);
//			setTitle(mNavigationDrawerItemTitles.get(position).getMenuItem());
//			mDrawerLayout.closeDrawer(mDrawerList);
//
//		} else {
//			Log.e("HomeActivity", "Error in creating fragment_restaurants");
//		}
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//
//		if (mDrawerToggle.onOptionsItemSelected(item)) {
//			return true;
//		}
//
//		return super.onOptionsItemSelected(item);
//	}
//
//	@Override
//	public void setTitle(CharSequence title) {
//		mTitle = title;
//		getSupportActionBar().setTitle(mTitle);
//	}
//
//	@Override
//	protected void onPostCreate(Bundle savedInstanceState) {
//		super.onPostCreate(savedInstanceState);
//		mDrawerToggle.syncState();
//	}
//
//	void setupToolbar()
//	{
//		toolbar = findViewById(R.id.toolbar);
//		setSupportActionBar(toolbar);
//		getSupportActionBar().setDisplayShowHomeEnabled(true);
//	}
//
//	void setupDrawerToggle(){
//		mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
//		//This is necessary to change the icon of the Drawer Toggle upon state change.
//		mDrawerToggle.syncState();
//	}
//
//	@Override
//	protected void onDestroy()
//	{
//		super.onDestroy();
//		mDrawerLayout.removeDrawerListener(mDrawerToggle);
//	}
}
