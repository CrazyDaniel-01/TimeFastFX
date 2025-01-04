/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.dao;

import Utilidades.Constantes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fasttimefx.modelo.ConexionWS;
import fasttimefx.pojo.RespuestaHTTP;
import fasttimefx.pojo.Tipo;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel
 */
public class TipoDAO {
    public static ObservableList<Tipo> obtenerTipos() {
        ObservableList<Tipo> tipos = FXCollections.observableArrayList();  
        String url = Constantes.URL_WS + "rol/obtenerRol";  
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);

        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            Gson gson = new Gson();
            try {
                Type tipoListaRol = new TypeToken<List<Tipo>>(){}.getType();
                List<Tipo> listaRoles = gson.fromJson(respuesta.getContenido(), tipoListaRol);
                tipos.addAll(listaRoles);  
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tipos;  
    }
}
