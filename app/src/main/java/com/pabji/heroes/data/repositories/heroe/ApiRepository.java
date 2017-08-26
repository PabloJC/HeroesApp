package com.pabji.heroes.data.repositories.heroe;

import com.pabji.heroes.data.entities.ApiEntity;

import rx.Observable;

public interface ApiRepository {
    Observable<ApiEntity> getApiModel();
}