package com.pabji.heroes.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.pabji.heroes.presentation.activities.main.MainActivity;
import com.pabji.heroes.presentation.base.BaseActivity;

import javax.inject.Inject;

public class Router {

    private Context application;

    @Inject
    public Router(Context application){
        this.application = application;
    }

    public void goToMainActivity() {
        if(application != null) {
            Intent intent = MainActivity.getCallingIntent(application);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            application.startActivity(intent);
        }
    }

    public void finishActivity(Context context) {
        if(context != null) {
            ((BaseActivity)context).finish();
        }
    }
}
