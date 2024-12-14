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
}
