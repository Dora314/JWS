package com.vn.jewelry_management_system.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.vn.jewelry_management_system.domain.SalesInvoice;
import com.vn.jewelry_management_system.domain.SalesInvoiceDetail;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@Service
public class InvoicePdfService {

    public byte[] generateInvoicePdf(SalesInvoice invoice) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        document.open();

        // Thiết lập font chữ cho toàn bộ tài liệu
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
        Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
        Font tableHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE); // Font màu trắng
                                                                                                     // cho header

        // Thêm tiêu đề hóa đơn
        Paragraph title = new Paragraph("HOA DON BAN HANG", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Thêm thông tin cửa hàng
        Paragraph storeInfo = new Paragraph("Cửa hàng ABC\nĐịa chỉ: 123 Đường XYZ, TP.HCM\nSố điện thoại: 0123456789",
                infoFont);
        storeInfo.setAlignment(Element.ALIGN_CENTER);
        document.add(storeInfo);

        // Thêm khoảng trống
        document.add(new Paragraph("\n"));

        // Thêm thông tin hóa đơn
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Paragraph invoiceInfo = new Paragraph(
                "Mã hóa đơn: " + invoice.getSalesInvoiceId() + "\n" +
                        "Ngày tạo: " + dateFormat.format(invoice.getCreatedDate()) + "\n" +
                        "Khách hàng: " + invoice.getCustomer().getCustomerName() + "\n" +
                        "Nhân viên: " + invoice.getEmployee().getEmployeeName() + "\n" +
                        "Quầy hàng: " + invoice.getStall().getStallName(),
                infoFont);
        document.add(invoiceInfo);

        // Thêm bảng chi tiết sản phẩm
        PdfPTable table = new PdfPTable(4); // 4 cột: Sản phẩm, Số lượng, Đơn giá, Thành tiền
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        // Thêm header cho bảng
        addTableHeader(table, tableHeaderFont);

        // Thêm chi tiết sản phẩm
        for (SalesInvoiceDetail detail : invoice.getSalesInvoiceDetails()) {
            table.addCell(detail.getProduct().getProductName());
            table.addCell(String.valueOf(detail.getQuantity()));
            table.addCell(String.valueOf(detail.getUnitPrice()));
            table.addCell(String.valueOf(detail.getUnitPrice().multiply(new BigDecimal(detail.getQuantity()))));
        }
        document.add(table);

        // Thêm tổng tiền và chiết khấu
        Paragraph totalInfo = new Paragraph(
                "Tổng tiền: " + invoice.getTotalAmount() + "\n" +
                        "Chiết khấu: " + invoice.getDiscount() + "\n" +
                        "Thành tiền: " + (invoice.getTotalAmount().subtract(invoice.getDiscount())),
                infoFont);
        totalInfo.setAlignment(Element.ALIGN_RIGHT);
        document.add(totalInfo);

        document.close();
        return out.toByteArray();
    }

    private void addTableHeader(PdfPTable table, Font font) {
        Stream.of("Sản phẩm", "Số lượng", "Đơn giá", "Thành tiền")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.GRAY); // Màu header
                    header.setBorderWidth(2);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER); // Căn giữa nội dung header
                    header.setPhrase(new Phrase(columnTitle, font));
                    table.addCell(header);
                });
    }
}