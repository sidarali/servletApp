package by.iba.mikhailovich;

import by.iba.mikhailovich.List.ListService;
import by.iba.mikhailovich.dao.UserDao;
import by.iba.mikhailovich.util.HashPassword;
import org.apache.tomcat.util.http.parser.Cookie;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserDao daoUser = new UserDao();
        if (daoUser.isValidUser(name, HashPassword.getHash(password))) {
            request.getSession().setAttribute("username",name);
            request.setAttribute("name", name);
                    request.getRequestDispatcher("/GroupServlet").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Неверный логин или пароль!!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

}
