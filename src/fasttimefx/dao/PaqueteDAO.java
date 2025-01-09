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
import fasttimefx.pojo.Envio;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.Paquete;
import fasttimefx.pojo.RespuestaHTTP;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;

/**
 *
 * @author afs30
 */
public class PaqueteDAO {
    
        public static List<Paquete>obtenerPaquete(){
        List<Paquete>paquetes = null;
        String url =Constantes.URL_WS+ "paquete/obtenerPaquete";
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if(respuesta.getCodigoRespuesta()==HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            try{
                Type tipoListaPaquete = new TypeToken<List<Paquete>>(){}.getType();
                paquetes = gson.fromJson(respuesta.getContenido(),tipoListaPaquete);
            }catch(Exception e){           
                e.printStackTrace();         
            }
        }
        return paquetes;
    }
        public static Mensaje actualizarPaquete(Paquete paquete) {
            Mensaje msj = new Mensaje();
            String url = Constantes.URL_WS + "paquete/editarPaquete";
            Gson gson = new Gson();

            try {
                String parametros = gson.toJson(paquete);
                RespuestaHTTP respuesta = ConexionWS.peticionPUTJSON(url, parametros);
                if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
                    msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
                } else {
                    msj.setError(true);
                    msj.setMensaje(respuesta.getContenido());
                }
            } catch (Exception e) {
                msj.setError(true);
                msj.setMensaje("Error al actualizar el paquete: " + e.getMessage());
            }
            return msj;
        }   
        public static Mensaje eliminarPaquete(Integer idPaquete) {
            Mensaje msj = new Mensaje();
            String url = Constantes.URL_WS + "paquete/eliminarPaquete/"+idPaquete;
            Gson gson = new Gson();
            try {
                RespuestaHTTP respuesta = ConexionWS.peticionDELETE(url, idPaquete.toString());

                if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
                    msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
                } else {
                    msj.setError(true);
                    msj.setMensaje(respuesta.getContenido());
                }
            } catch (Exception e) {
                msj.setError(true);
                msj.setMensaje("Error al eliminar paquete: " + e.getMessage());
            }
            return msj;
        }   
        
        public static Mensaje registrarPaquete(Paquete paquete){
        Mensaje msj = new Mensaje();
        String url= Constantes.URL_WS+"paquete/registrarPaquete";
        Gson gson= new Gson();
            try{
                String parametros=gson.toJson(paquete);
                RespuestaHTTP respuesta = ConexionWS.peticionPOSTJSON(url, parametros);
                if(respuesta.getCodigoRespuesta()==HttpURLConnection.HTTP_OK){
                    msj=gson.fromJson(respuesta.getContenido(), Mensaje.class);
                }else{
                    msj.setError(true);
                    msj.setMensaje(respuesta.getContenido());
                }
            }catch(Exception e){
                  msj.setError(true);
                  msj.setMensaje(e.getMessage());
            }
            return msj;
    }
}
