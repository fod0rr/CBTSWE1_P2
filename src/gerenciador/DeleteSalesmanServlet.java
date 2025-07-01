//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteSalesmanServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));

        try {
            SalesmanDAO dao = new SalesmanDAO();
            dao.delete(salesmanId);
            response.sendRedirect("listSalesmen.jsp?status=deleted");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Erro ao deletar vendedor", e);
        }
    }
}