package org.example.quest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/start-servlet")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        HttpSession session = req.getSession();

        String playerName = req.getParameter("playerName");

        if (playerName != null && !playerName.isEmpty()) {
            session.setAttribute("playerName", playerName);
        }

        String action = req.getParameter("action");

        if ("button1".equals(action)) {
            resp.sendRedirect("rich-servlet");
            return;
        } else if ("button2".equals(action)) {
            resp.sendRedirect("no-money-servlet");
            return;
        }

        PrintWriter out = resp.getWriter();
        out.println("<html><head>");
        out.println("<style>");
        out.println("body { background-color: #121212; color: #f1f1f1; font-family: Arial, sans-serif; text-align: center; padding-top: 50px; }");
        out.println("button { background-color: #1f1f1f; color: white; padding: 10px 20px; border: none; border-radius: 8px; font-size: 16px; cursor: pointer; margin: 10px; }");
        out.println("button:hover { background-color: #333333; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<h2>Имя пользователя: " + session.getAttribute("playerName") + "</h2>");
        out.println("<h2>Хотите много зарабатывать?</h2>");
        out.println("<form method='get' action='start-servlet'>");
        out.println("<button type='submit' name='action' value='button1'>Да</button>");
        out.println("<button type='submit' name='action' value='button2'>Нет</button>");
        out.println("</form>");
        out.println("</body></html>");
        out.close();
    }
}