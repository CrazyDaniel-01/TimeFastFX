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
import fasttimefx.pojo.Colaborador;
import fasttimefx.pojo.Envio;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.RespuestaHTTP;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;

/**
 *
 * @author afs30
 */
public class EnvioDAO {
       public static List<Envio>obtenerEnvio(){
        List<Envio>envios = null;
        String url =Constantes.URL_WS+ "envio/obtenerEnvio";
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if(respuesta.getCodigoRespuesta()==HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            try{
                Type tipoListaEnvio = new TypeToken<List<Envio>>(){}.getType();
                envios = gson.fromJson(respuesta.getContenido(),tipoListaEnvio);
            }catch(Exception e){           
                e.printStackTrace();         
            }
        }
        return envios;
    }
    
       
       public static List<Envio>obtenerNumerosGuias(){
        List<Envio>envios = null;
        String url =Constantes.URL_WS+ "envio/obtenerNumerosGuias";
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if(respuesta.getCodigoRespuesta()==HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            try{
                Type tipoListaEnvio = new TypeToken<List<Envio>>(){}.getType();
                envios = gson.fromJson(respuesta.getContenido(),tipoListaEnvio);
            }catch(Exception e){           
                e.printStackTrace();         
            }
        }
        return envios;
    }   
    public static Mensaje registrarEnvio(Envio envio) {
    Mensaje msj = new Mensaje();
    String url = Constantes.URL_WS + "envio/registrarEnvio"; // Cambiamos la URL para "envio"
    Gson gson = new Gson();
    try {
        String parametros = gson.toJson(envio); // Cambiamos el objeto serializado a "envio"
        System.out.print(parametros);
        RespuestaHTTP respuesta = ConexionWS.peticionPOSTJSON(url, parametros);
        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
        } else {
            msj.setError(true);
            msj.setMensaje(respuesta.getContenido());
        }
    } catch (Exception e) {
        msj.setError(true);
        msj.setMensaje(e.getMessage());
    }
    return msj;
}

public static Mensaje actualizarEnvio(Envio envio) {
    Mensaje msj = new Mensaje();
    String url = Constantes.URL_WS + "envio/editarEnvio"; // Cambiamos la URL para "envio"
    Gson gson = new Gson();

    try {
        String parametros = gson.toJson(envio); // Cambiamos el objeto serializado a "envio"
        System.out.println(parametros);
        RespuestaHTTP respuesta = ConexionWS.peticionPUTJSON(url, parametros);
        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
        } else {
            msj.setError(true);
            msj.setMensaje(respuesta.getContenido());
        }
    } catch (Exception e) {
        msj.setError(true);
        msj.setMensaje("Error al actualizar el envío: " + e.getMessage());
    }
    return msj;
}


        public static Mensaje eliminarEnvio(Integer idEnvio) {
            Mensaje msj = new Mensaje();
            String url = Constantes.URL_WS + "envio/eliminarEnvio/"+idEnvio;
            Gson gson = new Gson();
            System.out.println(url);
            try {
                RespuestaHTTP respuesta = ConexionWS.peticionDELETE(url, idEnvio.toString());

                if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
                    msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
                } else {
                    msj.setError(true);
                    msj.setMensaje(respuesta.getContenido());
                }
            } catch (Exception e) {
                msj.setError(true);
                msj.setMensaje("Error al eliminar envio: " + e.getMessage());
            }
            return msj;
        }  
}
