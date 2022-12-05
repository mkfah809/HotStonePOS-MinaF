var checkboxes = document.querySelectorAll("input[type=checkbox][name=settings]");

var toppingsArray = []
var addPizza = document.querySelector("#pizzaAdded");


var pizzaId = document.getElementById("pizzaId").innerText
var orderId = document.getElementById("orderId").innerText
var  pizza, topping



// Use Array.forEach to add an event listener to each checkbox.
checkboxes.forEach(function(checkbox) {
	checkbox.addEventListener('change', function() {
		toppingsArray =
			Array.from(checkboxes) // Convert checkboxes to an array to use filter and map.
				.filter(toppingValue => toppingValue.checked) // Use Array.filter to remove unchecked checkboxes.
				.map(toppingValue => toppingValue.value) // Use Array.map to extract only the checkbox values from the array of objects.


		toppingsArray.map(function(toppingValue) {

			let order =
			{
				'orderId': parseInt(orderId),
				'pizza':
				{
					'pizzaId': parseInt(pizzaId),
					topping:
					{
						'id': parseInt(toppingValue)
					}

				}

			}


			topping = {
				'id': parseInt(toppingValue)
			}


			console.log(JSON.stringify(order))


			fetch("/addItem/To/order/{orderId}/{custId}/{pizzaId}", {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
					'X-CSRF-TOKEN': document.getElementById('csrf').value
				},
				body: JSON.stringify(order)
			})


		})



	})
});