var inv;


function init() {
    inv = location.href.toString().substring(location.href.toString().indexOf('?')+1, location.href.toString().length-1);
    doRequest();
    
}

function doRequest() {
    request = new XMLHttpRequest();
    var url = "sof";
    request.open("GET", url, true);
    request.onreadystatechange = callback;
    request.send(null);
}

function callback() {
    //чтение ответа
    if (request.readyState === 4) {

        if (request.status === 200) {
            parseXML(request.responseXML);
            //alert(request.responseText);
        }
        else
            alert("WARNING  status is " + request.status);
    }
}

function parseXML(responseXML) {
    
    if (responseXML === null) {
        return false;
    } else {
        var softs = responseXML.getElementsByTagName("softs")[0];
        if (softs.getElementsByTagName("soft86")[0].childNodes.length > 1) {
            createTable("subtab0", softs.getElementsByTagName("soft86")[0]);
        }
        createTable("subtab1", softs.getElementsByTagName("soft")[0]);
    }
}

function createTable(tabName, arr) {

    var table = document.getElementsByClassName(tabName)[0];
    var row;
    var cell0;
    var cell1;
    var str;
    
    for (var i = 0; i < arr.childNodes.length; i++) {
        row = table.insertRow();
        str = arr.childNodes[i].childNodes[0].nodeValue;
        cell0 = row.insertCell(0);
        cell0.appendChild(document.createTextNode(str.substring(1, str.indexOf(','))));
        cell1 = row.insertCell(1);
        cell1.appendChild(document.createTextNode(str.substring(str.indexOf(',')+1, str.length-1)));
    } 
    
}

