package com.pabji.heroes.domain.features.heroDetail;

import com.pabji.heroes.data.entities.ApiEntity;
import com.pabji.heroes.data.repositories.heroe.ApiRepository;
import com.pabji.heroes.domain.base.BaseInteractor;
import com.pabji.heroes.domain.callbacks.ResultCallback;
import com.pabji.heroes.domain.enums.ResultError;
import com.pabji.heroes.domain.executor.RxInteractor;
import com.pabji.heroes.domain.models.SuperHero;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

public class HeroDetailInteractor implements BaseInteractor<SuperHero> {

    private ApiRepository apiRepository;

    @Inject
    public HeroDetailInteractor(ApiRepository apiRepository){
        this.apiRepository = apiRepository;
    }

    @Override
    public void run(final ResultCallback<SuperHero> resultCallback) {
        SuperHero superHero = this.apiRepository.getCurrentHero();

        if(superHero == null){
            resultCallback.onError(ResultError.NO_DATA);
        }else{
            resultCallback.onSuccess(superHero);
        }
    }

    public void setCurrentHero(SuperHero superHero) {
        this.apiRepository.setCurrentHero(superHero);
    }
}
