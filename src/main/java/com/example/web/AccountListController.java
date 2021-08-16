package com.example.web;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JpaAccountRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/accountlist")
public class AccountListController extends HttpServlet {
    private AccountRepository accountRepository;

    @Override
    public void init() throws ServletException {
        accountRepository=new JpaAccountRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        if (httpSession != null) {
            String filter = req.getParameter("filter");
            List<Account> accounts = new ArrayList<>();
            if (filter == null || filter.equals("all")) {
                accounts = accountRepository.findAll();
            }
            if (filter != null) {
                if (filter.equals("top10")) {
                    accounts = accountRepository.findByLimit(10);
                }
            }
            req.setAttribute("accounts", accounts);
            req.getRequestDispatcher("/WEB-INF/accounts-list.jsp").forward(req, resp);

        }else {
            resp.sendRedirect("login.html");
        }

    }
}
