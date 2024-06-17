import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Check if user is already logged in (has username attribute)
        if (session.getAttribute("username") != null) {
            response.getWriter().println("Welcome back, " + session.getAttribute("username"));
        } else {
            // User not logged in, prompt for username
            response.getWriter().println("<form method='post' action='servlet1'>");
            response.getWriter().println("Username: <input type='text' name='username' required>");
            response.getWriter().println("<input type='submit' value='Login'>");
            response.getWriter().println("</form>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        // Store username in session
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        // Redirect to another servlet (can be modified to show different content)
        response.sendRedirect("servlet2");
    }
}
