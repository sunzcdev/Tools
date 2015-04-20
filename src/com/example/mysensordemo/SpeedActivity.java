package com.example.mysensordemo;

import android.app.Activity;
import android.hardware.Sensor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.mysensordemo.util.MySensor;

public class SpeedActivity extends Activity {
	private static TextView speedTv;
	private MySensor mSensor;
	private static Handler myHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {

			speedTv.setText(""+msg.arg1);
			super.handleMessage(msg);
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.speed);
		
		speedTv = (TextView) findViewById(R.id.speed_tv);
		
//		mSensor = new MySensor(SpeedActivity.this, Sensor.Type);
		
	}

	@Override
	protected void onDestroy() {
		mSensor.unregisterListener();
		super.onDestroy();
	}
	
	public static Handler getMyHandler() {
		// TODO Auto-generated method stub
		return myHandler;
	}
	
}
