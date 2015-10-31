package com.mokelab.libs.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Base ViewHolder. This holder has section and position in section
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    public int mSection;
    public int mPositionInSection;
    public OnItemClickListener mListener;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public BaseViewHolder(View itemView, OnItemClickListener l) {
        super(itemView);
        mListener = l;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener == null) { return; }
                mListener.onItemClick(mSection, mPositionInSection);
            }
        });
    }
}
