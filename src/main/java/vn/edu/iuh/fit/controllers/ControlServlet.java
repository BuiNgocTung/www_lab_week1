package vn.edu.iuh.fit.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.repositories.AccountRespository;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Account;

import java.io.IOException;
@WebServlet( urlPatterns = {"/controller","/account"})
public class ControlServlet extends HttpServlet {

    private Account account = null;
    private RequestDispatcher requestDispatcher = null;
    private final AccountRespository accountRepository = new AccountRespository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        handleLogin(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
    }

    public void handleLogin(ServletRequest req, ServletResponse reqs) throws ServletException, IOException {

        requestDispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
        requestDispatcher.forward(req,reqs);
        String email = req.getParameter("email");
        String password = req.getParameter("psw");

        account =accountRepository.getAccountByEmailAndPassword(email,password);
        if (account != null){
            req.setAttribute("accountID", account.getAccountID());
            req.setAttribute("fullName", account.getFullName());
            req.setAttribute("email", account.getEmail());
            req.setAttribute("phone", account.getPhone());

        }
        else
            System.out.println("Sai");

    }
}