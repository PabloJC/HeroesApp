package com.pabji.heroes.app;


import android.app.Application;

public class HeroesApp extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getInjector() {
        return component;
    }
}
