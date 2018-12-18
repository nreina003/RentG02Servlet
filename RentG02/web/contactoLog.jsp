<%-- 
    Document   : contactoLog
    Created on : 18-dic-2018, 12:26:36
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
        <title>Contacto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="img/favicon.png" />
        <link rel="stylesheet" href="css/index.css">
        <script src="js/indexedDB.js"></script>
        <script src="js/registrarse.js"></script>
        <script src="js/reservaLogeado.js"></script>
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
                    
                    <li><a href="consultarReservas.jsp">Consulta Reservas</a></li>
                    <li><a href="reservaLogeado.jsp">Reservar</a></li>
                    <li><a href="contactoLog.jsp">Contacto</a></li>
                    <li><button type="button" id="logoff">Cerrar Sesión</button></li>
                </ul>
            </div>
        </nav>
        <main>
            <div>
                <section id="articulosprincipales">
                    <article>
                        <h1>RentG</h1>

                        <p>
                            Como empresa puntera en el alquiler de vehículos en 
                            el país vasco queremos ofrecerles la libertad de viajar, 
                            disfrutar de nuestras preciosas ciudades sin preocuparse
                            por el transporte.

                        </p>

                        <h2> "Somos una empresa familiar con 3 oficinas en la comunidad.
                            Y no importa lo grandes que lleguemos a ser, siempre seremos más una familia que un negocio."</h2>  
                        <h2> En redes sociales: </h2>                        

                        <p>
                            Twitter: @RentGasteiz
                            Facebook: RentG alquiler
                            Youtube: RentG Pais Vasco
                        </p>

                        <h2> Contacto: </h2>                        

                        <p>
                            Telefono: 685978462.
                        </p>
                    </article>

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
