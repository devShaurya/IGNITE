package com.example.ignite;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class DeveloperActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(getDrawable(R.drawable.newgrad));

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lineardev);
        ImageButton btn1 = (ImageButton)findViewById(R.id.btn_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/anshuman-yadav-319694153/"));
                startActivity(i);
            }
        });
        ImageButton btn2 = (ImageButton)findViewById(R.id.btn_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/shaurya-agarawal-286415155/"));
                startActivity(i);
            }
        });

//

    }
}