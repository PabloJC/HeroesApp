package com.pabji.heroes.data.repositories.heroe;

import com.pabji.heroes.data.base.BaseRepository;
import com.pabji.heroes.data.entities.ApiEntity;
import com.pabji.heroes.data.net.ApiClient;
import com.pabji.heroes.data.net.ApiEndPoints;
import com.pabji.heroes.domain.models.SuperHero;

import javax.inject.Inject;

import rx.Observable;


public class ApiRepositoryImpl extends BaseRepository implements ApiRepository {

    private final ApiEndPoints service;
    private SuperHero currentHero;

    @Inject
    public ApiRepositoryImpl(){
        service = ApiClient.createService(ApiEndPoints.class);
    }

    @Override
    public Observable<ApiEntity> getApiModel() {
        return service.getApiModel();
    }

    @Override
    public void setCurrentHero(SuperHero superHero) {
        this.currentHero = superHero;
    }

    @Override
    public SuperHero getCurrentHero() {
        return currentHero;
    }
}