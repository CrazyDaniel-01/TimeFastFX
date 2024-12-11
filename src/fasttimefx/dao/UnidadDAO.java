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
}
