package com.example.artivatic.reddit;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by artivatic on 30/3/17.
 */

public class RealmStorage {
    Realm realm;
    RealmResults<DetailModel> detailModels;
    Boolean saved = null;

    public RealmStorage(Realm realm) {
        this.realm = realm;
    }

    public boolean save(final DetailModel detailModel) {
        if (detailModel == null) {
            saved = false;
        } else {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    try {
                        DetailModel d=realm.copyToRealm(detailModel);
                        saved=true;

                    } catch (Exception e) {
                        e.printStackTrace();
                        saved=false;

                    }
                }
            });
        }
        return  saved;

    }
    public void retrieveFromDb()
    {
        detailModels=realm.where(DetailModel.class).findAll();
    }
    public ArrayList<DetailModel> getRefresh()
    {
        ArrayList<DetailModel> insert=new ArrayList<>();
        for(DetailModel d:detailModels )
        {
           insert.add(d);

        }
        return  insert;
    }


}