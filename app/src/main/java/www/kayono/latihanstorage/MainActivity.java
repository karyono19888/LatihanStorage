package www.kayono.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Internal(View view) {
        setContentView(R.layout.activity_internal);
    }

    public void External(View view) {
        setContentView(R.layout.activity_external);
    }
}