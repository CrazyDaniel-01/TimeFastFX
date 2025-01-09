package fasttimefx.dao;

import Utilidades.Constantes;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import fasttimefx.modelo.ConexionWS;
import fasttimefx.pojo.Colaborador;
import fasttimefx.pojo.RespuestaHTTP;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.Base64;
import java.util.List;

public class ColaboradorDAO {

    public static List<Colaborador> obtenerColaborador() {
        List<Colaborador> colaboradores = null;
        String url = Constantes.URL_WS + "colaborador/obtenerColaborador";
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
<<<<<<< Updated upstream
}
=======

    public static Mensaje registrarColaborador(Colaborador colaborador) {
        Mensaje msj = new Mensaje();
        String url = Constantes.URL_WS + "colaborador/registrarColaborador";
        Gson gson = new Gson();
        try {
            String parametros = gson.toJson(colaborador);
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

    public static Mensaje actualizarColaborador(Colaborador colaborador) {
        Mensaje msj = new Mensaje();
        String url = Constantes.URL_WS + "colaborador/editarColaborador";
        Gson gson = new Gson();
        try {
            String parametros = gson.toJson(colaborador);
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

 public static Mensaje cargarImagen(int idColaborador, byte[] fotografia) {
    Mensaje msj = new Mensaje();
    String url = Constantes.URL_WS + "colaborador/subirFoto/" + idColaborador;

    try {
        RespuestaHTTP respuesta = ConexionWS.peticionPUTFoto(url, fotografia);
        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            Gson gson = new Gson();
            msj = gson.fromJson(respuesta.getContenido(), Mensaje.class);
        } else {
            msj.setError(true);
            msj.setMensaje("Error al subir la imagen: Código " + respuesta.getCodigoRespuesta());
        }
    } catch (Exception e) {
        msj.setError(true);
        msj.setMensaje("Error al subir la imagen: " + e.getMessage());
    }
    return msj;
}


public static byte[] descargarImagen(int idColaborador) {
    String url = Constantes.URL_WS + "colaborador/obtenerFoto/" + idColaborador;

    try {
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        if (respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(respuesta.getContenido(), JsonObject.class);

            if (jsonObject.has("fotoBase64")) {
                // Elimina caracteres no válidos como saltos de línea
                String base64Image = jsonObject.get("fotoBase64").getAsString().replaceAll("\\s", "");
                return Base64.getDecoder().decode(base64Image);
            } else {
                System.err.println("La respuesta no contiene la clave 'fotoBase64'.");
            }
        } else {
            System.err.println("Error al obtener la imagen: " + respuesta.getCodigoRespuesta());
        }
    } catch (IllegalArgumentException e) {
        System.err.println("Error al decodificar Base64: " + e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}




}
>>>>>>> Stashed changes
