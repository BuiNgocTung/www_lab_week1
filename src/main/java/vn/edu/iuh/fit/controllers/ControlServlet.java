package vn.edu.iuh.fit.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.repositories.AccountRespository;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Account;

import java.io.IOException;

@WebServlet(name = "ControlServlet", urlPatterns = {"/ControlServlet"})
public class ControlServlet extends HttpServlet {
    private final EntityManagerFactory emf = Connection.getInstance().getEntityManagerFactory();
    private final AccountRespository accountRepository = new AccountRespository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            login(request, response);
        } else if ("logout".equals(action)) {
            logout(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        EntityManager em = emf.createEntityManager();
        try {
            Account account = accountRepository.getAccountByEmail(em, email);

            if (account != null && account.getpassword().equals(password) && account.getStatus() == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedIn", true);
                session.setAttribute("email", email);

                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("index.jsp?error=true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=true");
        } finally {
            em.close();
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("loggedIn");
        session.removeAttribute("email");
        session.invalidate();

        response.sendRedirect("index.jsp");
    }

    @Override
    public void destroy() {
        emf.close();
    }
}