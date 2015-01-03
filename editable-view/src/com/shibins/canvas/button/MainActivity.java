package com.shibins.canvas.button;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.shibins.canvas.R;
/**
 * 
 * @author Shibin Francis
 *
 */
public class MainActivity extends ActionBarActivity {
	private com.shibins.canvas.view.CanvasClass canvasClass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		canvasClass = (com.shibins.canvas.view.CanvasClass)findViewById(R.canvas_test.canvas_view);		
	}

	
}
