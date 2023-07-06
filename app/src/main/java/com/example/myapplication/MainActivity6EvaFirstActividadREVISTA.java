package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.myapplication.Adaptadores.AdaptadorRevista;
import com.example.myapplication.Adaptadores.AdaptadorUsuarios;
import com.example.myapplication.Modelos.Revista;
import com.example.myapplication.Modelos.Usuario;
import com.example.myapplication.R;

import com.example.myapplication.WebServices.Asynchtask;
import com.example.myapplication.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity6EvaFirstActividadREVISTA extends AppCompatActivity implements Asynchtask {
    ListView lstReviGeneral;
    ArrayList<Revista> lstRevistasXD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity6_eva_first_actividad_revista);

        lstReviGeneral = (ListView)findViewById(R.id.lstRevistas);
        View header = getLayoutInflater().inflate(R.layout.lyheaderlu, null);
        lstReviGeneral.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity6EvaFirstActividadREVISTA.this   , MainActivity6EvaFirstActividadREVISTA.this);
        ws.execute("GET");






    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlista = new JSONArray(result);

        ArrayList<Revista> lstRevistasXD = Revista.JsonObjectsBuild(JSONlista);
        AdaptadorRevista adaptaRevista = new AdaptadorRevista(this, lstRevistasXD);
        lstReviGeneral.setAdapter(adaptaRevista);
    }
}