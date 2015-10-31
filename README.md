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
