package com.artemzin.qualitymatters.items.ui;

import android.support.annotation.NonNull;

import com.artemzin.qualitymatters.items.entities.Item;
import com.artemzin.qualitymatters.performance.AnyThread;

import java.util.List;

/**
 * Main purpose of such interfaces — hide details of View implementation,
 * such as hundred methods of {@link android.support.v4.app.Fragment}.
 */
public interface ItemsView {

    // Presenter does not know about Main Thread. It's a detail of View implementation!
    @AnyThread
    void showLoadingUi();

    @AnyThread
    void showErrorUi(@NonNull Throwable error);

    @AnyThread
    void showContentUi(@NonNull List<Item> items);
}
