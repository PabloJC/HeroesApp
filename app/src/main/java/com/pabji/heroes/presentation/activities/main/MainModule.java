package com.pabji.heroes.presentation.activities.main;

import com.pabji.heroes.data.repositories.heroe.ApiRepository;
import com.pabji.heroes.domain.features.heroList.HeroListInteractor;
import com.pabji.heroes.presentation.adapters.HeroListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    public MainModule(){}

    @Provides
    HeroListInteractor provideRecipeListInteractor(ApiRepository recipeRepository){
        return new HeroListInteractor(recipeRepository);
    }

    @Provides
    HeroListAdapter provideHeroeListAdapter(){
        return new HeroListAdapter();
    }

}
