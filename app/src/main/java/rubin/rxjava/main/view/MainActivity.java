package rubin.rxjava.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rubin.rxjava.MainContract;
import rubin.rxjava.R;
import rubin.rxjava.main.adapter.PostAdapter;
import rubin.rxjava.main.model.Post;
import rubin.rxjava.main.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.IView {

    @BindView(R.id.postRV)
    RecyclerView postRV;

    private MainPresenter presenter;
    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        ButterKnife.bind(this);

        postRV.setLayoutManager(new LinearLayoutManager(this));

        presenter = new MainPresenter(this);
        presenter.getData();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayData(List<Post> postList) {
        adapter = new PostAdapter(postList);
        postRV.setAdapter(adapter);
    }
}
