package com.litefoote.demo.SplashScreen;

import java.io.IOException;
import java.io.InputStream;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.modifier.AlphaModifier;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.bitmap.BitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.adt.io.in.IInputStreamOpener;
import org.andengine.util.debug.Debug;

import android.widget.Toast;

public class SplashScreenDemoActivity extends SimpleBaseGameActivity implements IUpdateHandler {
    // ===========================================================
    // Constants
    // ===========================================================

    private static final int CAMERA_WIDTH = 720;
    private static final int CAMERA_HEIGHT = 480;

	private ITexture mTexture;
	private ITextureRegion mFaceTextureRegion;
	
	private Sprite mLogo ;
	private float mCurrentAlpha = 0;
	
	public EngineOptions onCreateEngineOptions() {
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}
	   

	public void onCreateResources() {
		try {
			this.mTexture = new BitmapTexture(this.getTextureManager(), new IInputStreamOpener() {
				public InputStream open() throws IOException {
					return getAssets().open("gfx/AndEngine.png");
				}
			});

			this.mTexture.load();
			this.mFaceTextureRegion = TextureRegionFactory.extractFromTexture(this.mTexture);
		} catch (IOException e) {
			Debug.e(e);
		}
	}
	
	

	public Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		final Scene scene = new Scene();
		scene.setBackground(new Background(0, 0, 0));

		/* Create the face and add it to the scene. */
		mLogo = new Sprite((CAMERA_WIDTH - this.mFaceTextureRegion.getWidth())/2, (CAMERA_HEIGHT- this.mFaceTextureRegion.getHeight())/2, this.mFaceTextureRegion, this.getVertexBufferObjectManager());
		mLogo.setAlpha(0);
		scene.attachChild(mLogo);
		
		mLogo.registerEntityModifier(new AlphaModifier(1.0f, 0.0f, 1.0f));
		
		this.runOnUiThread(new Runnable() {
	        public void run() {
				Toast.makeText(SplashScreenDemoActivity.this, "This is a Test", 30).show();
	        }});
		
		
		scene.registerUpdateHandler(this);
		return scene;
	}

	public void onUpdate(float pSecondsElapsed) {
	}

	public void reset() {
	}
}
