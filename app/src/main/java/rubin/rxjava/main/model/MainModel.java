package rubin.rxjava.main.model;

import java.util.List;

import rubin.rxjava.MainContract;
import rubin.rxjava.api.RestAPI;
import rx.Observable;

/**
 * Class for Project RxJava
 * Created on 10/05/2017.
 */

public class MainModel implements MainContract.IModel {

    public MainModel() {
        new RestAPI();
    }

    @Override
    public Observable<List<Post>> getAllPosts() {
        return RestAPI.openAPI.getAllPosts();
    }
}
