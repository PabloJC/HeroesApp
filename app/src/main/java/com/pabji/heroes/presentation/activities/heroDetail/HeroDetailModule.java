package com.pabji.heroes.presentation.activities.heroDetail;

import com.pabji.heroes.data.repositories.heroe.ApiRepository;
import com.pabji.heroes.domain.features.heroDetail.HeroDetailInteractor;
import com.pabji.heroes.domain.features.heroDetail.HeroDetailPresenter;
import com.pabji.heroes.domain.features.heroList.HeroListInteractor;
import com.pabji.heroes.presentation.adapters.HeroListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class HeroDetailModule {
    public HeroDetailModule(){}

    @Provides
    HeroDetailInteractor provideRecipeDetailInteractor(ApiRepository apiRepository){
        return new HeroDetailInteractor(apiRepository);
    }


}
