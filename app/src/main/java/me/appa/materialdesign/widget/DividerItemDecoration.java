package me.appa.materialdesign.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by yeeni on 2015/11/22.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

    private Drawable mDivider;


    public DividerItemDecoration(Context context) {
        final TypedArray styleAttributes = context.obtainStyledAttributes(ATTRS);
        mDivider = styleAttributes.getDrawable(0);
        styleAttributes.recycle();
    }

    public DividerItemDecoration(Context context, int resID) {

        mDivider = ContextCompat.getDrawable(context, resID);

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            if(i % 2 == 0) {
                mDivider.setBounds(left, top, right, bottom);
            }else{
                mDivider.setBounds(left+20,top,right-20,bottom);
            }
            mDivider.draw(c);



        }
    }
}
