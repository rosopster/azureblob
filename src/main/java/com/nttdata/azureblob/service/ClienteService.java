package com.nttdata.azureblob.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nttdata.azureblob.model.Cliente;

import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class ClienteService {

    private static final String AZURE_BLOB_URL = "https://clientesnttstorage.blob.core.windows.net/datos-clientes/clientes.json";

    public List<Cliente> obtenerClientes() throws Exception {
        URL url = new URL(AZURE_BLOB_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() == 200) {
            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            return new Gson().fromJson(reader, new TypeToken<List<Cliente>>() {}.getType());
        } else {
            throw new RuntimeException("Error al obtener el archivo JSON: " + conn.getResponseCode());
        }
    }
}