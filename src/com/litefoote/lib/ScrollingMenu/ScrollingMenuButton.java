package com.litefoote.lib.ScrollingMenu;

import org.andengine.opengl.texture.region.ITextureRegion;

public class ScrollingMenuButton {
	
	public String srcImage;
	public String key;
	ITextureRegion mMenuTextureRegion;
	IOnButtonTouchListener iOnButtonListener;
	
	public ScrollingMenuButton (String source) {
		srcImage= source;
	}
	
	public ScrollingMenuButton (String key, String source, IOnButtonTouchListener listener) {
		srcImage= source;
		iOnButtonListener = listener;
		this.key = key;
	}
	
}
