package com.example.mysensordemo.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.example.mysensordemo.listener.MyListener;

public class MySensor {
	
	private SensorManager sensorManager;
	private Sensor sensor;
	private SensorEventListener listener;
	
	public MySensor(Context context, int sensorType){
		// ��ȡ������������
		sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		// ��ȡ������
		sensor = sensorManager.getDefaultSensor(sensorType);
	}
	
	public void sensorListener(){
		listener = new MyListener();
		sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI);
	}
	
	public void unregisterListener(){
		sensorManager.unregisterListener(listener);
		listener = null;
	}
}
