var request;
var table;
var headers;
var body;
var flagTD = true;

var mbVendors = new Object();
    mbVendors.ASUS = "http://www.asus.com";
    mbVendors.ASUSTek = "http://www.asus.com";
    mbVendors.Intel = "http://www.intel.ru";
    mbVendors.MSI = "https://ru.msi.com";
    mbVendors.GIGABYTE = "http://www.gigabyte.ru";
    mbVendors.ASROCK = "http://www.asrock.com";

function doRequest() {
    //Создаем таблицу
    createTable();
    //Формируем запрос к базе
    request = new XMLHttpRequest();
    var url = "pc"; //контекстное имя сервлета
    request.open("GET", url, true);
    request.onreadystatechange = callback;
    request.send(null);
}


function callback() {
    //чтение ответа
    if (request.readyState === 4) {

        if (request.status === 200) {
            parseXML(request.responseXML);
        }
        else
            alert("WARNING  status is " + request.status);
    }
}

function parseXML(responseXML) {


    //not response
    if (responseXML === null) {

        return false;
    } else {
        //Если ответ получен формируем массив данных
        var pcs = responseXML.getElementsByTagName("pcs")[0];
        
        if (pcs.childNodes.length > 0) {
            
            for (var i = 0; i < pcs.childNodes.length; i++) {
                var pc = pcs.childNodes[i];
                var id = pc.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                var inv = pc.getElementsByTagName("inv")[0].childNodes[0].nodeValue;
                var loc = pc.getElementsByTagName("loc")[0].childNodes[0].nodeValue;
                var dep = pc.getElementsByTagName("dep")[0].childNodes[0].nodeValue;
                var pcname = pc.getElementsByTagName("pcname")[0].childNodes[0].nodeValue;
                var mb_vendor = pc.getElementsByTagName("mbvendor")[0].childNodes[0].nodeValue;
                var mb_name = pc.getElementsByTagName("mbname")[0].childNodes[0].nodeValue;
                var ven = pc.getElementsByTagName("ven")[0].childNodes[0].nodeValue;
                var model = pc.getElementsByTagName("model")[0].childNodes[0].nodeValue;
                var cores = pc.getElementsByTagName("cores")[0].childNodes[0].nodeValue;
                var mhz = pc.getElementsByTagName("mhz")[0].childNodes[0].nodeValue;
                var ipaddr = pc.getElementsByTagName("ipaddr")[0].childNodes[0].nodeValue;
                var macaddr = pc.getElementsByTagName("macaddr")[0].childNodes[0].nodeValue;
                var osname = pc.getElementsByTagName("osname")[0].childNodes[0].nodeValue;
                var osarch = pc.getElementsByTagName("osarch")[0].childNodes[0].nodeValue;
                var ram = pc.getElementsByTagName("ram")[0].childNodes[0].nodeValue;
                var hdd = pc.getElementsByTagName("hdd")[0].childNodes[0].nodeValue;
                //Добавляем на страницу
                appendPC(id, inv, loc, dep, pcname, mb_vendor, mb_name, ven, model, cores, mhz, ipaddr, macaddr, osname, osarch, ram, hdd);
            }

        }
    }


}

function createTable() {
    table = document.createElement("table");
    createHeaders();
    createBody();
    document.body.appendChild(table);
}

function createHeaders(){
    //Создаем строку заголовков
    headers = document.createElement("thead");
    var rowHead = document.createElement("tr");
    //<editor-fold defaultstate="collapsed" desc="Задаем названия столбцов">
    var cellh0 = document.createElement("th");
    var cellh1 = document.createElement("th");
    var cellh2 = document.createElement("th");
    var cellh3 = document.createElement("th");
    var cellh4 = document.createElement("th");
    var cellh5 = document.createElement("th");
    var cellh6 = document.createElement("th");
    var cellh7 = document.createElement("th");
    var cellh8 = document.createElement("th");
    var cellh9 = document.createElement("th");
    var cellh10 = document.createElement("th");
    var cellh11 = document.createElement("th");
    var cellh12 = document.createElement("th");
    var cellh13 = document.createElement("th");
    var cellh14 = document.createElement("th");
    var cellh15 = document.createElement("th");
    cellh0.appendChild(document.createTextNode("Инв. Ном."));
    cellh1.appendChild(document.createTextNode("Местонахождение"));
    cellh2.appendChild(document.createTextNode("Кафедра"));
    cellh3.appendChild(document.createTextNode("Имя ПК"));
    cellh4.appendChild(document.createTextNode("Производитель Мат. Платы"));
    cellh5.appendChild(document.createTextNode("Название Мат. Платы"));
    cellh6.appendChild(document.createTextNode("Производитель ЦП"));
    cellh7.appendChild(document.createTextNode("Модель ЦП"));
    cellh8.appendChild(document.createTextNode("Кол-во ядер ЦП"));
    cellh9.appendChild(document.createTextNode("Частота ЦП"));
    cellh10.appendChild(document.createTextNode("IP адрес"));
    cellh11.appendChild(document.createTextNode("MAC адрес"));
    cellh12.appendChild(document.createTextNode("Имя ОС"));
    cellh13.appendChild(document.createTextNode("Разрядность ОС"));
    cellh14.appendChild(document.createTextNode("RAM МБ"));
    cellh15.appendChild(document.createTextNode("HDD ГБ"));
    rowHead.appendChild(cellh0);
    rowHead.appendChild(cellh1);
    rowHead.appendChild(cellh2);
    rowHead.appendChild(cellh3);
    rowHead.appendChild(cellh4);
    rowHead.appendChild(cellh5);
    rowHead.appendChild(cellh6);
    rowHead.appendChild(cellh7);
    rowHead.appendChild(cellh8);
    rowHead.appendChild(cellh9);
    rowHead.appendChild(cellh10);
    rowHead.appendChild(cellh11);
    rowHead.appendChild(cellh12);
    rowHead.appendChild(cellh13);
    rowHead.appendChild(cellh14);
    rowHead.appendChild(cellh15);
    headers.appendChild(rowHead);
    //</editor-fold>

    table.appendChild(headers);
}

