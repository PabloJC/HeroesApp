package com.pabji.heroes.domain.features.heroList;

import android.content.Context;

import com.pabji.heroes.domain.callbacks.ResultCallback;
import com.pabji.heroes.domain.enums.ResultError;
import com.pabji.heroes.domain.features.heroDetail.HeroDetailInteractor;
import com.pabji.heroes.domain.models.SuperHero;
import com.pabji.heroes.presentation.navigation.Router;

import net.bytebuddy.implementation.bind.annotation.Super;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class HeroListPresenterTest {

    private HeroListPresenter heroListPresenter;

    @Mock
    private HeroListView mockHeroListView;
    @Mock
    private Router mockRouter;
    @Mock private HeroListInteractor mockHeroListIteractor;

    @Mock private HeroDetailInteractor mockDetailIteractor;

    @Mock private Context mockContext;

    @Captor
    private ArgumentCaptor<ResultCallback<List<SuperHero>>> loadListCaptor;

    private static List<SuperHero> LIST = Arrays.asList(
            new SuperHero("Name1","Photo1","RealName1","Height1","Power1","Abilities1","Groups1"),
            new SuperHero("Name2","Photo2","RealName2","Height2","Power2","Abilities2","Groups2"),
            new SuperHero("Name3","Photo3","RealName3","Height3","Power3","Abilities3","Groups3"));

    private static final String ERROR = "ERROR";


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        heroListPresenter = new HeroListPresenter(mockRouter,mockHeroListIteractor,mockDetailIteractor);
        heroListPresenter.attachView(mockHeroListView);
    }

    @Test
    public void initShowList() throws Exception {

        heroListPresenter.init(mockContext);
        verify(mockHeroListIteractor).run(loadListCaptor.capture());

        loadListCaptor.getValue().onSuccess(LIST);
        verify(mockHeroListView).showList(LIST);
    }

    @Test
    public void initShowError() throws Exception {

        heroListPresenter.init(mockContext);

        verify(mockHeroListIteractor).run(loadListCaptor.capture());
        loadListCaptor.getValue().onError(ResultError.API_ERROR);
        verify(mockHeroListView).showError(ERROR);
    }

    @Test
    public void openDetail() throws Exception {
        SuperHero superHero = new SuperHero();

        heroListPresenter.openDetail(superHero);

        verify(mockDetailIteractor).setCurrentHero(superHero);
        verify(mockRouter).goToHeroDetail();
    }

}