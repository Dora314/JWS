<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Create Sales Invoice</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <h1>Create Sales Invoice</h1>
                    <form:form method="POST" action="/admin/sales-invoices/create" modelAttribute="salesInvoice">
                        <div class="mb-3">
                            <form:label path="customer" class="form-label">Customer:</form:label>
                            <form:select path="customer" class="form-select">
                                <form:option value="">-- Select Customer --</form:option>
                                <c:forEach items="${customers}" var="customer">
                                    <form:option value="${customer}">${customer.customerName}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="mb-3">
                            <form:label path="employee" class="form-label">Employee:</form:label>
                            <form:select path="employee" class="form-select">
                                <form:option value="">-- Select Employee --</form:option>
                                <c:forEach items="${employees}" var="employee">
                                    <form:option value="${employee.employeeId}">${employee.employeeName}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="mb-3">
                            <form:label path="stall" class="form-label">Stall:</form:label>
                            <form:select path="stall" class="form-select">
                                <form:option value="">-- Select Stall --</form:option>
                                <c:forEach items="${stalls}" var="stall">
                                    <form:option value="${stall.stallId}">${stall.stallName}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="mb-3">
                            <form:label path="totalAmount" class="form-label">Total Amount:</form:label>
                            <form:input path="totalAmount" class="form-control" type="number" step="0.01" />
                        </div>
                        <div class="mb-3">
                            <form:label path="discount" class="form-label">Discount:</form:label>
                            <form:input path="discount" class="form-control" type="number" step="0.01" />
                        </div>
                        <div class="mb-3">
                            <form:label path="paymentMethod" class="form-label">Payment Method:</form:label>
                            <form:input path="paymentMethod" class="form-control" />
                        </div>
                        <button type="submit" class="btn btn-primary">Create</button>
                    </form:form>
                    <a href="/admin/sales-invoices" class="btn btn-secondary mt-3">Back to Sales Invoices</a>
                </div>
            </body>

            </html>