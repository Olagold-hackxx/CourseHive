
 const signInForm = document.getElementById('sign-in-form');
 const signUpForm = document.getElementById('sign-up-form');
 
 const showSignUpLink = document.getElementById('show-signup');
 const showSignInLink = document.getElementById('show-signin');
 
 showSignUpLink.addEventListener('click', function() {
     signInForm.style.display = 'none';  
     signUpForm.style.display = 'block'; 
 });
 
 showSignInLink.addEventListener('click', function() {
     signUpForm.style.display = 'none';  
     signInForm.style.display = 'block'; 
 });



const updatePanel = document.getElementById('update-panel');
const closeButton = document.getElementById('close-btn');

window.onload = () => {
  setTimeout(() => {
    updatePanel.classList.add('show'); 
  }, 100); 
};
closeButton.addEventListener('click', () => {
  updatePanel.style.display = 'none'; 
});



function delayedRedirect() {
  var buttonText = document.getElementById('buttonText');
  var spinner = document.getElementById('spinner');

  buttonText.style.display = 'none';
  spinner.style.display = 'block';

  document.getElementById('loadingButton').disabled = true;

  setTimeout(function() {
      buttonText.style.display = 'inline-block';
      spinner.style.display = 'none';
      document.getElementById('loadingButton').disabled = false;
  }, 3000)

  setTimeout(function() {
    window.location.href = 'main.html';
  }, 2000); 
}

