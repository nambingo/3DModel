package com.example.framgiaphamducnam.demoapp3d.view;

import android.content.Context;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.example.framgiaphamducnam.demoapp3d.MainActivity;
import com.example.framgiaphamducnam.demoapp3d.controller.TouchController;
import javax.microedition.khronos.opengles.GL10;

/**
 * This is the actual opengl view. From here we can detect touch gestures for example
 * 
 * @author andresoviedo
 *
 */
public class ModelSurfaceView extends GLSurfaceView {

	private MainActivity parent;
	private ModelRenderer mRenderer;
	//private TouchController touchHandler;

	//public ModelSurfaceView(MainActivity parent) {
	//	super(parent);
    //
	//	// parent component
	//
	//}

	//@Override
	//public boolean onTouchEvent(MotionEvent event) {
	//	return this.onTouchEvent(event);
	//}

	public MainActivity getModelActivity() {
		return parent;
	}

	public ModelRenderer getModelRenderer(){
		return mRenderer;
	}

	public ModelSurfaceView(Context context) {
		super(context);
		init(context);
	}

	public ModelSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		this.parent = (MainActivity) context;

		// Create an OpenGL ES 2.0 context.
		setEGLContextClientVersion(2);

		// This is the actual renderer of the 3D space
		mRenderer = new ModelRenderer(this);
		setRenderer(mRenderer);
		setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

		// Render the view only when there is a change in the drawing data
		// TODO: enable this again
		// setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

		//touchHandler = new TouchController(this, mRenderer);

		//do stuff that was in your original constructor...
	}

	//public void reset(){
	//	mRenderer.glLoadIdentity();                    //Reset The Projection Matrix
	//	parent.getgLView().glMatrixMode(GL10.GL_PROJECTION);    //Select The Projection Matrix
	//}


}