

<%@page import="logica.Wallet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid px-4">
    <% Wallet efectivo = (Wallet) request.getSession().getAttribute("efectivo");%>
    <% Wallet banco = (Wallet) request.getSession().getAttribute("banco");%>
    <% Wallet mp = (Wallet) request.getSession().getAttribute("mp");%>
    <div class="row">
        <div class="col-xl-3 col-md-6">
            <div class="card bg-primary text-white mb-4">
                <div class="card-body">Efectivo</div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <p class="text-white stretched-link">$<%= efectivo.getBalance()%></p>
                    <div class="small text-white"><i class="bi bi-cash-coin"></i></div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-md-6">
            <div class="card bg-warning text-white mb-4">
                <div class="card-body">Mercado Pago</div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <p class="text-white stretched-link">$<%= mp.getBalance()%></p>
                    <div class="small text-white"><i class="bi bi-wallet2"></i></div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-md-6">
            <div class="card bg-success text-white mb-4">
                <div class="card-body">Banco</div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <p class="text-white stretched-link">$<%= banco.getBalance()%></p>
                    <div class="small text-white"><i class="bi bi-bank2"></i></div>
                </div>
            </div>
        </div>
    </div>
