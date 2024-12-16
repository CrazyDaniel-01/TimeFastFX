/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.dao;

import Utilidades.Constantes;
import Utilidades.Utilidades;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fasttimefx.modelo.ConexionWS;
import fasttimefx.pojo.Colaborador;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.RespuestaHTTP;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author afs30
 */
public class ColaboradorDAO {
    
    
       public static List<Colaborador>obtenerColaborador(){
        List<Colaborador>colaboradores = null;
        String url =Constantes.URL_WS+ "colaborador/obtenerColaborador";
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
       public static Mensaje registrarColaborador(Colaborador colaborador){
        Mensaje msj = new Mensaje();
        String url= Constantes.URL_WS+"colaborador/registrarColaborador";
        Gson gson= new Gson();
            try{
                String parametros=gson.toJson(colaborador);
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
       
       public static Mensaje actualizarColaborador(Colaborador colaborador) {
            Mensaje msj = new Mensaje();
            String url = Constantes.URL_WS + "colaborador/editarColaborador";
            Gson gson = new Gson();

            try {
                String parametros = gson.toJson(colaborador);
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
                msj.setMensaje("Error al actualizar el colaborador: " + e.getMessage());
            }
            return msj;
        }   
public static Mensaje eliminarColaborador(Integer idColaborador) {
    Mensaje msj = new Mensaje();
    String url = Constantes.URL_WS + "colaborador/eliminarColaborador/" + idColaborador;
    Gson gson = new Gson();

    try {
        RespuestaHTTP respuesta = ConexionWS.peticionDELETE(url, idColaborador.toString());

        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
        } else {
            msj.setError(true);
            msj.setMensaje(respuesta.getContenido());
        }
    } catch (Exception e) {
        msj.setError(true);
        msj.setMensaje("Error al eliminar el colaborador: " + e.getMessage());
    }
    return msj;
}
    public static List<Colaborador> buscarColaboradoresPorNombre(String nombre) {
    List<Colaborador> colaboradores = null;
    String url = Constantes.URL_WS + "colaborador/obtenerColaboradorNombre/" + nombre;
    System.out.println(url);
    RespuestaHTTP respuesta = ConexionWS.peticionGET(url);

    if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
        Gson gson = new Gson();
        try {
            Type tipoListaColaborador = new TypeToken<List<Colaborador>>() {}.getType();
            colaboradores = gson.fromJson(respuesta.getContenido(), tipoListaColaborador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return colaboradores;
}

}
