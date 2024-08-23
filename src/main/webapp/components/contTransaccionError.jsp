

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card shadow-lg border-0 rounded-lg mt-5">
    <div class="card-header"><h3 class="text-center font-weight-light my-4">Agregar Transacción</h3></div>
    <div class="card-body">
        <form class="user" action="SvTransacciones" method="POST">
            <div class="row mb-3">
                <div class="col-md-6">
                    <div class="form-floating mb-3 mb-md-0">
                        <input class="form-control" id="date" name="date" type="date" placeholder="Fecha" required/>
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
                        <input class="form-control" id="monto" name="monto" type="text" placeholder="monto" required/>
                        <label for="monto">Monto</label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-floating">
                        <select class="custom-select form-select" id="tipoTrans" name="tipoTrans" required>
                            <option selected>Tipo Transacción</option>
                            <option value="DEPOSITAR">Depositar</option>
                            <option value="RETIRAR">Retirar</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="mt-4 mb-0">
                <div class="d-grid"><button class="btn btn-primary btn-block" type="submit">Registrar Transacción</button></div>
            </div>
            <%
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) {
            %>
            <div class="mt-4 mb-0">
                <div class="alert alert-danger" role="alert">
                    <%= errorMessage%>
                </div>
            </div>
            <% }%>
        </form>
    </div>
</div>
