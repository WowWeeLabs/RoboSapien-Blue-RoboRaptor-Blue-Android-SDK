package com.wowwee.roboremotebluesampleproject.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.Layout.Alignment;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

public class DimmableButtonCircle extends Button {
	private final int ALPHA_FOR_NORMAL = 255;
	private final int ALPHA_FOR_DISABLE = 128;
	
	int PaddingLeft;
	int PaddingTop;
	int PaddingRight;
	int PaddingBottom;
	
	public int dpToPx(int dp) {
	    DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
	    int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));       
	    return px;
	}
	
	public DimmableButtonCircle(Context context) {
		
		super(context);
		PaddingLeft = (this.getPaddingLeft() <= 0) ? dpToPx(3) : this.getPaddingLeft();
		PaddingTop = (this.getPaddingTop() <= 0) ? dpToPx(3) : this.getPaddingTop();
		PaddingRight = (this.getPaddingRight() <= 0) ? dpToPx(3) : this.getPaddingRight();
		PaddingBottom = (this.getPaddingBottom() <= 0) ? dpToPx(3) : this.getPaddingBottom();
		this.setPadding(PaddingLeft, PaddingTop, PaddingRight, PaddingBottom);
		init(null);
	}

	public DimmableButtonCircle(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
		PaddingLeft = (this.getPaddingLeft() <= 0) ? dpToPx(3) : this.getPaddingLeft();
		PaddingTop = (this.getPaddingTop() <= 0) ? dpToPx(3) : this.getPaddingTop();
		PaddingRight = (this.getPaddingRight() <= 0) ? dpToPx(3) : this.getPaddingRight();
		PaddingBottom = (this.getPaddingBottom() <= 0) ? dpToPx(3) : this.getPaddingBottom();
		this.setPadding(PaddingLeft, PaddingTop, PaddingRight, PaddingBottom);
        mTextSize = getTextSize();
	}

	public DimmableButtonCircle(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
		PaddingLeft = (this.getPaddingLeft() <= 0) ? dpToPx(3) : this.getPaddingLeft();
		PaddingTop = (this.getPaddingTop() <= 0) ? dpToPx(3) : this.getPaddingTop();
		PaddingRight = (this.getPaddingRight() <= 0) ? dpToPx(3) : this.getPaddingRight();
		PaddingBottom = (this.getPaddingBottom() <= 0) ? dpToPx(3) : this.getPaddingBottom();
		this.setPadding(PaddingLeft, PaddingTop, PaddingRight, PaddingBottom);
        mTextSize = getTextSize();
	}
	
	public void init(AttributeSet attrs){
        this.setSoundEffectsEnabled(false);
		getBackground().setColorFilter(Color.WHITE, Mode.MULTIPLY);
		getBackground().setAlpha(isEnabled()?ALPHA_FOR_NORMAL:ALPHA_FOR_DISABLE);
		invalidate();
	}
	
	public void reset() {
		getBackground().setColorFilter(Color.WHITE, Mode.MULTIPLY);
		invalidate();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		getBackground().setAlpha(isEnabled()?ALPHA_FOR_NORMAL:ALPHA_FOR_DISABLE);
		super.onDraw(canvas);
	}
	
	@Override
    public boolean onTouchEvent(MotionEvent event)
    {

		
        boolean result = super.onTouchEvent(event);

		if (isEnabled() && isClickable()) {
	        if (event.getAction() == MotionEvent.ACTION_DOWN)
	        {
	    		getBackground().setColorFilter(Color.GRAY, Mode.MULTIPLY);
	    		invalidate();
	        }
	        else if (event.getAction() == MotionEvent.ACTION_UP
	        		|| event.getAction() == MotionEvent.ACTION_CANCEL)
	        {
	    		getBackground().setColorFilter(Color.WHITE, Mode.MULTIPLY);
	    		invalidate();
	        }
        }
        
        return result;
    }
    // Minimum text size for this text view
    public static final float MIN_TEXT_SIZE = 2;

    // Interface for resize notifications
    public interface OnTextResizeListener {
        public void onTextResize(TextView textView, float oldSize, float newSize);
    }

    // Our ellipse string
    private static final String mEllipsis = "...";

    // Registered resize listener
    private OnTextResizeListener mTextResizeListener;

    // Flag for text and/or size changes to force a resize
    private boolean mNeedsResize = false;

    // Text size that is set from code. This acts as a starting point for resizing
    private float mTextSize;

    // Temporary upper bounds on the starting text size
    private float mMaxTextSize = 0;

    // Lower bounds for text size
    private float mMinTextSize = MIN_TEXT_SIZE;

    // Text view line spacing multiplier
    private float mSpacingMult = 1.0f;

    // Text view additional line spacing
    private float mSpacingAdd = 0.0f;

    // Add ellipsis to text that overflows at the smallest text size
    private boolean mAddEllipsis = true;




    /**
     * When text changes, set the force resize flag to true and reset the text size.
     */
    @Override
    protected void onTextChanged(final CharSequence text, final int start, final int before, final int after) {
        mNeedsResize = true;
        // Since this view may be reused, it is good to reset the text size
        resetTextSize();
    }

    /**
     * If the text view size changed, set the force resize flag to true
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w != oldw || h != oldh) {
            mNeedsResize = true;
        }
    }

    /**
     * Register listener to receive resize notifications
     * @param listener
     */
    public void setOnResizeListener(OnTextResizeListener listener) {
        mTextResizeListener = listener;
    }

    /**
     * Override the set text size to update our internal reference values
     */
    @Override
    public void setTextSize(float size) {
        super.setTextSize(size);
        mTextSize = getTextSize();
    }

    /**
     * Override the set text size to update our internal reference values
     */
    @Override
    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
        mTextSize = getTextSize();
    }

    /**
     * Override the set line spacing to update our internal reference values
     */
    @Override
    public void setLineSpacing(float add, float mult) {
        super.setLineSpacing(add, mult);
        mSpacingMult = mult;
        mSpacingAdd = add;
    }

    /**
     * Set the upper text size limit and invalidate the view
     * @param maxTextSize
     */
    public void setMaxTextSize(float maxTextSize) {
        mMaxTextSize = maxTextSize;
        requestLayout();
        invalidate();
    }

    /**
     * Return upper text size limit
     * @return
     */
    public float getMaxTextSize() {
        return mMaxTextSize;
    }

    /**
     * Set the lower text size limit and invalidate the view
     * @param minTextSize
     */
    public void setMinTextSize(float minTextSize) {
        mMinTextSize = minTextSize;
        requestLayout();
        invalidate();
    }

    /**
     * Return lower text size limit
     * @return
     */
    public float getMinTextSize() {
        return mMinTextSize;
    }

    /**
     * Set flag to add ellipsis to text that overflows at the smallest text size
     * @param addEllipsis
     */
    public void setAddEllipsis(boolean addEllipsis) {
        mAddEllipsis = addEllipsis;
    }

    /**
     * Return flag to add ellipsis to text that overflows at the smallest text size
     * @return
     */
    public boolean getAddEllipsis() {
        return mAddEllipsis;
    }

    /**
     * Reset the text to the original size
     */
    public void resetTextSize() {
        if (mTextSize > 0) {
            super.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
            mMaxTextSize = mTextSize;
        }
    }

    /**
     * Resize text after measuring
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed || mNeedsResize) {
            int widthLimit = (right - left) - getCompoundPaddingLeft() - getCompoundPaddingRight();
            int heightLimit = (bottom - top) - getCompoundPaddingBottom() - getCompoundPaddingTop();
            resizeText(widthLimit, heightLimit);
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * Resize the text size with default width and height
     */
    public void resizeText() {

        int heightLimit = getHeight() - getPaddingBottom() - getPaddingTop();
        int widthLimit = getWidth() - getPaddingLeft() - getPaddingRight();
        resizeText(widthLimit, heightLimit);
    }

    /**
     * Resize the text size with specified width and height
     * @param width
     * @param height
     */
    public void resizeText(int width, int height) {
    	//height =(int) (((float)width) * 0.35);
    	

        CharSequence text = getText();
        // Do not resize if the view does not have dimensions or there is no text
        if (text == null || text.length() == 0 || height <= 0 || width <= 0 || mTextSize == 0) {
            return;
        }

        if (getTransformationMethod() != null) {
            text = getTransformationMethod().getTransformation(text, this);
        }

        // Get the text view's paint object
        TextPaint textPaint = getPaint();

        // Store the current text size
        float oldTextSize = textPaint.getTextSize();
        // If there is a max text size set, use the lesser of that and the default text size
        float targetTextSize = mMaxTextSize > 0 ? Math.min(mTextSize, mMaxTextSize) : mTextSize;

        // Get the required text height
        int textHeight = getTextHeight(text, textPaint, width, targetTextSize);

        int textWidth = getTextWidth(text, textPaint, width, targetTextSize);
        
        
        height = height > width ?  width : height;
        
    	if (textWidth > 0)
    	{
    		height = ((int) (((float)height) / ((float)textWidth / (float)width)));
    	}else
    	{
    		height = (int) (width * 0.45);
    	}
        
        // Until we either fit within our text view or we had reached our min text size, incrementally try smaller sizes
        while (textHeight > height && targetTextSize > mMinTextSize) {
            targetTextSize = Math.max(targetTextSize - 2, mMinTextSize);
            textHeight = getTextHeight(text, textPaint, width, targetTextSize);
        }

        // If we had reached our minimum text size and still don't fit, append an ellipsis
        if (mAddEllipsis && targetTextSize == mMinTextSize && textHeight > height) {
            // Draw using a static layout
            // modified: use a copy of TextPaint for measuring
            TextPaint paint = new TextPaint(textPaint);
            // Draw using a static layout
            StaticLayout layout = new StaticLayout(text, paint, width, Alignment.ALIGN_NORMAL, mSpacingMult, mSpacingAdd, false);
            // Check that we have a least one line of rendered text
            if (layout.getLineCount() > 0) {
                // Since the line at the specific vertical position would be cut off,
                // we must trim up to the previous line
                int lastLine = layout.getLineForVertical(height) - 1;
                // If the text would not even fit on a single line, clear it
                if (lastLine < 0) {
                    setText("");
                }
                // Otherwise, trim to the previous line and add an ellipsis
                else {
                    int start = layout.getLineStart(lastLine);
                    int end = layout.getLineEnd(lastLine);
                    float lineWidth = layout.getLineWidth(lastLine);
                    float ellipseWidth = textPaint.measureText(mEllipsis);

                    // Trim characters off until we have enough room to draw the ellipsis
                    while (width < lineWidth + ellipseWidth) {
                        lineWidth = textPaint.measureText(text.subSequence(start, --end + 1).toString());
                    }
                    setText(text.subSequence(0, end) + mEllipsis);
                }
            }
        }

        // Some devices try to auto adjust line spacing, so force default line spacing
        // and invalidate the layout as a side effect
        setTextSize(TypedValue.COMPLEX_UNIT_PX, targetTextSize );
        setLineSpacing(mSpacingAdd, mSpacingMult);

        // Notify the listener if registered
        if (mTextResizeListener != null) {
            mTextResizeListener.onTextResize(this, oldTextSize, targetTextSize );
        }

        // Reset force resize flag
        mNeedsResize = false;
    }

    // Set the text size of the text paint object and use a static layout to render text off screen before measuring
    private int getTextHeight(CharSequence source, TextPaint paint, int width, float textSize) {
        // modified: make a copy of the original TextPaint object for measuring
        // (apparently the object gets modified while measuring, see also the
        // docs for TextView.getPaint() (which states to access it read-only)
        TextPaint paintCopy = new TextPaint(paint);
        // Update the text paint object
        paintCopy.setTextSize(textSize);
        // Measure using a static layout
        StaticLayout layout = new StaticLayout(source, paintCopy, width, Alignment.ALIGN_NORMAL, mSpacingMult, mSpacingAdd, true);
        return layout.getHeight();
    }
    // Set the text size of the text paint object and use a static layout to render text off screen before measuring
    private int getTextWidth(CharSequence source, TextPaint paint, int width, float textSize) {
        // modified: make a copy of the original TextPaint object for measuring
        // (apparently the object gets modified while measuring, see also the
        // docs for TextView.getPaint() (which states to access it read-only)
    	
    	
    	
    	if (source.toString().contains("\n"))
    	{
    		Log.d("DimmableButtonPanel", "source.toString() " + source.toString());
    		String[] separated = source.toString().split("\n");
    		int longest = 0;
    		
    		for ( String testString : separated)
    		{
    			Log.d("DimmableButtonPanel", "testString " + testString);
    			longest = testString.length() > longest ? testString.length() :longest;
    			
    		}
    		
    		return  ((int) ((longest ) * textSize * 0.85));// + dpToPx(this.PaddingLeft) + dpToPx(this.PaddingRight);
    	}
    	
    	TextPaint paintCopy = new TextPaint(paint);
        // Update the text paint object
        paintCopy.setTextSize(textSize);
        return 0;// ((int) ((source.length()  ) * textSize * 0.95));// + dpToPx(this.PaddingLeft) + dpToPx(this.PaddingRight);
    }
}
