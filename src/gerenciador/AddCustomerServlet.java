package gerenciador;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Customer customer = new Customer();
        customer.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
        customer.setCustName(request.getParameter("custName"));
        customer.setCity(request.getParameter("city"));
        customer.setGrade(Integer.parseInt(request.getParameter("grade")));
        customer.setSalesmanId(Integer.parseInt(request.getParameter("salesmanId")));

        try {
            CustomerDAO dao = new CustomerDAO(); // Já se conecta ao banco internamente
            dao.insert(customer);
            response.sendRedirect("addCustomer.jsp?status=ok");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Erro ao cadastrar cliente", e);
        }
    }
}
