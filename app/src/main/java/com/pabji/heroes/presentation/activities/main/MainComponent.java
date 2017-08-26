package com.pabji.heroes.presentation.activities.main;

import com.pabji.heroes.app.AppComponent;
import com.pabji.heroes.domain.features.heroList.HeroListInteractor;
import com.pabji.heroes.domain.features.heroList.HeroListPresenter;
import com.pabji.heroes.presentation.adapters.HeroListAdapter;
import com.pabji.heroes.presentation.di.PerActivity;
import com.pabji.heroes.presentation.fragments.HeroListFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class,modules = MainModule.class)
public interface MainComponent {
    HeroListPresenter heroeListPresenter();
    HeroListInteractor getHeroelistInteractor();
    HeroListAdapter getHeroeListAdapter();
    void inject(MainActivity mainActivity);
    void inject(HeroListFragment fragment);
}
