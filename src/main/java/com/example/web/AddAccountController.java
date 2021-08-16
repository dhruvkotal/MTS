package com.example.web;

import com.example.repository.AccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.repository.JpaTxnRepository;
import com.example.repository.TxnRepository;
import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/addaccount"})
public class AddAccountController extends HttpServlet {

    TxrService txrService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        AccountRepository accountRepository=new JpaAccountRepository();
        TxnRepository txnRepository=new JpaTxnRepository();
        txrService=new TxrServiceImpl(accountRepository,txnRepository);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession=req.getSession(false);
        if(httpSession!=null) {
            req.getRequestDispatcher("/WEB-INF/add-account-form.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("login.html");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession=req.getSession(false);
        if(httpSession!=null) {
            // Input
            double balance=Double.parseDouble(req.getParameter("balance"));
            String number=req.getParameter("number");

            // Process
            txrService.addAcc(number,balance);

            // Output
            req.setAttribute("message", "Account added successfully");
            req.getRequestDispatcher("/WEB-INF/acc-status.jsp").forward(req, resp);


        }else {
            resp.sendRedirect("login.html");
        }

    }
}
