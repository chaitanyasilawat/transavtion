package controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.service.BankAccountDAO;
import com.trans.exception.BankTransactionException;

import con.sendFrom.SendMoneyForm;
import model.Bank_inf;

@Controller
public class MainController {

   @Autowired
   private BankAccountDAO bankAccountDAO;

   @RequestMapping(value = "/info", method = RequestMethod.GET)
   public String showBankAccounts(Model model) {
       List<Bank_inf> list = bankAccountDAO.listBankAccountInfo();

       model.addAttribute("accountInfos", list);

       return "accountsPage";
   }

   @RequestMapping(value = "/sendmoney", method = RequestMethod.GET)
   public String viewSendMoneyPage(Model model) {

       SendMoneyForm form = new SendMoneyForm(1L, 2L, 700d);

       model.addAttribute("sendMoneyForm", form);

       return "sendMoneyPage";
   }

 
   @RequestMapping(value = "/sendmoney", method = RequestMethod.POST)
   public String processSendMoney(Model model, SendMoneyForm sendMoneyForm) {

       System.out.println("Send Money: " + sendMoneyForm.getAmount());

       try {
           bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(), //
                   sendMoneyForm.getToAccountId(), //
                   sendMoneyForm.getAmount());
       } catch (BankTransactionException e) {
           model.addAttribute("errorMessage", "Error: " + e.getMessage());
           return "/sendMoneyPage";
       }
       return "redirect:/";
   }

}