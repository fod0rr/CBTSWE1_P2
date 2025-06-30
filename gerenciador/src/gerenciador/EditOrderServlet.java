//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class EditOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Order order = new Order();
        order.setOrderNo(Integer.parseInt(request.getParameter("orderNo")));
        order.setPurchaseAmt(Double.parseDouble(request.getParameter("purchaseAmt")));
        order.setOrderDate(Date.valueOf(request.getParameter("orderDate")));
        order.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
        order.setSalesmanId(Integer.parseInt(request.getParameter("salesmanId")));

        try {
            OrderDAO dao = new OrderDAO();
            dao.update(order);
            response.sendRedirect("listOrders.jsp?status=updated");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Erro ao atualizar pedido", e);
        }
    }
}