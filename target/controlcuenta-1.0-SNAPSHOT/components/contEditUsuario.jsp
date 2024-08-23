

<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card shadow-lg border-0 rounded-lg mt-5">
    <% Usuario us = (Usuario) request.getSession().getAttribute("usuEditar");%>
    <div class="card-header"><h3 class="text-center font-weight-light my-4">Edición Usuario</h3></div>
    <div class="card-body">
        <form class="user" action="SvEditUsuarios" method="POST">
            <div class="form-group row">
                <div class="col-md-6">
                    <label for="usuario" class="text-gray-600 small" >Nombre de Usuario</label>
                    <input type="text" class="form-control form-control-user" name="usuario" id="usuario"
                           placeholder="Usuario" value="<%=us.getNombreUsuario()%>">
                </div>
                <div class="col-sm-6">
                    <label for="contra" class="text-gray-600 small" >Contraseña</label>
                    <input type="password" class="form-control form-control-user" name="contra" id="contra"
                           placeholder="Contraseña" value="<%=us.getContrasenia()%>" >              
                </div>
            </div>
            <div class="mt-4 mb-0">
                <div class="d-grid"><button class="btn btn-primary btn-block" type="submit">Guardar edición</button></div>
            </div>

            <hr>
        </form>
    </div>
</div>
