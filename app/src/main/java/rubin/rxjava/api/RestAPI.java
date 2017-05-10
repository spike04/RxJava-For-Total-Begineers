package rubin.rxjava.api;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rubin.rxjava.main.model.Post;
import rx.Observable;

/**
 * Class for Project RxJava
 * Created on 10/05/2017.
 */

public class RestAPI {

    public static OpenAPI openAPI;

    public RestAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        openAPI = retrofit.create(OpenAPI.class);

    }

    public interface OpenAPI {
        @GET("/posts")
        Observable<List<Post>> getAllPosts();
    }
}
