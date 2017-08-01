package pl.kfrak.removal2app;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by RENT on 2017-08-01.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this); //realm korzysta z inicjacji w tej kjlasie, zeby nie trzeba tego robic przy kazdej nowej klasie itd; przekazujemy kontext calej aplikacji
    }
}
