package yanomas.android.gt.myapplication.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import yanomas.android.gt.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNicknameEP, etTituloEP,etContenidoEP;
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        iniciaVars();
    }

    private void iniciaVars() {
        etNicknameEP = (EditText) findViewById(R.id.etNicknameEP);
        etTituloEP = (EditText) findViewById(R.id.etTituloEP);
        etContenidoEP = (EditText) findViewById(R.id.etContenidoEP);
        findViewById(R.id.bPublicar).setOnClickListener(this);
        requestQueue = Volley.newRequestQueue(this);
    }

    @Override
    public void onClick(View v) {

    }
}
