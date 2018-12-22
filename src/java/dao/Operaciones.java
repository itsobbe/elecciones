/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Votante;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.ApplicationException;
import java.time.LocalDate;
import modelo.Candidato;
import modelo.Escaño;
import modelo.Parametros;
import modelo.Partido;
import modelo.PartidoCandidato;

/**
 *
 * @author owa_7
 */
public class Operaciones {

    public boolean insertarVotante(Connection conexion, Votante votante) throws SQLException {
        try {
            String sql = "insert into votante values(null,?,AES_ENCRYPT(?,'oualid'),?,?,?,?,'N','votante')";
            PreparedStatement prestm = conexion.prepareStatement(sql);
            prestm.setString(3, votante.getNombre());
            prestm.setString(4, votante.getApellidos());
            prestm.setString(2, votante.getContraseña());
            prestm.setString(5, votante.getDomicilio());
            prestm.setString(1, votante.getNif());
            Date fecha = java.sql.Date.valueOf(votante.getFechaNac());
            prestm.setDate(6, fecha);
            int resultado = prestm.executeUpdate();
            if (resultado == 1) {
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Votante inicioSesion(String nif, String contraseña, Connection conexion) throws SQLException, ApplicationException {
        try {
            PreparedStatement pre = conexion.prepareStatement("SELECT * FROM votante WHERE nif=? AND AES_DECRYPT(password,'oualid')=?");
            pre.setString(1, nif);
            pre.setString(2, contraseña);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return new Votante(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("domicilio"), LocalDate.parse(rs.getString("fechaNac")), rs.getString("nif"), rs.getString("rol"), rs.getString("votado"));
            } else {
                throw new ApplicationException("Error", 0, "Usuario no encontrado");
            }
        } catch (SQLException e) {
            throw new ApplicationException(e.getMessage(), e.getErrorCode(), e.getSQLState());
        }
    }

    public ArrayList<Votante> listadoCenso(Connection conexion) throws ApplicationException {
        ArrayList<Votante> array = new ArrayList();
        try {
            PreparedStatement pre = conexion.prepareStatement("SELECT * FROM votante");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                array.add(new Votante(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("domicilio"), LocalDate.parse(rs.getString("fechaNac")), rs.getString("nif"), rs.getString("rol"), rs.getString("votado")));
//            array.add(new Votante(rs.getString("nif"),rs.getString("votado"),rs.getString("rol")));
            }

        } catch (SQLException e) {
            throw new ApplicationException("Error en listado", e.getErrorCode(), e.getMessage());
        }
        return array;
    }

    public Votante devuelveVotante(String nif, Connection conexion) throws ApplicationException {
        try {
            PreparedStatement pre = conexion.prepareStatement("select * from votante where nif=?");
            pre.setString(1, nif);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                return new Votante(rs.getString("nif"), rs.getString("votado"), rs.getString("rol"));
            }
        } catch (SQLException e) {
            throw new ApplicationException("Error devolver objeto votante", e.getErrorCode(), e.getMessage());
        }
        return null;
    }

