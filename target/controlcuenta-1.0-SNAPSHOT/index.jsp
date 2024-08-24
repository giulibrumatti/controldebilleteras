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
                        <h1 class="mt-4">Wallet</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Saldo en billeteras</li>
                        </ol>
                        <%
                            
                            request.getRequestDispatcher("SvWallet").include(request, response);
                        %>
                        <%@include file="components/contIndex.jsp"%> 
                    </div>
                </main>
                <%@include file="estructura/footer.jsp"%> 
            </div>
        </div>
        <%@include file="estructura/script.jsp"%> 
    </body>
</html>
