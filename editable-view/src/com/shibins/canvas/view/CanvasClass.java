package com.shibins.canvas.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import com.shibins.canvas.R;
/**
 * 
 * @author Shibin Francis
 *
 */

public class CanvasClass extends View {
	//private RectF squareBounds = new RectF();
	//private static Paint bluePaint = new Paint();
	private Paint whitePaint = new Paint();
	private Paint editCursor = new Paint();
	private RectF cursorBounds = new RectF();
	private String text;
	private Handler uiHandler = new Handler();
	private int count = 0;
	public CanvasClass(Context context, AttributeSet attrs) {

		super(context, attrs);
		TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.CanvasClass);
		CharSequence canvas_text = arr.getString(R.styleable.CanvasClass_text);
		System.out.println("___attrs"+canvas_text);
		if (canvas_text != null) {
			this.text = canvas_text.toString();
		}
		arr.recycle();
	}
	@Override
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		/*canvas.drawRect(squareBounds, bluePaint);*/

		System.out.println("___attrs2::"+text);
		//canvas.drawText(text, getResources().getDimension(R.dimen.canvas_left_padding), getResources().getDimension(R.dimen.canvas_ht)/2+(getResources().getDimension(R.dimen.canvas_size)/4), whitePaint);
		canvas.drawRect(cursorBounds, editCursor);
		uiHandler.postDelayed(testRunnable, 550);

	}
	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		setupBounds();
		//invalidate();

	}
	/**
	 * To set up initial view attributes 
	 */
	private void setupBounds() {
		/*squareBounds = new RectF(0, 0, getResources().getDimension(R.dimen.canvas_width), getResources().getDimension(R.dimen.canvas_ht));
		bluePaint.setColor(getResources().getColor(R.color.blue));
		bluePaint.setAntiAlias(true);
		bluePaint.setStyle(Style.FILL);  
		bluePaint.setTextAlign(Align.CENTER);*/
		cursorBounds = new RectF(15,(getResources().getDimension(R.dimen.canvas_ht)/2)-(getResources().getDimension(R.dimen.canvas_size)), 17, (getResources().getDimension(R.dimen.canvas_cursor_ht)));
		editCursor.setColor(getResources().getColor(R.color.white));
		editCursor.setStyle(Style.FILL);
		editCursor.setAntiAlias(true);

		whitePaint.setColor(getResources().getColor(R.color.white));
		whitePaint.setStyle(Style.FILL);
		whitePaint.setAntiAlias(true);
		whitePaint.setTextSize((int)getResources().getDimension(R.dimen.canvas_size));
		whitePaint.setTypeface(Typeface.DEFAULT);
		whitePaint.setTextAlign(Align.LEFT);

	}
	/*public void updateAttr(int color){
		bluePaint.setColor(color);
		invalidate();

	}*/
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	private Runnable testRunnable = new Runnable() {

		@Override
		public void run() {
			count++;
			if(count%2 == 0)
				editCursor.setColor(getResources().getColor(R.color.white));
			else
				editCursor.setColor(getResources().getColor(R.color.red));
			invalidate();
			//uiHandler.postDelayed(testRunnable, 1000);
		}
	};

}
