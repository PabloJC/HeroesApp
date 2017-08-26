package com.pabji.heroes.presentation.activities.main;

import com.pabji.heroes.data.repositories.heroe.ApiRepository;
import com.pabji.heroes.domain.features.heroDetail.HeroDetailInteractor;
import com.pabji.heroes.domain.features.heroList.HeroListInteractor;
import com.pabji.heroes.presentation.adapters.HeroListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    public MainModule(){}

    @Provides
    HeroListInteractor provideHeroListInteractor(ApiRepository apiRepository){
        return new HeroListInteractor(apiRepository);
    }

    @Provides
    HeroDetailInteractor provideHeroDetailInteractor(ApiRepository apiRepository){
        return new HeroDetailInteractor(apiRepository);
    }

    @Provides
    HeroListAdapter provideHeroeListAdapter(){
        return new HeroListAdapter();
    }

}
