

<%@page import="logica.TransaccionType"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Transaccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card shadow-lg border-0 rounded-lg mt-5">
    <% Transaccion trans = (Transaccion) request.getSession().getAttribute("transEditar");
        SimpleDateFormat formatoDate = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = (trans.getDate() != null) ? formatoDate.format(trans.getDate()) : "Fecha no disponible";

    %>

    <div class="card-header"><h3 class="text-center font-weight-light my-4">Edicion de Transacción</h3></div>
    <div class="card-body">
        <form class="user" action="SvEditTrans" method="POST">
            <div class="row mb-3">
                <div class="col-md-6">
                    <div class="form-floating mb-3 mb-md-0">
                        <input class="form-control" id="date" value="<%=fechaFormateada%>" name="date" type="date" placeholder="Fecha" required/>
                        <label for="date">Fecha</label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-floating">
                        <select class="custom-select form-select" id="wallet" name="wallet" required>
                            <option selected>Wallet</option>
                            <option value="EFECTIVO">Efectivo</option>
                            <option value="MERCADOPAGO">MercadoPago</option>
                            <option value="BANCO">Banco</option>
                        </select>

                    </div>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-md-6">
                    <div class="form-floating mb-3 mb-md-0">
                        <input class="form-control" id="monto" value="<%=trans.getAmount()%>" name="monto" type="text" placeholder="monto" required/>
                        <label for="monto">Monto</label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-floating">
                        <select class="custom-select form-select" id="tipoTrans" name="tipoTrans" required>
                            <option>Tipo Transacción</option>
                            <option value="DEPOSITAR" <%= TransaccionType.DEPOSITAR.equals(trans.getType()) ? "selected" : ""%>>Depositar</option>
                            <option value="RETIRAR" <%= TransaccionType.RETIRAR.equals(trans.getType()) ? "selected" : ""%>>Retirar</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="mt-4 mb-0">
                <div class="d-grid"><button class="btn btn-primary btn-block" type="submit">Registrar Transacción</button></div>
            </div>
        </form>
    </div>
</div>
