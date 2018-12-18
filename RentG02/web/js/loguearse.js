window.addEventListener("load", cargar, false);

function cargar() {
    iniciar();

}
/* global alertify */

function iniciar() {
    var email = document.getElementById("email").addEventListener("change", controlar, false);
    var contraseña = document.getElementById("contraseña").addEventListener("change", controlar, false);
    var l = document.getElementById("login1").addEventListener("click", login);

}
/**
function comprobacion(){
    validarTIS(tis.value);
    //validarFecha(fecha.value);
}

function validarTIS(pTIS){
    var ex = /^[0-9]{8}$/;
    
    if(ex.test(pTIS) || pTIS === ''){
        tis.style.background = '#FFFFFF';
        return true;
    }
    else{
        tis.style.background = '#FFDDDD';
        return false;
    }
}

function validarFecha(pFecha){
    
    var hoy = new Date();
    
    //var dd1 = hoy.getDate();
    //var mm1 = hoy.getMonth()+1; 
    //var yyyy1 = hoy.getFullYear();
    
    //hoy = yyyy1 + '-' + mm1 + '-' + dd1;
    
    pFecha.setAttribute("max", hoy);
    
    var dd = pFecha.substring( 8 , 10 );
    
    var mm = pFecha.substring( 5 , 7 );
    
    var yyyy = pFecha.substring( 0 , 4 );
    
    var fecha = new Date( yyyy , mm , dd );
    
    console.log(pFecha);
   
    console.log(hoy);
    
    if ( fecha > hoy )
    {
        fecha.style.background = "#FFDDDD";
        return false;
    }
    else
    {
        fecha.style.background = "#FFFFFF";
        return true;
    }
    
}

function hoy(){
    var hoy = new Date();
    var dd = hoy.getDate();
    var mm = hoy.getMonth()+1; 
    var yyyy = hoy.getFullYear();
    if(dd<10){
        dd='0'+dd;
    } 
    if(mm<10){
        mm='0'+mm;
    } 
    hoy = yyyy + '-' + mm + '-' + dd;
    document.getElementById("fechaNacimiento").setAttribute("max", hoy);
}**/

/**
function maxFecha(){
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    if(dd<10){
        dd='0'+dd;
    } 
    if(mm<10){
        mm='0'+mm;
    } 

    today = dd + '/' + mm + '/' + yyyy;

    document.getElementById("fechaNac").setAttribute("max", today);
    var fecha=document.getElementById("fecha"); 
    
    if(fecha>today){
        alertify.alert("Fecha incorrecta");
    }
}

function minFecha(){
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    if(dd<10){
        dd='0'+dd;
    } 
    if(mm<10){
        mm='0'+mm;
    } 

    today = yyyy+'-'+mm+'-'+dd;

    document.getElementById("fechaNac").setAttribute("min", "1990-01-01");
}
**/
/**
function validarFecha(){
    private int miAnio, miMes, miDia;
    Calendar calendar =  Calendar.getInstance();
    miAnio = calendar.get(Calendar.YEAR);
    miMes = calendar.get(Calendar.MONTH);
    miDia = calendar.get(Calendar.DAY_OF_MONTH);

    DatePickerDialog oyenteSelectorFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            Log.i("TAG", String.valueOf(year) + String.valueOf(monthOfYear) + String.valueOf(dayOfMonth));

        }
    }, miAnio, miMes, miDia);


    //Como ejemplo: deseamos que la fecha minima sea un mes antes y un dia antes.
    Calendar calendarioMin = Calendar.getInstance();
    calendarioMin.add(Calendar.YEAR, 27)
    calendarioMin.add(Calendar.MONTH, -10); //Mes anterior
    calendarioMin.add(Calendar.DAY_OF_MONTH, - 23); //dia anterior
}

/** function iniciar(){
    tis=document.getElementById("tis");
    fecha=document.getElementById("fecha");
    tis.addEventListener("input", validar, false);
    fecha.addEventListener("input", validarFecha, false);
    validar();
    validarFecha();
    validarDirecto();
}

function validarDirecto(){
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();

    if(dd<10) {
        dd = '0'+dd;
    } 

    if(mm<10) {
        mm = '0'+mm;
    } 
    dd=dd+1; //Día de hoy, el primer dia es 0

    today = yyyy+ '/' + mm + '/' + dd;
    document.getElementById("fecha").setAttribute("max", today);
    
    if(fechaNac.value>=today || fechaNac.value === ""){
        fechaNac.setCustomValidity("Inserte una fecha válida");
        fechaNac.style.background = '#FFDDDD';
    }
    else{
     fechaNac.setCustomValidity('');
     fechaNac.style.background = '#FFFFFF';
    }
}

}
**/



//HAY QUE MODIFICAR !!!!!!!

function login() {

    var active = dataBase.result;
    var data = active.transaction(["clientes"], "readonly");
    var object = data.objectStore("clientes");
    var request = object.get(document.querySelector("#email").value);
    request.onsuccess = function (event) {
        if (request.result.contraseña === document.querySelector("#contraseña").value)
        {

            sessionStorage.setItem("nomLogeado", request.result.nombre);
            sessionStorage.setItem("emaLogeado", request.result.email);
            if (request.result.nombre === "Responsable")
            {
                alert("Hola " + request.result.nombre + ", ahora estas logeado.");
                location.href = "responsableO.html";
            }else
            {
                alert("Hola " + request.result.nombre + ", ahora estas logeado.");
                location.href = "inicioCliente.html";
            }
        } else
        {
            alert("Contraseña erronea");
        }
    };
}