package in.blackpaper.instasp.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import in.blackpaper.instasp.base.mvp.MvpView;
import okhttp3.RequestBody;

public class BaseFragment extends Fragment implements MvpView {

    private ProgressDialog mProgressDialog;
    private Context context;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage("Loading,Please wait...");
        mProgressDialog.setTitle("Loading");
        mProgressDialog.setCancelable(false);
        mProgressDialog.setCanceledOnTouchOutside(false);


    }

    @Override
    public void showLoading() {
        if (mProgressDialog != null) {
            hideLoading();
            mProgressDialog.show();
        }
    }


    @Override
    public void hideLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void showSnackBar(int resId) {

    }

    @Override
    public void showSnackBar(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }

    @Override
    public void showDialogAndFinishActivity(String resId) {

    }

    @Override
    public void showDialogAndMoveToDashborad(String resId) {

    }

    @Override
    public void showLogoutalert() {

    }

    @Override
    public RequestBody generateStringFromRequestBody(String value) {
        return null;
    }
}
