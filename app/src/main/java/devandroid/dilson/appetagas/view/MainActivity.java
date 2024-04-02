package devandroid.dilson.appetagas.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.dilson.appetagas.R;
import devandroid.dilson.appetagas.controller.FuelController;
import devandroid.dilson.appetagas.model.Ethanol;
import devandroid.dilson.appetagas.model.Gasoline;
import devandroid.dilson.appetagas.util.CalculateFuel;

public class MainActivity extends AppCompatActivity {
    private EditText editGasoline;
    private EditText editEthanol;
    private Button btnCalculate;
    private Button btnFinish;
    private Button btnClear;
    private Button btnSave;
    private TextView txtResult;
    private String msg;
    private Gasoline gasoline;
    private Ethanol ethanol;
    private FuelController fuelController;

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
        this.txtResult = findViewById(R.id.txtResult);
        this.fuelController = new FuelController(MainActivity.this);

        this.btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Boa Economia!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSave.setEnabled(false);
                editGasoline.setText("");
                editEthanol.setText("");
                fuelController.clear();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gasoline = new Gasoline(Double.parseDouble(editGasoline.getText().toString()));
                gasoline.setMsg(msg);
                ethanol = new Ethanol(Double.parseDouble(editEthanol.getText().toString()));
                ethanol.setMsg(msg);
                fuelController.save(gasoline);
                fuelController.save(ethanol);

            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDataOk = true;
                if (TextUtils.isEmpty(editGasoline.getText())) {
                    editGasoline.setError("* Campo Gasolina obrigatório");
                    editGasoline.requestFocus();
                    isDataOk = false;
                }
                if (TextUtils.isEmpty(editEthanol.getText())) {
                    editEthanol.setError("* Campo Etanol obrigatório");
                    editEthanol.requestFocus();
                    isDataOk = false;
                }

                if (isDataOk) {
                    gasoline = new Gasoline(Double.parseDouble(editGasoline.getText().toString()));
                    ethanol = new Ethanol(Double.parseDouble(editEthanol.getText().toString()));
                    msg = CalculateFuel.getResult(gasoline, ethanol);
                    gasoline.setMsg(msg);
                    ethanol.setMsg(msg);

                    txtResult.setText(msg);
                    btnSave.setEnabled(true);

                } else {
                    btnSave.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Digite os dados corretamente", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}