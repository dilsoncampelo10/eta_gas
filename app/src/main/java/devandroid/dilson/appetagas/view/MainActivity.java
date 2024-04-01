package devandroid.dilson.appetagas.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.dilson.appetagas.R;

public class MainActivity extends AppCompatActivity {
    private EditText editGasoline;
    private EditText editEthanol;
    private Button btnCalculate;
    private Button btnFinish;
    private Button btnClear;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.editEthanol = findViewById(R.id.editEthanol);
        this.editGasoline = findViewById(R.id.editGasoline);
        this.btnCalculate = findViewById(R.id.btnCalculate);
        this.btnClear = findViewById(R.id.btnClear);
        this.btnFinish = findViewById(R.id.btnFinish);
        this.btnSave = findViewById(R.id.btnSave);


        this.btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Boa Economia!",Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}