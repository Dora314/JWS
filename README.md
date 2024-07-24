## Phần mềm Quản lý Bán hàng Trang sức Jewelry Management System (JMS)

**Dự án Spring Boot cho công ty kinh doanh trang sức tại cửa hàng với nhiều quầy hàng.**

**Chức năng chính:**

* **Quản lý bán hàng:**
    * Tạo đơn hàng bán hàng tại quầy.
    * Nhập mặt hàng bằng cách quét barcode hoặc nhập mã hàng.
    * Tính toán giá bán tự động: `Giá bán = giá vốn sản phẩm * tỉ lệ áp giá`.
    * Tính toán giá vốn sản phẩm: `[giá vàng thời điểm * trọng lượng sản phẩm] + tiền công + tiền đá`.
    * Áp dụng chương trình khuyến mãi và chính sách ưu đãi cho khách hàng.
    * Tính toán chiết khấu: `Chiếu khấu = chiếu khẩu khuyến mãi (nếu có) + chiếu khẩu ưu đãi (nếu có)`.
    * In hóa đơn bán hàng và phiếu bảo hành (nếu có).
* **Quản lý mua lại hàng:**
    * Tạo đơn mua lại hàng tại quầy.
    * Tìm kiếm hóa đơn bán hàng của khách hàng.
    * Áp dụng chính sách ưu đãi giá mua lại.
    * Tính toán giá mua lại dựa trên loại sản phẩm (vàng, đá quý).
    * In hóa đơn mua hàng.
* **Quản lý sản phẩm:**
    * Khai báo thông tin sản phẩm (tên, loại, trọng lượng, đá quý, ...).
    * Khai báo giá vàng, bảng giá đá quý, tiền công.
    * Quản lý sản phẩm theo quầy hàng.
* **Quản lý khách hàng:**
    * Lưu trữ thông tin khách hàng.
    * Quản lý tích lũy điểm cho khách hàng.
* **Quản lý nhân viên và quầy hàng:**
    * Quản lý thông tin nhân viên và phân công quầy hàng.
    * Theo dõi doanh thu theo quầy hàng và nhân viên.
* **Bảng giá vàng:**
    * Hiển thị bảng giá vàng trực tiếp trên các thiết bị tivi tại cửa hàng.
* **Chính sách:**
    * Khai báo chính sách đổi trả trang sức.
* **Thống kê:**
    * Dashboard thống kê doanh thu, sản phẩm bán chạy, ...

**Công nghệ:**

* Java
* Spring Boot
* Spring Data JPA
* MySQL

**Cài đặt và chạy:**

1. Clone dự án từ Github.
2. Import dự án vào IDE (ví dụ: IntelliJ IDEA, Eclipse).
3. Cấu hình database trong file `application.properties`.
4. Chạy ứng dụng bằng cách chạy file main của Spring Boot.

**Liên hệ:**

* Anh Phan Le, Thien Duy, Thanh Ngan, Khanh Phong
* Email: anhphanle8818@gmail.com
