package com.amparo.films;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText et_email, et_password;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        //Preferences
        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
    }

    //Enter button
    public void enterPressed(View view) {

        //Pickup  text of EditText
        String sMail = et_email.getText().toString();
        String sPassword = et_password.getText().toString();

        //check mail+password and go to MainActivity(al fer finish)
        if (checkFields()) {
            saveShared();
            finish();
        }
    }

    //check empty fields and show Toast
    public boolean checkFields() {
        boolean fieldsOk = true;

        if ("".equals(et_email.getText().toString())) {
            fieldsOk = false;
            Toast.makeText(this, getString(R.string.userKO), Toast.LENGTH_LONG).show();
            //et_email.setError(getString(R.string.errEmptyEmail));
        }
        if ("".equals(et_password.getText().toString())) {
            fieldsOk = false;
            Toast.makeText(this, getString(R.string.userKO), Toast.LENGTH_LONG).show();
            //et_password.setError(getString(R.string.errEmptyPassword));
        }
        return fieldsOk;
    }

/*esborrar
    //Go to Main Activity
    public void goToMainActivity (){
        Intent i = new Intent(this, MainActivity.class);
        startActivity (i);
    }
*/

    //open view on navigator
    public void goToWeb(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.abc.es/play/cine/peliculas/"));
        startActivity(i);
    }

    //save preferences
    public void saveShared(){
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("valor", et_email.getText().toString());

        editor.commit();
    }
}
