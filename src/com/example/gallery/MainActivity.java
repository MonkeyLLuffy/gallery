package com.example.gallery;

import com.example.gallery.R.id;

import android.widget.AdapterView.OnItemSelectedListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener,ViewFactory{

	private int[] res = { R.drawable.item1, R.drawable.item2, R.drawable.item3,
			R.drawable.item4, R.drawable.item5, R.drawable.item6,
			R.drawable.item7, R.drawable.item8, R.drawable.item9,
			R.drawable.item10, R.drawable.item11, R.drawable.item12 };
	
	private ImageAdapter adapter;
	private Gallery gallery;
	private ImageSwitcher is;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gallery = (Gallery) findViewById(R.id.gallery);
		is = (ImageSwitcher) findViewById(R.id.is);
		
		adapter = new ImageAdapter(res, this);
		gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(this);
		
		is.setFactory(this);
        is.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
	    is.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
		
		
		
	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		is.setBackgroundResource(res[arg2%res.length]);
		Toast.makeText(this,"бЁжа" , Toast.LENGTH_SHORT).show();
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		ImageView image=new ImageView(this);
		image.setScaleType(ScaleType.FIT_CENTER);
		
		return image;
	}

}
