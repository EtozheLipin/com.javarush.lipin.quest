
import org.example.quest.RichServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RichServletTest {

    private RichServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        servlet = new RichServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession(false)).thenReturn(session);
    }

    @Test
    void testRedirectToStupidServlet() throws Exception {
        when(request.getParameter("action")).thenReturn("button1");

        servlet.doGet(request, response);

        verify(response).sendRedirect("stupid-servlet");
    }

    @Test
    void testRedirectToSmartServlet() throws Exception {
        when(request.getParameter("action")).thenReturn("button2");

        servlet.doGet(request, response);

        verify(response).sendRedirect("smart-servlet");
    }

    @Test
    void testHtmlRenderedWhenNoAction() throws Exception {
        when(request.getParameter("action")).thenReturn(null);
        when(session.getAttribute("playerName")).thenReturn("Alice");

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(pw);

        servlet.doGet(request, response);

        String result = sw.toString();

        assertTrue(result.contains("Имя пользователя: Alice"));
        assertTrue(result.contains("Вы тупой?"));
        assertTrue(result.contains("<button type='submit' name='action' value='button1'>Да</button>"));
        assertTrue(result.contains("<button type='submit' name='action' value='button2'>Нет</button>"));
    }

    @Test
    void testHtmlRenderedWhenPlayerNameIsNull() throws Exception {
        when(request.getParameter("action")).thenReturn(null);
        when(session.getAttribute("playerName")).thenReturn(null);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(pw);

        servlet.doGet(request, response);

        String result = sw.toString();

        assertTrue(result.contains("Имя пользователя: null"));
        assertTrue(result.contains("Вы тупой?"));
    }
}