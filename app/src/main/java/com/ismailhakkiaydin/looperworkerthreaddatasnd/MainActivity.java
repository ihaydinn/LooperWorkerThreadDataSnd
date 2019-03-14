package com.ismailhakkiaydin.looperworkerthreaddatasnd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myThread = new MyThread();
        myThread.start();

    }

    public void sendMessagetoBackgroundThread(View view) {

        Message mesaj = Message.obtain();
        mesaj.arg1 = 1;
        myThread.handler.sendMessage(mesaj);


    }
}

class MyThread extends Thread {

    Handler handler;

    public MyThread() {
    }

    @Override
    public void run() {

        Looper.prepare();
        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                Log.i("csd", "Gelen veri:" + msg.arg1 + " Thread adı:" + Thread.currentThread().getName());
            }
        };
        Looper.loop();
    }
}