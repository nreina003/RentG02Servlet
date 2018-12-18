<%-- 
    Document   : loguearse
    Created on : 17-dic-2018, 16:51:19
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
        <title>Loguearse</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/indexedDB.js"></script>
        <script src="js/loguearse.js"></script>
        <link rel="icon" type="image/png" href="img/favicon.png" />
       <link rel="stylesheet" href="css/index.css">
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
                    
                    <!-- mirar porque en el form no admite post arreglarlo -->
                    <form method="post">
                        <p>Email:<input type="email" name="email" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required="" />
                        <p>Contraseña:<input type="password" name="contraseña" id="contraseña" maxlength="10" size="10" required="" />
                            
                         
                            <button type="button" id="login1">Login</button>
                            <input type="reset" value="Reset">
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
