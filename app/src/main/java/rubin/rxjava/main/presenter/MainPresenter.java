package rubin.rxjava.main.presenter;

import java.util.List;

import rubin.rxjava.MainContract;
import rubin.rxjava.main.model.MainModel;
import rubin.rxjava.main.model.Post;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Class for Project RxJava
 * Created on 10/05/2017.
 */

public class MainPresenter implements MainContract.IPresenter {

    private MainContract.IView view;
    private MainContract.IModel model;

    public MainPresenter(MainContract.IView view) {
        this.view = view;
        this.model = new MainModel();
    }

    @Override
    public void getData() {
        model.getAllPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {
                        view.showToast("Data Obtained");
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showToast("Error Occured. Please Check Log");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        view.displayData(posts);
                    }
                });
    }
}
