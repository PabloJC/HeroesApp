package com.pabji.heroes.app;

import android.app.Application;

import com.pabji.heroes.data.repositories.heroe.ApiRepository;
import com.pabji.heroes.data.repositories.heroe.ApiRepositoryImpl;
import com.pabji.heroes.presentation.navigation.Router;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    private Application appContext;

    public AppModule(Application application) {
        this.appContext= application;
    }

    @Provides
    @Named("ApplicationContext")
    @Singleton
    public Application provideApplicationContext(){
        return this.appContext;
    }

    @Provides
    @Singleton
    public Router providesRouter(){
        return new Router(this.appContext);
    }

    @Provides @Singleton
    ApiRepository provideHeroesRepository(){
        return new ApiRepositoryImpl();
    }

}

