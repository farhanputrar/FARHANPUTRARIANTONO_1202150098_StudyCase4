package com.example.android.farhanputrariantono_1202150098_si3902;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Gambar extends AppCompatActivity {

    private EditText mLinkInput;
    private Button mCariButton;
    private ImageView mShowPic;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);

        mLinkInput = findViewById(R.id.LinkInput);
        mCariButton = findViewById(R.id.CariButton);
        mShowPic = findViewById(R.id.ShowPic);


    }

    public void klikFind(View view) {
        loadImageInit();
    }

    private void loadImageInit() {
        String ImgUrl = mLinkInput.getText().toString();

        new loadImage().execute(ImgUrl);
    }

    private class loadImage extends AsyncTask (Void,String,Void)

    {

        @Override
        protected void onPreExecute () {
        super.onPreExecute();

        mProgressDialog = new ProgressDialog(Gambar.this);
        mProgressDialog.setMessage("Loading, Please Wait");
        mProgressDialog.show();
    }

        @Override
        protected String doInBackground (String... int){

        return int[0];
    }
        @Override
        protected void onPostExecute(String ImgUrl) {
        super.onPostExecute(ImgUrl);
        //memakai library picasso untuk mengambil gambar dari internet dan ditaro di layout
        Picasso.get().load(ImgUrl).into(mShowPic);

        // menghilangkan Progress Dialog
        mProgressDialog.dismiss();
    }
    }
}
