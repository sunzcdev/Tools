package com.example.mysensordemo;

import android.app.Activity;
import android.hardware.Sensor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysensordemo.util.MySensor;

public class CompassActivity extends Activity {
	private static TextView compassDegTv, compassOriTv;
	private static ImageView compassIv;
	private MySensor mSensor;
	static float lastDegress = 0f;

	// �������������������
	private static Handler myHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			compassDegTv.setText("ƫ���Ƕȣ�" + msg.what + "��");
			showOri(msg.what);
			compassIv.startAnimation(showAnimation(msg.what));
			super.handleMessage(msg);
		}
		
	};

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.compass);
		compassDegTv = (TextView) findViewById(R.id.tv_degress_compass);
		compassOriTv = (TextView) findViewById(R.id.tv_ori_compass);
		compassIv = (ImageView) findViewById(R.id.iv_compass);

		//����һ��Sensor��ִ��Sensor��ע������¼��Ķ���
		mSensor = new MySensor(CompassActivity.this, Sensor.TYPE_ORIENTATION);
		mSensor.sensorListener();
		
	}
	
	private static void showOri(int angle) {
		if (angle >= 0 & angle < 45 || angle >= 315) {
			compassOriTv.setText("����");
			// msg.arg2 = 0;
			// msg.sendToTarget();
		} else if (angle >= 45 & angle < 135) {
			compassOriTv.setText("����");
			// msg.arg2 = 1;
			// msg.sendToTarget();
		} else if (angle >= 135 & angle < 225) {
			compassOriTv.setText("�Ϸ�");
			// msg.arg2 = 2;
			// msg.sendToTarget();
		} else if (angle >= 225 & angle < 315) {
			compassOriTv.setText("����");
			// msg.arg2 = 3;
			// msg.sendToTarget();
		}
	}
	
	private static RotateAnimation showAnimation(float value) {
		// TODO ���ݴ������ķ���ֵ��ImageView�е�ͼƬ���ж�����ת��
		
		float sensorDegresss = -value;
		RotateAnimation mRotateAnima = new RotateAnimation(lastDegress, sensorDegresss, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		mRotateAnima.setDuration(100);
		lastDegress = -value;
		return mRotateAnima;
	}

	@Override
	protected void onDestroy() {
		mSensor.unregisterListener();
		super.onDestroy();
	}

	public static Handler getMyHandler() {
		return myHandler;
	}

	public static void setMyHandler(Handler myHandler) {
		CompassActivity.myHandler = myHandler;
	}
}
