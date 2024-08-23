<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <%@include file="estructura/head.jsp"%> 
    <body class="sb-nav-fixed">
        <%@include file="estructura/barraUsuario.jsp"%> 
        <div id="layoutSidenav">
            <%@include file="estructura/barraMenu.jsp"%> 
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Ver Usuarios</h1>
                        <p class="mb-4">A continuación podrá visualizar la lista de usuarios.</p>         
                        <div class="d-flex justify-content-center align-items-center">
                            <%@include file="components/contVerUsuarios.jsp"%>
                        </div>
                    </div>
                </main>
                <%@include file="estructura/footer.jsp"%> 
            </div>
        </div>
            <%@include file="estructura/script.jsp"%> 
    </body>
</html>
