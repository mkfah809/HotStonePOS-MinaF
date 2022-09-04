var form = document.getElementById('form');
var submitBtn = document.querySelector('#submitBtn')
var username = document.getElementById('username');
var title = document.getElementById('title');
var password = document.getElementById('password');
var confirmPassword = document.getElementById('confirmPassword');
var eyeIcons = document.querySelectorAll('.fa-eye')
var employee
var employeeInputs
async function createEmployee() {
	submitBtn.addEventListener('submit', (e) => {
		e.preventDefault();
		if (checkInputs()) {
			alert('the inputs are ok, NOW insert ')
			employee = {
				empUsername: username.value,
				empTitle: title.value,
				empPassword: password.value
			}

			fireRequest()



		} else {
			alert('Check Inputs')
		}






	})
}


async function passwordShowUp() {
	eyeIcons.forEach((eyeIcon) => {
		eyeIcon.addEventListener('click', () => {

			if (eyeIcon.classList.contains('fa-eye')) {
				eyeIcon.classList.replace('fa-eye', 'fa-eye-slash')


				if (eyeIcon.getAttribute('id') === 'passwordEyeIcon') {
					password.type = 'text'
				} else {
					confirmPassword.type = 'text'
				}

			} else {
				eyeIcon.classList.replace('fa-eye-slash', 'fa-eye')
				if (eyeIcon.getAttribute('id') === 'passwordEyeIcon') {
					password.type = 'password'
				} else {
					confirmPassword.type = 'password'
				}
			}
		})
	})
}

function checkInputs() {
	var usernameValue = username.value.trim();
	var titleValue = title.value.trim();
	var passwordValue = password.value.trim();
	var confirmPasswordValue = confirmPassword.value.trim();

	if (usernameValue === '') {

		setErrorFor(username, 'Username cannot be blank')

		return false
	} else {

		setSuccessFor(username)
	}
	if (titleValue === 'none') {
		setErrorFor(title, 'title cannot be blank')
		return false
	} else {
		setSuccessFor(title)
	}

	if (passwordValue === '') {
		setErrorFor(password, 'password cannot be blank')
		return false
	} else if (!isPassword(passwordValue)) {

		setErrorFor(password, 'Please insert only numbers')
		return false
	} else {
		setSuccessFor(password)
	}

	if (confirmPasswordValue === '') {
		setErrorFor(confirmPassword, 'password cannot be blank')
		return false
	} else if (passwordValue !== confirmPasswordValue) {
		setErrorFor(confirmPassword, 'password does not match')
		return false
	} else {
		setSuccessFor(confirmPassword)
	}



	// submit into database
	return true

}

async function setErrorFor(input, message) {
	const formControl = input.parentElement; //.form-control
	const small = formControl.querySelector('small')

	small.innerText = message;

	formControl.className = 'form-control error'
}

async function setSuccessFor(input) {
	const formControl = input.parentElement; //.form-control
	formControl.className = 'form-control success'

}

function isPassword(password) {
	return new RegExp('[0-9]').test(password);
}

async function fireRequest() {

//	fetch('/register/new/employee', {
//		method: 'POST',
//		headers: {
//			'Content-Type': 'x-www-form-urlencoded',
//		},
//		body: JSON.stringify(employee)
//	}).then((response) => response.json())

	//	var request = new XMLHttpRequest();
	//	request.submit = function() {
	//		if (request.readyState == XMLHttpRequest.DONE) {
	//			location.reload();
	//		}
	//	}
	//
	//	// Headers for CSRF protection
	//	var token = $("meta[name='_csrf']").attr("content");
	//	var header = $("meta[name='_csrf_header']").attr("content");
	//
	//	request.open("POST", "/register/new/employee");
	//	request.setRequestHeader(header, token);  // < --This line throws syntax error.
	//	request.send(employee);
	//	request.contentType('application/json')

		(function testing() {
			var token = $("meta[name='_csrf']").attr("content")
			console.log(token)
			var header = $("meta[name='_csrf_header']").attr("content")
			console.log(header)
			$(document).ajaxSend(function(e, xhr, options) {
				xhr.setRequestHeader(header, token)
			})
		})
		$.ajax({
			contentType: 'application/x-www-form-urlencoded',
			data: JSON.stringify(employee),
			dataType: 'json',
			cache: false,
			type: 'POST',
			url: 'http://localhost:8080/register/new/employee'
		})

}

passwordShowUp()
createEmployee()

