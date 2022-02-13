package com.example.lenovo.expresslove;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/*import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;*/

public class Main2Activity extends AppCompatActivity {
  //  private WebView mWebView;
  private WebView webView;
    AlertDialog builder=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main2);
      /*  mWebView = (com.tencent.smtt.sdk.WebView) findViewById(R.id.webView2);
        mWebView.loadUrl("file:///android_asset/index3.html");
        if (Build.VERSION.SDK_INT >= 21) {//设置顶部状态栏为半透明
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }*/
        final TextView  textView=(TextView)findViewById(R.id.textview);









        webView = (WebView) findViewById(R.id.webView);
        //需要加载的网页的url
        webView.loadUrl("file:///android_asset/index5.html");//这里写的是assets文件夹下html文件的名称，需要带上后面的后缀名，前面的路径是安卓系统自己规定的android_asset就是表示的在assets文件夹下的意思。
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//自适应屏幕
        webView.getSettings().setLoadWithOverviewMode(true);//自适应屏幕
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setUseWideViewPort(true);//扩大比例的缩放
       // webView.getSettings().setBuiltInZoomControls(true);//设置是否出现缩放工具,这里我想就不出现了，影响效果
        WebSettings settings = webView.getSettings();
        // 如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.animator.anim);
        textView.startAnimation(scaleAnimation);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.hide();
        }
        if (Build.VERSION.SDK_INT >= 21) {//设置顶部状态栏为半透明
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);}

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable(){ // 为了减少代码使用匿名Handler创建一个延时的调用
            public void run() {
                textView.setText("<----看完再点哦~~~");
            } }, 4500);

        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(Main2Activity.this);
//2.设置属性
                b.setTitle("老婆~~");


                b.setPositiveButton("老公~~", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder c = new AlertDialog.Builder(Main2Activity.this);
                        c.setMessage("要抱抱~~");
                        c.setPositiveButton("好~~", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                AlertDialog.Builder d = new AlertDialog.Builder(Main2Activity.this);
                                d.setMessage("要亲亲~~");
                                d.setNegativeButton("好~~", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        AlertDialog.Builder y = new AlertDialog.Builder(Main2Activity.this);
                                        y.setMessage("要举高高~~");
                                        y.setNegativeButton("ฅ՞•ﻌ•՞ฅ", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                                                startActivity(intent);
                                            }
                                        });
                                        y.create();
                                        y.show();
                                    }
                                });
                                d.create();
                                d.show();
                            }
                        });
                        c.create();//创建
                        c.show();//show
                    }
                });
                b.create();//创建
                b.show();//show

            }

        });
        //这里是外面的括号了





    }





    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            new CommomDialog(this, R.style.dialog, "爱你哦~~", new CommomDialog.OnCloseListener() {
                @Override
                public void onClick(Dialog dialog, boolean confirm) {
                    if(confirm){

                        dialog.dismiss();
                    }

                }
            })
                    .setTitle("ฅ՞•ﻌ•՞ฅ").show();

    }
    return true;
    }}

