<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Buyback Invoice Details</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        </head>

        <body>
            <div class="container mt-5">
                <h1>Buyback Invoice Details</h1>
                <a href="/admin/buyback-invoice-details/create" class="btn btn-primary mb-3">Create New Buyback Invoice
                    Detail</a>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Buyback Invoice</th>
                            <th>Product</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${buybackInvoiceDetails}" var="detail">
                            <tr>
                                <td>${detail.buybackInvoice.buybackInvoiceId}</td>
                                <td>${detail.product.productName}</td>
                                <td>${detail.quantity}</td>
                                <td>${detail.unitPrice}</td>
                                <td>
                                    <a href="/admin/buyback-invoice-details/edit/${detail.id.buybackInvoiceId}/${detail.id.productId}"
                                        class="btn btn-warning btn-sm">Edit</a>
                                    <a href="/admin/buyback-invoice-details/delete/${detail.id.buybackInvoiceId}/${detail.id.productId}"
                                        class="btn btn-danger btn-sm"
                                        onclick="return confirm('Are you sure you want to delete this buyback invoice detail?')">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </body>

        </html>