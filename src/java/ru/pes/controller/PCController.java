package ru.pes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.pes.Objects.PC;
import ru.pes.db.service.PCService;

/**
 *
 * @author Admin
 */
public class PCController extends HttpServlet {

    PCService service = new PCService();//Вспомогательный сервис для работы с БД
    
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
            out.println(getPCS());
        }
    }

    private String getPCS() {
        StringBuilder res = new StringBuilder("");
        StringBuilder comps = new StringBuilder("");
        String comp, id, inv, loc, dep, pcName, mb_vendor, mb_name, ven, model, cores, mhz, ipAddr, macAddr, osName, osArch, ram, hdd; 
        
        List<PC> pcs = service.findAll();//Получаем весь набор компьютеров
        
        for (PC pc : pcs) {
           id = getXMLObject("id", String.valueOf(pc.getId()));
           inv = getXMLObject("inv", pc.getInventory().equals("") ? null : pc.getInventory()); // Сравниваем с пустой стройкой так как js плохо переваривает пустые строки
           loc = getXMLObject("loc", pc.getLocation());
           dep = getXMLObject("dep", pc.getDepartment());
           pcName = getXMLObject("pcname", pc.getName().equals("") ? null : pc.getName());
           mb_vendor = getXMLObject("mbvendor", pc.getMb_vendor().equals("") ? null : pc.getMb_vendor());
           mb_name = getXMLObject("mbname", pc.getMb_name().equals("") ? null : pc.getMb_name());
           ven = getXMLObject("ven", pc.getVendor().equals("") ? null : pc.getVendor());
           model = getXMLObject("model", pc.getModel().equals("") ? null : pc.getModel());
           cores = getXMLObject("cores", pc.getCores().equals("") ? null : pc.getCores());
           mhz = getXMLObject("mhz", pc.getMhz().equals("") ? null : pc.getMhz());
           ipAddr = getXMLObject("ipaddr", pc.getIpaddr().equals("") ? null : pc.getIpaddr());
           macAddr = getXMLObject("macaddr", pc.getMacaddr().equals("") ? null : pc.getMacaddr());
           osName = getXMLObject("osname", pc.getOsname().equals("") ? null : pc.getOsname());
           osArch = getXMLObject("osarch", pc.getOsarch().equals("") ? null : pc.getOsarch());
           ram = getXMLObject("ram", String.valueOf(pc.getRam()));
           hdd = getXMLObject("hdd", pc.getHdd().equals("") ? null : pc.getHdd());
           comp = id + inv + loc + dep + pcName + mb_vendor + mb_name + ven + model + cores
                   + mhz + ipAddr + macAddr + osName + osArch + ram + hdd;
          comps.append(getXMLObject("pc", comp));
        }
        res.append(getXMLObject("pcs", new String(comps)));
        return new String(res);
    }
    
    //Функция для формирования XML объектов extClosers - объект, str - данные
    private String getXMLObject(String extClosers, String str) {
        String res;
            res = "<" + extClosers + ">" + str + "</" + extClosers + ">";
        return res;
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
