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
		
		//添加指南针项目
		addItemToMap(R.drawable.compass_icon, "指南针");
		//添加光感器项目
		addItemToMap(R.drawable.light_icon, "光感器");
		//添加项目修改这里
		
		
		
		
		
		
		
		
		
		// 生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
		SimpleAdapter viewItemsAdapter = new SimpleAdapter(this, listImageItem, R.layout.item,
				// 动态数组与ImageItem对应的子项
				new String[] { "ItemImage", "ItemText" },
				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] {R.id.ItemImage, R.id.ItemText});
		
		// 添加并且显示
		mainGv.setAdapter(viewItemsAdapter);
		// 添加消息处理
		mainGv.setOnItemClickListener(new MyListener(MainActivity.this));
	}
	
	private void addItemToMap(int itemImageResId, String itemText) {
		//TODO 生成动态数组，并且转入数据
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ItemImage", itemImageResId);// 添加网格图像资源的ID
		map.put("ItemText", itemText);// 添加网格文字
		listImageItem.add(map);
	}

}
