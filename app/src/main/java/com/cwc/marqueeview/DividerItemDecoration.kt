package com.cwc.memo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.View
import com.cwc.marqueeview.R

/**
 * Created by Cui on 2017/8/15.
 * @Description
 */
class DividerItemDecoration(context : Context) : RecyclerView.ItemDecoration() {
    var divider: Drawable = context.resources.getDrawable(R.drawable.divider)
    val columnDivider: Drawable = context.resources.getDrawable(R.drawable.divider_column)
    val padding = 30

    override fun onDrawOver(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        if (c != null && parent != null) {
            drawHorizontalLine(c, parent)
            drawVerticalLine(c, parent)
        }
    }

    fun drawHorizontalLine(c: Canvas, parent: RecyclerView){
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount
        (0 .. childCount - 1)
                .filter { it % 2 == 0 }
                .map { parent.getChildAt(it) }
                .forEach {
                    it?.let {
                        val params = it.layoutParams as RecyclerView.LayoutParams
                        val top = it.top
                        val bottom = top + divider.intrinsicHeight
                        divider.bounds = Rect(left + padding, top, right - padding, bottom)
                        divider.draw(c)
                    }
                }
    }

    fun drawVerticalLine(c: Canvas, parent: RecyclerView){
        val childCount = parent.childCount
        (0..childCount - 1)
                .filter { it % 2 == 1 }
                .map {
                    val child = parent.getChildAt(it)
                    val left = child.left
                    val right = left + columnDivider.intrinsicWidth
                    val top = if (it == 1) child.top + padding else child.top
                    val bottom = if (it == 3) child.bottom - padding else child.bottom
                    columnDivider.bounds = Rect(left, top, right, bottom)
                    columnDivider.draw(c)
                }
    }

    override fun getItemOffsets(outRect: Rect?, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val position = parent.indexOfChild(view)
        if (position % 2 == 0) {
            outRect?.set(0, 0, 0, divider.intrinsicHeight)
        } else if (position % 2 == 1) {
            outRect?.set(0, 0, columnDivider.intrinsicWidth, 0)
        }

    }

}