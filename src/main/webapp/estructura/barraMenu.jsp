           

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <div class="sb-sidenav-menu-heading">Menú</div>
                <a class="nav-link" href="index.jsp">
                    <div class="sb-nav-link-icon"><i class="bi bi-house"></i></div>
                    Inicio
                </a>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayoutsFour" aria-expanded="false" aria-controls="collapseLayouts">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    Transacción
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseLayoutsFour" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="transacciones.jsp">Agregar Transacción</a>
                        <a class="nav-link" href="SvTransacciones">Ver Historial</a>
                    </nav>
                </div>
                                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayoutsFive" aria-expanded="false" aria-controls="collapseLayouts">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    Usuario
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseLayoutsFive" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="altaUsuario.jsp">Alta Usuario</a>
                        <a class="nav-link" href="SvUsuarios">Ver Usuario</a>
                    </nav>
                </div>
            </div>
        </div>
    </nav>
</div>