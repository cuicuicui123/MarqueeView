package com.cwc.marqueeview;

import android.support.v7.widget.RecyclerView;

/**
 * @author Cuiweicong
 */

public abstract class MarsStudentBaseRecyclerViewAdapter extends RecyclerView.Adapter {
    protected OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}