function createBody(){
    body = document.createElement("tbody");
    table.appendChild(body);
}

function appendPC(id, inv, loc, dep, pcname, mb_vendor, mb_name, ven, model, cores, mhz, ipaddr, macaddr, osname, osarch, ram, hdd) {

    var row = document.createElement("tr");
    
    //Для визуального разграничения строк
    if (flagTD) {
        row.setAttribute("class", "alt");
        flagTD = false;
    } else {
        flagTD = true;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Наполняем строку">
    var cell0 = document.createElement("td");
        var href = document.createElement("a");
        href.setAttribute("href", "soft.html?"+id);
        href.setAttribute("title", "ПО этого ПК");
        href.appendChild(document.createTextNode(inv));
    cell0.appendChild(href);
    row.appendChild(cell0);
    var cell1 = document.createElement("td");
    cell1.appendChild(document.createTextNode(loc));
    row.appendChild(cell1);
    var cell2 = document.createElement("td");
    cell2.appendChild(document.createTextNode(dep));
    row.appendChild(cell2);
    var cell3 = document.createElement("td");
    cell3.appendChild(document.createTextNode(pcname));
    row.appendChild(cell3);
    var cell4 = document.createElement("td");
        var hrefVendor = document.createElement("a");
        hrefVendor.setAttribute("href", "http://ya.ru");
        hrefVendor.setAttribute("target", "_blank");
        for (var prop in mbVendors) {
            if (mb_vendor.toLowerCase().indexOf(prop.toLowerCase()) > -1) {
                hrefVendor.setAttribute("href", mbVendors[prop]);
            }
        }
        hrefVendor.setAttribute("title", "Производитель материнской платы");
        hrefVendor.appendChild(document.createTextNode(mb_vendor));
    cell4.appendChild(hrefVendor);
    row.appendChild(cell4);
    var cell5 = document.createElement("td");
    cell5.appendChild(document.createTextNode(mb_name));
    row.appendChild(cell5);
    var cell6 = document.createElement("td");
    cell6.appendChild(document.createTextNode(ven));
    row.appendChild(cell6);
    var cell7 = document.createElement("td");
    cell7.appendChild(document.createTextNode(model));
    row.appendChild(cell7);
    var cell8 = document.createElement("td");
    cell8.appendChild(document.createTextNode(cores));
    row.appendChild(cell8);
    var cell9 = document.createElement("td");
    cell9.appendChild(document.createTextNode(mhz));
    row.appendChild(cell9);
    var cell10 = document.createElement("td");
    cell10.appendChild(document.createTextNode(ipaddr));
    row.appendChild(cell10);
    var cell11 = document.createElement("td");
    cell11.appendChild(document.createTextNode(macaddr));
    row.appendChild(cell11);
    var cell12 = document.createElement("td");
    cell12.appendChild(document.createTextNode(osname));
    row.appendChild(cell12);
    var cell13 = document.createElement("td");
    cell13.appendChild(document.createTextNode(osarch));
    row.appendChild(cell13);
    var cell14 = document.createElement("td");
    cell14.appendChild(document.createTextNode(ram));
    row.appendChild(cell14);
    var cell15 = document.createElement("td");
    cell15.appendChild(document.createTextNode(hdd));
    row.appendChild(cell15);
    //</editor-fold>
    
    body.appendChild(row);
}