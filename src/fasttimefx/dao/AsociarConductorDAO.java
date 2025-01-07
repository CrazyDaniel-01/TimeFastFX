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
import fasttimefx.pojo.AsociacionVehicular;
import fasttimefx.pojo.Colaborador;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.RespuestaHTTP;
import fasttimefx.pojo.Unidad;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;

/**
 *
 * @author afs30
 */
public class AsociarConductorDAO {
    
        public static List<Colaborador>obtenerColaboradorLibre(){
        List<Colaborador>colaboradores = null;
        String url =Constantes.URL_WS+ "colaborador/obtenerConductorLibre";
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if(respuesta.getCodigoRespuesta()==HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            try{
                Type tipoListaColaborador = new TypeToken<List<Colaborador>>(){}.getType();
                colaboradores = gson.fromJson(respuesta.getContenido(),tipoListaColaborador);
            }catch(Exception e){           
                e.printStackTrace();         
            }
        }
        return colaboradores;
    }
    
        public static List<Unidad>obtenerUnidadLibre(){
        List<Unidad>unidades = null;
        String url =Constantes.URL_WS+ "unidad/obtenerUnidadLibre";
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if(respuesta.getCodigoRespuesta()==HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            try{
                Type tipoListaUnidad = new TypeToken<List<Unidad>>(){}.getType();
                unidades = gson.fromJson(respuesta.getContenido(),tipoListaUnidad);
            }catch(Exception e){           
                e.printStackTrace();         
            }
        }
        return unidades;
    }
        
 public static Mensaje registrarAsociacion(String jsonAsociacion) {
    Mensaje msj = new Mensaje();
    String url = Constantes.URL_WS + "asociacionVehicular/registrarAsociacion";
    Gson gson = new Gson();

    try {
        System.out.println("JSON Enviado: " + jsonAsociacion); // Debug: Verifica el JSON enviado
        RespuestaHTTP respuesta = ConexionWS.peticionPOSTJSON(url, jsonAsociacion);

        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
        } else {
            msj.setError(true);
            msj.setMensaje("Error en la respuesta del servidor: " + respuesta.getContenido());
        }
    } catch (Exception e) {
        msj.setError(true);
        msj.setMensaje("Error al conectar con el servidor: " + e.getMessage());
    }

    return msj;
}

}
