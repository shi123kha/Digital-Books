package com.example.artivatic.reddit;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    LoadAdapter loadAdapter;
    private static int id = 1;
    Realm myRealm;
    BookResponse bookResponse;
    BookResponse.Info info;
    RealmChangeListener realmChangeListener;
    private static ArrayList<DetailModel> personDetailsModelArrayList = new ArrayList<>();
    private DetailModel detailModel;
    private static MainActivity instance;
   // ApiService apiService;

    EditText title,url_image,description;

    FloatingActionButton floatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        bookResponse=new BookResponse();
        myRealm=Realm.getDefaultInstance();
        RealmStorage storage=new RealmStorage(myRealm);

        storage.retrieveFromDb();


        Call<BookResponse> call=new RestClient().getApiService().downloadBooks("1");
        call.enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                if(response.isSuccessful())
                {
                    if(response.body().getStatus()==1) {
                        for (int i = 0; i < response.body().getInfo().size(); i++) {
                             bookResponse=response.body();
                            DetailModel detailModel=new DetailModel();
                            detailModel.setTitle(bookResponse.getInfo().get(i).getTilte());
                            detailModel.setDescription(bookResponse.getInfo().get(i).getDescription());
                            detailModel.setImage(bookResponse.getInfo().get(i).getImage());
                            long time = System.currentTimeMillis();
                            detailModel.setId(time);
                            RealmStorage realmStorage = new RealmStorage(myRealm);
                            realmStorage.save(detailModel);



                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {

            }
        });


       initView();


        setPersonDetailsAdapter(storage);

    }



    private void initView() {
        listView=(ListView)findViewById(R.id.listview);
   floatingActionButton=(FloatingActionButton)findViewById(R.id.floatbutton);

    }
    private void setPersonDetailsAdapter(final RealmStorage storage)
    {
        Log.e("calling_apigetttt","");


        loadAdapter = new LoadAdapter(MainActivity.this, storage.getRefresh());
        listView.setAdapter(loadAdapter);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showInputDialog();
            }
        });

        realmChangeListener=new RealmChangeListener() {
            @Override
            public void onChange() {

                loadAdapter = new LoadAdapter(MainActivity.this, storage.getRefresh());
                listView.setAdapter(loadAdapter);
            }

        };
        myRealm.addChangeListener(realmChangeListener);

    }



    private  void showInputDialog() {
        Dialog dialog = new Dialog(this);

        dialog.setTitle("ADD DATA");
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setContentView(R.layout.input_dialog);
        title = (EditText) dialog.findViewById(R.id.et_title);
        description = (EditText) dialog.findViewById(R.id.et_description);
        url_image = (EditText) dialog.findViewById(R.id.et_url);
        Button save = (Button) dialog.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title_data = title.getText().toString();
                String descrip = description.getText().toString();
                String url = url_image.getText().toString();
                if (title_data != null && title_data.length() != 0) {
                    //set the data in Detailmode(realm object)
                    DetailModel detailModel = new DetailModel();

                    detailModel.setTitle(title_data);
                    detailModel.setDescription(descrip);
                    detailModel.setImage(url);
                    long time= System.currentTimeMillis();
                    detailModel.setId(time);

                    RealmStorage realmStorage = new RealmStorage(myRealm);

                    if (realmStorage.save(detailModel)) {
                        title.setText("");
                        description.setText("");
                        url_image.setText("");

                    } else {
                        Toast.makeText(getApplicationContext(), "input is not valid", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "title is not empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        myRealm.removeChangeListener(realmChangeListener);
        myRealm.close();
    }
}
