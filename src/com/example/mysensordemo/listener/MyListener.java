package com.example.mysensordemo.listener;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.mysensordemo.CompassActivity;
import com.example.mysensordemo.LightActivity;

public class MyListener implements SensorEventListener, OnItemClickListener {
	
	private static Handler compHandler = CompassActivity.getMyHandler();
	private static Handler lighHandler = LightActivity.getMyHandler();
	
	
	
	
	

	private static Context mContext;
	private static int activityId;

	public MyListener() {

	}

	public MyListener(Context activityContext) {
		mContext = activityContext;
	}

	// 添加项目修改这里
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO 根据当前运行的页面，调用相应的传感器监听器的数据并传送到响应的页面UI进程。
		switch (activityId) {
		case 0:
			compHandler.sendMessage(compHandler.obtainMessage((int) event.values[0]));
			System.out.println("指南针：" + event.values[0]);
			break;
		case 1:
			lighHandler.sendMessage(lighHandler.obtainMessage((int) event.values[0]));
			break;
			
			
			
			
			

		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO 传感器精确度变化时

	}

	@Override
	public void onItemClick(AdapterView<?> parent, // The AdapterView where the
													// click happened
			View view, // The view within the AdapterView that was clicked
			int position,// The position of the view in the adapter
			long id// The row id of the item that was clicked
	) {
		// TODO 在九宫格页面中点击条目，并跳到相应的页面
		// 添加项目修改这里
		switch (position) {
		case 0:
			activityId = position;
			mContext.startActivity(new Intent(mContext, CompassActivity.class));
			break;
		case 1:
			activityId = position;
			mContext.startActivity(new Intent(mContext, LightActivity.class));
			break;
			
			
			
			
			

		}
	}

}
