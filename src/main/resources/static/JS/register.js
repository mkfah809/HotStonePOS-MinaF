var form = document.getElementById('form');
var username = document.getElementById('username');
var title = document.getElementById('title');
var password = document.getElementById('password');
var confirmPassword = document.getElementById('confirmPassword');
var submitBtn = document.querySelector('#submitBtn')
var eyeIcons = document.querySelectorAll('.fa-eye')
var employee
var employeeInputs


async function createEmployee() {
	form.addEventListener('submit', (e) => {
		e.preventDefault();
		employeeInputs = checkInputs();
		alert(employeeInputs)

		employee = {
			empUsername: username.value,
			empPassword: password.value,
			empTitle: title.value
		}
		
		if(employeeInputs === true) {
			fetch('/register/new/employee', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(employee)
			}).then((response) => response.json())
		} else {
			alert('error in fetching')
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
		const passNum = isPassword()
		alert(passNum)
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

function setErrorFor(input, message) {
	const formControl = input.parentElement; //.form-control
	const small = formControl.querySelector('small')

	small.innerText = message;

	formControl.className = 'form-control error'
}

function setSuccessFor(input) {
	const formControl = input.parentElement; //.form-control
	formControl.className = 'form-control success'

}

function isPassword(password) {
	return new RegExp('[0-9]').test(password);
}



passwordShowUp()
createEmployee()


