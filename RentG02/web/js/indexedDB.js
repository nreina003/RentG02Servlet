window.indexedDB = window.indexedDB || window.mozIndexedDB || window.webkitIndexedDB || window.msIndexedDB;

//prefixes of window.IDB objects
window.IDBTransaction = window.IDBTransaction || window.webkitIDBTransaction || window.msIDBTransaction;
window.IDBKeyRange = window.IDBKeyRange || window.webkitIDBKeyRange || window.msIDBKeyRange;

// Se comprueba que tu navegador soporte la version de indexedDB.

if (!window.indexedDB) {
    window.alert("Your browser doesn't support a stable version of IndexedDB.");
}
window.addEventListener("load", startDB);
var dataBase;

//Función addResponsable creara un responsable predefinido en la BD de IndexedDB.
function addResponsable() {
    var active = dataBase.result;
    var data = active.transaction(["clientes"], "readwrite");
    var object = data.objectStore("clientes");
    var request = object.put({
        nombre: "Responsable",
        email: "xabier@gmail.com",
        contraseña: "321",
        dni: "123987654",
        movil: "654321987",
        archivos: "imagen1.png"
    });
    request.onerror = function (e) {
        alert(request.error.nombre + '\n\n' + request.error.message);
    };
    data.oncomplete = function (e) {
        // alert('Object successfully added');
    };
}

//Función addCoches creara cuatro coches predefinidos en la BD de IndexedDB.
function addCoches() {
    var active = dataBase.result;
    var data = active.transaction(["coches"], "readwrite");
    var object = data.objectStore("coches");
    var request = object.put({
        matricula: "2341 QWE",
        marca: "Fiat 500"
    });
    var request = object.put({
        matricula: "3412 ASD",
        marca: "Opel Corsa"
    });
    var request = object.put({
        matricula: "4123 ZXC",
        marca: "Peugeot 3008"
    });
    var request = object.put({
        matricula: "4321 DFG",
        marca: "Renault Twingo 3D"
    });
    request.onerror = function (e) {
        alert(request.error.matricula + '\n\n' + request.error.message);
    };
    data.oncomplete = function (e) {
        //alert('Object successfully added');
    };
}
//La función startDB() inicializa la base de datos creandola y generando el squema, las tablas y los campos dentro de las tablas.

function startDB() {

    dataBase = indexedDB.open("rentg02", 1);
    dataBase.onupgradeneeded = function (e) {
        var active = dataBase.result;
        var objectStore = active.createObjectStore("coches", {keyPath: "matricula"});
        objectStore.createIndex('by_matricula', 'matricula', {unique: true});
        objectStore.createIndex('by_marca', 'marca', {unique: false});

        var objectStore = active.createObjectStore("clientes", {keyPath: "email"});
        objectStore.createIndex('by_nombre', 'nombre', {unique: false});
        objectStore.createIndex('by_dni', 'dni', {unique: false});
        objectStore.createIndex('by_contraseña', 'contraseña', {unique: false});
        objectStore.createIndex('by_movil', 'movil', {unique: false});
        objectStore.createIndex('by_archivos', 'archivos', {unique: false});

        var objectStore = active.createObjectStore("reservas", {keyPath: "id", autoIncrement: true});
        objectStore.createIndex('by_email', 'email', {unique: true});
        objectStore.createIndex('by_matricula', 'matricula', {unique: true});
        objectStore.createIndex('by_fechaInicio', 'fechaInicio', {unique: false});
        objectStore.createIndex('by_horaInicio', 'horaInicio', {unique: false});
        objectStore.createIndex('by_fechaFin', 'fechaFin', {unique: false});
        objectStore.createIndex('by_horaFin', 'horaFin', {unique: false});
        objectStore.createIndex('by_lugarrec', 'lugar', {unique: false});

    };

    dataBase.onsuccess = function (e) {
        //alert('Database loaded');
        addResponsable();
        addCoches();
    };

    dataBase.onerror = function (e) {
        alert('Error loading database');
    };
}





function saludo() {
    var saludar = document.getElementById("saludo");
    saludar.innerHTML += "HOLA, " + sessionStorage.getItem("nomLogeado");
}
;



