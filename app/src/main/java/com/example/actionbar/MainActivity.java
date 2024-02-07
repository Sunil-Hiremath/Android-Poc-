package com.example.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        //step 1
        //setting the toolbar for this activity
        setSupportActionBar(toolbar);

        //step 2
        //performing action on toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//back button function
            getSupportActionBar().setTitle("My ToolBar");
        }


        toolbar.setSubtitle("sub Title");
    }

    // the menu in the param is the reference ot position where the menu to be inflated or placed
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    // the below method includes back button also, so whenever clicked on menu or back button below method is triggered
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();

        if(itemId==R.id.opt_new){
            Toast.makeText(this, "Created  new File", Toast.LENGTH_SHORT).show();
        } else if (itemId==R.id.opt_open) {
            Toast.makeText(this, "File Open.", Toast.LENGTH_SHORT).show();
            
        } else if (itemId==android.R.id.home) {
            super.onBackPressed();
        }else{
            Toast.makeText(this, "File Saved.", Toast.LENGTH_SHORT).show();

        }


        return super.onOptionsItemSelected(item);
    }
}