package com.example.myapplication11;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        //Помогает приложению открывать ссылки внутри WebView, а не вовнешнем браузере
        webView.getSettings().setJavaScriptEnabled(true);
        //Включаем поддержку JavaScript

        webView.loadUrl("https://www.mirea.ru");
        //Загрузка страницы
    }
}