package me.xoder.neteasy.activity;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Method;

import me.xoder.neteasy.R;
import me.xoder.neteasy.adapter.TabContentPagerAdapter;

public class MainActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private DrawerLayout slideMenu;
	private ActionBar actionBar;

	private TabContentPagerAdapter mPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		actionBar = getActionBar();
		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		slideMenu = (DrawerLayout) findViewById(R.id.slide_menu);

		slideMenu.setScrimColor(Color.argb(50, 0, 0, 0));

		mPagerAdapter = new TabContentPagerAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}
		});
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {
			@Override
			public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
				mViewPager.setCurrentItem(tab.getPosition());
			}
			
			@Override
			public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
				
			}
			
			@Override
			public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
				
			}
		};
		
		TypedArray tabIconIds = getResources().obtainTypedArray(R.array.actionbar_icons);
		for (int i = 0; i < 3; i++) {
			View view = getLayoutInflater().inflate(R.layout.actionbar_tab, null);
			ImageView tabIcon = (ImageView) view.findViewById(R.id.actionbar_tab_icon);
			tabIcon.setImageResource(tabIconIds.getResourceId(i, -1));
			
			actionBar.addTab(actionBar.newTab().setCustomView(view).setTabListener(tabListener));
		}
		
		enableEmbeddedTabs(actionBar);
	}
	
	/**
	 * 在actionbar中内嵌Tab
	 *
	 * @param actionBar actionbar
	 */
	private void enableEmbeddedTabs(android.app.ActionBar actionBar) {
		try {
			Method setHasEmbeddedTabsMethod = actionBar.getClass().getDeclaredMethod("setHasEmbeddedTabs", boolean.class);
			setHasEmbeddedTabsMethod.setAccessible(true);
			setHasEmbeddedTabsMethod.invoke(actionBar, true);
		} catch (Exception e) {
			Log.v("enableEmbeddedTabs", e.getMessage().toString());
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		
		if (id == R.id.action_search) {
			// TODO: 2015-07-25 搜索界面 		
		} else if (id == R.id.action_menu) {
			// TODO: 2015-07-25 菜单选择
			if (slideMenu.isDrawerOpen(Gravity.RIGHT)) {
				slideMenu.closeDrawer(Gravity.RIGHT);
			} else {
				slideMenu.openDrawer(Gravity.RIGHT);
			}
		}
		
		return true;
	}
}
