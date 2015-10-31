package com.mokelab.libs.recyclerview;

import android.support.v7.widget.RecyclerView;

/**
 * Adapter that supports sectioning feature
 */
public abstract class SectionedAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int sectionCount = getSectionCount();
        for (int section = 0 ; section < sectionCount ; ++section) {
            if (position == 0) {
                onBindSectionHeaderViewHolder(holder, section);
                return;
            }
            --position;
            int itemCount = getItemCount(section);
            if (position < itemCount) {
                onBindViewHolder(holder, section, position);
                return;
            }
            position -= itemCount;
        }
    }

    @Override
    public int getItemCount() {
        int count = 0;
        int numSection = getSectionCount();
        for (int i = 0 ; i < numSection ; ++i) {
            count += (1 + getItemCount(i));
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        int sectionCount = getSectionCount();
        for (int section = 0 ; section < sectionCount ; ++section) {
            if (position == 0) {
                return getSectionHeaderViewType(section);
            }
            --position;
            int itemCount = getItemCount(section);
            if (position < itemCount) {
                return getItemViewType(section, position);
            }
            position -= itemCount;
        }
        return 0;
    }

    public abstract int getSectionCount();

    public abstract int getItemCount(int section);

    protected abstract int getSectionHeaderViewType(int section);

    protected abstract int getItemViewType(int section, int positionInSection);

    protected abstract void onBindSectionHeaderViewHolder(BaseViewHolder holder, int section);

    protected abstract void onBindViewHolder(BaseViewHolder holder, int section, int positionInSection);
}
