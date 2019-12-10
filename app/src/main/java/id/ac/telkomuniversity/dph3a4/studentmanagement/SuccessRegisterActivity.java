package id.ac.telkomuniversity.dph3a4.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessRegisterActivity extends AppCompatActivity {

    Button btn_goLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);

        btn_goLogin = findViewById(R.id.btn_goLogin);
        btn_goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotologin = new Intent(SuccessRegisterActivity.this, LoginActivity.class);
                startActivity(gotologin);
            }
        });
    }
}