package com.zinni;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.util.Log;

import com.onesignal.notifications.IActionButton;
import com.onesignal.notifications.IDisplayableMutableNotification;
import com.onesignal.notifications.INotificationReceivedEvent;
import com.onesignal.notifications.INotificationServiceExtension;

import org.json.JSONException;
import org.json.JSONObject;
import java.math.BigInteger;

public class MyNotificationExtenderService implements INotificationServiceExtension {
   @Override
   public void onNotificationReceived(INotificationReceivedEvent event) {
      JSONObject data = event.getNotification().getAdditionalData();

      Log.v("GINNI", "IRemoteNotificationReceivedHandler fired" + " with INotificationReceivedEvent: " + event.getNotification().getAdditionalData());

      try {
            String PushType = data.getString("PushType");

            if(PushType.equals("app_logout")) {

            }

            if(PushType.equals("app_logout")) {
                SharedPreferences.Editor editor = event.getContext().getSharedPreferences("FlutterSharedPreferences", MODE_PRIVATE).edit();
                editor.putBoolean("flutter.app_logout", true);
                editor.apply();

               Log.v("GINNI", "PushType : " + PushType);
            }
        } catch (JSONException e) {
         Log.v("GINNI", "PushType : " + e.getMessage());
      }    
   }
}
