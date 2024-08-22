<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Sales Invoices</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <h1>Sales Invoices</h1>
                    <a href="/admin/sales-invoices/create" class="btn btn-primary mb-3">Create New Sales Invoice</a>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Created Date</th>
                                <th>Customer</th>
                                <th>Employee</th>
                                <th>Stall</th>
                                <th>Total Amount</th>
                                <th>Discount</th>
                                <th>Payment Method</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${salesInvoices}" var="salesInvoice">
                                <tr>
                                    <td>${salesInvoice.salesInvoiceId}</td>
                                    <td>
                                        <fmt:formatDate value="${salesInvoice.createdDate}"
                                            pattern="yyyy-MM-dd HH:mm:ss" />
                                    </td>
                                    <td>${salesInvoice.customer.customerName}</td>
                                    <td>${salesInvoice.employee.employeeName}</td>
                                    <td>${salesInvoice.stall.stallName}</td>
                                    <td>${salesInvoice.totalAmount}</td>
                                    <td>${salesInvoice.discount}</td>
                                    <td>${salesInvoice.paymentMethod}</td>
                                    <td>
                                        <a href="/admin/sales-invoices/edit/${salesInvoice.salesInvoiceId}"
                                            class="btn btn-warning btn-sm">Edit</a>
                                        <a href="/admin/sales-invoices/delete/${salesInvoice.salesInvoiceId}"
                                            class="btn btn-danger btn-sm"
                                            onclick="return confirm('Are you sure you want to delete this sales invoice?')">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </body>

            </html>