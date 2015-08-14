package com.example.ken_phonegap_test;

import org.apache.cordova.DroidGap;

import android.os.Bundle;

public class MainActivity extends DroidGap  {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.loadUrl("file:///android_asset/www/UserHost.html"); 
	}
}
