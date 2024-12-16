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
import fasttimefx.pojo.Rol;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel
 */
public class RolDAO {

    // Método para obtener la lista de roles y convertirla a ObservableList
    public static ObservableList<Rol> obtenerRoles() {
        ObservableList<Rol> roles = FXCollections.observableArrayList();  // Lista observable para el ComboBox
        String url = Constantes.URL_WS + "rol/obtenerRol";  
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);

        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            Gson gson = new Gson();
            try {
                Type tipoListaRol = new TypeToken<List<Rol>>(){}.getType();
                List<Rol> listaRoles = gson.fromJson(respuesta.getContenido(), tipoListaRol);
                roles.addAll(listaRoles);  
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return roles;  
    }
}
