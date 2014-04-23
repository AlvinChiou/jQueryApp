package com.example.jQueryApp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    static WebView vw; //定義類別變數使全類別均可存取
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findviews();
    }
    private void findviews(){
        vw = (WebView)findViewById(R.id.webView);
        String url = "http://10.120.38.1:8080/webcar/js_call_android.html";
        WebSettings webSettings = vw.getSettings();
        webSettings.setJavaScriptEnabled(true);
        vw.loadUrl(url);
        vw.addJavascriptInterface(new WebAppInterface(this), "Android"); //vw is a WebView object.
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK)&&vw.canGoBack()){
            vw.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public class WebAppInterface{
        Context context;
        WebAppInterface(Context context){
            this.context = context;
        }
        @JavascriptInterface
        public void showToast(String msg){
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }
    }
}
