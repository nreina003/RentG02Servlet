<%-- 
    Document   : registrarse
    Created on : 17-dic-2018, 16:53:51
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
        <title>Registrarse</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <link rel="stylesheet" href="css/index.css">
       <link rel="icon" type="image/png" href="img/favicon.png" />
       <script src="js/registrarse.js"></script>
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
                    <section id="cajaformulario">
                        <form name="formulario" method="post">
                            <p><label>Nombre: <input type="text" id="nombre" name="nombre" pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{3,48}" required=""/></label></p>
                            <p><label>DNI: <input type="text" id="dni" name="dni" maxlength="9" pattern="[0-9]{9}" /></label></p>
                            <p><label>Movil: <input  type="text" id="movil" name="movil" ></label></p>
                            <p><label>Correo: <input  type="email" id="email" name="email" required=""></label></p>
                            <p><label>Contraseña: <input  type="password" id="contraseña" name="contraseña" maxlength="10" size="10" required="" /></p>
                            <label for="archivos">Archivo: </label>
                            <input type="file" name="archivos" id="archivos">



                            <section id="cajadatos">
                                <p>Seleccione un archivo</p>
                            </section>

                            <p>
                                <button type="button" id="regis">Registrarse</button>
                                <input type="reset" value="Reset">
                        </form>
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