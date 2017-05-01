package hu.i_host.thespiralkata;

import android.app.Application;
import android.content.Context;

import hu.i_host.thespiralkata.provider.ApplicationModule;
import hu.i_host.thespiralkata.provider.DaggerSpiralActivityComponent;
import hu.i_host.thespiralkata.provider.SpiralActivityComponent;

public class MainApplication extends Application {

   protected SpiralActivityComponent mSpiralActivityComponent;

   public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // We can not add those modules which don't have parameter in the constructor.
        mSpiralActivityComponent = DaggerSpiralActivityComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public SpiralActivityComponent getSpiralActivityComponent(){
        return mSpiralActivityComponent;
    }
}