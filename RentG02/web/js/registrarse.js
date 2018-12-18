window.addEventListener("load", cargar, false);

function cargar() {
    iniciar();

}

function iniciar() {
    var nombre = document.getElementById("nombre").addEventListener("change", controlar, false);
    var dni = document.getElementById("dni").addEventListener("change", controlar, false);
    var movil = document.getElementById("movil").addEventListener("change", controlar, false);
    var email = document.getElementById("email").addEventListener("change", controlar, false);
    var contraseña = document.getElementById("contraseña").addEventListener("change", controlar, false);
    var archivos = document.getElementById("archivos").addEventListener("change", controlar, false);
    var r = document.getElementById("regis").addEventListener("click", addCliente);
}

function controlar(e) {
    var elemento = e.target;
    if (elemento.validity.valid) {
        elemento.style.background = '#FFFFFF';
    } else {
        elemento.style.background = '#FFDDDD';
    }
}
//La función addClientes añadira los datos recogidos del formulario de registrarse.html y la añadira en la BD de IndexedDB.
function addCliente() {
    var active = dataBase.result;
    var data = active.transaction(["clientes"], "readwrite");
    var object = data.objectStore("clientes");
    var request = object.put({
        nombre: document.querySelector("#nombre").value,
        email: document.querySelector("#email").value,
        contraseña: document.querySelector("#contraseña").value,
        archivos: document.querySelector("#archivos").value,
        dni: document.querySelector("#dni").value,
        movil: document.querySelector("#movil").value},
            
    );
    request.onsuccess = function (e) {
        location.href = "loguearse.html";
        //alert("Info añadida a la BD correctamente");
    };
    request.onerror = function (e) {
        alert(request.error.nombre + '\n\n' + request.error.message);
    };

}