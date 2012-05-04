package com.litefoote.demo.SplashScreen;

import org.andengine.entity.scene.background.Background;

import android.content.Intent;

import com.litefoote.lib.SplashScreen.BaseSplashScreenActivity;

public class SplashScreenDemoActivity extends BaseSplashScreenActivity {

	public void onSetupEngineOptions() {
			this.addSplash("gfx/AndEngine.png");
			this.addSplash("gfx/YMAGAMES.png");
			this.addSplash("gfx/litefoote.png");
			
			this.allowSkip = true;
	}

	public void onLoadSplashScreens() {
		this.mBackground = new Background(0,0,0);
	}

	public void onFinished() {
		Intent menu = new Intent(SplashScreenDemoActivity.this, ScrollingMenuDemo.class);
		startActivity(menu);
		finish();
	} 
	
}
