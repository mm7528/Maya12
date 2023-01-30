package com.example.maya12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * The type Main activity 2.
 */
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0,0,100,"Previous");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        String st = item.getTitle().toString();
        if(st.equals("Previous"))
        {
            finish();
        }
        return true;
    }
}