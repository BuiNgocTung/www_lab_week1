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
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.repositories.AccountRespository;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.RoleRepository;

import java.io.IOException;
@WebServlet( urlPatterns = {"/controller","/action"})
public class ControlServlet extends HttpServlet {


    private RequestDispatcher requestDispatcher = null;
    private  AccountRespository accountRepository = new AccountRespository();
    private RoleRepository roleRepository = new RoleRepository();

    private Account account = null;


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


        String email = req.getParameter("email");
        String password = req.getParameter("psw");

        account =accountRepository.getAccountByEmailAndPassword(email,password);
        if (account != null){
            Role role = roleRepository.findRoleByAccountId(account.getAccountID());
            if (role != null)
            {
                if (role.getRoleID().equalsIgnoreCase("admin"))
                {
                    req.setAttribute("roleID", role.getRoleID());
                    req.setAttribute("accountID", account.getAccountID());
                    req.setAttribute("fullName", account.getFullName());
                    req.setAttribute("email", account.getEmail());
                    req.setAttribute("phone", account.getPhone());
                    requestDispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
                    requestDispatcher.forward(req,reqs);
                }
                else {

                    req.setAttribute("accountID", account.getAccountID());
                    req.setAttribute("fullName", account.getFullName());
                    req.setAttribute("email", account.getEmail());
                    req.setAttribute("phone", account.getPhone());
//                    table role
                    req.setAttribute("roleID", role.getRoleID());
                    req.setAttribute("roleName", role.getRoleName());
                    req.setAttribute("description", role.getDescription());
                    requestDispatcher = getServletContext().getRequestDispatcher("/user.jsp");
                    requestDispatcher.forward(req,reqs);


                }
            }

        }
        else
            System.out.println("Sai");

    }
}