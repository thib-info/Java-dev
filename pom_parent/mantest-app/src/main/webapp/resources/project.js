// Project JS here
window.onload = function(){
	listenerRapport();
}


function listenerRapport(){
	var tests = document.getElementsByClassName("generate-rapport");
	for(var i=0; i<tests.length; i++){
		tests[i].addEventListener('click', function(event){
			generateRapport(event.target);
		});
	}
}

function generateRapport(s){
	var idT = s.parentElement.children[0].innerText;
	var idS = document.getElementById('id-systeme').innerText.split(': ')[1];
	post('/rapport', {idSystem: idS, idTest: idT});
}


function post(path, params, method='post') {

  const form = document.createElement('form');
  form.style = "display: none;";
  form.method = method;
  form.action = path;

  for (const key in params) {
    if (params.hasOwnProperty(key)) {
      const hiddenField = document.createElement('input');
      hiddenField.type = 'hidden';
      hiddenField.name = key;
      hiddenField.value = params[key];
      form.appendChild(hiddenField);
    }
  }

  document.body.appendChild(form);
  form.submit();
}