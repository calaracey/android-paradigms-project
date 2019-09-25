package com.example.helloowenandconnor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mSearchBoxEditText;
    private TextView mDisplayTextView;
    private TextView mSearchResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);
        mDisplayTextView = (TextView) findViewById(R.id.tv_display_text);
        mSearchResultsTextView = (TextView) findViewById(R.id.tv_results);
                super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemSelected = item.getItemId();

        //if our search option was selected
        if(menuItemSelected == R.id.action_search){
            Context context = MainActivity.this;
            String message = "Search selected";
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
        return true;
    }


}
