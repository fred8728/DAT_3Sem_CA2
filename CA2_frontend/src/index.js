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
        "<tr>" +
            "<th>POST</th>" +
            "<th>api/person/</th>"+
            "<th>User 1 no ID</th>"+
            "<th></th>"+
            "<th></th>" +
        "</tr>" +
        "<tr>" +
            "<th>PUT</th>" +
            "<th>api/person/{id}</th>"+
            "<th>User 1 ID</th>"+
            "<th>Requested user with changes</th>"+
            "<th></th>" +
        "</tr>" +
        "<tr>" +
            "<th>DELETE</th>" +
            "<th>api/person/{id}</th>"+
            "<th>User 1 ID</th>"+
            "<th>(maybe an OK message)</th>"+
            "<th></th>" +
        "</tr>" +
    "</table>" +
    "<em>" +
    "Request Body and Response Formats<br>" +
    "(1) User format (don’t provide ID, for POST<br>" +
"{<br>"+
    "&emsp;&emsp; " + "id" + ": Number,<br>" +
    "&emsp;&emsp; " + "firstname" + ": String,<br>" +
    "&emsp;&emsp; " + "lastname" + ": String,<br>" +
    "&emsp;&emsp; " + "phone" +": Number,<br>" +
    "&emsp;&emsp; " + "email" + ": String (email)<br>" +
"}<br>" +
"</em>" ;
});



