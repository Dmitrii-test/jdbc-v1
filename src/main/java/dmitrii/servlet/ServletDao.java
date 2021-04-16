package dmitrii.servlet;


import dmitrii.dao.UsersDao;
import dmitrii.dao.UsersDaoJdbcImpl;
import dmitrii.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@WebServlet("/")
public class ServletDao extends HttpServlet {

    public static UsersDao usersDao;
    private Connection connection;


    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {
            //Настраиваем connection
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String driverClassName = properties.getProperty("driverClassName");
            // инициализируем драйвер sql
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
            usersDao = new UsersDaoJdbcImpl(connection);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional<User> user = usersDao.find(1);
        int i = 0;
        List<User> users = null;
        if (req.getParameter("firstName") != null) {
            String firstName = req.getParameter("firstName");
            users = usersDao.findAllByFirstName(firstName);
        } else {
            users = usersDao.findAll();
        }
        req.setAttribute("usersFromServer", users);
        req.getServletContext().getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first-name");
        String adress = req.getParameter("adress_tes");
        User user = new User(firstName, adress);
        usersDao.save(user);
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        usersDao.delete(Integer.valueOf(req.getParameter("id")));
    }
}