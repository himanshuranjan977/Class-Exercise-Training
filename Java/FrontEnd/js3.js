function findTotal() {
    var maths = document.getElementById("maths").value;
    var social = document.getElementById("social").value;
    var science = document.getElementById("science").value;

    var total = parseInt(maths) + parseInt(science) + parseInt(social);
    var average = total / 3;

    // Update the HTML elements
    document.getElementById("total").value = total;
    document.getElementById("average").textContent = average.toFixed(2);
}
