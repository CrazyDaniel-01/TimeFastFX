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

        System.out.println("URL de solicitud: " + url);
        System.out.println("Código de respuesta: " + respuesta.getCodigoRespuesta());
        System.out.println("Contenido recibido: " + respuesta.getContenido());

        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            Gson gson = new Gson();
            try {
                Type tipoListaRol = new TypeToken<List<Rol>>() {}.getType();
                rol = gson.fromJson(respuesta.getContenido(), tipoListaRol);

                if (rol != null) {
                    System.out.println("Roles cargados desde el JSON:");
                    for (Rol r : rol) {
                        System.out.println("ID: " + r.getIdRol() + ", Nombre: " + r.getDescripcionRol());
                    }
                } else {
                    System.out.println("La lista de roles es nula después de la conversión.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error en la solicitud: Código " + respuesta.getCodigoRespuesta());
        }

        return rol; 
    }
}
