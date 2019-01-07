package id.co.mkamal.mkamalmobile.activity_pengacara;

import android.app.DatePickerDialog;
import android.content.Intent;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import id.co.mkamal.mkamalmobile.R;

public class TambahKegiatanActivity extends AppCompatActivity {


    private TextView mDisplayData;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    EditText tanggalKegiatanP;

    Button pindahkegiatan ;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kegiatan);

        tanggalKegiatanP = (EditText) findViewById(R.id.tanggalKegiatanP);
        myCalendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        tanggalKegiatanP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(TambahKegiatanActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        pindahkegiatan = (Button) findViewById(R.id.tambahkegiatanK);
        pindahkegiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(TambahKegiatanActivity.this, HomePengacaraActivity.class);
                startActivity(a);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        tanggalKegiatanP.setText(sdf.format(myCalendar.getTime()));
    }
}
