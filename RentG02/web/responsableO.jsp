<%-- 
    Document   : responsableO
    Created on : 18-dic-2018, 12:28:33
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
        <title>Responsable</title>
        <meta charset="utf-8">
        <meta name="description" content="Este es un documento HTML5">
        <meta name="keywords" content="HTML, CSS, JavaScript">
        <link rel="stylesheet" href="css/index.css">
        <link rel="icon" type="image/png" href="img/favicon.png" />
        <script src="js/responsableO.js"></script>
        <script src="js/indexedDB.js"></script>
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
                    <li><a href="consultarReservasO.jsp">Consultar Reservas</a></li>
                    <li><a href="contactoLog.jsp">Contacto</a></li>
                    <li><button type="button" id="logoff">Cerrar Sesión</button></li>
                </ul>
            </div>
        </nav>
        <main>
            <div>
                <section id="articulosprincipales">
                    <article>
                        <table>
                            <tr>
                                <td>
                                    <h1>RentG</h1>
                                </td>

                            </tr>
                            <tr>
                                <td>
                                    <section id="saludo" >
                                    </section>
                                </td>
                            </tr>
                        </table>



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