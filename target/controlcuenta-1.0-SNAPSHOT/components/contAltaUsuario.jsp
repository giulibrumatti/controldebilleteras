

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="card shadow-lg border-0 rounded-lg mt-5">
    <div class="card-header"><h3 class="text-center font-weight-light my-4">Agregar Usuario</h3></div>
    <div class="card-body">
        <form class="user" action="SvUsuarios" method="POST">
            <div class="row mb-3">
                <div class="col-md-6">
                    <div class="form-floating mb-3 mb-md-0">
                        <input class="form-control" id="nombreUs" type="text" placeholder="nombreUs" name="nombreUs" required/>
                        <label for="fecha">Nombre de usuario</label>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-floating mb-3 mb-md-0">
                        <input class="form-control" id="pass" type="password" placeholder="pass" name="pass" required/>
                        <label for="pass">Contraseña</label>
                    </div>
                </div>
            </div>
            <div class="mt-4 mb-0">
                <div class="d-grid"><button class="btn btn-primary btn-block" type="submit">Registrar Usuario</button></div>
            </div>
        </form>
    </div>
</div>
