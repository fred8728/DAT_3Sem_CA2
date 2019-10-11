import 'bootstrap/dist/css/bootstrap.css'
//import jokes from "./jokes"; 


//for fetching all users in JSON not tested
document.getElementById("allPersons").addEventListener("click", function () {
    fetch('http://localhost:8080/CA2/api/person/all'/* 'https://frederikkesimone.dk/Register/api/person/all' */)
        .then(function (response) {
            return response.json();
        })
        .then(function (myJson) {
            document.getElementById("allPersonsRes").innerHTML = PersonToHTMLTable(myJson);
        });
});
//not sure about what values will be displayed in the Json but need to fix them below
function PersonToHTMLTable(arr) {
    var arrHTML = arr.map(item => "<tr>"
        + "<td>" + item.id + "</td>"
        + "<td>" + item.name + "</td>"
        /* + "<td>" + item.firstName + "</td>"
        + "<td>" + item.lastName + "</td>" */
        + "<td>" + item.gender + "</td>"
        + "<td>" + item.address + "</td>"
        + "<td>" + item.phone + "</td>"
        + "<td>" + item.hobby + "</td>"
        + "<td>" + item.email + "</td>"
        + "<td>" + item.city + "</td>"
        + "</tr>");
    var arrStr = arrHTML.join('');
    var result = "<table class=\"table table-striped\"><tr>"
        + "<th width = 10%>ID</th>"
        + "<th width = 10%>Name</th>"
        + "<th width = 10%>Gender</th>"
        + "<th width = 10%>Address</th>"
        + "<th width = 10%>Phone</th>"
        + "<th width = 10%>Hobby</th>"
        + "<th width = 10%>Email</th>"
        + "<th width = 10%>City</th>"
        + arrStr + "</table>";
    return result;
}

document.getElementById("personID").addEventListener("click", function () {
    var test = document.getElementById("inp1");
    if(test === null){

        alert("insert a value which is instantiated!")
    }
    console.log(test.value);
    console.log(test);
    //fetch('https://frederikkesimone.dk/Register/api/person/'+ test.value)
    fetch('http://localhost:8080/CA2/api/person/' + test.value)
        .then(function (response) {
            return response.json();
        })
        .then(function (myJson) {
            document.getElementById("personIDRes").innerHTML = PersonToHTML(myJson);
        });
});

function PersonToHTML(item) {
    var arrHTML = "<tr>"
        + "<td>" + item.id + "</td>"
        + "<td>" + item.name + "</td>"
        /* + "<td>" + item.firstName + "</td>"
        + "<td>" + item.lastName + "</td>" */
        + "<td>" + item.address + "</td>"
        + "<td>" + item.phone + "</td>"
        + "<td>" + item.hobby + "</td>"
        + "<td>" + item.email + "</td>"
        + "<td>" + item.city + "</td>"
        + "</tr>";
    var result = "<table class=\"table table-striped\"><tr>"
        + "<th width = 10%>ID</th>"
        + "<th width = 10%>Name</th>"
        + "<th width = 10%>Address</th>"
        + "<th width = 10%>Phone</th>"
        + "<th width = 10%>Hobby</th>"
        + "<th width = 10%>Email</th>"
        + "<th width = 10%>City</th>"
        + arrHTML + "</table>";
    return result;
}



