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
                        <h1 class="mt-4">Alta Usuario</h1>
                        <ol class="breadcrumb mb-4 d-flex justify-content-center align-items-center">
                            <li><%@include file="components/contAltaUsuario.jsp"%> </li>
                        </ol>
                    </div>
                </main>
                <%@include file="estructura/footer.jsp"%> 
            </div>
        </div>
            <%@include file="estructura/script.jsp"%> 
    </body>
</html>
