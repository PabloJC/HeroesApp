package com.pabji.heroes.presentation.activities.heroDetail;

import com.pabji.heroes.app.AppComponent;
import com.pabji.heroes.domain.features.heroDetail.HeroDetailPresenter;
import com.pabji.heroes.presentation.activities.main.MainActivity;
import com.pabji.heroes.presentation.di.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class,modules = HeroDetailModule.class)
public interface HeroDetailComponent {
    HeroDetailPresenter heroeDetailPresenter();
    void inject(MainActivity mainActivity);
}
