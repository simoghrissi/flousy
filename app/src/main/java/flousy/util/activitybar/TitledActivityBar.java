package flousy.util.activitybar;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import com.diderot.android.flousy.R;

/**
 * Created by Samir on 11/03/2015.
 */
public class TitledActivityBar extends ActivityBar {

    private int textViewId;
    private TextView textView;
    private CharSequence title;

    public TitledActivityBar() {
        super(R.layout.layout_titledactivitybar);
        this.textViewId = R.id.titledactivitybar_textview;
        this.textView = null;
        this.title = "Title";
    }

    public int getTextViewId() {
        return this.textViewId;
    }

    public void setTextViewId(int textViewId) {
        this.textViewId = textViewId;
    }

    public CharSequence getTitle() {
        return this.title;
    }

    public void setTitle(CharSequence title) {
        this.title = title;

        if(this.textView != null) {
            this.textView.setText(this.title);
        }
    }

    @Override
    public View create(ViewStub viewStub) {
        ViewGroup viewGroup = null;

        viewStub.setLayoutResource(getLayoutResource());
        viewGroup = (ViewGroup) viewStub.inflate();

        View viewChild;
        for(int i=0; i<viewGroup.getChildCount(); i++) {
            viewChild = viewGroup.getChildAt(i);
            if(viewChild.getId() == this.textViewId) {
                this.textView = (TextView) viewChild;
                this.textView.setText(this.title);
            }
        }

        return viewGroup;
    }
}