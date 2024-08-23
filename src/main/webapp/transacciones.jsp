

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="estructura/head.jsp"%> 
    <body class="sb-nav-fixed">
        <%@include file="estructura/barraUsuario.jsp"%> 
        <div id="layoutSidenav">
            <%@include file="estructura/barraMenu.jsp"%> 
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Wallet</h1>
                        <%@include file="components/contTransacciones.jsp"%>     
                    </div>
                </main>
                <%@include file="estructura/footer.jsp"%> 
            </div>
        </div>
            <%@include file="estructura/script.jsp"%> 
    </body>
</html>
