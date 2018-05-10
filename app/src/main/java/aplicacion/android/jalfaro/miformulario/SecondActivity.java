package aplicacion.android.jalfaro.miformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private View btn1;
    private View btn2;
    SeekBar seekBar;
    TextView textView;
    String edad;
    private String name1;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    int currentMax = 70, currentStep= 18 ;
    int currentProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        name1 = getIntent().getStringExtra("name");
        //Toast.makeText(SecondActivity.this, name1, Toast.LENGTH_LONG).show();



        btn1 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                //Toast.makeText(SecondActivity.this, radioButton.getText(),Toast.LENGTH_LONG).show();
                //Toast.makeText(SecondActivity.this, textEdad.getText(), Toast.LENGTH_LONG).show();

                if(radioButton.getText().equals("Saludo")){
                    String Saludo = "Hola "+name1+" ¿Como van esos "+ edad+"?";
                    //Toast.makeText(SecondActivity.this, Saludo ,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("mensaje", Saludo);
                    startActivity(intent);
                }else{
                    int edadnum = Integer.parseInt(edad);
                    edadnum = edadnum +1;
                    String edadnum1 = String.valueOf(edadnum);
                    String Despedida = "Espero verte antes de que cumplas "+ edadnum1 +"!";
                    //Toast.makeText(SecondActivity.this, Despedida,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("mensaje", Despedida);
                    startActivity(intent);
                }

            }
        });

        btn2 = (Button) findViewById(R.id.buttonAtras);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




        seekBar = (SeekBar) findViewById(R.id.Edad);
        textView = (TextView) findViewById(R.id.textView2);

        textView.setText("0 años");



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textView.setText(progress + " años");
                edad  = String.valueOf(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
