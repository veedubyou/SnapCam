package com.example.snapcam;

import com.example.snapcam.R;

import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
	private Camera mCamera;
    private CameraPreview mPreview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try{
			// Create an instance of Camera
			mCamera = Camera.open(); // attempt to get a Camera instance
	    }
	    catch (Exception e){
	        // TODO: return error message
	    };

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void switchPortrait()
	{
	
	}
	
	public void switchLandscape()
	{
		
	}
	
	public void startListening()
	{
		
	}
	
	public void snapPicture()
	{
		//
	}
	
	public void snapTimer(int seconds)
	{
		
	}
	
	public void toggleFlash(boolean on)
	{
		
	}
	
	public void toggleCamera(boolean front)
	{
		
	}
}
