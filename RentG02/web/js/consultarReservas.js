var indexedDB = window.indexedDB || window.mozIndexedDB || window.webkitIndexedDB || window.msIndexedDB;
window.addEventListener("load", cargar);
function cargar() {
    iniciar();
}

function iniciar() {
    var cs = document.getElementById("logoff").addEventListener("click", cerrarSesion);
    var r=document.getElementById("mostrarReservaEmail").addEventListener("click", mostrarReservaEmail);
   
}

function cerrarSesion() {
    sessionStorage.clear();
    location.href = "index.html";
}


function mostrarReservaEmail() {

    var active = dataBase.result;
    var data = active.transaction(["reservas"], "readonly");
    var object = data.objectStore("reservas");

    var elements = [];
    object.openCursor().onsuccess = function (e) {
        var result = e.target.result;
        if (result === null) {
            return;
        }

        elements.push(result.value);
        result.continue();
    };
    data.oncomplete = function () {

        var outerHTML = '';

        for (var key in elements) {
            if (elements[key].email === sessionStorage.getItem("emaLogeado")) {
                outerHTML += '\n\
                        <tr>\n\
                            <td>' + elements[key].email + '</td>\n\
                            <td>' + elements[key].fechaFin + '</td>\n\
                            <td>' + elements[key].fechaInicio + '</td>\n\
                            <td>' + elements[key].horaFin + '</td>\n\
                            <td>' + elements[key].horaInicio + '</td>\n\
                            <td>' + elements[key].id + '</td>\n\
                            <td>' + elements[key].lugar + '</td>\n\
                            <td>' + elements[key].matricula + '</td>\n\
                            <td>\n\
                                <button type="button" onclick="load(' + elements[key].id + ')">Details</button>\n\
                            </td>\n\
                        </tr>';
            }


        }

        elements = [];
        document.querySelector("#elementsList").innerHTML = outerHTML;
    };
}