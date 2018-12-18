var indexedDB = window.indexedDB || window.mozIndexedDB || window.webkitIndexedDB || window.msIndexedDB;
window.addEventListener("load", cargar);

function cargar(){
    iniciar();
    saludo();
}


function iniciar(){
    var cs=document.getElementById("logoff").addEventListener("click", cerrarSesion);
}
function cerrarSesion(){
    sessionStorage.clear();
    location.href = "index.html";
}