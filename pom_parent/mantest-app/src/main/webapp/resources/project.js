// Project JS here
window.onload = function(){
	listenerRapport();
  listenerNewTest();
  listenerDelete();
  listenerProtocol();
  listenerNewProtocol();
  listenerDeleteProtocol();
}

function listenerDeleteProtocol(){
  var cross = document.getElementsByClassName("delete-protocol");

  for(var i=0; i<cross.length; i++){
    cross[i].addEventListener('click', function(sender){
      console.log("test");
      deleteProtocol(sender);
    });
  }
}

function deleteProtocol(sender){
  var idProt = sender.originalTarget.parentElement.parentElement.id.split('_')[1];
  var idS = document.getElementById('id-systeme').innerText.split(': ')[1];
  var valueToSend = "idSystem=" + idS + "&idProtocol=" + idProt;
  ajaxSend(valueToSend, "/removeProtocol", 0);
}

function listenerNewProtocol(){
  var button = document.getElementById("addNewProtocol");
  button.addEventListener('click', function(){
    createNewProtocol();
  });
}

function createNewProtocol(){
  var container = document.getElementById("container-new-protocol");
  container.style = "";
  
  var buttonConfirm = document.getElementById("confirm-new-protocole");
  buttonConfirm.addEventListener('click', function(){createNewProtocoleSend();});
  
  var buttonCancel = document.getElementById("cancel-new-protocole");
  buttonCancel.addEventListener('clcik', function(){cancelNewProtocol();});
}

function createNewProtocoleSend(){
  var name = document.getElementById("input-new-protocole-name").value;
  var description = document.getElementById("input-new-protocole-description").value;
  var idS = document.getElementById('id-systeme').innerText.split(': ')[1];

  if(name != '' && description != ''){
    var valueToSend = "idSystem=" + idS + "&titleProtocol=" + name + "&descriptionProtocol=" + description;
    var path = "/addProtocol";
    ajaxSend(valueToSend, path, 3);
  }

}

function cancelNewProtocol(){
  var container = document.getElementById("container-new-protocol");
  container.style = "display: none";
  var name = document.getElementById("input-new-protocole-name").value = "";
  var description = document.getElementById("input-new-protocole-description").value = "";
}

function listenerProtocol(){
  var tableProt = document.getElementById("tab-protocols").children[1];

  for(var i=0; i<tableProt.children.length; i++){
    tableProt.children[i].addEventListener('click', function(sender){
      getElementsProtocols(sender);
    });
  }
}

function getElementsProtocols(sender){
  if(sender.originalTarget.parentElement.className === "delete-protocol")
    return;

  console.log(sender.originalTarget.parentElement.parentElement.className);
  var idS = document.getElementById('id-systeme').innerText.split(': ')[1];
  var protocol = sender.originalTarget.parentElement.id.split('_')[1];

  var nameProtocol = sender.originalTarget.parentElement.children[1].innerText;
  var titleProtcol = document.getElementById("name-protocol-test");
  titleProtcol.innerText = nameProtocol;

  var container = document.getElementById("container-protocol-test");
  container.style = "";

  var valueToSend = "idSystem=" + idS + "&idProtocol=" + protocol;
  ajaxSend(valueToSend, "/getProtocolTests", 2);
  ajaxSend(valueToSend, "/getAllTestsSystem", 10);
}

function listenerDelete(){
  var cross = document.getElementsByClassName('delete-test');
  for(var i=0; i<cross.length; i++){
    cross[i].addEventListener('click', function(event){
      deleteTest(event.target);
    });
  }
}

function deleteTest(sender){
  var idTestToDelete = sender.parentElement.parentElement.children[0].innerText;
  var idS = document.getElementById('id-systeme').innerText.split(': ')[1];
  var valueToSend = "idSystem=" + idS + "&idTest=" + idTestToDelete;
  ajaxSend(valueToSend, './removeTest', 1);
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