<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Transaccion"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid">
    <!-- Begin Page Content -->
    <div class="container-fluid">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Transacciones</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="datatablesSimple" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Fecha</th>
                                <th>Tipo Transaccion</th>
                                <th>Monto</th>
                                <th>Tipo Billetera</th>
                                <th style="width:210px">Acción</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>Fecha</th>
                                <th>Tipo Transaccion</th>
                                <th>Monto</th>
                                <th>Tipo Billetera</th>
                                <th style="width:210px">Acción</th>
                            </tr>
                        </tfoot>
                        <%
                            List<Transaccion> listaTrans = (List) request.getSession().getAttribute("listaTrans");
                            SimpleDateFormat formatoDate = new SimpleDateFormat("dd-MM-yyyy");
                        %>
                        <tbody>
                            <% for (Transaccion trans : listaTrans) {
                                String fechaFormateada = (trans.getDate() != null) ? formatoDate.format(trans.getDate()) : "Fecha no disponible";
                            %>
                            <tr>
                                <td id="idUsuario<%=trans.getTransactionId()%>"> <%= trans.getTransactionId()%> </td>
                                <td> <%= fechaFormateada %> </td>
                                <td> <%= trans.getType()%> </td>
                                <td> <%= trans.getAmount()%> </td>
                                <td> <%= trans.getWallet().getType()%> </td>

                                <td style="display: flex; width:230px">
                                    <form name="eliminar" action="SvElimTrans" method="POST">
                                        <button type="submit" class="btn btn-danger btn-circle m-1" style="border-color:red; background-color:red; margin-right: 5px;">
                                            <i class="fas fa-trash"></i>
                                        </button>
                                        <input type="hidden" name="idTrans" value="<%=trans.getTransactionId()%>">
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