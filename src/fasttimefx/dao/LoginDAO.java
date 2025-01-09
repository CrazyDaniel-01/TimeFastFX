/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.dao;

import Utilidades.Constantes;
import com.google.gson.Gson;
import fasttimefx.modelo.ConexionWS;
import fasttimefx.pojo.Login;
import fasttimefx.pojo.RespuestaHTTP;
import java.net.HttpURLConnection;

/**
 *
 * @author Daniel
 */
public class LoginDAO {
    public static Login iniciarSesion(String noPersonal, String password){
        Login respuestaLogin = new Login();
        String urlServicio =Constantes.URL_WS+"login/colaborador";
        String parametros = String.format("noPersonal=%s&password=%s",noPersonal,password);
        RespuestaHTTP respuestaWS = ConexionWS.peticionPOST(urlServicio, parametros);
        if(respuestaWS.getCodigoRespuesta()== HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            respuestaLogin =gson.fromJson(respuestaWS.getContenido(), Login.class);
        }else{
            respuestaLogin.setError(Boolean.TRUE);
            respuestaLogin.setMensaje("Lo sentimos, hubo un error al procesar la autenticacion, por favor intente de nuevo");
        }
        return respuestaLogin;
        
        
    }
}
