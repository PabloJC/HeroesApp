package com.pabji.heroes.domain.features.heroeList;

import com.pabji.heroes.data.entities.ApiEntity;
import com.pabji.heroes.domain.base.BaseInteractor;
import com.pabji.heroes.domain.models.SuperHero;
import com.pabji.heroes.data.repositories.heroe.ApiRepository;
import com.pabji.heroes.domain.executor.RxInteractor;
import com.pabji.heroes.domain.callbacks.ResultCallback;
import com.pabji.heroes.domain.enums.ResultError;

import java.util.List;

import javax.inject.Inject;
import rx.Subscriber;

public class HeroeListInteractor extends RxInteractor<ApiEntity> implements BaseInteractor<List<SuperHero>> {

    private ApiRepository apiRepository;

    @Inject
    public HeroeListInteractor(ApiRepository apiRepository){
        this.apiRepository = apiRepository;
    }

    @Override
    public void run(final ResultCallback<List<SuperHero>> resultCallback) {
        execute(new Subscriber<ApiEntity>() {
            @Override
            public void onCompleted() {
                this.unsubscribe();
            }

            @Override
            public void onError(Throwable e) {
                this.unsubscribe();
                resultCallback.onError(ResultError.API_ERROR);
            }

            @Override
            public void onNext(ApiEntity apiEntity) {
                resultCallback.onSuccess(apiEntity.getSuperheroes());
            }
        }, apiRepository.getApiModel());
    }
}
