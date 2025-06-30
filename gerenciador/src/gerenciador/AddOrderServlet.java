//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class AddOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Order o = new Order();
        o.setOrderNo(Integer.parseInt(request.getParameter("orderNo")));
        o.setPurchaseAmt(Double.parseDouble(request.getParameter("purchaseAmt")));
        o.setOrderDate(Date.valueOf(request.getParameter("orderDate")));
        o.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
        o.setSalesmanId(Integer.parseInt(request.getParameter("salesmanId")));

        try {
            OrderDAO dao = new OrderDAO();
            dao.insert(o);
            response.sendRedirect("addOrder.jsp?status=ok");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Erro ao cadastrar pedido", e);
        }
    }
}
