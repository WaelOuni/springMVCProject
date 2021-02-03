// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels: ['January', 'February', 'March'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3A2F31", "#A21773", "#EF1928"],
            borderColor: 'rgb(255, 99, 132)',
            data: [2, 10, 5]
        }]
    },
    // Configuration options go here
    options: {}
});