<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Create Promotion</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <h1>Create Promotion</h1>
                    <form:form method="POST" action="/admin/promotions/create" modelAttribute="promotion">
                        <div class="mb-3">
                            <form:label path="promotionName" class="form-label">Promotion Name:</form:label>
                            <form:input path="promotionName" class="form-control" />
                        </div>
                        <div class="mb-3">
                            <form:label path="promotionType" class="form-label">Promotion Type:</form:label>
                            <form:input path="promotionType" class="form-control" />
                        </div>
                        <div class="mb-3">
                            <form:label path="cdt" class="form-label">Condition:</form:label>
                            <form:input path="cdt" class="form-control" />
                        </div>
                        <div class="mb-3">
                            <form:label path="value" class="form-label">Value:</form:label>
                            <form:input path="value" class="form-control" type="number" step="0.01" />
                        </div>
                        <div class="mb-3">
                            <form:label path="startDate" class="form-label">Start Date:</form:label>
                            <form:input path="startDate" class="form-control" type="date" />
                        </div>
                        <div class="mb-3">
                            <form:label path="endDate" class="form-label">End Date:</form:label>
                            <form:input path="endDate" class="form-control" type="date" />
                        </div>
                        <button type="submit" class="btn btn-primary">Create</button>
                    </form:form>
                    <a href="/admin/promotions" class="btn btn-secondary mt-3">Back to Promotions</a>
                </div>
            </body>

            </html>