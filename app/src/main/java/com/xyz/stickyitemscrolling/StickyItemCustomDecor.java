package com.xyz.stickyitemscrolling;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StickyItemCustomDecor extends RecyclerView.ItemDecoration {

    private View stickyItem;
    private int itemPosition;
    private int DIRECTION_UP = -1;
    private int DIRECTION_DOWN = 1;

    public StickyItemCustomDecor(View mStickyItem, int position) {
        this.itemPosition = position;
        this.stickyItem = mStickyItem;
    }

    @Override
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(canvas, parent, state);
        LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
        int topVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
        int topFullVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
        int bottomVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
        int bottomFullVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
        if (topVisibleItemPosition == RecyclerView.NO_POSITION
                || topFullVisibleItemPosition == itemPosition
                || bottomVisibleItemPosition == RecyclerView.NO_POSITION
                || bottomFullVisibleItemPosition == itemPosition
                || isContentScrollable(parent)
        ) {
            return;
        }

        if (canStickToTop(topVisibleItemPosition, layoutManager)) {
            fixLayoutSize(parent);
            drawStickyView(canvas, (float) parent.getPaddingLeft(), 0f);
        }

        if (canStickToBottom(bottomVisibleItemPosition, layoutManager, parent)) {
            fixLayoutSize(parent);
            drawStickyView(canvas, (float) parent.getPaddingLeft(), (float) (parent.getBottom() - parent.getTop() - stickyItem.getMeasuredHeight()));
        }
    }

    private Boolean isContentScrollable(RecyclerView recyclerView) {
        return recyclerView.canScrollVertically(DIRECTION_UP)
                || recyclerView.canScrollVertically(DIRECTION_DOWN);
    }

    private Boolean canStickToTop(
            int topVisibleItemPosition,
            LinearLayoutManager layoutManager
    ) {
        return itemPosition < topVisibleItemPosition
                || (itemPosition == topVisibleItemPosition
                && isTopOffsetDisappeared(layoutManager));
    }

    private Boolean isTopOffsetDisappeared(LinearLayoutManager layoutManager) {

        View view = layoutManager.findViewByPosition(itemPosition);
        int topDecorationHeight = layoutManager.getTopDecorationHeight(view);
        int decoratedTop = layoutManager.getDecoratedTop(view);
        return decoratedTop <= -topDecorationHeight;
    }

    private Boolean canStickToBottom(
            int bottomVisibleItemPosition,
            LinearLayoutManager layoutManager,
            RecyclerView parent
    ) {
        return itemPosition > bottomVisibleItemPosition
                || (itemPosition == bottomVisibleItemPosition)
                && isBottomOffsetDisappeared(layoutManager, parent.getTop(), parent.getBottom());
    }

    private Boolean isBottomOffsetDisappeared(
            LinearLayoutManager layoutManager,
            int parentTop,
            int parentBottom
    ) {
        View view = layoutManager.findViewByPosition(itemPosition);
        int bottomDecorationHeight = layoutManager.getBottomDecorationHeight(view);
        int decoratedBottom = layoutManager.getDecoratedBottom(view);
        return decoratedBottom >= parentBottom - parentTop + bottomDecorationHeight;
    }

    private void drawStickyView(Canvas canvas, Float dx, Float dy) {
        canvas.save();
        canvas.translate(dx, dy);
        stickyItem.draw(canvas);
        canvas.restore();
    }

    private void fixLayoutSize(ViewGroup parent) {
        int widthSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth(), View.MeasureSpec.EXACTLY);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(parent.getHeight(), View.MeasureSpec.UNSPECIFIED);

        int childWidthSpec = ViewGroup.getChildMeasureSpec(
                widthSpec,
                parent.getPaddingLeft() + parent.getPaddingRight(),
                stickyItem.getLayoutParams().width
        );
        int childHeightSpec = ViewGroup.getChildMeasureSpec(
                heightSpec,
                parent.getPaddingTop() + parent.getPaddingBottom(),
                stickyItem.getLayoutParams().height
        );
        stickyItem.measure(childWidthSpec, childHeightSpec);
        stickyItem.layout(0, 0, stickyItem.getMeasuredWidth(), stickyItem.getMeasuredHeight());
    }
}
