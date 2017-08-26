package com.pabji.heroes.presentation.di;

/**
 * Component for dagger
 */
public interface HasComponent<C> {
    C getComponent();
}
