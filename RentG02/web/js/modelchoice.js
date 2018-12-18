window.addEventListener("load", cargar, false);

function cargar(){
    iniciar();
    
}

function iniciar(){
    var rr=document.getElementById("reaReserva1").addEventListener("click", addReserva);
}

function controlar(e) {
    var elemento = e.target;
    if (elemento.validity.valid) {
        elemento.style.background = '#FFFFFF';
    } else {
        elemento.style.background = '#FFDDDD';
    }
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
        alert("Reserva hecha satisfactoriamente");
    };
    request.onerror = function (e) {
        alert(request.error.nombre + '\n\n' + request.error.message);
    };
}