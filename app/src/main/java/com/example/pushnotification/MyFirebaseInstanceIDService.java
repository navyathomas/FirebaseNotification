package com.example.pushnotification;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
//import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.util.concurrent.Executor;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {


    private static final String TAG = "MyFirebaseIIDService";


    /**
     * Retrieving token from FCM SDK
     **/
    @Override
    public void onTokenRefresh() {


        /** will get the Current Token...**/
        final String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG, "token" + refreshedToken);


        /** Implement this method to send any registration to your app's Server..**/
        sendRegistrationToServer(refreshedToken);

    }

    /** To send registration Token to server **/
    private void sendRegistrationToServer(String refreshedToken) {

    }
}
