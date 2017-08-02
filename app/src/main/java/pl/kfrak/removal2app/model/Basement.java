package pl.kfrak.removal2app.model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by RENT on 2017-08-01.
 */

public class Basement extends RealmObject {

    @PrimaryKey
    private int id;

    private RealmList<Item> items;
    private String name;

    public Basement() {
        //leave empty, realm
    }

    public Basement(int id, RealmList<Item> items, String name) {
        this.id = id;
        this.items = items;
        this.name = name;
    }
}
