package com.yhbzxx.danansoft.xiaocalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends Activity {

    private Button btntest;
    private XmlPullParserFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btntest = (Button) findViewById(R.id.btnequl);
        btntest.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Toast.makeText(v.getContext(), "测试一下!!", Toast.LENGTH_SHORT).show();
                                           File file = new File(getCacheDir() + "info.txt");
                                           OutputStream out = null;
                                           try {
                                               out = new FileOutputStream(file);
                                           } catch (FileNotFoundException e) {
                                               e.printStackTrace();
                                           }
                                           String str = btntest.getText().toString();
                                           try {
                                               out.write(str.getBytes());
                                               out.close();
                                           } catch (IOException e) {
                                               e.printStackTrace();
                                           }
                                           try {
                                               factory = XmlPullParserFactory.newInstance();
                                           } catch (XmlPullParserException e) {
                                               e.printStackTrace();
                                           }


                                       }
                                   }
        );
    }


}
