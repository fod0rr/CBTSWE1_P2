//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class EditSalesmanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Salesman salesman = new Salesman();
        salesman.setSalesmanId(Integer.parseInt(request.getParameter("salesmanId")));
        salesman.setName(request.getParameter("name"));
        salesman.setCity(request.getParameter("city"));
        salesman.setCommission(Double.parseDouble(request.getParameter("commission")));

        try {
            SalesmanDAO dao = new SalesmanDAO();
            dao.update(salesman);
            response.sendRedirect("listSalesmen.jsp?status=updated");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Erro ao atualizar vendedor", e);
        }
    }
}