package com.example.pushnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.common.internal.Constants;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;

//import androidx.core.app.NotificationCompat;
//import androidx.core.app.NotificationManagerCompat;

public class MyFirebaseMessagingService extends FirebaseMessagingService   {

    private Context mcontext;
   // private static int count=0;
    private static final String TAG = "MyFirebaseMsgService";



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        Log.d(TAG,"remoteTitle" +remoteMessage.getNotification().getTitle());
        Log.d(TAG,"remoteBody" +remoteMessage.getNotification().getBody());


        sendNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody(), remoteMessage.getData());

}


    private void sendNotification(String messageBody, String messageTitle, Map<String,String> row){

      PendingIntent pendingIntent=null;


        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());

    }
}
