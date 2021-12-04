// Project JS here
window.onload = function(){
	listenerRapport();
}

function listenerNewTest(){
  var buttonNewTest = document.getElementById('addNewTest');
  buttonNewTest.addEventListener('click', function(event){
    printNewTestFrom();
  });
}

function printNewTestFrom(){
  var addTestBut = document.getElementById('addNewTest').style = "display: none";
  var form = document.getElementById('container-new-test').style = "";
  var confirmBut = document.getElementById('confirm-new-test');
  var cancelBut = document.getElementById('cancel-new-test');

  confirmBut.addEventListener('click', function(){
    addNewTest();
  });

  cancelBut.addEventListener('click', function(){
    cleanFormNewTest();
  });

}

function addNewTest(){
  var idS = document.getElementById('id-systeme').innerText.split(': ')[1];
  var titleTest = document.getElementsByClassName('input-new-test')[0].value;
  var descriptionTest = document.getElementsByClassName('input-new-test')[1].value;

  if(titleTest != '' && descriptionTest != ''){
    var valueToSend = "idSystem=" + idS + "&titleTest=" + titleTest + "&descriptionTest=" + descriptionTest;
    var path = "./addTest";
    ajaxSend(valueToSend, path, 0);
  }

}

function cleanFormNewTest(){
  var inputNewTest = document.getElementsByClassName('input-new-test');
  for(var i=0; i<inputNewTest.length; i++)
    inputNewTest[i].value = "";
  
  var form = document.getElementById('container-new-test').style = "display: none";
  var addTestBut = document.getElementById('addNewTest').style = "";
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