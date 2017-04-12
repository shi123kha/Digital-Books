package com.example.artivatic.reddit;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.media.tv.TvInputService;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by artivatic on 5/4/17.
 */

public class SplashActivity extends Activity {
    CallbackManager callbackManager;
    LoginButton fbLoginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_splash);
        Log.e("value_fbbbbb","");
        callbackManager = CallbackManager.Factory.create();
        Log.e("value_fbbbbb","");

        initFB();
    }



    private void initFB() {
        {
            if (!isFinishing()) {

                fbLoginButton = (LoginButton) findViewById(R.id.login_button);
                fbLoginButton.setCompoundDrawablePadding(0);
                fbLoginButton.setText("Connect With Facebook");
                Log.e("init_fbbb","");

                fbLoginButton.setReadPermissions(Arrays.asList("public_profile,user_friends, email, user_birthday, user_hometown, user_location, user_friends, user_work_history, user_education_history, user_photos, user_relationships,user_likes"));


                fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse) {
                                        if (!isFinishing()) {

                                            Log.d("TAG", graphResponse.toString());
                                            final JSONObject JSONobj = graphResponse.getJSONObject();
                                            Log.d("TAG", "response+fb" + JSONobj.toString());
                                            Bundle bundle = new Bundle();
                                            bundle.putInt("limit", 5000);
                                            try
                                            {
                                                new GraphRequest(
                                                        AccessToken.getCurrentAccessToken(),
                                                        "/" + JSONobj.getString("id") + "/friends",
                                                        bundle,
                                                        HttpMethod.GET,
                                                        new GraphRequest.Callback() {
                                                            public void onCompleted(GraphResponse response) {
                                                                Log.e("LOGGER+friends", response.getJSONObject().toString());
                                                                JSONObject JSONobj1 = response.getJSONObject();
                                                                ArrayList<String> friends = null;
                                                                try {
                                                                    JSONArray jsonArray = JSONobj1.getJSONArray("data");
                                                                    Intent i1=new Intent(SplashActivity.this,MainActivity.class);

                                                                    startActivity(i1);
                                                                   // setupMemberRegistrationRequestData(JSONobj, s);
                                                                } catch (JSONException e) {
                                                                    e.printStackTrace();
                                                                }
                                                                Log.e("sonaray", "array");


                                                            }
                                                        }
                                                ).executeAsync();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }


//                                checkUserExists();

                                        }
                                    }
                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id, name, first_name, last_name,age_range,gender,email,birthday,hometown,location,photos,work,education");


                        request.setParameters(parameters);
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {
                    }

                    @Override
                    public void onError(FacebookException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
