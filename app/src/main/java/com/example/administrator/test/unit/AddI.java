package com.example.administrator.test.unit;

import android.content.Context;

import com.example.administrator.test.R;

/**
 * @author Alex
 * @date 2019/3/28 上午11:38
 * @email 18238818283@sina.cn
 * @desc ...
 */
public class AddI implements Add {
	@Override
	public int mether(int a, int b) {
		return 0;
	}

	public void syncAnswer(final Callback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				callback.success("Success");
			}
		});
	}

	public String getString(Context context) {
		System.out.println("=====");
		return context.getString(R.string.app_name);
	}

}
