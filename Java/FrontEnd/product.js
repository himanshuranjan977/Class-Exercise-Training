function findDetail() {
    var name = document.getElementById("name").value.trim();
    var price = document.getElementById("price").value;
    var discount = document.getElementById("discount").value;
    var tax = document.getElementById("tax").value;

    // Validation for Name
    if (name === '') {
        alert("Please enter a product name");
        return;
    }

    // Price validation
    if (price === '' || isNaN(price) || parseFloat(price) <= 0) {
        alert("Please enter a valid price greater than 0");
        return;
    }
    price = parseFloat(price);

    // Discount validation
    if (discount === '' || isNaN(discount) || discount < 0 || discount > 100) {
        alert("Please enter a discount between 0 and 100");
        return;
    }
    discount = parseFloat(discount);

    // Tax validation
    if (tax === '' || isNaN(tax) || tax < 0) {
        alert("Please enter a valid tax percentage");
        return;
    }
    tax = parseFloat(tax);

    // Calculate final price
    var discountedPrice = price - (price * (discount / 100));
    var finalPrice = discountedPrice + (discountedPrice * (tax / 100));

    // Output to table
    document.getElementById("nameTd").textContent = name;
    document.getElementById("priceTd").textContent = price.toFixed(2);
    document.getElementById("discountTd").textContent = discount + "%";
    document.getElementById("taxTd").textContent = tax + "%";
    document.getElementById("finalPriceTd").textContent = finalPrice.toFixed(2);
}
