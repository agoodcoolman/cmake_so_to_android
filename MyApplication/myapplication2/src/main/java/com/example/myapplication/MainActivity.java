package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private MainHandler mainHandler;
    private NFCReaderHelper nfcReaderHelper;
    private AsyncTask<Void, Void, String> nfcTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainHandler = new MainHandler(this);
        nfcReaderHelper = new NFCReaderHelper(this, mainHandler);

    }

    public void button(View view) {

        nfcReaderHelper.read();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (nfcReaderHelper.isNFC(intent)) {

            nfcTask = new NFCReadTask(intent).executeOnExecutor(Executors
                    .newCachedThreadPool());

            Log.e("MainActivity", "返回的intent可用");
            /*if (nfcTask == null) {



                *//*nfcTask = new NFCReadTask(intent).executeOnExecutor(Executors
                        .newCachedThreadPool());*//*
            }*/
        } else {
            Log.e("MainActivity", "返回的intent不可用");
        }
    }

    class MainHandler extends Handler {

        private final Activity activity;

        public MainHandler(Activity a) {
            WeakReference<Activity> activityWeakReference = new WeakReference<>(a);
            activity = activityWeakReference.get();
        }

        @Override
        public void handleMessage(Message msg) {
            Log.e("MainActivity", "接受到消息");
            switch (msg.what) {

            }
        }
    }
    private class NFCReadTask extends AsyncTask<Void, Void, String> {

        private Intent mIntent = null;

        public NFCReadTask(Intent i) {
            mIntent = i;
        }

        @Override
        protected String doInBackground(Void... params) {

            String strCardInfo = nfcReaderHelper.readCardWithIntent(mIntent);
            return strCardInfo;
        }

        @Override
        protected void onPostExecute(String strCardInfo) {



            if (TextUtils.isEmpty(strCardInfo)) {

                return;
            }

            if (strCardInfo.length() <= 2){

                return;
            }


            super.onPostExecute(strCardInfo);
        }

    }


}
