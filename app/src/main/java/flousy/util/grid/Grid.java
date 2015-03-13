package flousy.util.grid;

import android.content.Context;
import android.widget.GridView;

import com.diderot.android.flousy.R;

/**
 * Created by Samir on 21/02/2015.
 */
public abstract class Grid {

    private Context context;
    private ListGridItem listGridItem;
    private int itemLayoutResource;

    protected Grid(Context context, int itemLayoutResource) {
        this.context = context;
        this.listGridItem = new ListGridItem();
        this.itemLayoutResource = itemLayoutResource;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ListGridItem getListGridItem() {
        return this.listGridItem;
    }

    public void setListGridItem(ListGridItem listGridItem) {
        this.listGridItem = listGridItem;
    }

    public int getItemLayoutResource() {
        return this.itemLayoutResource;
    }

    public void setItemLayoutResource(int itemLayoutResource) {
        this.itemLayoutResource = itemLayoutResource;
    }

    public abstract void create(GridView gridView);
}