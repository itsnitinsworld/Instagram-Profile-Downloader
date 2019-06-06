package com.blackpaper.InstaDownload.stories.profile.post.download;


import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.facebook.stetho.Stetho;

import org.acra.ACRA;
import org.acra.config.ACRAConfiguration;
import org.acra.config.ACRAConfigurationException;
import org.acra.config.ConfigurationBuilder;
import org.acra.sender.ReportSenderFactory;

import com.blackpaper.InstaDownload.stories.profile.post.download.data.prefs.PreferencesManager;
import com.blackpaper.InstaDownload.stories.profile.post.download.data.repositry.DataObjectRepositry;
import com.blackpaper.InstaDownload.stories.profile.post.download.helper.report.AcraReportSenderFactory;
import com.blackpaper.InstaDownload.stories.profile.post.download.helper.report.ErrorActivity;
import com.blackpaper.InstaDownload.stories.profile.post.download.helper.report.UserAction;


public class AppController extends MultiDexApplication {
    @SuppressWarnings("unchecked")
    private static final Class<? extends ReportSenderFactory>[]
            reportSenderFactoryClasses = new Class[]{AcraReportSenderFactory.class};

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

        PreferencesManager.init(this);
        DataObjectRepositry.init(this);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        initACRA();
    }

    private void initACRA() {
        try {
            final ACRAConfiguration acraConfig = new ConfigurationBuilder(this)
                    .setReportSenderFactoryClasses(reportSenderFactoryClasses)
                    .setBuildConfigClass(BuildConfig.class)
                    .build();
            ACRA.init(this, acraConfig);
        } catch (ACRAConfigurationException ace) {
            ace.printStackTrace();
            ErrorActivity.reportError(this,
                    ace,
                    null,
                    null,
                    ErrorActivity.ErrorInfo.make(UserAction.SOMETHING_ELSE, "none",
                            "Could not initialize ACRA crash report", R.string.app_ui_crash));
        }
    }
}