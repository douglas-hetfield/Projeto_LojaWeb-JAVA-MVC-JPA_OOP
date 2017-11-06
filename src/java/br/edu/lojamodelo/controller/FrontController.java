package br.edu.lojamodelo.controller;

import br.edu.lojamodelo.logica.Logica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fc")
@MultipartConfig(  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
          maxFileSize = 1024 * 1024 * 10, // 10 MB
          maxRequestSize = 1024 * 1024 * 15, // 15 MB 
          location = "/"//para uso do glassfish. Retirar no Tomcat
        )

public class FrontController extends HttpServlet {
    
    private final String localLogica = "br.edu.lojamodelo.logica.";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String parametro = request.getParameter("logica");
        String nomeDaClasse = localLogica + parametro;
        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Logica logica = (Logica) classe.newInstance();
            // Recebe o String após a execução da lógica
            String pagina = logica.executa(request, response);
            // Faz o forward para a página JSP
            request.getRequestDispatcher(pagina).forward(request, response);
        } catch (Exception e) {
            throw new ServletException("A lógica de negócios causou uma exceção.", e);
        }

    }

//Codido doGET e doPOST
//<editor-fold>
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}