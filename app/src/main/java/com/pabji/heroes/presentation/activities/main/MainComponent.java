package com.pabji.heroes.presentation.activities.main;

import com.pabji.heroes.app.AppComponent;
import com.pabji.heroes.domain.features.heroeList.HeroeListInteractor;
import com.pabji.heroes.domain.features.heroeList.HeroeListPresenter;
import com.pabji.heroes.presentation.adapters.HeroeListAdapter;
import com.pabji.heroes.presentation.di.PerActivity;
import com.pabji.heroes.presentation.fragments.HeroeListFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class,modules = MainModule.class)
public interface MainComponent {
    HeroeListPresenter heroeListPresenter();
    HeroeListInteractor getHeroelistInteractor();
    HeroeListAdapter getHeroeListAdapter();
    void inject(MainActivity mainActivity);
    void inject(HeroeListFragment fragment);
}
