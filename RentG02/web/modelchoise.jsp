<%-- 
    Document   : modelchoise
    Created on : 17-dic-2018, 16:52:11
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Realizar reserva</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/index.css">
        <link rel="icon" type="image/png" href="img/favicon.png" />
        <script src="js/indexedDB.js"></script>
        <script src="js/modelchoice.js"></script>
    </head>
    <body>

        <header id="cabeceralogo">
            <div>
                <a href="index.jsp"><h1>RENTG02</h1></a>
            </div>
        </header>
        <nav id="menuprincipal">
            <div>
                <ul>
                    <li><a href="loguearse.jsp">Loguearse</a></li>
                    <li><a href="registrarse.jsp">Registrarse</a></li>
                    <li><a href="modelchoice.jsp">Model Choice</a></li>
                    <li><a href="contacto.jsp">Contacto</a></li>
                </ul>
            </div>
        </nav>
        <main>
            <div>
                <section id="articulosprincipales">
                    <article>
                        <h1>¿Qué es el servicio de “Model Choice” de RentG02?</h1>

                        <p>El servicio Model Choice le permite solicitar marcas y modelos 
                            específicos de nuestros vehículos disponibles en nuestras oficinas.
                            Evite sorpresas indeseadas y certifique que su viaje empieza bien, 
                            conduciendo el modelo que ha reservado. 
                        </p>

                        <h2>Nuestros vehículos Model Choice</h2>
                    </article>
                    <!-- HAY QUE CAMBIAR TODO ESTO, LAS IMAGENES LAS ACEPTA ASI PERO INSERTAR EL COCHE HAY QUE HACERLO DESDE BD-->


                    <article>
                        <h1>Realizar reserva </h1>
                        <p> Llegó la hora de realizar tu reserva.
                            Complete los siguientes campos para
                            realizar la busqueda.
                        </p>
                    </article>
                    <p> Fiat 500: Blanco</p>
                    <img src="img/Fiat 500.PNG" alt="Fiat blanco" />
                    <p> Opel Corsa: Azul Marino</p>
                    <img src="img/Opel Corsa.PNG" alt="Opel azul marino" />
                    <p> Peugeot 3008: Marrón</p>
                    <img src="img/Peugeot 3008.PNG" alt="Peugeot marron" />
                    <p> Renault Twingo 3D:Azul</p>
                    <img src="img/Renault Twingo 3D.PNG" alt="Renault azul" />
                    <form method="post">
                        <p> <select name="modelo" id="modelo" size="1">
                                <option value="2341 QWE" >Fiat</option>
                                <option value="3412 ASD" >Opel</option>
                                <option value="4123 ZXC" >Peugeot</option>   
                                <option value="4321 DFG" >Renault</option> 
                            </select> 
                        </p>



                       <p> Oficina de recogida:</p>
                        <p>
                            Email:<input type="email" name="email" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required="" />
                        </p>
                        <p>
                            <select name="lugar" id="lugar" size="1">
                                <option value="Vitoria-Gasteiz" >Vitoria-Gasteiz</option>
                                <option value="San Sebastian " >San Sebastian</option>
                                <option value="Bilbao" >Bilbao</option>                      
                            </select>  
                        </p>
                        <p> 
                            Fecha:<input type="date" name="fechaInicio" id="fechaInicio" />
                        </p>
                        <p>
                            Hora:<input type="time" name="horaInicio" id="horaInicio" />
                        </p>
                       <p> Oficina de entrega:</p>

                        <p>
                            Fecha:<input type="date" name="fechaFin" id="fechaFin" />
                        </p>
                        <p>
                            Hora:<input type="time" name="horaFin" id="horaFin" />  
                        </p>
                        <button type="button" id="reaReserva1">Reralizar Reserva</button>
                        <input type="reset" value="Reset" />
                    </form>

                </section>
                <aside id="infoadicional">
                    <h1>Nuestras oficinas</h1>
                    <p>Vitoria</p>
                    <p>Donostia</p>
                    <p>Bilbo</p>
                     <div id="logo">
                        <img src="img/favicon.png" alt="Logo" />
                    </div>
                </aside>
                <div class="recuperar"></div>
            </div>
        </main>
        <footer id="pielogo">
            <div>
                <section class="seccionpie">
                    <h1>Sitio Web</h1>
                    <p><a href="index.jsp">Principal</a></p>
                    <p><a href="fotos.jsp">Fotos</a></p>
                    <p><a href="videos.jsp">Videos</a></p>
                </section>
                <section class="seccionpie">
                    <h1>Ayuda</h1>
                    <p><a href="contacto.jsp">Contacto</a></p>
                </section>
                <section class="seccionpie">
                    <address>Vitoria, País Vasco</address>
                    <small>&copy; Derechos Reservados 2018</small>
                </section>
                <div class="recuperar"></div>
            </div>
        </footer>
    </body>
</html>