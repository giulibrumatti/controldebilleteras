<%-- 
    Document   : contVerUsuarios
    Created on : 9 ago. 2024, 13:27:24
    Author     : Rombo del Tejar
--%>

<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid">
    <!-- Begin Page Content -->
    <div class="container-fluid">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre de usuario</th>
                                <th style="width:210px">Acción</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>Nombre de usuario</th>
                                <th style="width:210px">Acción</th>
                            </tr>
                        </tfoot>
                        <%
                            List<Usuario> listaUs = (List) request.getSession().getAttribute("listaUsuarios");
                        %>
                        <tbody>
                            <% for (Usuario usu : listaUs) {%>
                            <tr>
                                <td id="idUsuario<%=usu.getIdUsuario()%>"> <%= usu.getIdUsuario()%> </td>
                                <td> <%= usu.getNombreUsuario()%> </td>

                                <td style="display: flex; width:230px">
                                    <form name="editar" action="SvEditUsuarios" method="GET">
                                        <button type="submit" class="btn btn-primary btn-circle btn-block m-1" style="margin-left: 5px;">
                                            <i class="fas fa-pencil-alt"></i>
                                        </button>
                                        <input type="hidden" name="id" value="<%=usu.getIdUsuario()%>">
                                    </form>
                                    <form name="eliminar" action="SvElimUsuarios" method="POST">
                                        <button type="submit" class="btn btn-danger btn-circle m-1" style="border-color:red; background-color:red; margin-right: 5px;">
                                            <i class="fas fa-trash"></i>
                                        </button>
                                        <input type="hidden" name="id" value="<%=usu.getIdUsuario()%>">
                                    </form>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>