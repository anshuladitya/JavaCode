package com.springPayPal.poc;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PayPalController {

    private final PayPalClient payPalClient;
    @Autowired
    PayPalController(PayPalClient payPalClient){
        this.payPalClient = payPalClient;
    }

    @RequestMapping(value = "/")
    public String showWelcomePage() {
    	return "Welcome";
    }
    	
    @RequestMapping(value = "/LoginPage")
    public String LoginPage() {
    	return "LoginPage";	
    }
    
    @RequestMapping(value = "/ShowItems")
    public String ShowItems(@RequestParam("Username") String Username,@RequestParam("Password") String Password) {
    	if (Username.equals("Admin") && Password.equals("Admin"))
    		return "ShowItems";
    	else
    		return "ErrorPage";
    }

    @RequestMapping(value = "/MakePayment")
    public ResponseEntity<Object> redirectToExternalUrl(@RequestParam("sum") String sum) throws URISyntaxException {
        URI paypal = new URI(payPalClient.createPayment(sum).get("redirect_url").toString());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(paypal);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
    	
    @RequestMapping(value = "/CompletePayment")
    public String completePayment(HttpServletRequest request, @RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
        payPalClient.completePayment(request);
        return "PaymentCompletion";
    }


}