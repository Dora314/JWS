const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
    type: 'line', // Sử dụng 'line' cho area chart
    data: {
        labels: ['Tháng', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10'],
        datasets: [{
            label: 'Số lượng sản phẩm bán được',
            data: [60, 80, 50, 40, 50, 70, 60, 70, 50, 60], // Dữ liệu mẫu, thay bằng dữ liệu của bạn
            fill: true, // Tô màu dưới đường
            borderColor: 'rgba(75, 192, 192, 1)', // Màu đường viền
            backgroundColor: 'rgba(75, 192, 192, 0.2)', // Màu nền
            tension: 0.4 // Điều chỉnh độ cong của đường
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});