package com.example.android.menuexercise;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    CoordinatorLayout coordrinatorLayout;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get reference to use for SnackBar
        coordrinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        //Get reference of TextView for Contextual Menu
        mTextView = (TextView) findViewById(R.id.textView_context_menu);
        //Register the contextMenu
        registerForContextMenu(mTextView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        String msg;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout_dp);
        switch (id) {
            case R.id.settings_menu:
                msg = "Setting Menu is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.image_menu:
                msg = "Image Menu is clicked";
                showSnackMenuMessage(msg);
                View menuItemView = findViewById(R.id.image_menu);
                showPopupMenu(menuItemView);
                return true;
            case R.id.file_menu:
                msg = "File Menu is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.file_sub_menu_1:
                msg = "File SubMenu 1 is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.file_sub_menu_2:
                msg = "File SubMenu 2 is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.group_menu_item:
                msg = "Group Menu is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.group_item_1:
                msg = "Group SubMenu 1 is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.group_item_2:
                msg = "Group SubMenu 2 is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.group_checkable:
                msg = "Group Checkable Menu is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.group_check_red:
                msg = "Group Red checkable Menu is clicked";
                showSnackMenuMessage(msg);
                if (item.isChecked())
                    item.setCheckable(false);
                else {
                    item.setChecked(true);
                    relativeLayout.setBackgroundColor(Color.RED);
                }
                showSnackMenuMessage(msg);
                return true;
            case R.id.group_check_blue:
                msg = "Group Blue checkable Menu is clicked";
                if (item.isChecked())
                    item.setCheckable(false);
                else {
                    item.setChecked(true);
                    relativeLayout.setBackgroundColor(Color.BLUE);
                }
                showSnackMenuMessage(msg);
                return true;
            case R.id.group_check_green:
                msg = "Group Green checkable Menu is clicked";
                if (item.isChecked())
                    item.setCheckable(false);
                else {
                    item.setChecked(true);
                    relativeLayout.setBackgroundColor(Color.GREEN);
                }
                showSnackMenuMessage(msg);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Override the onCreateContextMenu method to use contextual menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
    }

    //Override the onContextItemSelected() method to capture the click
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String msg;
        switch (item.getItemId()) {
            case R.id.context_menu_item1:
                msg = "Contextual menu 1 is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.context_menu_item2:
                msg = "Contextual menu 3 is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.context_menu_item3:
                msg = "Contextual menu 3 is clicked";
                showSnackMenuMessage(msg);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void showSnackMenuMessage (String msg) {
        Snackbar.make(coordrinatorLayout,msg,Snackbar.LENGTH_LONG).show();
    }

    public void showPopupMenu (View menuItemView) {
        PopupMenu popupMenu = new PopupMenu(this, menuItemView);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
        //Implement the PopupMenu.OnMenuItemClickListener interface to handle click
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    //Override the onMenuItemClick for PopUP menu
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        String msg;
        switch(item.getItemId()) {
            case R.id.popup_item_1:
                msg = "First Pop Item Menu is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.popup_item_2:
                msg = "Second Pop Item Menu is clicked";
                showSnackMenuMessage(msg);
                return true;
            case R.id.popup_item_3:
                msg = "Third Pop Item Menu is clicked";
                showSnackMenuMessage(msg);
                return true;
            default:
                return false;
        }
    }
}
