package me.xoder.neteasy.activity;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import me.xoder.neteasy.R;
import me.xoder.neteasy.fragment.discover.fm.CoverFragment;
import me.xoder.neteasy.utils.ToastUtils;

/**
 * Created by alex.lee on 2015-07-29.
 */
public class PersonalFMActivity extends FragmentActivity {
	private ActionBar actionBar;

	private Fragment fgTo;
	private Fragment fgCover;

	private FrameLayout frameContainer;

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

		if (fgCover == null) {
			fgCover = new CoverFragment();
		}
		if (!fgCover.isAdded()) {
			getSupportFragmentManager().beginTransaction().add(R.id.frame_fm_container, fgCover, CoverFragment.class.getSimpleName()).commit();
		}
		fgTo = fgCover;

		frameContainer = (FrameLayout) findViewById(R.id.frame_fm_container);
		frameContainer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ToastUtils.show(PersonalFMActivity.this, "切换界面");
			}
		});
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

	public void switchFragment(Fragment from, Fragment to, boolean animFlag) {
		if (from == null || to == null || from == to) {
			return;
		}

		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

		if (animFlag) {
			transaction.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out);
		} else {
			transaction.setCustomAnimations(R.anim.push_right_in, R.anim.push_right_out);
		}

		if (!to.isAdded()) {
			// 隐藏当前的fragment，add下一个到Activity中
			transaction.hide(from).add(R.id.frame_container, to).commit();
		} else {
			// 隐藏当前的fragment，显示下一个
			transaction.hide(from).show(to).commit();
		}

		fgTo = to;
	}
}
