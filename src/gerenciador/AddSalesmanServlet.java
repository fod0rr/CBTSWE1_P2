//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class AddSalesmanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Salesman s = new Salesman();
        s.setSalesmanId(Integer.parseInt(request.getParameter("salesmanId")));
        s.setName(request.getParameter("name"));
        s.setCity(request.getParameter("city"));
        s.setCommission(Double.parseDouble(request.getParameter("commission")));

        try {
            SalesmanDAO dao = new SalesmanDAO();
            dao.insert(s);
            response.sendRedirect("addSalesman.jsp?status=ok");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Erro ao cadastrar vendedor", e);
        }
    }
}
