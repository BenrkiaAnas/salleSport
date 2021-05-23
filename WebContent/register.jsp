<%@page import="entities.Type_abonnement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Language" content="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Salle Sport - Créer Compte</title>
    <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
    <meta name="description" content="ArchitectUI HTML Bootstrap 4 Dashboard Template">

    <!-- Disable tap highlight on IE -->
    <meta name="msapplication-tap-highlight" content="no">

<link href="main.css" rel="stylesheet"></head>

<body>
    <div class="app-container app-theme-white body-tabs-shadow">
        <div class="app-container">
            <div class="h-100 bg-premium-dark">
                <div class="d-flex h-100 justify-content-center align-items-center">
                    <div class="mx-auto app-login-box col-md-8">
                        <div class="app-logo-inverse mx-auto mb-3"></div>
                        <div class="modal-dialog w-100">
                            <div class="modal-content">
                                <div class="modal-body">
                                    <h5 class="modal-title">
                                        <h4 class="mt-2">
                                            <div>Bonjour,</div>
                                        </h4>
                                    </h5>
                                    <div class="divider row"></div>
                                    <form class="form-row" action="" method="POST">
                                        <div class="col-md-6">
                                            <div class="position-relative form-group">
                                                <input name="nom" id="nom"  placeholder="Nom" type="text" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="position-relative form-group">
                                                <input name="prenom" id="nom"  placeholder="Prénom" type="text" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="position-relative form-group">
                                                <input name="email" id="email" placeholder="E-mail" type="email" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="position-relative form-group">
                                                <input name="password"  id="password" placeholder="Mot de Passe" type="password"  class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="position-relative form-group">
                                                <select class="mb-2 form-control" name="plan">
                                                
                                                	 <c:forEach var="item" items="${requestScope.plans}" >
														   <option value="${item['id_type_abon'] }">${item['nom_type']}</option>
													</c:forEach>
													
													
												
													
													
                                                    
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="position-relative form-group">
                                                <input name="espace" id="espace" placeholder="Nom Espace" type="text" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="position-relative form-group">
                                                <input name="terrain" id="terrain" placeholder="Nom Terrain" type="text" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-md-12" style="text-align: center">
                                            <button class="btn-wide btn-pill btn-shadow btn-hover-shine btn btn-primary btn-lg">Crée Compte</button>
                                        </div>
                                    </form>
                                  
                                    <div class="divider row"></div>
                                    <h6 class="mb-0">Vous avez déjà un compte? 
                                        <a href="/salleSport/login" class="text-primary">Se Connecter</a> 
                                    </h6>
                                </div>
                               
                            </div>
                        </div>
                        <div class="text-center text-white opacity-8 mt-3">Salle Sport © 2021</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script type="text/javascript" src="main.js"></script></body>


</html>
