package com.example.swipemenulistviewtest;

import java.util.ArrayList;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.baoyz.swipemenulistview.SwipeMenuListView.OnMenuItemClickListener;

import android.os.Bundle;
import android.R.array;
import android.R.string;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.Menu;
import android.view.animation.BounceInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	SwipeMenuListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (SwipeMenuListView) findViewById(R.id.listView);
		SwipeMenuCreator creator = new SwipeMenuCreator() {

		    @Override
		    public void create(SwipeMenu menu) {
		    // 创建一个Item
		    SwipeMenuItem openItem = new SwipeMenuItem(getApplicationContext());
		    // 设置背景
		    openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,0xCE)));
		    // 设置宽度
		    openItem.setWidth(dp2px(90));
		    // 设置显示的文字
		    openItem.setTitle("Open");
		    // 设置文字大小
		    openItem.setTitleSize(18);
		    // 设置文字颜色
		    openItem.setTitleColor(Color.WHITE);
		    // 添加到菜单里
		    menu.addMenuItem(openItem);

		    // 再创建一个Item
		    SwipeMenuItem deleteItem = new SwipeMenuItem(
		    getApplicationContext());
		    // 设置背景
		    deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
		    0x3F, 0x25)));
		    // 设置宽度
		    deleteItem.setWidth(dp2px(90));
		    // 设置一个图标
		    deleteItem.setIcon(R.drawable.ic_delete);
		    // 添加到菜单
		    menu.addMenuItem(deleteItem);
		    }

			private int dp2px(int dpVal) {
				// TODO Auto-generated method stub
				return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,  
		                dpVal, getResources().getDisplayMetrics()); 
			}
		};

		// 将菜单生成器设置给ListView即可
		listView.setMenuCreator(creator);

		
		listView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
	        @Override
	        public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
	                switch (index) {
	                case 0:
	                        // 第一项被点击
	                        break;
	                case 1:
	                        // 第二项被点击
	                        break;
	                }
					return false;
	        }
		});
	
		// Close Interpolator
		listView.setCloseInterpolator(new BounceInterpolator());
		// Open Interpolator
		listView.setOpenInterpolator(new BounceInterpolator());
		
		String[] strs = new String[]{"first", "second", "third", "fourth", "fifth"};
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strs));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
