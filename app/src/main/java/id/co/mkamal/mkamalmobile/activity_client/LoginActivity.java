package id.co.mkamal.mkamalmobile.activity_client;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.co.mkamal.mkamalmobile.API.MobileAPI;
import id.co.mkamal.mkamalmobile.Base.BaseActivity;
import id.co.mkamal.mkamalmobile.R;
import id.co.mkamal.mkamalmobile.Response.ResponseLogin;
import id.co.mkamal.mkamalmobile.Utils.AppConstants;
import id.co.mkamal.mkamalmobile.activity_pengacara.HomePengacaraActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends BaseActivity {
    EditText idlogin ,passwordlogin;
    Button btn;
    Button btnloginstaf;

    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idlogin = (EditText) findViewById(R.id.idlogin);
        passwordlogin = (EditText) findViewById(R.id.passwordlogin);

        btn = (Button)findViewById(R.id.btnlogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. membuat progress dialog
                progress = new ProgressDialog(LoginActivity.this);
                progress.setCancelable(false);
                progress.setMessage("Loading ...");
                progress.show();

                //mengambil data textview
                String username_request = idlogin.getText().toString();
                String password_request = passwordlogin.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(AppConstants.BaseUrl) //api
                        .addConverterFactory(GsonConverterFactory.create()) //bawaan . untuk json
                        .build();

                MobileAPI api = retrofit.create(MobileAPI.class); //menghubungkan ke mobileAPI
                Call<ResponseLogin> call = api.login(username_request, password_request);//panggil fungsi get
                call.enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        progress.dismiss();//clear progress dialog

                        String respon = response.body().getResponse_code();
                        String level= response.body().getLevel();
                        if (respon.equals(AppConstants.SUCCESS)){
                            ResponseLogin objectResponse = (ResponseLogin) response.body(); //ambil semua nilai dalam response bode dan dipindah ke login response dengan nama objectResponse

                            loginSession.setParam(objectResponse.getIdamin(), objectResponse.getNamalengkap(),objectResponse.getLevel());


                            if (level.equals(AppConstants.PENGACARA)){
                                Intent a = new Intent(LoginActivity.this, HomePengacaraActivity.class);
                                a.putExtra(AppConstants.INTENT_DATA,(Parcelable) objectResponse);
                                startActivity(a);
                                finish();


                            }else if (level.equals(AppConstants.CLIENT)){
                                Intent a = new Intent(LoginActivity.this, HomeClientActivity.class);
                                startActivity(a);
                                finish();
                            }else{
                                Toast.makeText(LoginActivity.this, level+" Tidak memiliki hak akses login", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if (respon.equals(AppConstants.FAILED)){
                            Toast.makeText(LoginActivity.this, "Username / Password Salah", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Isi Data", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Gagal", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

    }
}
