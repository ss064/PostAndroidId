package com.example.suzukisusumu_sist.postandroidid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class postActivity extends AppCompatActivity {
    public TextView androidId;
    public EditText name;
    public Button submit;
    private AsyncHttp asynchttp;
    public EditText t_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        androidId=(TextView)findViewById(R.id.androidid);
        androidId.setText(android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID));
        name = (EditText) findViewById(R.id.editText);
        t_name =(EditText) findViewById(R.id.t_name);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty()==false && t_name.getText().toString().isEmpty()==false){
                    asynchttp = new AsyncHttp(android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID),name.getText().toString(),t_name.getText().toString());
                    asynchttp.execute();
                    Toast.makeText(postActivity.this,"submit",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(postActivity.this,"送信エラー",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
