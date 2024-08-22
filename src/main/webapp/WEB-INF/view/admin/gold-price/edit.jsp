<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Edit Gold Price</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <h1>Edit Gold Price</h1>
                    <form:form method="POST" action="/admin/gold-prices/edit/${goldPrice.goldPriceId}"
                        modelAttribute="goldPrice">
                        <div class="mb-3">
                            <form:label path="updateDate" class="form-label">Update Date:</form:label>
                            <form:input path="updateDate" class="form-control" type="date" />
                        </div>
                        <div class="mb-3">
                            <form:label path="goldPrice" class="form-label">Gold Price:</form:label>
                            <form:input path="goldPrice" class="form-control" type="number" step="0.01" />
                        </div>
                        <button type="submit" class="btn btn-primary">Update</button>
                    </form:form>
                    <a href="/admin/gold-prices" class="btn btn-secondary mt-3">Back to Gold Prices</a>
                </div>
            </body>

            </html>