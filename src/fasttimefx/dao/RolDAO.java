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

/**
 *
 * @author Daniel
 */
public class RolDAO {
    
    public static List<Rol> obtenerRol() {
        List<Rol> rol = null;
        String url = Constantes.URL_WS + "rol/obtenerRol";
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);

        
        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            Gson gson = new Gson();
            try {
                Type tipoListaRol = new TypeToken<List<Rol>>() {}.getType();
                rol = gson.fromJson(respuesta.getContenido(), tipoListaRol);

                if (rol != null) {
                    
                    for (Rol r : rol) {
                        
                    }
                } else {
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            
        }

        return rol; 
    }
}
