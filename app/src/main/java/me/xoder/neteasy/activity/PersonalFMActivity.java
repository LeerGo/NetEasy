package me.xoder.neteasy.activity;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import me.xoder.neteasy.R;

/**
 * Created by alex.lee on 2015-07-29.
 */
public class PersonalFMActivity extends Activity {
	private ActionBar actionBar;

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_fm);

		actionBar = getActionBar();
		actionBar.setTitle("私人FM");
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setDisplayUseLogoEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setLogo(R.drawable.actionbar_logo);
		actionBar.setHomeAsUpIndicator(R.drawable.rdi_icn_arr);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_personal_fm, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		switch (id) {
			case android.R.id.home:
				finish();
				break;
		}

		return true;
	}
}
