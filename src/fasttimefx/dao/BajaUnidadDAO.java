/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.dao;

import Utilidades.Constantes;
import com.google.gson.Gson;
import fasttimefx.modelo.ConexionWS;
import fasttimefx.pojo.BajaUnidad;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.RespuestaHTTP;
import java.net.HttpURLConnection;

/**
 *
 * @author Daniel
 */
public class BajaUnidadDAO {
    public static Mensaje bajaUnidad(BajaUnidad bajaUnidad) {
            Mensaje msj = new Mensaje();
            String url = Constantes.URL_WS + "unidad/bajaUnidad";
            Gson gson = new Gson();

            try {
                String parametros = gson.toJson(bajaUnidad);
                RespuestaHTTP respuesta = ConexionWS.peticionPOSTJSON(url, parametros);
                if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
                    msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
                } else {
                    msj.setError(true);
                    msj.setMensaje(respuesta.getContenido());
                }
            } catch (Exception e) {
                msj.setError(true);
                msj.setMensaje("Error al dar de baja la unidad: " + e.getMessage());
            }
            return msj;
        }
}
