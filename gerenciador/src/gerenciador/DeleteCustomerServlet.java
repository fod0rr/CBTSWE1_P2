//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteCustomerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));

        try {
            CustomerDAO dao = new CustomerDAO();
            dao.delete(customerId);
            response.sendRedirect("listCustomers.jsp?status=deleted"); //
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Erro ao deletar cliente", e);
        }
    }
}