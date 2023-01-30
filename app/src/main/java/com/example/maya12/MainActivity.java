package com.example.maya12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The Adb.
     */
    AlertDialog.Builder adb;
    /**
     * The View 1.
     */
    View view1;
    /**
     * The Si.
     */
    Intent si;
    /**
     * The Colors.
     */
    String[] colors={"Red","Green","Blue"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1= (View) findViewById(R.id.linLayout);
        si = new Intent(this,MainActivity2.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        String st = item.getTitle().toString();
        if(st.equals("Credits"))
        {
            startActivity(si);
        }
        return true;
    }

    /**
     * First button.
     *
     * @param view the view
     */
    public void firstButton(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        int[] color = {0,0,0};
        adb.setTitle("List of colors- one choice");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i]=255;
                view1.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
                dialogInterface.dismiss();
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog ad =adb.create();
        ad.show();
    }

    /**
     * Second button.
     *
     * @param view the view
     */
    public void secondButton(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        int[] color = {0,0,0};
        adb.setTitle("List of colors- one choice");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b) color[i]=255;
                else if(color[1]==255) color[i]=0;
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                view1.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
                dialogInterface.dismiss();
            }
        });
        AlertDialog ad =adb.create();
        ad.show();
    }

    /**
     * Third button.
     *
     * @param view the view
     */
    public void thirdButton(View view) {
        view1.setBackgroundColor(Color.WHITE);
    }

    /**
     * Fourth button.
     *
     * @param view the view
     */
    public void fourthButton(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Write something...");
        EditText et = new EditText(this);
        adb.setView(et);
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = et.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        AlertDialog ad =adb.create();
        ad.show();
    }
}