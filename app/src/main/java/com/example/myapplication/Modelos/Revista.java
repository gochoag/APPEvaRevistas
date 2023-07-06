package com.example.myapplication.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    private String name;
    private String journal_id;
    private String portada;

    public Revista(JSONObject a) throws JSONException {
        name = a.getString("name").toString();
        journal_id = a.getString("journal_id").toString() ;
        portada = a.getString("portada").toString() ;
    }
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revista> revistas = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            JSONObject datosrevista = datos.getJSONObject(i);
            revistas.add(new Revista(datosrevista));
        }

        return revistas;
    }



}
