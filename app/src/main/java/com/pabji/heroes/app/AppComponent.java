package com.pabji.heroes.app;

import com.pabji.heroes.data.repositories.heroe.ApiRepository;
import com.pabji.heroes.presentation.base.BaseActivity;
import com.pabji.heroes.presentation.navigation.Router;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Router getRouter();
    ApiRepository getHeroesRepository();
    void inject (BaseActivity baseActivity);
}
