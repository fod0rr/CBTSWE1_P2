//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

import java.sql.Date;

public class Order {
    private int orderNo;
    private double purchaseAmt;
    private Date orderDate;
    private int customerId;
    private int salesmanId;

    public int getOrderNo() { return orderNo; }
    public void setOrderNo(int orderNo) { this.orderNo = orderNo; }

    public double getPurchaseAmt() { return purchaseAmt; }
    public void setPurchaseAmt(double purchaseAmt) { this.purchaseAmt = purchaseAmt; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getSalesmanId() { return salesmanId; }
    public void setSalesmanId(int salesmanId) { this.salesmanId = salesmanId; }
}
