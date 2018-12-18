<%-- 
    Document   : consultarReservas
    Created on : 18-dic-2018, 12:25:57
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

        <title>Consultar Reservas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="img/favicon.png" />
        <link rel="stylesheet" href="css/index.css">
        <script src="js/indexedDB.js"></script>
        <script src="js/consultarReservas.js"></script>
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
                    <li><a href="reservaLogeado.jso">Reservar</a></li>
                    <li><a href="contactoLog.jsp">Contacto</a></li>
                    <li><button type="button" id="logoff">Cerrar Sesión</button></li>
                    <li><button type="button" id="mostrarReservaEmail">Mostrar las Reservas </button></li>
                </ul>
            </div>
        </nav>
        <main>
            <div>
                <section id="articulosprincipales">

                    <div id="elements">
                        <table>
                            <caption>Reservas</caption>
                            <thead>
                                <tr>
                                    <th>Email</th>
                                    <th>Fecha Fin</th>
                                    <th>Fecha Inicio</th>
                                    <th>Hora Fin</th>
                                    <th>Hora Inicio</th>
                                    <th>ID</th>
                                    <th>Lugar</th>
                                    <th>Matricula</th>
                                </tr>
                            </thead>
                            <tbody id="elementsList">
                                <tr>
                                    <td colspan="3">No hay elementos que mostrar</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

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