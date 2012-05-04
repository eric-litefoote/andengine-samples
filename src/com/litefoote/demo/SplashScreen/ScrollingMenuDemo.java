package com.litefoote.demo.SplashScreen;

import org.andengine.engine.options.ScreenOrientation;

import com.litefoote.lib.ScrollingMenu.BaseScrollingMenuActivity;
import com.litefoote.lib.ScrollingMenu.IOnButtonTouchListener;
import com.litefoote.lib.ScrollingMenu.ScrollingMenuButton;

public class ScrollingMenuDemo 
    extends BaseScrollingMenuActivity 
    implements IOnButtonTouchListener {

	@Override
	public void onSetupEngineOptions() {   
		this.CAMERA_HEIGHT = 720;
		this.CAMERA_WIDTH = 480;
	    this.START_X = this.CAMERA_WIDTH / 2;
	    this.START_Y = this.PADDING * 2;
		this.screenOrientation =  ScreenOrientation.PORTRAIT_FIXED;
	}

	@Override
	public void onConfigureButtons() {
		this.addButton(new ScrollingMenuButton("Start", "gfx/Start.png", this));
		this.addButton(new ScrollingMenuButton("Options", "gfx/Options.png", this));
		this.addButton(new ScrollingMenuButton("Exit", "gfx/Exit.png", this));	
	}

	@Override
	public void onSceneCreated() {
	}

	@Override
	public void onButtonTouched(ScrollingMenuButton  btnTouched) {
		if (btnTouched.key == "Exit") {
			finish();
		}
		
	}



}
