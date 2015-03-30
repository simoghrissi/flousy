package com.diderot.android.flousy;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import flousy.gui.actionbar.ActionBar;
import flousy.gui.content.ListMenu;
import flousy.gui.recycler.grid.GridItem;
import flousy.gui.recycler.grid.Grid;
import flousy.gui.widget.CustomDialogBuilder;

public class MenuActivity extends MotherActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set ActivityContent
        setContentView(R.layout.grid);

        //Set CustomActionBar
        ActionBar actionBar = getCustomActionBar();
        actionBar.getTitleView().setText(R.string.activity_menu_name);
        actionBar.setActionUpButtonEnabled(false);

        //Disable Drawer
        actionBar.setActionDrawerButtonEnabled(false);
        getDrawer().setEnabled(false);

        //Set Activity content
        RecyclerView gridView = (RecyclerView) findViewById(R.id.grid_view);
        Grid gridMenu = new Grid(this);
        gridMenu.adapt(gridView);

        //Add items
        ListMenu listMenu = ListMenu.getInstance(this);
        ListMenu.Menu menu;

        GridItem gridItem;
        for(int i=0; i<listMenu.count(); i++) {
            gridItem = new GridItem();
            menu = listMenu.get(i);

            gridItem.setColor(menu.getColor());
            gridItem.setImage(menu.getImage());
            gridItem.setText(menu.getName());
            gridItem.setIntent(menu.getIntent());

            gridMenu.addItem(gridItem);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (getIntent().hasExtra("WELCOME") && getIntent().getBooleanExtra("WELCOME", false) == true) {
            getIntent().removeExtra("WELCOME");

            CharSequence firstName = getIntent().getCharSequenceExtra("NEW_USER_FIRSTNAME");

            CustomDialogBuilder builder = new CustomDialogBuilder(this, CustomDialogBuilder.TYPE_ONEBUTTON_OK);
            builder.setTitle(R.string.menu_alertdialog_welcome_title)
                    .setMessage(getResources().getString(R.string.menu_alertdialog_welcome_message) + " " + firstName + " !")
                    .setNeutralButton(null);
            AlertDialog dialog = builder.create();
            dialog.show();
        } else if (getIntent().hasExtra("EXIT") && getIntent().getBooleanExtra("EXIT", false) == true) {
            getIntent().removeExtra("EXIT");

            Intent intent = new Intent(this, LogInActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        super.onCreateOptionsMenu(menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }
}