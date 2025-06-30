//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class EditCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Customer customer = new Customer();
        customer.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
        customer.setCustName(request.getParameter("custName"));
        customer.setCity(request.getParameter("city"));
        customer.setGrade(Integer.parseInt(request.getParameter("grade")));
        customer.setSalesmanId(Integer.parseInt(request.getParameter("salesmanId")));

        try {
            CustomerDAO dao = new CustomerDAO();
            dao.update(customer);
            response.sendRedirect("listCustomers.jsp?status=updated");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Erro ao atualizar cliente", e);
        }
    }
}