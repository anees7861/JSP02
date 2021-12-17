package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.instamojo.wrapper.api.ApiContext;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderResponse;

import model.User;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			HttpSession hs = req.getSession();
			ApiContext context = 
					ApiContext.create("test_UiGa0J0jpkmV1bfzvERpWAzVhe28VaJhurB","test_DSdB4DaBKQDcqUe0Y6mplF73D88y9d3Qo5ZajN5ukwXYXAqKiYLNhpgrE6D4tTRMObrVECk267rbtIHd0aKCqAWRfRwtSZPml50wZj11vbmGWU5MhzvFSFgMCvU",ApiContext.Mode.TEST);
			Instamojo api = new InstamojoImpl(context);
			
			PaymentOrder order = new PaymentOrder();
			order.setName(((User)hs.getAttribute("u")).getUser());
			order.setEmail(((User)hs.getAttribute("u")).getMail());
			order.setPhone("9833065621");
			order.setCurrency("INR");
			order.setAmount((double) 11);
			order.setDescription("Description");
			order.setRedirectUrl("https://www.google.com");
			order.setWebhookUrl("https://www.google.com");
			order.setTransactionId(UUID.randomUUID().toString());
			
			PaymentOrderResponse payOrdResp = api.createPaymentOrder(order);
			resp.sendRedirect(payOrdResp.getPaymentOptions().getPaymentUrl());
			
		}catch (Exception e) {
			// TODO: handle exception
			PrintWriter pw = resp.getWriter();
			pw.println(e.getLocalizedMessage());
		}
	}
}
