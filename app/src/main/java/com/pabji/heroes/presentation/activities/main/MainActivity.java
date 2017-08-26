package com.pabji.heroes.presentation.activities.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.pabji.heroes.R;
import com.pabji.heroes.presentation.base.BaseActivity;
import com.pabji.heroes.presentation.di.HasComponent;
import com.pabji.heroes.presentation.fragments.HeroListFragment;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent> {

    private MainComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(R.id.fragment_container, HeroListFragment.newInstance());
    }

    @Override
    protected void initInjector() {
        this.component = DaggerMainComponent.builder().appComponent(getInjector()).build();
    }

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public MainComponent getComponent() {
        return component;
    }
}
