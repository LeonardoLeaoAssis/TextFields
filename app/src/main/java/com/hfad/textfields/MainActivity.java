package com.hfad.textfields;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtlayout_email)
    public TextInputLayout txtlayout_email;

    @BindView(R.id.txtlayout_password)
    public TextInputLayout txtlayout_password;

    @BindView(R.id.edt_email)
    public AppCompatEditText edt_email;

    @BindView(R.id.edt_password)
    public AppCompatEditText edt_password;

    @BindView(R.id.btn_login)
    public Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void onClickLogin(View view) {
        validaForm();
    }

    private void validaForm() {
        if (edt_email.getText().toString().isEmpty()) {
            txtlayout_email.setErrorEnabled(true);
            txtlayout_email.setError(getString(R.string.msg_email));
        } else {
            txtlayout_email.setErrorEnabled(false);
        }

        if (edt_password.getText().toString().isEmpty()) {
            txtlayout_password.setErrorEnabled(true);
            txtlayout_password.setError(getString(R.string.msg_password));
        } else {
            txtlayout_password.setErrorEnabled(false);
        }

        if (!txtlayout_email.isErrorEnabled() && !txtlayout_password.isErrorEnabled()) {
            Toast.makeText(getApplicationContext(), "Login realizado com sucesso.", Toast.LENGTH_LONG).show();
        }
    }

}
