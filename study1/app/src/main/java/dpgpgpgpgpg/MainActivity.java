package dpgpgpgpgpg;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.gang.dpgpgpgpgpg.R;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_email, TextInputEditText_Password;
    LinearLayout LinearLayout_LoginButton;
    String emailOk = "1234";
    String passwordOk = "1234";

    String inputEmail = "";
    String inputPassword = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        TextInputEditText_email = findViewById(R.id.TextInputEdit_Email);
        TextInputEditText_Password = findViewById(R.id.TextInputEdit_Password);
        LinearLayout_LoginButton = findViewById(R.id.LinearLayout_LoginButton);

        //1. 값을 가져온다  -> 값을 검사한다.(이메일 123@naver.com // 비번 1234)
        //2. 클릭을 감지
        //3. 1번의 값을 다음 액티비티로 넘긴다.
        LinearLayout_LoginButton.setClickable(false);


        //로그인체크 이벤트
        TextInputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Log.d("Senti", s + "," +count);
                if(s != null){
                    inputEmail = s.toString();
                    LinearLayout_LoginButton.setClickable(validaction());
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        TextInputEditText_Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Log.d("Senti", s + "," +count);
                if(s != null){
                    inputPassword = s.toString();
                    LinearLayout_LoginButton.setClickable(validaction());
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
//        LinearLayout_LoginButton.setClickable(true);
        LinearLayout_LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String userEmail = TextInputEditText_email.getText().toString();
               String userPassword = TextInputEditText_Password.getText().toString();

               Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);
               intent.putExtra("userEmail", userEmail);
               intent.putExtra("userPassword", userPassword);
               startActivity(intent);
            }
        });
    }

    public boolean validaction(){
        Log.d("Senti", inputEmail+"//"+(inputPassword.equals(passwordOk)) +"//"+(inputEmail.equals(emailOk))) ;
        return inputEmail.equals(emailOk) && inputPassword.equals(passwordOk);
    }

}
