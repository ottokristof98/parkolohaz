/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Exceptiondata;
import org.json.JSONArray;
import org.json.JSONObject;
import service.ExceptionDataService;

/**
 *
 * @author zsipaak
 */
public class ExceptionDataController extends HttpServlet {

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
        response.setContentType("application/json");
        ExceptionDataService edService = new ExceptionDataService();
        try{
            if(request.getParameter("task") != null){
                if(request.getParameter("task").equals("getAllException")){
                    PrintWriter _package = response.getWriter();
                    List<Exceptiondata> data = edService.getAllException(1);
                    JSONArray allException = new JSONArray();
                    for(Exceptiondata exx : data){
                        JSONObject obj = new JSONObject();
                        obj.put("id", exx.getExceptiondataid());
                        obj.put("createdon", exx.getCreatedon());
                        obj.put("description", exx.getGroupname());
                        allException.put(obj);
                    }
                    _package.write(allException.toString());
                }
                if(request.getParameter("task").equals("loadOneException")){
                    PrintWriter _package = response.getWriter();
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    Exceptiondata exd = edService.getOneException(id);
                    JSONObject obj = new JSONObject();
                    obj.put("createdon", exd.getCreatedon());
                    obj.put("groupname", exd.getGroupname());
                    obj.put("stacktrace", exd.getStacktrace());
                    obj.put("description", exd.getDescription());
                    _package.print(obj.toString());
                }
                if(request.getParameter("task").equals("createNullPointerException")){
                    Integer demo = null;
                    String pelda = "";
                    try{
                        pelda = "Ez a példa";
                        Integer x = demo * demo + 2;
                    }
                    catch(Exception e){
                        Integer id = new Random().nextInt();
                        Date now = Calendar.getInstance().getTime();
                        String group = e.toString();
                        String stacktrace = Arrays.toString(e.getStackTrace());
                        String description = "";
                        //String state = "";
                        Exceptiondata eData = new Exceptiondata(id, now, group, stacktrace, description);
                        eData.addStateElement("pelda", pelda);
                        eData.addStateElement("x", demo);
                        edService.createException(eData);
                    }
                    PrintWriter _package = response.getWriter();
                    List<Exceptiondata> data = edService.getAllException(1);
                    JSONArray allException = new JSONArray();
                    for(Exceptiondata exx : data){
                        JSONObject obj = new JSONObject();
                        obj.put("id", exx.getExceptiondataid());
                        obj.put("createdon", exx.getCreatedon());
                        obj.put("description", exx.getGroupname());
                        allException.put(obj);
                    }
                    _package.write(allException.toString());
                    
                }
                if(request.getParameter("task").equals("saveDS")){
                    if(request.getParameter("id") != null &&
                    request.getParameter("description") != null){
                        Integer id = Integer.parseInt(request.getParameter("id"));
                        String description = request.getParameter("description");
                        String msg = "Hiba";
                        if(edService.save(id, description)){
                            msg = "Siker";
                        }
                        PrintWriter _package = response.getWriter();
                        JSONObject obj = new JSONObject();
                        obj.put("valasz", msg);
                        _package.write(obj.toString());
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
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
