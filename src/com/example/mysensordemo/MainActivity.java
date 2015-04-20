package com.example.mysensordemo;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.mysensordemo.listener.MyListener;

public class MainActivity extends Activity {
	private GridView mainGv;
	private ArrayList<HashMap<String, Object>> listImageItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mainGv = (GridView) findViewById(R.id.gridview_main);
		
		listImageItem = new ArrayList<HashMap<String, Object>>();
		
		//���ָ������Ŀ
		addItemToMap(R.drawable.compass_icon, "ָ����");
		//��ӹ������Ŀ
		addItemToMap(R.drawable.light_icon, "�����");
		//�����Ŀ�޸�����
		
		
		
		
		
		
		
		
		
		// ������������ImageItem <====> ��̬�����Ԫ�أ�����һһ��Ӧ
		SimpleAdapter viewItemsAdapter = new SimpleAdapter(this, listImageItem, R.layout.item,
				// ��̬������ImageItem��Ӧ������
				new String[] { "ItemImage", "ItemText" },
				// ImageItem��XML�ļ������һ��ImageView,����TextView ID
				new int[] {R.id.ItemImage, R.id.ItemText});
		
		// ��Ӳ�����ʾ
		mainGv.setAdapter(viewItemsAdapter);
		// �����Ϣ����
		mainGv.setOnItemClickListener(new MyListener(MainActivity.this));
	}
	
	private void addItemToMap(int itemImageResId, String itemText) {
		//TODO ���ɶ�̬���飬����ת������
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ItemImage", itemImageResId);// �������ͼ����Դ��ID
		map.put("ItemText", itemText);// �����������
		listImageItem.add(map);
	}

}
