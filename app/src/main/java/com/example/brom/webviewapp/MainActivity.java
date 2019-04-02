package com.example.brom.webviewapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    //Global variables
    private WebView webView;
    private String homeUrl = "http://wwwlab.iit.his.se/a18antsv/mobilapplikationsdesign/projekt/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Gets the webview element created in content_main.xml and stores it in a declared variable
        webView = (WebView) findViewById(R.id.my_webview);
        //Attaches WebViewClient to the WebView, making it possible to browse the web
        webView.setWebViewClient(new WebViewClient());
        //Activates javascript compatibility
        webView.getSettings().setJavaScriptEnabled(true);
        //Load url inside WebView element
        webView.loadUrl(homeUrl);
    }

    //Creates and shows Snackbar. Can be closed by event listener
    public void showSnackbar(View v, String m, int d) {
        final Snackbar snackbar = Snackbar.make(v, m, d);
        snackbar.setAction("CLOSE", new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Select a menu item, do the action the menu item represents
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                webView.loadUrl(homeUrl);
                break;
            case R.id.action_about:
                webView.loadUrl("file:///android_asset/about.html");
                break;
            case R.id.action_contact:
                showSnackbar(getWindow().getCurrentFocus(), "Kontakta mig: gotneifhd@gmail.com", Snackbar.LENGTH_INDEFINITE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
