var form = document.getElementById('form');
var id = document.getElementById('id')
var phoneField = document.getElementById('phone')
var nameField = document.getElementById('name')

var addressLine1Field = document.getElementById('addressLine1')
var addressLine2Field = document.getElementById('addressLine2')
var cityField = document.getElementById('city')
var countryField = document.getElementById('country')
var regionField = document.getElementById('region')
var zipCodeField = document.getElementById('zipCode')

var customer

async function createEmployee() {
	form.addEventListener('submit', (e) => {
		e.preventDefault();


		fireRequest();



	})
}



function fireRequest() {

	customer = {
		id: id.value,
		name: nameField.value,
		phone: phoneField.value,
		address: {
			addressLine1: addressLine1Field.value,
			addressLine2: addressLine2Field.value,
			city: cityField.value,
			country: countryField.value,
			region: regionField.value,
			zipCode: zipCodeField.value
		}
	}

	fetch("/customer/information/", {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
			'X-CSRF-TOKEN': document.getElementById('csrf').value
		},
		body: JSON.stringify(customer)
	})
		.then((response) => response.json())
		.then((data) => {
			if (data === true) {
				alert("user exists")

			} else {
				alert("a new customer")
			}
		})

}


createEmployee()
//hideElements()
