// script.js

// Giả sử bạn đã có một mảng chứa thông tin khách hàng
let customers = [
    { name: 'Đỗ Nam Trung', gender: 'Nam', birthYear: 1990, phone: '0123456789', address: 'Hà Nội' },
    // ... thêm khách hàng khác
];

const customerList = document.getElementById('customer-list');
const searchInput = document.getElementById('search');

// Hàm để hiển thị danh sách khách hàng
function displayCustomers(customersToDisplay) {
    customerList.innerHTML = ''; // Xóa nội dung cũ

    customersToDisplay.forEach(customer => {
        const row = customerList.insertRow();
        const nameCell = row.insertCell();
        const genderCell = row.insertCell();
        const birthYearCell = row.insertCell();
        const phoneCell = row.insertCell();
        const addressCell = row.insertCell();

        nameCell.textContent = customer.name;
        genderCell.textContent = customer.gender;
        birthYearCell.textContent = customer.birthYear;
        phoneCell.textContent = customer.phone;
        addressCell.textContent = customer.address;
    });
}

// Hiển thị danh sách khách hàng ban đầu
displayCustomers(customers);

// Xử lý sự kiện tìm kiếm
searchInput.addEventListener('input', () => {
    const searchTerm = searchInput.value.toLowerCase();
    const filteredCustomers = customers.filter(customer =>
        customer.name.toLowerCase().includes(searchTerm) ||
        customer.phone.includes(searchTerm)
    );
    displayCustomers(filteredCustomers);
});