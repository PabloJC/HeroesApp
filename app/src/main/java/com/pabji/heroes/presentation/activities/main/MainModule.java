package com.pabji.heroes.presentation.activities.main;

import com.pabji.heroes.data.repositories.heroe.ApiRepository;
import com.pabji.heroes.domain.features.heroeList.HeroeListInteractor;
import com.pabji.heroes.presentation.adapters.HeroeListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    public MainModule(){}

    @Provides
    HeroeListInteractor provideRecipeListInteractor(ApiRepository recipeRepository){
        return new HeroeListInteractor(recipeRepository);
    }

    @Provides
    HeroeListAdapter provideHeroeListAdapter(){
        return new HeroeListAdapter();
    }

}
