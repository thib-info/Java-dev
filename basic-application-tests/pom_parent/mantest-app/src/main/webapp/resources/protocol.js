function listTestsProtocol(jsonTests){
    jsonTests = JSON.parse(jsonTests);
    var HTMLString = "<table id='tab-protocol-test'>\
    <thead><tr><td>Nom</td><td>Description</td><td>Status</td></tr></thead>\
    <tbody>";
    for(var i=0; i<jsonTests.store.length; i++){
        HTMLString += "<tr><td>" + jsonTests.store[i].name + "</td><td>" + jsonTests.store[i].description + "</td><td>" + jsonTests.store[i].result.status + "</td></tr>";
    }
    HTMLString += "</tbody></table>";

    var container = document.getElementById("container-protocol-test-tab");
    container.insertAdjacentHTML('beforeend', HTMLString);
    addTestToProtocol(jsonTests);
}

function addTestToProtocol(jsonTests, valueSent){
    var idProt = valueSent.split('&')[1].split('=')[1];
    console.log("Id du protocole: " + idProt);
    jsonTests = JSON.parse(jsonTests);
    var HTMLString = "<label>Vous pouvez sélectionner le test à ajouter au protocole:</label><select id='add-test-prot' name='test-prot'><option value=''>Select a test</option>";
    for(var i=0; i<jsonTests.store.length; i++){
        HTMLString += "<option value="+ jsonTests.store[i].id + ">"+ jsonTests.store[i].name +"</option>";
    }
    HTMLString+="</select><button id='add-test-prot-btn'>\
    Ajouter ce test\
    </button>";
    
    var container = document.getElementById("container-protocol-test-tab");
    container.insertAdjacentHTML('beforeend', HTMLString);

    var button = document.getElementById("add-test-prot-btn");
    button.addEventListener('click', function(){
        var idTest = document.getElementById('add-test-prot').value;
        var idS = document.getElementById('id-systeme').innerText.split(': ')[1];
        valueToSend = "idSystem=" + idS + "&idProtocol=" + idProt + "&idTest=" +idTest;
        ajaxSend(valueToSend, './addTestToProtocol',0);
    });
}