package com.pabji.heroes.data.net;

import android.content.Context;
import android.net.ConnectivityManager;

public class Connectivity {

    public static Boolean haveInternetConnection(Context context) {
        if (context != null) {
            try {
                ConnectivityManager conMgr =
                        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                return conMgr.getActiveNetworkInfo() != null
                        && conMgr.getActiveNetworkInfo().isAvailable()
                        && conMgr.getActiveNetworkInfo().isConnected();
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
