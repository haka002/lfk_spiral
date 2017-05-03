package hu.i_host.thespiralkata.provider;

import android.app.Application;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import hu.i_host.thespiralkata.R;
import hu.i_host.thespiralkata.SpiralLine;
import hu.i_host.thespiralkata.SpiralTable;

@Module
class SpiralActivityModule {

    @Provides
    @Singleton
    ArrayAdapter provideArrrayAdapter(Application application) {
        return ArrayAdapter.createFromResource(application.getApplicationContext(), R.array.dimension_list,
                android.R.layout.simple_spinner_item);
    }

    @Provides
    @Singleton
    SpiralLine provideSpiralLine() {
        return new SpiralLine();
    }

    @Provides
    @Singleton
    SpiralTable provideSpiralTable(SpiralLine line, List<String> directionList) {
        return new SpiralTable(line, directionList);
    }

    @Provides
    @Singleton
    List<String> provideDirectionList() {
        List<String> list = new ArrayList<>();

        list.add("right");
        list.add("down");
        list.add("left");
        list.add("up");

        return list;
    }
}
