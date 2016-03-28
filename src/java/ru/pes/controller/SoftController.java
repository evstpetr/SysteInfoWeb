package ru.pes.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.pes.Objects.Soft;
import ru.pes.db.service.SoftService;

/**
 *
 * @author Admin
 */
public class SoftController extends HttpServlet {

    SoftService service = new SoftService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(getSoft("62"));

        }
    }

    private String getSoft(String id) {
        StringBuilder softs = new StringBuilder("");
        StringBuilder softs86 = new StringBuilder("");
        String s, s86;
        String res = "";

        
        Soft soft = service.findById(id);

        try {
            List<ArrayList<String>> si = getSI(soft.getSoft());
            int i = 0;
            for (String str : si.get(0)) {
                softs.append(getXMLObject("s" + i, str.equals("") ? null : str));
                i++;
            }
            s = getXMLObject("soft", softs.toString());
            if (si.get(1) != null) {
                int j = 0;
                for (String str : si.get(1)) {
                    softs86.append(getXMLObject("s" + j, str.equals("") ? null : str));
                    j++;
                }
            } else {
                softs86.append(getXMLObject("s0", "0"));
            }
            s86 = getXMLObject("soft86", softs86.toString());
            
            res = getXMLObject("softs", s + s86);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return res;
    }

    //Функция для формирования XML объектов extClosers - объект, str - данные
    private String getXMLObject(String extClosers, String str) {
        String res;
        res = "<" + extClosers + ">" + str + "</" + extClosers + ">";
        return res;
    }

    private List getSI(Blob blob) throws IOException, ClassNotFoundException, SQLException {
        ObjectInputStream ois = new ObjectInputStream(blob.getBinaryStream());

        ArrayList<ArrayList<String>> list =  (ArrayList<ArrayList<String>>) ois.readObject();

        return list;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
