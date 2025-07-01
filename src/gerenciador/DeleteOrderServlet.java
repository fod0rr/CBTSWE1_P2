//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteOrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderNo = Integer.parseInt(request.getParameter("orderNo"));

        try {
            OrderDAO dao = new OrderDAO();
            dao.delete(orderNo);
            response.sendRedirect("listOrders.jsp?status=deleted");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Erro ao deletar pedido", e);
        }
    }
}