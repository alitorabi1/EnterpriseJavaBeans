package servlet;

import ejb.Chat;
import ejb.ChatEJBRemote;
import ejb.InvalidChatException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ChatServlet", urlPatterns = {"/ChatServlet"})
public class ChatServlet extends HttpServlet {

    @EJB
    private ChatEJBRemote chatEJB;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChatServlet</title>");            

            out.println("<script>");
            out.println("function clearChat(){");
            out.println("document.getElementById(\"chatBody\").innerHTML = \"\";");
            out.println("}");
            out.println("</script>");

            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome to Chat Servlet</h1>");
           
            out.println("<form id='frmChat'>");
            out.println("Name: <input type='text' name='name'><br/>");
            out.println("Chat: <input type='text' name='chat'><br/>");

            out.println("<div id=\"chatBody\">");
            try {
                String name = request.getParameter("name");
                String chat = request.getParameter("chat");
                DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                Date dateobj = new Date();

                chatEJB.addChat(name, chat, df.format(dateobj));
                ArrayList<Chat> list = chatEJB.getChat();

                for (Chat s : list) {
                    out.println(String.format("%s: %s &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(%s)", s.name, s.chat, s.date.toString()));
                    out.println("</br>");
                }
            } catch (RuntimeException | InvalidChatException ex) {
                ex.printStackTrace();
            }

            out.println("</div>");
            out.println("<input type='submit' value='Chat !'>");
            out.println("<input type=\"button\" value=\"Clear\" onclick=clearChat()><br/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
