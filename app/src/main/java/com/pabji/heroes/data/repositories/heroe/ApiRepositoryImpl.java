package com.pabji.heroes.data.repositories.heroe;

import com.pabji.heroes.data.base.BaseRepository;
import com.pabji.heroes.data.entities.ApiEntity;
import com.pabji.heroes.data.net.ApiClient;
import com.pabji.heroes.data.net.ApiEndPoints;

import javax.inject.Inject;

import rx.Observable;


public class ApiRepositoryImpl extends BaseRepository implements ApiRepository {

    private final ApiEndPoints service;

    @Inject
    public ApiRepositoryImpl(){
        service = ApiClient.createService(ApiEndPoints.class);
    }

    @Override
    public Observable<ApiEntity> getApiModel() {
        return service.getApiModel();
    }
}