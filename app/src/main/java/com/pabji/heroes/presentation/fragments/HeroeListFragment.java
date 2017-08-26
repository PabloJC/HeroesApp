package com.pabji.heroes.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabji.heroes.R;
import com.pabji.heroes.domain.models.SuperHero;
import com.pabji.heroes.domain.features.heroList.HeroeListPresenter;
import com.pabji.heroes.domain.features.heroList.HeroeListView;
import com.pabji.heroes.presentation.activities.main.MainComponent;
import com.pabji.heroes.presentation.adapters.HeroListAdapter;
import com.pabji.heroes.presentation.base.BaseMVPFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HeroeListFragment extends BaseMVPFragment<HeroeListPresenter,HeroeListView> implements HeroeListView, HeroListAdapter.HeroListListener {

    @Inject
    HeroListAdapter recipeListAdapter;

    @BindView(R.id.rv_heroe_list)
    RecyclerView rv_heroeList;

    private Unbinder unbind;
    private MainComponent component;

    public static HeroeListFragment newInstance() {
        return new HeroeListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hero_list, viewGroup, false);
        unbind = ButterKnife.bind(this,view);
        injectFragment();
        return view;
    }

    private void injectFragment() {
        component = getComponent(MainComponent.class);
        component.inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecyclerView();
        presenter.init(getContext());
    }

    private void initRecyclerView() {
        rv_heroeList.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rv_heroeList.setAdapter(recipeListAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind.unbind();
    }

    @NonNull
    @Override
    public HeroeListPresenter createPresenter() {
        return component.heroeListPresenter();
    }

    @Override
    public void showList(List<SuperHero> superHeros) {
        recipeListAdapter.setData(superHeros, this);
    }

    @Override
    public void openDetail(SuperHero superHero) {
        presenter.openDetail(superHero);
    }
}

