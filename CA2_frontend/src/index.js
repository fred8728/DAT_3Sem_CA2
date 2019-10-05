import 'bootstrap/dist/css/bootstrap.css'
import jokes from "./jokes";

document.getElementById("but1").addEventListener("click", function(){
    document.getElementById("div1").innerHTML = "<table border=" + "1px" + 
    "> <tr>" +
        "<th width = 100px>Method</th>" +
        "<th width = 100px>Endpoint</th>" +
        "<th width = 100px>Request body (JSON)</th>"+
        "<th width = 100px>Response(JSON)</th>"+
        "<th width = 100px>Error</th>"+
    "</tr>"+
    "<tr>" +
            "<th>GET</th>"+
            "<th>api/person/all</th>"+
            "<th></th>" +
            "<th>[user,user,...] (array of users)</th>" +
            "<th></th>" +
        "</tr>" +
        "<tr>" +
            "<th>GET</th>" +
            "<th>api/person/{id}</th>"+
            "<th></th>"+
            "<th>user (with the requested id)</th>"+
            "<th>(e1)</th>" +
        "</tr>" +
    "</table>";
});



