package com.pabji.heroes.presentation.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.pabji.heroes.domain.features.heroDetail.HeroDetailView;
import com.pabji.heroes.presentation.activities.heroDetail.HeroDetailActivity;
import com.pabji.heroes.presentation.activities.main.MainActivity;
import com.pabji.heroes.presentation.base.BaseActivity;

import javax.inject.Inject;

public class Router {

    private Context application;

    @Inject
    public Router(Context application){
        this.application = application;
    }

    public void goToHeroDetail() {
        if(application != null) {
            Intent intent = HeroDetailActivity.getCallingIntent(application);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            application.startActivity(intent);
        }
    }
}
