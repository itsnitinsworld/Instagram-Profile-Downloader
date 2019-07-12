package com.storyPost.PhotoVideoDownloader.base.mvp;


import androidx.annotation.StringRes;

public interface MvpView {

    void showLoading();

    void hideLoading();

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    void onError(String message);

    void onError(@StringRes int resId);

    void showSnackBar(@StringRes int resId);

    void showSnackBar(String message);

    boolean isNetworkConnected();

    void hideKeyboard();

    void showDialogAndFinishActivity(String resId);

    void showDialogAndMoveToDashborad(String resId);

    void showLogoutalert();


}
