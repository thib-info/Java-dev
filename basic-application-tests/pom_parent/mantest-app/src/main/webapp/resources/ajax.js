function ajaxSend(valueToSend, target, goal){
    var httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', target, true);
    httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    httpRequest.onreadystatechange = function(){
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            var response = httpRequest.responseText;
            if(goal == 10){
                addTestToProtocol(response, valueToSend);
                return;
            }
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