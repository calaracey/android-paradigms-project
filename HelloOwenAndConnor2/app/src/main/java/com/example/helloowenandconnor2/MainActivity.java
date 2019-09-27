package com.example.helloowenandconnor2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private EditText mSearchBoxEditText;
    private TextView mDisplayTextView;
    private TextView mSearchResultsTextView;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);
        mDisplayTextView = (TextView) findViewById(R.id.tv_display_text);
        mSearchResultsTextView = (TextView) findViewById(R.id.tv_results);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main); // R is the class that has all the resources information.

    // connecting handles to view system elements
    mSearchResultsTextView = (TextView) findViewById(R.id.tv_results);
    mDisplayTextView = (TextView) findViewById(R.id.tv_display_text);
    mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);
    System.out.println("BUTTNS MADE @@@@@@@@@@@@@@@");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemSelected = item.getItemId();

        //if our search option was selected
        if (menuItemSelected == R.id.action_search) {
            //Context context = MainActivity.this;
            //String message = "Search selected";
            //Toast.makeText(context, message, Toast.LENGTH_LONG).show();

            makeSearchQuery();
        }
        return true;
    }
    */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    int menuItemSelected = item.getItemId();

    //if our search option was selected
    if(menuItemSelected == R.id.action_search){

    String message = mSearchBoxEditText.getText().toString();
    mSearchResultsTextView.setText(message);
    System.out.println(message);
    Context c = MainActivity.this;
    String msg = "Search clicked! " + message;
    Toast.makeText(c, msg, Toast.LENGTH_LONG).show();


    Toast.makeText(c, message, Toast.LENGTH_LONG).show();

    makeSearchQuery();
    }
    return true;
    }

    private void makeSearchQuery(){
        String searchQuery = mSearchBoxEditText.getText().toString();
        mDisplayTextView.setText("Results for " + searchQuery);
        mSearchResultsTextView.setText(""); // empty string

        new FetchNetworkData().execute(searchQuery);

    } // end of method makeSearchQuery


    public class FetchNetworkData extends AsyncTask<String, Void, String> {

        @Override
        public String doInBackground(String... params) {
            try {
                String cityName = params[0];
                System.out.println(cityName);
                String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&APPID=f56113b7642a7b4074a4cb058700750f";
                System.out.println(urlString);
                URL url = new URL(urlString);
                String responseString = NetworkUtils.getResponseFromHttpUrl(url);
                return responseString;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onPostExecute(String responseData) {
            Weather result = NetworkUtils.readDataFromJson(responseData);

            mSearchResultsTextView.append(result.toString());
        }
    }
}



