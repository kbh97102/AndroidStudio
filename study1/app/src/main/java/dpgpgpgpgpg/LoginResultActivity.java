package dpgpgpgpgpg;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gang.dpgpgpgpgpg.R;

public class LoginResultActivity extends AppCompatActivity {

    TextView TextView_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView_get = findViewById(R.id.TextView_get);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String email = bundle.getString("userEmail");
        String password =  bundle.getString("userPassword");


        TextView_get.setText(email+" / "+password);

    }

    }




