package fasttimefx.dao;

import Utilidades.Constantes;
import Utilidades.Utilidades;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fasttimefx.modelo.ConexionWS;
import fasttimefx.pojo.Cliente;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.RespuestaHTTP;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;
import javafx.scene.control.Alert;

/**
 * Clase DAO para gestionar operaciones relacionadas con los clientes.
 */
public class ClienteDAO {

    /**
     * Obtiene una lista de clientes desde el servicio web.
     *
     * @return Lista de clientes.
     */
    public static List<Cliente> obtenerCliente() {
        List<Cliente> clientes = null;
        String url = Constantes.URL_WS + "cliente/obtenerCliente";
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);

        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            Gson gson = new Gson();
            try {
                Type tipoListaCliente = new TypeToken<List<Cliente>>() {}.getType();
                clientes = gson.fromJson(respuesta.getContenido(), tipoListaCliente);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return clientes;
    }

    public static Mensaje registrarCliente(Cliente cliente) {
        Mensaje msj = new Mensaje();
        String url = Constantes.URL_WS + "cliente/registrarCliente";
        Gson gson = new Gson();

        try {
            String parametros = gson.toJson(cliente);
            System.out.print(parametros);
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


    public static Mensaje actualizarCliente(Cliente cliente) {
    Mensaje msj = new Mensaje();
    String url = Constantes.URL_WS + "cliente/editarCliente";
    Gson gson = new Gson();

    try {
        String parametros = gson.toJson(cliente);
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
        msj.setMensaje("Error al actualizar el cliente y su dirección: " + e.getMessage());
    }
    return msj;
}


    public static Mensaje eliminarCliente(Integer idCliente) {
        Mensaje msj = new Mensaje();
        String url = Constantes.URL_WS + "cliente/eliminarCliente/" + idCliente;
        Gson gson = new Gson();

        try {
            RespuestaHTTP respuesta = ConexionWS.peticionDELETE(url, idCliente.toString());

            if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
                msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
            } else {
                msj.setError(true);
                msj.setMensaje(respuesta.getContenido());
            }
        } catch (Exception e) {
            msj.setError(true);
            msj.setMensaje("Error al eliminar el cliente: " + e.getMessage());
        }

        return msj;
    }

    public static List<Cliente> buscarClientesPorNombre(String nombre) {
        List<Cliente> clientes = null;
        String url = Constantes.URL_WS + "cliente/obtenerClienteNombre/" + nombre;
        System.out.println(url);
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);

        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            Gson gson = new Gson();
            try {
                Type tipoListaCliente = new TypeToken<List<Cliente>>() {}.getType();
                clientes = gson.fromJson(respuesta.getContenido(), tipoListaCliente);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return clientes;
    }
    
}
