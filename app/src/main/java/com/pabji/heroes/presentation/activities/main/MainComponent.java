package com.pabji.heroes.presentation.activities.main;

import com.pabji.heroes.app.AppComponent;
import com.pabji.heroes.domain.features.heroeList.HeroeListInteractor;
import com.pabji.heroes.domain.features.heroeList.HeroeListPresenter;
import com.pabji.heroes.presentation.di.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class,modules = MainModule.class)
public interface MainComponent {
    HeroeListPresenter heroeListPresenter();
    HeroeListInteractor getHeroelistInteractor();
    void inject(MainActivity mainActivity);
}
