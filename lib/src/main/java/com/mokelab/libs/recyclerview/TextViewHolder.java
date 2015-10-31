package com.mokelab.libs.recyclerview;

import android.view.View;
import android.widget.TextView;

/**
 * ViewHolder that has 1 {@link TextView}
 */
public class TextViewHolder extends BaseViewHolder {
    public TextView mTextView;

    public TextViewHolder(View itemView, int viewId) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(viewId);
    }

    public TextViewHolder(View itemView, int viewId, OnItemClickListener l) {
        super(itemView, l);
        mTextView = (TextView) itemView.findViewById(viewId);
    }
}
