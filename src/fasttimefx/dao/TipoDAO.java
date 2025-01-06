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
import fasttimefx.pojo.Tipo;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel
 */
public class TipoDAO {
   public static ObservableList<Tipo> obtenerTipos() {
    ObservableList<Tipo> tipos = FXCollections.observableArrayList();
    String url = Constantes.URL_WS + "unidad/obtenerTipo";
    RespuestaHTTP respuesta = ConexionWS.peticionGET(url);

    System.out.println("URL de solicitud: " + url);
    System.out.println("Código de respuesta: " + respuesta.getCodigoRespuesta());
    System.out.println("Contenido recibido: " + respuesta.getContenido());

    if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
        Gson gson = new Gson();
        try {
            Type tipoListaTipos = new TypeToken<List<Tipo>>() {}.getType();
            List<Tipo> listaTipos = gson.fromJson(respuesta.getContenido(), tipoListaTipos);

            if (listaTipos != null) {
                tipos.addAll(listaTipos);
                System.out.println("Tipos cargados desde el JSON:");
                for (Tipo t : listaTipos) {
                    System.out.println("ID: " + t.getIdTipo() + ", Nombre: " + t.getDescripcionTipo());
                }
            } else {
                System.out.println("La lista de tipos es nula después de la conversión.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error durante la conversión del JSON:");
            e.printStackTrace();
        }
    } else {
        System.out.println("Error en la solicitud: Código " + respuesta.getCodigoRespuesta());
    }

    return tipos;
}

}
