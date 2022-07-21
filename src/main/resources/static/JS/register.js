var username = document.querySelector('#username')
var submitBtn = document.querySelector('#submitBtn')
var password = document.querySelector('#password');
var confirmPassword = document.querySelector('#confirmPassword');
var eyeIcons = document.querySelectorAll('.fa-eye')
var title = document.querySelector('#title')

async function createEmployee() {
	submitBtn.addEventListener('click', () => {
		if(username.value == "") {
			alert("Username Can't Be Empty!")
		  } else if (title.value === "none") {
			alert("Please Select A Role")
		  }else if(password.value == "") {
			alert("Password Can't Be Empty!")
		  } else if(password.value != confirmPassword.value){
		  	alert("Password Must Be The Same!")
		  } else if (password === confirmPassword){
			alert("It's Nice Having You'")
		}
	
	});
}


async function passwordShowUp() {
	eyeIcons.forEach((eyeIcon) => {
		eyeIcon.addEventListener('click', () => {
			console.log(eyeIcon)
			if (eyeIcon.classList.contains('fa-eye')) {
				eyeIcon.classList.replace('fa-eye', 'fa-eye-slash')


				if (eyeIcon.getAttribute('id') === 'passwordEyeIcon') {
					document.querySelector("#password").type = 'text'
				} else {
					document.querySelector("#confirmPassword").type = 'text'
				}

			} else {
				eyeIcon.classList.replace('fa-eye-slash', 'fa-eye')
				if (eyeIcon.getAttribute('id') === 'passwordEyeIcon') {
					document.querySelector('#password').type = 'password'
				} else {
					document.querySelector('#confirmPassword').type = 'password'
				}
			}


		})
	})
}



createEmployee()
passwordShowUp()


//		alert.log("validate funn")
//		
//		if (pass != confirm_pass) {
//			alert.log("if stt")
//			document.getElementById('wrong_pass_alert').style.color = 'red';
//			document.getElementById('wrong_pass_alert').innerHTML
//				= '☒ Use same password';
//			document.getElementById('create').disabled = true;
//			document.getElementById('create').style.opacity = (0.4);
//		} else {
//			alert.log("else stt")
			//                document.getElementById('wrong_pass_alert').style.color = 'green';
			//                document.getElementById('wrong_pass_alert').innerHTML =
			//                    '🗹 Password Matched';
			//                document.getElementById('create').disabled = false;
			//                document.getElementById('create').style.opacity = (1);
//		}
//
	
//}




//        function wrong_pass_alert() {
//            if (document.getElementById('pass').value != "" &&
//                document.getElementById('confirm_pass').value != "") {
//                alert("Your response is submitted");
//            } else {
//                alert("Please fill all the fields");
//            }
//        }