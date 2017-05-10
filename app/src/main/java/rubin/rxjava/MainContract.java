package rubin.rxjava;

import java.util.List;

import rubin.rxjava.main.model.Post;
import rx.Observable;

/**
 * Class for Project RxJava
 * Created on 10/05/2017.
 */

public interface MainContract {

    interface IView {
        void showToast(String message);

        void displayData(List<Post> postList);
    }

    interface IPresenter {
        void getData();
    }

    interface IModel {
        Observable<List<Post>> getAllPosts();
    }
}
