<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Sales Invoice Details</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        </head>

        <body>
            <div class="container mt-5">
                <h1>Sales Invoice Details</h1>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${salesInvoiceDetails}" var="detail">
                            <tr>
                                <td>${detail.product.productName}</td>
                                <td>${detail.quantity}</td>
                                <td>${detail.unitPrice}</td>
                                <td>${detail.quantity * detail.unitPrice}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="/admin/sales-invoices" class="btn btn-secondary mt-3">Back to Sales Invoices</a>
            </div>
        </body>

        </html>