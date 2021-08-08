package com.example.kpkforestdeptcdegad.BroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
      try{

          if (isOnline(context)){
              Log.d("BroadCast ","Internet Connected!!!");
          }else {
              Toast.makeText(context, "No Internet Connection /n please make sure your wifi or mobile data is connected", Toast.LENGTH_LONG).show();
          }

      }catch (NullPointerException e){
          e.printStackTrace();
      }
    }

    public boolean isOnline(Context context){
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return (networkInfo!=null && networkInfo.isConnected());
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }
}