package com.pabji.heroes.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pabji.heroes.R;
import com.pabji.heroes.domain.features.heroList.HeroListPresenter;
import com.pabji.heroes.domain.features.heroList.HeroListView;
import com.pabji.heroes.domain.models.SuperHero;
import com.pabji.heroes.presentation.activities.main.MainComponent;
import com.pabji.heroes.presentation.adapters.HeroListAdapter;
import com.pabji.heroes.presentation.base.BaseMVPFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HeroListFragment extends BaseMVPFragment<HeroListPresenter,HeroListView> implements HeroListView, HeroListAdapter.HeroListListener {

    @Inject
    HeroListAdapter recipeListAdapter;

    @BindView(R.id.rv_heroe_list)
    RecyclerView rv_heroeList;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private Unbinder unbind;
    private MainComponent component;
    private ArrayList<SuperHero> heroList = new ArrayList<>();

    public static HeroListFragment newInstance() {
        return new HeroListFragment();
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

        if(savedInstanceState != null){
            heroList = savedInstanceState.getParcelableArrayList("heroList");
            showList(heroList);
        }else{
            presenter.init();
        }

    }

    private void initRecyclerView() {
        rv_heroeList.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rv_heroeList.setAdapter(recipeListAdapter);

        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        presenter.init();
                    }
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind.unbind();
    }

    @NonNull
    @Override
    public HeroListPresenter createPresenter() {
        return component.heroeListPresenter();
    }

    @Override
    public void showList(List<SuperHero> superHeros) {
        recipeListAdapter.setData(superHeros, this);
        this.heroList = new ArrayList<>(superHeros);
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void dismissLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void openDetail(SuperHero superHero) {
        presenter.openDetail(superHero);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("heroList",heroList);
    }
}

