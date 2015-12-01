package yanomas.android.gt.myapplication.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import yanomas.android.gt.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNicknameEP, etTituloEP, etContenidoEP;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        iniciaVars();
//pablo
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
        Publicacion publicacion = new Publicacion(
                etNicknameEP.getText().toString(),
                etTituloEP.getText().toString(),
                etContenidoEP.getText().toString());
        crearPublicacion(publicacion);
    }

    private void crearPublicacion(final Publicacion publicacion) {

        StringRequest request = new StringRequest(
                Request.Method.POST,
                Parametros.URL_JSON,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("nickname", publicacion.getNickname());
                params.put("titulo", publicacion.getTitulo());
                params.put("coment", publicacion.getComentario());
                params.put("imagen","1");
                return params;
            }
        };
        requestQueue.add(request);
    }
}
