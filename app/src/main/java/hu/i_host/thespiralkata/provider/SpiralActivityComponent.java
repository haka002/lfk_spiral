package hu.i_host.thespiralkata.provider;

import javax.inject.Singleton;

import dagger.Component;
import hu.i_host.thespiralkata.SpiralActivity;

@Singleton
@Component(modules = {ApplicationModule.class, SpiralActivityModule.class})
public interface SpiralActivityComponent {
    void inject(SpiralActivity activity);
}
