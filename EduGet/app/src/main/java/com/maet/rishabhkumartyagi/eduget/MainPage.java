package com.maet.rishabhkumartyagi.eduget;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        new Title().execute();


    }

    private class Title extends AsyncTask<Void, Void, Void> {
        String title;


        final ArrayList<String> siteName = new ArrayList<String>();
        final ArrayList<String> siteUrl = new ArrayList<String>();
        final ArrayList<String> imageUrl = new ArrayList<String>();



        @Override
        protected Void doInBackground(Void... params) {


            try {
                Document doc = (Document) Jsoup.connect("http://oer2go.org/").get();
                for (Element divblock : doc.select("div[class='appbox']")) {
                    siteUrl.add("http://oer2go.org" + divblock.select("a[href]").attr("href"));
                    siteName.add(divblock.select("div[title]").attr("title"));
                    imageUrl.add(divblock.select("div[style]").attr("style"));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {


            String[] siteNameArray = siteName.toArray(new String[siteName.size()]);
            String[] siteUrlArray = siteUrl.toArray(new String[siteUrl.size()]);
            String[] imageUrlArray = imageUrl.toArray(new String[imageUrl.size()]);
         //  Bitmap[] bmpArray = bmp.toArray(new Bitmap[bmp.size()]);



            String str = new String();
            str = "";
            for (int i = 0; i < siteNameArray.length; i++) {
                str = str + "name : " + siteNameArray[i] +"\n";//"strUrl : "+siteUrlArray[i]+"\n"+"imageUrl :"+"http://oer2go.org" + imageUrlArray[i].substring(imageUrlArray[i].indexOf("(")+1,imageUrlArray[i].indexOf(")"))+"\n" ;
            }

            TextView tv = (TextView) findViewById(R.id.textView);
            tv.setText(str);

        }
    }
}


