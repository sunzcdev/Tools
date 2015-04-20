package com.example.mysensordemo;

import android.app.Activity;
import android.hardware.Sensor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.mysensordemo.util.MySensor;

public class LightActivity extends Activity {
	private static TextView lightTv;
	private MySensor mSensor; 
	private static Handler myHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			lightTv.setText(msg.what + "");
			super.handleMessage(msg);
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.light);
		
		lightTv = (TextView) findViewById(R.id.light_tv);
		
		//构造一个Sensor，执行Sensor的注册监听事件的动作
		mSensor = new MySensor(LightActivity.this, Sensor.TYPE_LIGHT);
		mSensor.sensorListener();
//		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//		Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
//		listener = new MyListener();
//		sensorManager.registerListener(new MyListener(), sensor, SensorManager.SENSOR_DELAY_UI);
	}

	@Override
	protected void onDestroy() {
		// TODO 页面关闭后解除传感器的占用
		mSensor.unregisterListener();
		super.onDestroy();
	}

	public static Handler getMyHandler() {
		// TODO Auto-generated method stub
		return myHandler;
	}
	
}
