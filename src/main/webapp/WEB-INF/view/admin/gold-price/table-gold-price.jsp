<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Gold Prices</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <h1>Gold Prices</h1>
                    <a href="/admin/gold-prices/create" class="btn btn-primary mb-3">Add New Gold Price</a>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Update Date</th>
                                <th>Gold Price</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${goldPrices}" var="goldPrice">
                                <tr>
                                    <td>${goldPrice.goldPriceId}</td>
                                    <td>
                                        <fmt:formatDate value="${goldPrice.updateDate}" pattern="yyyy-MM-dd" />
                                    </td>
                                    <td>${goldPrice.goldPrice}</td>
                                    <td>
                                        <a href="/admin/gold-prices/edit/${goldPrice.goldPriceId}"
                                            class="btn btn-warning btn-sm">Edit</a>
                                        <a href="/admin/gold-prices/delete/${goldPrice.goldPriceId}"
                                            class="btn btn-danger btn-sm"
                                            onclick="return confirm('Are you sure you want to delete this gold price record?')">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </body>

            </html>