function ajaxSend(valueToSend, target, goal){
    var httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', target, true);
    httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    httpRequest.onreadystatechange = function(){
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var response = httpRequest.responseText;
            reactAjax(goal, response);
        }
    };

    httpRequest.send(valueToSend);
}

function reactAjax(index, response){
    switch(index){
        case 0: // Add new test
            reloadPage();
            break;
        case 1: // Remove test
            reloadPage();
            break;
        case 2: // Ask tests of a protocol
            listTestsProtocol(response);
            break;
        case 3: // Create New Protocol
            reloadPage();
            break;
        default:
            break;
    }
}

function reloadPage(){
    window.location = document.location.href;
}

function listTestsProtocol(jsonTests){
    jsonTests = JSON.parse(jsonTests);
    var HTMLString = "<table id='tab-protocol-test'>\
    <thead><tr><td>Nom</td><td>Description</td><td>Status</td></tr></thead>\
    <tbody>";
    for(var i=0; i<jsonTests.store.length; i++){
        HTMLString += "<tr><td>" + jsonTests.store[i].name + "</td><td>" + jsonTests.store[i].description + "</td><td>" + jsonTests.store[i].result.status + "</td></tr>";
    }
    HTMLString += "</tbody></table>";

    var container = document.getElementById("container-protocol-test");
    container.insertAdjacentHTML('beforeend', HTMLString);
}