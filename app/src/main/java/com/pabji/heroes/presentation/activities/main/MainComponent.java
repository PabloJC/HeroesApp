package com.pabji.heroes.presentation.activities.main;

import com.pabji.heroes.app.AppComponent;
import com.pabji.heroes.domain.features.heroList.HeroListInteractor;
import com.pabji.heroes.domain.features.heroList.HeroeListPresenter;
import com.pabji.heroes.presentation.adapters.HeroListAdapter;
import com.pabji.heroes.presentation.di.PerActivity;
import com.pabji.heroes.presentation.fragments.HeroeListFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class,modules = MainModule.class)
public interface MainComponent {
    HeroeListPresenter heroeListPresenter();
    HeroListInteractor getHeroelistInteractor();
    HeroListAdapter getHeroeListAdapter();
    void inject(MainActivity mainActivity);
    void inject(HeroeListFragment fragment);
}
