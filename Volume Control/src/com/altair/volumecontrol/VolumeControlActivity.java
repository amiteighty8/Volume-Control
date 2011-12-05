package com.altair.volumecontrol;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class VolumeControlActivity extends Activity {
	
	SeekBar seekBarVolume; 
	TextView textViewVolume;
	
	Button button0;
	Button button25;
	Button button50;
	Button button75;
	Button button100;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        WindowManager mWinMgr = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        int displayWidth = mWinMgr.getDefaultDisplay().getWidth();

         Log.d("device WIDTH", displayWidth + "");
        
        textViewVolume =(TextView)findViewById(R.id.textViewVolume);
        final AudioManager AM = (AudioManager) getSystemService(AUDIO_SERVICE); 
        
        seekBarVolume = (SeekBar)findViewById(R.id.seekBarVolume);
        int currentVolume =AM.getStreamVolume(AudioManager.STREAM_MUSIC);
        
        float percentVolume = currentVolume*100;
        percentVolume =percentVolume/15;
        
        textViewVolume.setText(((int)percentVolume)+"%");
        
        seekBarVolume.setProgress(((int)percentVolume));
        
        
        
        //////////////////Set Volume On Seek Bar Change ////////////////////////////////// 
        
        seekBarVolume.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				finish();
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				float vol = ((progress*15));
				Log.d("Volume",vol+"'1");
				vol=vol/100;
				Log.d("Volume",vol+"'2");
				textViewVolume.setText(progress+"%");
				setVolumeControlStream(AudioManager.STREAM_MUSIC);
				
				AM.setStreamVolume(AudioManager.STREAM_MUSIC, (int) vol, 0);
				
			}
		});
        
        
        //////////////////Set Volume On Button Click ////////////////////////////////// 
        
      button0 =(Button)findViewById(R.id.button0);
      button25 =(Button)findViewById(R.id.button25);
      button50 =(Button)findViewById(R.id.button50);
      button75 =(Button)findViewById(R.id.button75);
      button100 =(Button)findViewById(R.id.button100);
      
      
      
      
      View.OnClickListener setVolumeListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if( button0.getId() == ((Button)v).getId() ){
				AM.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
 
			        textViewVolume.setText(0+"%");
			        
			        seekBarVolume.setProgress(0);
				
		      }
		      else if( button25.getId() == ((Button)v).getId() ){
		    	  AM.setStreamVolume(AudioManager.STREAM_MUSIC, 4, 0);
		    	  
			        textViewVolume.setText(25+"%");
			        
			        seekBarVolume.setProgress(25);
		      }
		      else if( button50.getId() == ((Button)v).getId() ){
		    	  AM.setStreamVolume(AudioManager.STREAM_MUSIC, 8, 0);
		    	  
			        textViewVolume.setText(50+"%");
			        
			        seekBarVolume.setProgress(50);
		      }
		      else if( button75.getId() == ((Button)v).getId() ){
		    	  AM.setStreamVolume(AudioManager.STREAM_MUSIC, 12, 0);
		    	  
			        textViewVolume.setText(75+"%");
			        
			        seekBarVolume.setProgress(75);
		      }
		      else if( button100.getId() == ((Button)v).getId() ){
		    	  AM.setStreamVolume(AudioManager.STREAM_MUSIC, 15, 0);
		    	  
			        textViewVolume.setText(100+"%");
			        
			        seekBarVolume.setProgress(100);
		      }
			finish();
			
		}
	};
	
	button0.setOnClickListener(setVolumeListener);
	button25.setOnClickListener(setVolumeListener);
	button50.setOnClickListener(setVolumeListener);
	button75.setOnClickListener(setVolumeListener);
	button100.setOnClickListener(setVolumeListener);
	
	
    }
}