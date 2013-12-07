package edu.wm.cs.rajarenderer;

import rajawali.RajawaliActivity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends RajawaliActivity {
	
	public MainRenderer mRenderer; 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		mRenderer = new MainRenderer(this);
        mRenderer.setSurfaceView(mSurfaceView);
        super.setRenderer(mRenderer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
