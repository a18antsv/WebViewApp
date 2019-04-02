package com.example.brom.webviewapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    //Global variable declaration
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Gets the webview element created in content_main.xml and stores it in a declared variable
        webView = (WebView) findViewById(R.id.my_webview);
        // -- Commit and push to your github fork
        // 3. Locate the WebView element created in step 1 using the ID created in step 2
        // 4. Create a new WebViewClient to attach to our WebView. This allows us to
        //    browse the web inside our app.
        // -- Commit and push to your github fork
        // 5. Enter the url to load in our WebView
        // -- Commit and push to your github fork
    }

    public void showSnackbar(View v, String m, int d) {
        final Snackbar snackbar = Snackbar.make(v, m, d);
        snackbar.setAction("STÄNG", new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_contact) {
            showSnackbar(getWindow().getCurrentFocus(), "Kontakta mig: gotneifhd@gmail.com", Snackbar.LENGTH_INDEFINITE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
