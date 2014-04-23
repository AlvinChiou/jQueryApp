package com.example.jQueryApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    static WebView vw;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findviews();
    }
    private void findviews(){
         vw = (WebView)findViewById(R.id.webView);
        String url = "http://10.120.38.1:8080/webcar/carlist.html";
        WebSettings webSettings = vw.getSettings();
        webSettings.setJavaScriptEnabled(true);
        vw.loadUrl(url);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK)&&vw.canGoBack()){
            vw.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
