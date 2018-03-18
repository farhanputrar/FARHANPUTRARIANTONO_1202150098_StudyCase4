package com.example.android.farhanputrariantono_1202150098_si3902;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private ListView mListNama;
    private ProgressBar mBarProgress;
    private Button mStartAsyncTask;

    private String[] ListNamaArray = {
            "Ant Man", "Black Panther", "Captain America", "Daredevil", "Elektra", "Falcon", "Ghost Rider", "Hulk", "Iron Man"
            , "Jessica Jones", "Magneto", "Wolverine"}; //deklarasi array

    private AddItemtoViewList AddItemtoViewList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mListNama = (ListView) findViewById(R.id.ListNama);
        mBarProgress = (ProgressBar) findViewById(R.id.ProgressBar);
        mStartAsyncTask = (Button) findViewById(R.id.btnMulai);

        mListNama.setAdapter(new ArrayAdapter<String>(getApplicationContext()this, android.R.layout.simple_list_item_1, new ArrayList<String>()));

        mStartAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //memproses adapter dengan asynctask
                mAddItemtoViewList = new AddItemToViewList();
                mAddItemToViewList.execute();
            }
        });

    }

    public void AddItemToViewList extends AsyncTask<Void, String, Void> {

        private ArrayAdapter<String> mAdapter;
        private int counter = 1;
        ProgressDialog mProgressDialog = new ProgressDialog(Home.this);
        @Override
        protected void onPreExecute() {
            mAdapter = (ArrayAdapter<String>) mListNama.getAdapter(); //casting suggestion
            //isi progress dialog
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setTitle("Loading Data");
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Please wait....");
            mProgressDialog.setProgress(0);
            mProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Membatalkan Proses", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mAddItemToViewList.cancel(true);
                    mBarProgress.setVisibility(View.VISIBLE);
                    dialog.dismiss();
                }
            });
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void, String, Void) {
            for (String item : ListNamaArray) {
                publishProgress(item);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (isCancelled()) {
                    mAddItemToListView.cancel(true);
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            mAdapter.add(values[0]);

            Integer current_status = (int) ((counter / (float) ListNamaArray.length) * 100);
            mBarProgress.setProgress(current_status);


            mProgressDialog.setProgress(current_status);

            //set message will not working when using horizontal loading
            mProgressDialog.setMessage(String.valueOf(current_status + "%"));
            counter++;
        }

        @Override
        protected void onPostExecute(Void) {
            //hide progreebar
            mBarProgress.setVisibility(View.GONE);

            //remove progress dialog
            mProgressDialog.dismiss();
            mListNama.setVisibility(View.VISIBLE);
        }

    }
}
