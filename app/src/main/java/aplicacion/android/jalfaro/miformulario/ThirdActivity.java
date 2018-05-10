package aplicacion.android.jalfaro.miformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private String mensaje;
    private View btn;
    private View btn2;
    private View btn3;
    private String edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);



        mensaje = getIntent().getStringExtra("mensaje");
        //Toast.makeText(ThirdActivity.this, mensaje, Toast.LENGTH_LONG).show();





        btn = (Button) findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, mensaje, Toast.LENGTH_LONG).show();
                btn.setVisibility(View.INVISIBLE);
            }


        });


        btn2 = (Button) findViewById(R.id.buttonAtras);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        btn3 = (Button) findViewById(R.id.button4);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendText = new Intent();
                sendText.setAction(Intent.ACTION_SEND);
                sendText.putExtra(Intent.EXTRA_TEXT, mensaje);
                sendText.setType("text/plain");
                startActivity(sendText);

            }
        });
    }
}