    public boolean darBajaVotante(Votante votante, Connection conexion) throws ApplicationException {
        String nif = votante.getNif();
        try {
            PreparedStatement pre = conexion.prepareStatement("DELETE FROM votante where nif=?");
            pre.setString(1, nif);
            int resultado = pre.executeUpdate();
            if (resultado == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new ApplicationException("Error en baja", e.getErrorCode(), e.getMessage());
        }

    }

    public Boolean cambioDatos(Votante votante, Connection conexion) throws SQLException, ApplicationException {
        try {
            PreparedStatement pre = conexion.prepareStatement("UPDATE votante SET password=AES_ENCRYPT(?,'oualid'),nombre=?,apellidos=?,domicilio=?,fechaNac=? WHERE nif=?");
            pre.setString(1, votante.getContraseña());
            pre.setString(2, votante.getNombre());
            pre.setString(3, votante.getApellidos());
            pre.setString(4, votante.getDomicilio());
            pre.setDate(5, java.sql.Date.valueOf(votante.getFechaNac()));
            pre.setString(6, votante.getNif());
            int resultado = pre.executeUpdate();
            if (resultado != 1) {
                throw new ApplicationException("Error en actualización", 0, "No se ha podido actualizar");
            }
            return true;
        } catch (SQLException e) {
            throw new ApplicationException("Error en actualización", e.getErrorCode(), e.getMessage());
        }
    }

    public int votar(Votante votante, Partido partido, Connection conexion) throws ApplicationException {
        try {
            conexion.setAutoCommit(false);
            String orden = "UPDATE votante SET votado='S' WHERE NIF='" + votante.getNif() + "';";
            Statement s = conexion.createStatement();
            int resultado = s.executeUpdate(orden);
            if (resultado != 1) {
                conexion.rollback();
                conexion.setAutoCommit(true);
                throw new ApplicationException("Error votando", 0, "No se ha podido votar");
            }
            orden = "UPDATE partido SET votos=votos+1 WHERE id='" + partido.getId() + "';"; //le tengo que pasar partido y aqui coger id o algo
            s = conexion.createStatement();
            resultado = s.executeUpdate(orden);
            if (resultado != 1) {
                conexion.rollback();
                conexion.setAutoCommit(true);
                throw new ApplicationException("Error votando", 1, "No se ha podido votar");
            }
            conexion.commit();
            conexion.setAutoCommit(true);
            return resultado;
        } catch (SQLException e) {

            try {
                conexion.rollback();
                conexion.setAutoCommit(true);
                //hay que lanzar una excepcion aqui tmb
            } catch (SQLException e2) {
                throw new ApplicationException("Error votando", e2.getErrorCode(), e2.getMessage());
            }
            return -1;
        }
    }

    public ArrayList<Partido> devuelvePartidos(Connection conexion) throws ApplicationException {
        //usado para cargar la vista de votar
        try {
            ArrayList<Partido> a = new ArrayList();

            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM partido order by votos DESC");
//            if (rs.next()) {
            while (rs.next()) {
                //si error quitar votos
                a.add(new Partido(rs.getInt("id"), rs.getInt("votos"), rs.getString("denominacion"), rs.getString("logo")));
            }
            if (a != null) {
                return a;
            } else {
                throw new ApplicationException("Error mostrando partidos", 0, "No se han encontrado");
            }

        } catch (SQLException e) {
            throw new ApplicationException("Error mostrando partidos", e.getErrorCode(), e.getMessage());
        }
    }

    public Partido[] devuelvePartidosArray(Connection conexion) {  //para probarlo con array de partidos
        try {
            Partido[] partido;
            int cont = 0;
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM partido");
            while (rs.next()) {
                cont++;
            }
            partido = new Partido[cont];
            //s=conexion.createStatement();
            int in = 0;
            rs = s.executeQuery("SELECT * FROM partido");
            while (rs.next()) {
                partido[in] = new Partido(rs.getInt("votos"), rs.getString("siglas"));
                in++;
            }
            return partido;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<Partido> devuelvePartidosRecuento(Connection conexion) throws ApplicationException {
        //usado para que devuelva arraylist de partido con los datos necesarios para el recuento de escaños
        try {
            ArrayList<Partido> a = new ArrayList();
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM partido");
//            if (rs.next()) {
            while (rs.next()) {
                a.add(new Partido(rs.getInt("id"), rs.getInt("votos")));
            }
            if (a != null) {
                return a;
            } else {
                throw new ApplicationException("Error devolviendo partidos", 0, "No se han encontrado");
            }

        } catch (SQLException e) {
            throw new ApplicationException("Error devolución partidos", e.getErrorCode(), e.getMessage());
        }

    }

    public Partido[] escaños(Partido[] partido) { //primera prueba funciona 
        int escaños = 3;
        String mayorSigla = "";
        int maxIndice = 0; //indice del partido en array mas grande en cada momento
        int mayor = 0; //guarda mayor num votos
        String[] resultado = new String[escaños];
        for (int i = 0; i < escaños; i++) {
            for (int j = 0; j < partido.length; j++) {
                if (partido[j].getVotos() > mayor) {
                    mayor = partido[j].getVotos();
                    mayorSigla = partido[j].getSiglas();
                    maxIndice = j;
                }
                if (j == partido.length - 1) {
                    partido[maxIndice].setVotos(partido[maxIndice].getVotos() / 2);
                }
            }
            mayor = 0;
            resultado[i] = mayorSigla;
        }
        //contador escaños
        int pp = 0;
        int psoe = 0;
        int po = 0;
        int ci = 0;
        for (int i = 0; i < resultado.length; i++) {
            if (resultado[i].equals("PP")) {
                pp++;
            }
            if (resultado[i].equals("PSOE")) {
                psoe++;
            }
            if (resultado[i].equals("Cs")) {
                ci++;
            }
            if (resultado[i].equals("P")) {
                po++;
            }
        }
        Partido[] resultadoEsca = new Partido[4]; // 4 partidos
        resultadoEsca[0] = new Partido(pp, "PP");
        resultadoEsca[1] = new Partido(psoe, "PSOE");
        resultadoEsca[2] = new Partido(po, "P");
        resultadoEsca[3] = new Partido(ci, "Cs");
        return resultadoEsca;

    }

    public ArrayList<Escaño> resultadoEscaño(ArrayList<Partido> partido,Connection conexion) throws ApplicationException { //usado
        //metodo para calcular escaños segun votos
        int escaños = 0;
        int mayorId = 0;
        int maxIndice = 0; //indice del partido en array mas grande en cada momento
        int mayor = 0; //guarda mayor num votos
        ArrayList<Escaño> escaño = new ArrayList();

        try {
            Statement s=conexion.createStatement();
            ResultSet rs=s.executeQuery("Select numCandidatos from parametros");
            if (rs.first()) {
                escaños=rs.getInt("numCandidatos");
            }else throw new ApplicationException("Error", 0, "sacando el numero de escaños disponibles");
        } catch (SQLException e) {
            throw new ApplicationException("Error", e.getErrorCode(), e.getMessage());
        }
        
        
        
        for (int i = 0; i < partido.size(); i++) {
            escaño.add(new Escaño(partido.get(i).getId()));
        }

        for (int i = 0; i < escaños; i++) {
            for (int j = 0; j < partido.size(); j++) {
                if (partido.get(j).getVotos() > mayor) {

                    mayor = partido.get(j).getVotos();
                    mayorId = partido.get(j).getId();
                    maxIndice = j;
                }
                if (j == partido.size() - 1) {
                    partido.get(maxIndice).setVotos(partido.get(maxIndice).getVotos() / 2);
                }
            }
            mayor = 0;

            for (int a = 0; a < escaño.size(); a++) {
                if (escaño.get(a).getId_partido() == mayorId) {
                    escaño.get(a).setNumEscaños(escaño.get(a).getNumEscaños() + 1);
                }
            }
            //resultado[i]=mayorSigla;
        }
        return escaño;
    }

    public int registroEscaño(ArrayList<Escaño> escaño, Connection conexion) throws ApplicationException {
        //metodo para registrar los escaños en la tabla
        try {

            String orden1 = "select * from escaño";
            Statement s1 = conexion.createStatement();
            ResultSet rs = s1.executeQuery(orden1);
            if (rs.first()) {
                throw new ApplicationException("Error", 0, "Los escaños ya fueron asignados");
            }

            int resultado = 0;
            for (int i = 0; i < escaño.size(); i++) {
                int id_partido = escaño.get(i).getId_partido();
                int escaños = escaño.get(i).getNumEscaños();
                String orden = "INSERT INTO escaño VALUES(null,'" + escaños + "','" + id_partido + "');";
                Statement s = conexion.createStatement();
                resultado = s.executeUpdate(orden);
            }
            return resultado;
        } catch (SQLException e) {
            throw new ApplicationException(e.getMessage(), e.getErrorCode(), "error");

        }

    }

    public boolean escrutinio(Connection conexion) throws ApplicationException {
        //metodo para abrir o cerrar escrutinio
        try {
            String abierto = "";
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT escrutinioAbierto FROM parametros");
            if (rs.first()) {
                abierto = rs.getString("escrutinioAbierto");
            } else {
                return false;
            }
            if (abierto.equals("S")) {
                PreparedStatement pre = conexion.prepareStatement("UPDATE parametros set escrutinioAbierto='N'");
                int resultado = pre.executeUpdate();
                if (resultado == 1) {
                    return true;
                } else {
                    return false;
                }
            }
            if (abierto.equals("N")) {
                PreparedStatement pre = conexion.prepareStatement("UPDATE parametros set escrutinioAbierto='S'");
                int resultado = pre.executeUpdate();
                if (resultado == 1) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        } catch (SQLException e) {
            throw new ApplicationException("Error abriendo/cerrando escrutinio", e.getErrorCode(), e.getMessage());
        }
    }

    public void escrutinioV2(int id, Connection conexion) throws ApplicationException {
        PreparedStatement pre;
        int resultado = 0;
        try {
            switch (id) {
                case 1:
                    pre = conexion.prepareStatement("UPDATE parametros set escrutinioAbierto='N'");
                    resultado = pre.executeUpdate();
                    if (resultado != 1) {
                        throw new ApplicationException("Error", 0, "cerrando escrutinio");
                    }
                    break;
                case 2:
                    pre = conexion.prepareStatement("UPDATE parametros set escrutinioAbierto='S'");
                    resultado = pre.executeUpdate();
                    if (resultado != 1) {
                        throw new ApplicationException("Error", 0, "abriendo escrutinio");
                    }
                    break;
            }
        } catch (SQLException e) {
            throw new ApplicationException("Error abriendo/cerrando escrutinio", e.getErrorCode(), e.getMessage());
        }
    }

    public boolean consulta(Connection conexion) throws ApplicationException {
        //metodo para abrir o cerrar la consulta
        try {
            String abierto = "";
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT consultaAbierta FROM parametros");
            if (rs.first()) {
                abierto = rs.getString("consultaAbierta");
            } else {
                return false;
            }
            if (abierto.equals("S")) {
                PreparedStatement pre = conexion.prepareStatement("UPDATE parametros set consultaAbierta='N'");
                int resultado = pre.executeUpdate();
                if (resultado == 1) {
                    return true;
                } else {
                    return false;
                }
            }
            if (abierto.equals("N")) {
                PreparedStatement pre = conexion.prepareStatement("UPDATE parametros set consultaAbierta='S'");
                int resultado = pre.executeUpdate();
                if (resultado == 1) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        } catch (SQLException e) {
            throw new ApplicationException("Error abriendo/cerrando consulta", e.getErrorCode(), e.getMessage());
        }

    }

    public void consultav2(int peticion, Connection conexion) throws ApplicationException {
        try {
            switch (peticion) {
                case 1:
                    PreparedStatement pre = conexion.prepareStatement("UPDATE parametros set consultaAbierta='N'");
                    int resultado = pre.executeUpdate();
                    if (resultado != 1) {
                        throw new ApplicationException("Error", 0, "cerrando consulta");
                    }
                    break;
                case 2:
                    PreparedStatement pre2 = conexion.prepareStatement("UPDATE parametros set consultaAbierta='S'");
                    int resultado2 = pre2.executeUpdate();
                    if (resultado2 != 1) {
                        throw new ApplicationException("Error", 0, "abriendo consulta");
                    }
                    break;
            }
        } catch (SQLException e) {
            throw new ApplicationException("Error abriendo/cerrando consulta", e.getErrorCode(), e.getMessage());
        }
    }

    public Parametros devuelveParametros(Connection conexion) throws ApplicationException {
        //metodo que devuelve todos los parametros 
        //ArrayList<Parametros> parametros=new ArrayList();
        Parametros parametro = new Parametros();
        try {
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * from parametros");
            if (rs.first()) {
                parametro = new Parametros(rs.getString("circunscripcion"), rs.getInt("numCandidatos"), rs.getString("tipoConsulta"), rs.getDate("fechaConsulta").toLocalDate(), rs.getString("escrutinioAbierto"), rs.getString("consultaAbierta"));
//                    while(rs.next()){
//                        //parametros.add(new Parametros(rs.getString("circunscripcion"),rs.getInt("numCandidatos"),rs.getString("tipoConsulta"),rs.getDate("fechaConsulta").toLocalDate(),rs.getString("escrutinioAbierto"),rs.getString("consultaAbierta")));
//                        parametro=new Parametros(rs.getString("circunscripcion"),rs.getInt("numCandidatos"),rs.getString("tipoConsulta"),rs.getDate("fechaConsulta").toLocalDate(),rs.getString("escrutinioAbierto"),rs.getString("consultaAbierta"));
//                    }
                return parametro;
            } else {
                throw new ApplicationException("Error", 0, "error devolviendo parametros generales");
            }
        } catch (SQLException e) {
            throw new ApplicationException(e.getMessage(), e.getErrorCode(), "error devolviendo parametros generales");
        }
    }

    public ArrayList<PartidoCandidato> devuelveElegido(Connection conexion) throws ApplicationException {
        //metodo que devuelve los partidos con los candidatos que han sido elegidos 
        Statement s, s1;
        ResultSet rs, rs2;
        ArrayList<PartidoCandidato> arrayPartido = new ArrayList();
        PartidoCandidato partido = new PartidoCandidato();
        ArrayList<Candidato> candidato = new ArrayList();
        boolean hecho=false;
        try {
            s = conexion.createStatement();
            rs = s.executeQuery("select * from partido p,escaño e where p.id=e.id_partido");
            while (rs.next()) {
                partido = new PartidoCandidato(rs.getInt("numEscaños"), rs.getInt("id"), rs.getString("denominacion"), rs.getString("siglas"), rs.getString("logo"), rs.getInt("votos"));
                arrayPartido.add(partido);
            }
                s1 = conexion.createStatement();
                rs2 = s.executeQuery("select c.* from partido p,candidatos c where p.id=c.id_partido");
                if (rs2.isBeforeFirst()) {
                    while (rs2.next()) {
                        candidato.add(new Candidato(rs2.getString("nombre_apellidos"), rs2.getInt("orden"),rs2.getInt("id_partido")));
                    }
                }
            for (int i = 0; i < arrayPartido.size(); i++) {

                    hecho=false;
                    for (int k = 0; k < candidato.size() && !hecho; k++) {
                        int a=arrayPartido.get(i).getId();
                        int b=candidato.get(k).getId_partido();
                        if (arrayPartido.get(i).getId() == candidato.get(k).getId_partido()) {
                            arrayPartido.get(i).setCandidato(candidato.get(k));
                         }
                         if (arrayPartido.get(i).getCandidatos().size()>=arrayPartido.get(i).getEscaños()) {
                            hecho=true;
                        }
                    }
            }
            return arrayPartido;
        } catch (SQLException e) {
            throw new ApplicationException("Error", e.getErrorCode(), e.getMessage());
        }

    }

}