document.getElementById("logdata").addEventListener("click", function () {
    document.getElementById("valueLog").innerHTML =  //" boi bithc";
        "<p> The following is a list of the sprint log which we have chosen to make for this project <br>" +
        "it has been split into tree mini sprint which is shown in the list down below. <br>" +
        "There will be tried to complete as many of the given task as possible in the following week to this project." +
        "</p>" +
        "<div id = \"singleList\">" +
        "<ul>" +
        "Sprint one (Friday 04/10 - Monday 07/10):" +

        "<li>" +
        "The API description must be almost (we are using an iterative process) complete and available as a page on your deployed project." +
        "</li>" +
        "<li>" +
        "The SCRUM plan for the three mini-sprints must be available as a page on your deployed project. This can either be a copy of our suggestion below, or Sprint-1 as" +
        "given below and your own plan for the remaining sprints if your “product owner” agrees (red students)." +
        "</li>" +
        "<li>" +
        "The CI-pipeline must be setup" +
        "</li>" +
        "<li>" +
        "Some of the Entity Classes and the Facade(s) must be ready with supplementing tests" +
        "</li>" +
        "</ul>" +
        "</div>" +

        "<div id = \"singleList\">" +
        "<ul>" +
        "Sprint two (Tuesday 8/10 - Wednesday 9/10):" +
        "<li>" +
        "Most of the Entity Classes should be ready" +
        "</li>" +
        "<li>" +
        "Sample data should be available in the dev-database" +
        "</li>" +
        "<li>" +
        "Some of the endpoints (as a minimum a GET, POST and PUT) must be ready with the corresponding DTO’s and integrations tests" +
        "</li>" +
        "</ul>" +
        "</div>" +

        "<div id = \"singleList\">" +
        "<ul>" +
        "Sprint three (Thursday 10/10- Sunday 13/10):" +
        "<li>" +
        "Complete the API (as much as you have time for)" +
        "</li>" +
        "<li>"+
        "Implement a simple SPA which as a minimum must have the ability "+
        "to use some of your GET endpoints and at least one POST endpoint. Consider pages like:"+
        "</li>"+
        "<ul>" +
        "<li type = \"square\">" +
        "Get all persons with a given hobby" +
        "</li>" +
        "<li type = \"square\">" +
        "Get all persons living in a given city" +
        "</li>" +
        "<li type = \"square\">" +
        "Get the count of people with a given hobby" +
        "</li>" +
        "<li type = \"square\">" +
        "Get a list of all zip codes in Denmark" +
        "</li>" +
        "<li type = \"square\">" +
        "Get a list of companies with more than xx employes(RED LEVEL)" +
        "</li>" +
        "<li type = \"square\">" +
        "Create a Person, with hobbies, phone, address etc." +
        "</li> </ul> </li> <li>" +
        " Complete documentation and prepare for your review presentation after the holiday" +
        + " </li> </ul></div>";
});

document.getElementById("but1").addEventListener("click", function () {
    document.getElementById("div1").innerHTML = "<table border=" + "1px>" +
        " <tr>" +
        "<th width = 100px>Method</th>" +
        "<th width = 100px>Endpoint</th>" +
        "<th width = 100px>Request body (JSON)</th>" +
        "<th width = 100px>Response(JSON)</th>" +
        "<th width = 100px>Error</th>" +
        "</tr>" +
        "<tr>" +
        "<th>GET</th>" +
        "<th>api/person/all</th>" +
        "<th></th>" +
        "<th>[user,user,...] (array of users)</th>" +
        "<th></th>" +
        "</tr>" +
        "<tr>" +
        "<th>GET</th>" +
        "<th>api/person/{id}</th>" +
        "<th></th>" +
        "<th>user (with the requested id)</th>" +
        "<th>(e1)</th>" +
        "</tr>" +
        "<tr>" +
        "<th>POST</th>" +
        "<th>api/person/</th>" +
        "<th>User 1 no ID</th>" +
        "<th></th>" +
        "<th></th>" +
        "</tr>" +
        "<tr>" +
        "<th>PUT</th>" +
        "<th>api/person/{id}</th>" +
        "<th>User 1 ID</th>" +
        "<th>Requested user with changes</th>" +
        "<th></th>" +
        "</tr>" +
        "<tr>" +
        "<th>DELETE</th>" +
        "<th>api/person/{id}</th>" +
        "<th>User 1 ID</th>" +
        "<th>(maybe an OK message)</th>" +
        "<th></th>" +
        "</tr>" +
        "</table>" +
        "<em>" +
        "Request Body and Response Formats<br>" +
        "(1) User format (don’t provide ID, for POST<br>" +
        "{<br>" +
        "&emsp;&emsp; " + "id" + ": Number,<br>" +
        "&emsp;&emsp; " + "firstname" + ": String,<br>" +
        "&emsp;&emsp; " + "lastname" + ": String,<br>" +
        "&emsp;&emsp; " + "phone" + ": Number,<br>" +
        "&emsp;&emsp; " + "email" + ": String (email)<br>" +
        "}<br>" +
        "</em>";
});



