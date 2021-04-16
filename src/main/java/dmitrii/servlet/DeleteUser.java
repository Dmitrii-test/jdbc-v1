package dmitrii.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del")
public class DeleteUser extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletDao.usersDao.delete(Integer.valueOf(req.getParameter("id")));
        req.getServletContext().getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
    }
}
