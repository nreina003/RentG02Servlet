
window.addEventListener("load", cargar);

function cargar(){
    iniciar();
    
}

function iniciar(){
    var cs=document.getElementById("logoff").addEventListener("click", cerrarSesion);
    var rr=document.getElementById("reaReserva").addEventListener("click", addReserva);
}

function cerrarSesion(){
  sessionStorage.clear();
    location.href = "index.html";
}

function addReserva() {

    var active = dataBase.result;
    var data = active.transaction(["reservas"], "readwrite");
    var object = data.objectStore("reservas");
    var request = object.put({
        email: document.querySelector("#email").value,
        matricula: document.querySelector("#modelo").value,
        fechaInicio: document.querySelector("#fechaInicio").value,
        horaInicio: document.querySelector("#horaInicio").value,
        fechaFin: document.querySelector("#fechaFin").value,
        horaFin: document.querySelector("#horaFin").value,
        lugar: document.querySelector("#lugar").value
    });
    request.onsuccess = function (e) {
        //alert("Reserva hecha satisfactoriamente");
       location.href = "inicioCliente.html";
    };
    request.onerror = function (e) {
        alert(request.error.nombre + '\n\n' + request.error.message);
    };
}