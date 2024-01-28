function searchCustomer() {
    // Implement search logic here
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("customerTableBody");
    tr = table.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1]; // Change index based on the column you want to search
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function syncData() {
    
    // Call the remote API to fetch customer list and update the local database
    
     fetch('http://localhost:8089/api/customers/', {
        method: 'GET',
        headers: {
           'Authorization': 'Bearer your_jwt_token_here'
         }
     })
     .then(response => response.json())
     .then(data => {
         
    
     })
     .catch(error => console.error('Error:', error));
}

function addCustomer() {
    
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var street = document.getElementById("street").value;
    var address = document.getElementById("address").value;
    var city = document.getElementById("city").value;
    var state = document.getElementById("state").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;

    // Create a customer object with the input values

    
     var newCustomer = {
         "firstName": firstName,
         "lastName": lastName,
         "street": street,
         "address": address,
         "city": city,
         "state": state,
         "email": email,
         "phone": phone
     };

    // Send a request to the backend to add the new customer
    
     fetch('http://localhost:8089/api/customers/', {
         method: 'POST',
         headers: {
             'Content-Type': 'application/json'
         },
         body: JSON.stringify(newCustomer)
     })
     .then(response => response.json())
     .then(data => {
         
     })
     .catch(error => console.error('Error:', error));
}
