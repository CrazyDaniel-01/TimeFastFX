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
public class UnidadDAO {
           public static List<Unidad>obtenerUnidad(){
        List<Unidad>unidades = null;
        String url =Constantes.URL_WS+ "unidad/obtenerUnidad";
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
           
            public static Mensaje registrarUnidad(Unidad unidad){
        Mensaje msj = new Mensaje();
        String url= Constantes.URL_WS+"unidad/registrarUnidad";
        Gson gson= new Gson();
            try{
                String parametros=gson.toJson(unidad);
                System.out.print(parametros);
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
            
      
      public static Mensaje actualizarUnidad(Unidad unidad) {
            Mensaje msj = new Mensaje();
            String url = Constantes.URL_WS + "unidad/editarUnidad";
            Gson gson = new Gson();

            try {
                String parametros = gson.toJson(unidad);
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
                msj.setMensaje("Error al actualizar la unidad: " + e.getMessage());
            }
            return msj;
        }   
           
}
