<%-- 
    Document   : inicioCliente
    Created on : 17-dic-2018, 16:50:33
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
        <title>Inicio Cliente</title>
        <meta charset="utf-8">
        <meta name="description" content="Este es un documento HTML5">
        <meta name="keywords" content="HTML, CSS, JavaScript">
        <link rel="icon" type="image/png" href="img/favicon.png" />
        <link rel="stylesheet" href="css/index.css">
        <script src="js/indexedDB.js"></script>
        <script src="js/inicioCliente.js"></script>
    </head>
    <body>
        <header id="cabeceralogo">
            <div>
                <h1>RENTG02</h1>
            </div>
        </header>
        <nav id="menuprincipal">
            <div>
                <ul>

                    <li><a href="reservaLogeado.jsp">Reservar</a></li>
                    <li><a href="consultarReservas.jsp">Consultar Reservas</a></li>
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
                        <p>Bienvenido a RentG02, líder en el sector de alquiler de vehículos. 
                            Alquilar un coche nunca fue tan fácil como con nuestro motor de 
                            búsqueda y sus fáciles etapas de utilización. 
                            RentG02 es uno de los principales portales de alquiler de coches 
                            en internet. Nos esforzamos para ofrecerle el mejor servicio posible 
                            y satisfacer a nuestros clientes. Hay más razones que nunca para elegir 
                            RentG02, como por ejemplo el “Modo Choice” que le permite solicitar marcas
                            y modelos específicos de nuestro stock de vehículos en nuestras oficinas 
                            principales.
                            Al contrario de muchos otros sitios de alquiler de coches existentes, 
                            prestamos un servicio de atención al cliente. Si tiene cualquier problema 
                            con su coche alquilado, tenemos un equipo a su disposición. Puede llamar 
                            o contactarnos a cualquier hora del día o de la noche, 365 días por año.</p>
                    </article>
                    <section id="saludo" >
                    </section>
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