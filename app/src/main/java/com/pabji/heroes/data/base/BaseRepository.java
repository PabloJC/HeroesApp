package com.pabji.heroes.data.base;

import android.content.Context;

import com.pabji.heroes.data.net.Connectivity;

public class BaseRepository {

    protected boolean haveInternetConnection(Context context) {
        return Connectivity.haveInternetConnection(context);
    }
}