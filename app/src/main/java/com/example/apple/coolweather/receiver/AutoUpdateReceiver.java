package com.example.apple.coolweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.apple.coolweather.service.AutoUpdateService;

/**
 * Created by apple on 15/11/13.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, AutoUpdateService.class);
        context.startService(i);
    }
}
