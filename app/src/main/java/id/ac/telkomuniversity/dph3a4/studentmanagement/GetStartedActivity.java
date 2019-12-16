package id.ac.telkomuniversity.dph3a4.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GetStartedActivity extends AppCompatActivity {

    Button btn_sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        Preference pref = new Preference(getApplicationContext());
        if(pref.getUserLoggedIn()){
            Intent gotohome = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(gotohome);
            finish();
        }

        btn_sign_in = findViewById(R.id.btn_sign_in);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLogin = new Intent(GetStartedActivity.this, LoginActivity.class);
                startActivity(goToLogin);
            }
        });
    }
}
