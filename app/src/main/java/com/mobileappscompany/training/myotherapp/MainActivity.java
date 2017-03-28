package com.mobileappscompany.training.myotherapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.mobileappscompany.training.myserviceapp.MyParcelable;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyParcelable myParcelable = getIntent().getParcelableExtra("parcelable");

        editText = (EditText) findViewById(R.id.editText);
        if(myParcelable != null)
            editText.setText(myParcelable.getText());
    }

    public void onGoB(View view){
        Intent returnIntent = new Intent();

        MyParcelable parcelable = new MyParcelable();
        parcelable.setText(editText.getText().toString());

        returnIntent.putExtra("parcelable",parcelable);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
