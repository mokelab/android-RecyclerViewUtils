# android-RecyclerViewUtils
RecyclerView Utilities

# How to add

Add it to `dependencies'

```
compile 'com.mokelab:RecyclerViewUtil:1.0.0'
```

# Classes

## SectionedAdapter

`SectionedAdapter` provides item-sectioned feature. Each ViewHolder must extend `com.mokelab.libs.recyclerview.BaseViewHolder`

`SectionedAdapter` is an abstract class so developers must implements the following methods. 

```
public abstract int getSectionCount();
==> Return how many sections this list has.

public abstract int getItemCount(int section);
==> Return count of items in given section(0 - getSectionCount() - 1). 

protected abstract int getSectionHeaderViewType(int section);
==> Return view type of section header. 

protected abstract int getItemViewType(int section, int positionInSection);
==> Return view type of given item. 

protected abstract void onBindSectionHeaderViewHolder(BaseViewHolder holder, int section);
==> Perform data binding of section header

protected abstract void onBindViewHolder(BaseViewHolder holder, int section, int positionInSection);
==> Perform data binding of item. 

public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType);
==> Return ViewHolder. This method is an abstract method of RecyclerView.ViewHolder.
```

Example

```
public class MyAdapter extends SectionedAdapter implements OnItemClickListener {
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_SECTION_1 = 1;
    private static final int VIEW_TYPE_SECTION_2 = 2;

    private final LayoutInflater mInflater;

    private OnItemClickListener mListener;

    public MyAdapter(Context context, OnItemClickListener l) {
        mInflater = LayoutInflater.from(context);
        mListener = l;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
        case VIEW_TYPE_HEADER:
            return createHeaderViewHolder(parent);
        case VIEW_TYPE_SECTION_1:
            return createSection1ViewHolder(parent);
        case VIEW_TYPE_SECTION_2:
            return createSection2ViewHolder(parent);
        }
        return null;
    }

    @Override
    public int getSectionCount() {
        return 3;
    }

    @Override
    public int getItemCount(int section) {
        switch (section) {
        case 0: return 3;
        case 1: return 10;
        case 2: return 4;
        default: return 0;
        }
    }

    @Override
    protected int getSectionHeaderViewType(int section) {
        return VIEW_TYPE_HEADER;
    }

    @Override
    protected int getItemViewType(int section, int positionInSection) {
        switch (section) {
        case 0: return VIEW_TYPE_SECTION_1;
        case 1: return VIEW_TYPE_SECTION_2;
        case 2: return VIEW_TYPE_SECTION_1;
        default: return 0;
        }
    }

    @Override
    protected void onBindSectionHeaderViewHolder(BaseViewHolder holder, int section) {
        ((TextViewHolder)holder).mTextView.setText("Section " + section);
    }

    @Override
    protected void onBindViewHolder(BaseViewHolder holder, int section, int positionInSection) {
        ((TextViewHolder)holder).mTextView.setText("Section " + section + " - " + positionInSection);
    }

    // region private
    private BaseViewHolder createHeaderViewHolder(ViewGroup parent) {
        View root = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new TextViewHolder(root, android.R.id.text1);
    }

    private BaseViewHolder createSection1ViewHolder(ViewGroup parent) {
        View root = mInflater.inflate(R.layout.item_section_1, parent, false);
        return new TextViewHolder(root, android.R.id.text1, this);
    }

    private BaseViewHolder createSection2ViewHolder(ViewGroup parent) {
        View root = mInflater.inflate(R.layout.item_section_2, parent, false);
        return new TextViewHolder(root, android.R.id.text1, this);
    }

    // listener

    @Override
    public void onItemClick(int section, int position) {
        if (mListener == null) { return; }
        mListener.onItemClick(section, position);
    }
}
```
