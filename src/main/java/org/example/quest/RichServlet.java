package org.example.quest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/rich-servlet")
public class RichServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        String playerName = (String) session.getAttribute("playerName");

        String action = req.getParameter("action");

        if ("button1".equals(action)) {
            resp.sendRedirect("/rich-servlet");
            return;
        } else if ("button2".equals(action)) {
            resp.sendRedirect("second-servlet");
            return;
        }

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        out.println("<html><body>");
        out.println("<h2>Привет, " + session.getAttribute("playerName")+ "!</h2>");
        out.println("<h2>Вы тупой?</h2>");
        out.println("<form method='post' action='start-servlet'>");
        out.println("<button type='submit' name='action' value='button1'>Да</button>");
        out.println("<button type='submit' name='action' value='button2'>Нет</button>");
        out.println("</form>");
        out.println("</body></html>");
        out.close();
    }
}